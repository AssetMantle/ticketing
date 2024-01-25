package controllers

import controllers.actions._
import exceptions.BaseException
import models.analytics.NFTsAnalysis
import models.master._
import models.masterTransaction.NFTDraft
import models.{blockchain, master, masterTransaction}
import org.bitcoinj.core.ECKey
import play.api.Logger
import play.api.cache.Cached
import play.api.i18n.I18nSupport
import play.api.mvc._
import schema.data.Data
import utilities.MicroNumber
import views.base.companion.UploadFile
import views.nft.companion._

import java.io.File
import java.nio.file.Files
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class NFTController @Inject()(
                               messagesControllerComponents: MessagesControllerComponents,
                               cached: Cached,
                               withoutLoginActionAsync: WithoutLoginActionAsync,
                               withLoginActionAsync: WithLoginActionAsync,
                               withoutLoginAction: WithoutLoginAction,
                               withLoginAction: WithLoginAction,
                               nftsAnalysis: NFTsAnalysis,
                               masterAccounts: master.Accounts,
                               masterCollections: master.Collections,
                               masterKeys: master.Keys,
                               blockchainBalances: blockchain.Balances,
                               blockchainBlocks: blockchain.Blocks,
                               blockchainOrders: blockchain.Orders,
                               blockchainAssets: blockchain.Assets,
                               blockchainMetas: blockchain.Metas,
                               masterNFTs: master.NFTs,
                               masterSales: master.Sales,
                               masterPublicListings: master.PublicListings,
                               masterNFTOwners: master.NFTOwners,
                               masterWishLists: master.WishLists,
                               masterWhitelists: master.Whitelists,
                               masterWhitelistMembers: master.WhitelistMembers,
                               masterSecondaryMarkets: master.SecondaryMarkets,
                               utilitiesNotification: utilities.Notification,
                               masterTransactionPublicListingNFTTransactions: masterTransaction.PublicListingNFTTransactions,
                               masterTransactionNFTDrafts: masterTransaction.NFTDrafts,
                               masterTransactionTokenPrices: masterTransaction.TokenPrices,
                               masterTransactionRevealPropertyTransactions: masterTransaction.RevealPropertyTransactions,
                             )(implicit executionContext: ExecutionContext) extends AbstractController(messagesControllerComponents) with I18nSupport {

  implicit val logger: Logger = Logger(this.getClass)

  implicit val module: String = constants.Module.NFT_CONTROLLER

  implicit val callbackOnSessionTimeout: Call = routes.CollectionController.viewCollections()

  def viewNFT(nftId: String, activeTab: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val nft = masterNFTs.Service.tryGet(nftId)
        (for {
          nft <- nft
        } yield Ok(views.html.nft.viewNft(nft, activeTab))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def overview(nftId: String, activeTab: String): Action[AnyContent] = withoutLoginActionAsync { implicit loginState =>
    implicit request =>
      val nft = masterNFTs.Service.tryGet(nftId)
      (for {
        nft <- nft
      } yield Ok(views.html.nft.detail.view(nftId = nftId, totalSupply = nft.totalSupply, activeTab = activeTab))
        ).recover {
        case baseException: BaseException => InternalServerError(baseException.failure.message)
      }
  }

  def details(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val nft = masterNFTs.Service.tryGet(nftId)
        val liked = loginState.fold[Future[Option[Boolean]]](Future(None))(x => masterWishLists.Service.checkExists(accountId = x.username, nftId = nftId).map(Option(_)))

        def getCollection(collectionID: String) = masterCollections.Service.tryGet(collectionID)

        val isNFTOwner = if (loginState.isDefined) masterNFTOwners.Service.checkExists(nftId = nftId, ownerId = loginState.get.username) else Future(false)

        (for {
          nft <- nft
          liked <- liked
          collection <- getCollection(nft.collectionId)
          isNFTOwner <- isNFTOwner
        } yield Ok(views.html.nft.detail.overview(collection, nft, liked = liked, isNFTOwner = isNFTOwner))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def trade(nftId: String): Action[AnyContent] = withoutLoginActionAsync { implicit loginState =>
    implicit request =>
      Future(Ok(views.html.nft.detail.trade(nftId = nftId)))
  }

  def sellOrders(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val totalOrders = masterSecondaryMarkets.Service.totalForNFT(nftId)

        for {
          totalOrders <- totalOrders
        } yield Ok(views.html.nft.detail.sellOrders(nftId, totalOrders))
    }
  }

  def sellOrdersPerPage(nftId: String, pageNumber: Int): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val secondaryMarkets = masterSecondaryMarkets.Service.getByNFTIdAndPageNumber(nftId = nftId, pageNumber = pageNumber)

        def orders(secondaryMarkets: Seq[SecondaryMarket]) = blockchainOrders.Service.get(secondaryMarkets.map(_.orderId))

        (for {
          secondaryMarkets <- secondaryMarkets
          orders <- orders(secondaryMarkets)
        } yield Ok(views.html.nft.detail.sellOrdersPerPage(secondaryMarkets.sortBy(_.price), orders, blockchainBlocks.Service.getLatestHeight, masterTransactionTokenPrices.Service.getLatestPrice, pageNumber))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def yourOrders(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withLoginActionAsync { implicit loginState =>
      implicit request =>
        implicit val optionalLoginState: Option[LoginState] = Option(loginState)
        val totalOrders = masterSecondaryMarkets.Service.totalYourOrders(nftId = nftId, sellerId = loginState.username)
        for {
          totalOrders <- totalOrders
        } yield Ok(views.html.nft.detail.yourOrders(nftId, totalOrders))
    }
  }

  def yourOrdersPerPage(nftId: String, pageNumber: Int): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withLoginActionAsync { implicit loginState =>
      implicit request =>
        val secondaryMarkets = masterSecondaryMarkets.Service.getByNFTIdAndSellerIdAndPageNumber(nftId = nftId, sellerId = loginState.username, pageNumber = pageNumber)

        def orders(secondaryMarkets: Seq[SecondaryMarket]) = blockchainOrders.Service.get(secondaryMarkets.map(_.orderId))

        (for {
          secondaryMarkets <- secondaryMarkets
          orders <- orders(secondaryMarkets)
        } yield Ok(views.html.nft.detail.yourOrdersPerPage(secondaryMarkets.sortBy(_.price), orders, blockchainBlocks.Service.getLatestHeight, masterTransactionTokenPrices.Service.getLatestPrice, pageNumber))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def detailViewLeftCards(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginAction {
      implicit request =>
        Ok(views.html.nft.detail.leftCards(nftId))
    }
  }

  def info(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val nft = masterNFTs.Service.tryGet(nftId)
        val liked = loginState.fold[Future[Option[Boolean]]](Future(None))(x => masterWishLists.Service.checkExists(accountId = x.username, nftId = nftId).map(Option(_)))

        (for {
          nft <- nft
          liked <- liked
        } yield Ok(views.html.nft.detail.info(nft, liked))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def collectionInfo(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val nft = masterNFTs.Service.tryGet(nftId)
        val countOwners = masterNFTOwners.Service.countOwners(nftId)
        val secondaryMarket = masterSecondaryMarkets.Service.getByNFTIdAndLowestPrice(nftId)

        def nftOwner(countOwners: Int): Future[Option[NFTOwner]] = if (countOwners == 1) {
          masterNFTOwners.Service.getByNFTID(nftId = nftId).map(Option(_))
        } else Future(None)

        def collection(collectionId: String) = masterCollections.Service.tryGet(collectionId)

        (for {
          nft <- nft
          countOwners <- countOwners
          nftOwner <- nftOwner(countOwners)
          collection <- collection(nft.collectionId)
          secondaryMarket <- secondaryMarket
        } yield Ok(views.html.nft.detail.collectionInfo(nft, collection, nftOwner, countOwners, secondaryMarket))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def detailViewRightCards(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val totalOwners = masterNFTOwners.Service.countOwners(nftId)

        val nft = masterNFTs.Service.tryGet(nftId)
        val nftOwner: Future[Option[NFTOwner]] = if (loginState.isDefined) masterNFTOwners.Service.get(nftId = nftId, ownerId = loginState.get.username) else Future(None)
        val publicListing = masterPublicListings.Service.getPublicListingByNFTId(nftId)

        def collection(collectionId: String) = masterCollections.Service.tryGet(collectionId)

        val nftAnalysis = nftsAnalysis.Service.tryGet(nftId)

        (for {
          nft <- nft
          totalOwners <- totalOwners
          nftOwner <- nftOwner
          collection <- collection(nft.collectionId)
          nftAnalysis <- nftAnalysis
          publicListing <- publicListing
        } yield Ok(views.html.nft.detail.rightCards(collection, nftAnalysis, nft, userNFTOwner = nftOwner, totalOwners = totalOwners))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def publicListingRightCards(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val publicListing = masterPublicListings.Service.getPublicListingByNFTId(nftId)

        def getOthers(publicListing: Option[PublicListing]) = if (publicListing.isDefined) {
          val collection = masterCollections.Service.tryGet(publicListing.get.collectionId)

          for {
            collection <- collection
          } yield collection
        } else Future(null)

        (for {
          publicListing <- publicListing
          collection <- getOthers(publicListing)
        } yield Ok(views.html.nft.detail.publicListingRightCards(collection, publicListing))
          ).recover {
          case _: BaseException => NoContent
        }
    }
  }

  def saleRightCards(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val sale = masterSales.Service.getByNFTId(nftId)

        def getOthers(sale: Option[Sale]) = if (sale.isDefined) {
          val collection = masterCollections.Service.tryGet(sale.get.collectionId)
          val isMember = if (loginState.isDefined) masterWhitelistMembers.Service.isMember(sale.get.whitelistId, loginState.get.username) else Future(false)
          for {
            collection <- collection
            isMember <- isMember
          } yield (collection, isMember)
        } else Future(null, false)

        (for {
          sale <- sale
          (collection, isMember) <- getOthers(sale)
        } yield Ok(views.html.nft.detail.saleRightCards(collection, sale, isMember))
          ).recover {
          case _: BaseException => NoContent
        }
    }
  }

  def secondaryMarketRightCards(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val lowestPriceSecondaryMarket = masterSecondaryMarkets.Service.getByNFTIdAndLowestPrice(nftId)
        val isOwner = if (loginState.isDefined) masterNFTOwners.Service.checkExists(nftId, loginState.get.username) else Future(false)
        val userSecondaryMarkets = if (loginState.isDefined) masterSecondaryMarkets.Service.getByNFTIdAndSellerId(nftId = nftId, sellerId = loginState.get.username).map(_.sortBy(_.price)) else Future(Seq())

        def getOthers(lowestPriceSecondaryMarket: Option[SecondaryMarket]) = if (lowestPriceSecondaryMarket.isDefined) {
          val collection = masterCollections.Service.tryGet(lowestPriceSecondaryMarket.get.collectionId)
          for {
            collection <- collection
          } yield collection
        } else Future(null)

        (for {
          lowestPriceSecondaryMarket <- lowestPriceSecondaryMarket
          userSecondaryMarkets <- userSecondaryMarkets
          isOwner <- isOwner
          collection <- getOthers(lowestPriceSecondaryMarket)
        } yield Ok(views.html.nft.detail.secondaryMarketRightCards(nftId, collection, isOwner, lowestPriceSecondaryMarket = lowestPriceSecondaryMarket, userSecondaryMarkets = userSecondaryMarkets))
          ).recover {
          case _: BaseException => NoContent
        }
    }
  }

  def likesCounter(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val countLikes = masterWishLists.Service.countLikes(nftId)
        (for {
          countLikes <- countLikes
        } yield Ok(countLikes.toString)
          ).recover {
          case baseException: BaseException => BadRequest(baseException.failure.message)
        }
    }
  }

  def selectCollection(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val collections = masterCollections.Service.getByCreator(loginState.username)
      (for {
        collections <- collections
      } yield Ok(views.html.nft.selectCollection(collections))
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def uploadNFTFileForm(collectionId: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val checkCollectionOwner = masterCollections.Service.isOwner(id = collectionId, accountId = loginState.username)
      val totalNftDrafts = masterTransactionNFTDrafts.Service.countAllForCollection(collectionId)
      (for {
        collectionOwner <- checkCollectionOwner
        totalNftDrafts <- totalNftDrafts
      } yield if (collectionOwner) Ok(views.html.nft.upload(collectionId, totalNftDrafts))
      else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def storeNFTFile(collectionId: String, documentType: String) = withLoginAction.applyMultipartFormData { implicit loginState =>
    implicit request =>
      UploadFile.form.bindFromRequest().fold(
        formWithErrors => {
          BadRequest(constants.View.BAD_REQUEST)
        },
        fileUploadInfo => {
          try {
            request.body.file(constants.File.KEY_FILE) match {
              case None => BadRequest(constants.View.BAD_REQUEST)
              case Some(file) => if (fileUploadInfo.resumableTotalSize <= constants.File.NFT_FILE_FORM.maxFileSize) {
                utilities.FileOperations.savePartialFile(Files.readAllBytes(file.ref.path), fileUploadInfo, utilities.Collection.getNFTFilePath(collectionId))
                Ok
              } else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
            }
          } catch {
            case baseException: BaseException => BadRequest(baseException.failure.message)
          }
        }
      )
  }

  def uploadNFTFile(collectionId: String, documentType: String, name: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val oldFilePath = utilities.Collection.getNFTFilePath(collectionId) + name
      val nftId = utilities.FileOperations.getFileHash(oldFilePath)
      val fileExtension = utilities.FileOperations.fileExtensionFromName(name).toLowerCase
      val newFileName = nftId + "." + fileExtension
      val awsKey = utilities.NFT.getAWSKey(fileName = newFileName)
      val collection = if (new File(oldFilePath).length() <= constants.File.NFT_FILE_FORM.maxFileSize) masterCollections.Service.tryGet(id = collectionId)
      else {
        utilities.FileOperations.deleteFile(oldFilePath)
        constants.Response.FILE_SIZE_GREATER_THAN_ALLOWED.throwBaseException()
      }

      def uploadToAws(collection: Collection) = if (collection.creatorId == loginState.username) Future(utilities.AmazonS3.uploadFile(objectKey = awsKey, filePath = oldFilePath))
      else {
        utilities.FileOperations.deleteFile(oldFilePath)
        constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
      }

      def deleteLocalFile() = Future(utilities.FileOperations.deleteFile(oldFilePath))

      def add() = masterTransactionNFTDrafts.Service.add(id = nftId, fileExtension = utilities.FileOperations.fileExtensionFromName(name), collectionId = collectionId)

      (for {
        collection <- collection
        _ <- uploadToAws(collection)
        _ <- deleteLocalFile()
        _ <- add()
      } yield Ok(constants.CommonConfig.AmazonS3.s3BucketURL + awsKey)
        ).recover {
        case baseException: BaseException => BadRequest(messagesApi(baseException.failure.message)(request.lang))
      }
  }

  def basicDetailsForm(collectionId: String, nftId: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val isOwner = masterCollections.Service.isOwner(id = collectionId, accountId = loginState.username)

      def optionalNFTDraft(isOwner: Boolean) = if (isOwner) masterTransactionNFTDrafts.Service.get(nftId)
      else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()

      (for {
        isOwner <- isOwner
        optionalNFTDraft <- optionalNFTDraft(isOwner)
      } yield Ok(views.html.nft.nftBasicDetail(collectionId = collectionId, nftId = nftId, optionalNFTDraft = optionalNFTDraft))
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def basicDetails(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      NFTBasicDetail.form.bindFromRequest().fold(
        formWithErrors => {
          val nftId = formWithErrors.data.getOrElse(constants.FormField.NFT_ID.name, "")
          val optionalNFTDraft = masterTransactionNFTDrafts.Service.get(nftId)

          (for {
            optionalNFTDraft <- optionalNFTDraft
          } yield BadRequest(views.html.nft.nftBasicDetail(formWithErrors, formWithErrors.data.getOrElse(constants.FormField.COLLECTION_ID.name, ""), nftId, optionalNFTDraft))
            ).recover {
            case baseException: BaseException => BadRequest(baseException.failure.message)
          }

        },
        basicDetailsData => {
          val collection = masterCollections.Service.tryGet(id = basicDetailsData.collectionId)

          def update(isOwner: Boolean) = if (isOwner) masterTransactionNFTDrafts.Service.updateDetails(id = basicDetailsData.nftId, name = basicDetailsData.name, description = basicDetailsData.description, totalSupply = basicDetailsData.totalSupply)
          else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()

          def addToNFT(nftDraft: NFTDraft, collection: Collection) = if (!basicDetailsData.saveAsDraft) {
            val add = masterNFTs.Service.add(nftDraft.toNFT(collection = collection))

            def addOwner(nftOwner: master.NFTOwner) = masterNFTOwners.Service.add(nftOwner)

            def deleteDraft() = masterTransactionNFTDrafts.Service.deleteNFT(nftDraft.id)

            for {
              nft <- add
              _ <- addOwner(nftDraft.toNFTOwner(ownerID = collection.creatorId, creatorId = collection.creatorId))
              _ <- deleteDraft()
              _ <- nftsAnalysis.Utility.onNewNFT(nftDraft.id, collection.id)
              _ <- utilitiesNotification.send(accountID = loginState.username, notification = constants.Notification.NFT_CREATED, nftDraft.name.getOrElse(""))(s"'${nftDraft.id}'")
            } yield ()
          } else Future()

          (for {
            collection <- collection
            nftDraft <- update(collection.creatorId == loginState.username)
            _ <- addToNFT(nftDraft, collection)
          } yield PartialContent(views.html.nft.createSuccessful(nft = nftDraft.toNFT(collection), savedAsDraft = basicDetailsData.saveAsDraft))
            ).recover {
            case baseException: BaseException => BadRequest(views.html.nft.nftBasicDetail(NFTBasicDetail.form.withGlobalError(baseException.failure.message), collectionId = basicDetailsData.collectionId, nftId = basicDetailsData.nftId, None))
          }
        }
      )
  }

  def deleteDraftForm(nftId: String, fileHash: String): Action[AnyContent] = withoutLoginAction { implicit request =>
    Ok(views.html.nft.deleteDraft(nftId, fileHash))
  }

  def deleteDraft(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      DeleteDraft.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest)
        },
        deleteDraftData => {
          val nftDraft = masterTransactionNFTDrafts.Service.tryGet(deleteDraftData.nftFileName)

          def collection(collectionId: String) = masterCollections.Service.tryGet(id = collectionId)

          def delete(isOwner: Boolean, nftDraft: NFTDraft) = if (isOwner) {
            utilities.AmazonS3.deleteObject(utilities.NFT.getAWSKey(nftDraft.getFileName))
            masterTransactionNFTDrafts.Service.delete(deleteDraftData.nftFileName)
          } else constants.Response.NOT_NFT_OWNER.throwBaseException()

          (for {
            nftDraft <- nftDraft
            collection <- collection(nftDraft.collectionId)
            _ <- delete(collection.creatorId == loginState.username, nftDraft)
          } yield Ok
            ).recover {
            case baseException: BaseException => BadRequest(baseException.failure.message)
          }
        }
      )
  }

  def price(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req, cacheWithUsername = false), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit optionalLoginState =>
      implicit request =>
        val nft = masterNFTs.Service.get(nftId)

        (for {
          nftAnalysis <- nftsAnalysis.Service.tryGet(nftId)
        } yield Ok(nftAnalysis.bestOffer.toString)
          ).recover {
          case _: BaseException => BadRequest("--")
        }
    }
  }

  def revealPropertyForm(): Action[AnyContent] = withLoginAction { implicit loginState =>
    implicit request =>
      Ok(views.html.nft.reveal())
  }

  def revealProperty(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      RevealProperty.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.nft.reveal(formWithErrors)))
        },
        revealPropertyData => {
          val data = Future(revealPropertyData.getData())

          def checkPropertyExists(data: Data) = blockchainMetas.Service.get(data.getDataID)

          val verifyPassword = masterKeys.Service.validateActiveKeyUsernamePasswordAndGet(username = loginState.username, password = revealPropertyData.password)
          val balance = blockchainBalances.Service.getTokenBalance(loginState.address)

          def verifyAndTx(verifyPassword: Boolean, balance: MicroNumber, key: Key, propertyExists: Boolean) = {
            val errors = Seq(
              if (balance == MicroNumber.zero) Option(constants.Response.INSUFFICIENT_BALANCE) else None,
              if (!verifyPassword) Option(constants.Response.INVALID_PASSWORD) else None,
              if (propertyExists) Option(constants.Response.PROPERTY_ALREADY_REVEALED) else None,
            ).flatten

            if (errors.isEmpty) {
              masterTransactionRevealPropertyTransactions.Utility.transaction(
                fromAddress = key.address,
                accountId = loginState.username,
                data = revealPropertyData.getData(),
                gasPrice = constants.Transaction.DefaultGasPrice,
                ecKey = ECKey.fromPrivate(utilities.Secrets.decryptData(key.encryptedPrivateKey, revealPropertyData.password))
              )
            } else errors.head.throwBaseException()
          }

          (for {
            data <- data
            checkPropertyExists <- checkPropertyExists(data)
            (verified, key) <- verifyPassword
            balance <- balance
            blockchainTransaction <- verifyAndTx(verifyPassword = verified, balance = balance, key = key, checkPropertyExists.isDefined)
          } yield PartialContent(views.html.transactionSuccessful(blockchainTransaction))
            ).recover {
            case baseException: BaseException => BadRequest(views.html.nft.reveal(RevealProperty.form.withGlobalError(baseException.failure.message)))
          }
        }
      )
  }

  def resource(id: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginAction { implicit request =>
      Redirect(constants.CommonConfig.AmazonS3.s3BucketURL + utilities.NFT.getAWSKey(id))
    }
  }

}