package controllers

import controllers.actions._
import exceptions.BaseException
import models.analytics.NFTsAnalysis
import models.common.Collection.Detail
import models.master.{Collection, NFT, PublicListing}
import models.masterTransaction.CollectionDraft
import models.{master, masterTransaction}
import play.api.Logger
import play.api.cache.Cached
import play.api.i18n.I18nSupport
import play.api.mvc._
import utilities.MicroNumber
import views.base.companion.UploadFile
import views.collection.companion._

import java.io.File
import java.nio.file.Files
import javax.inject.{Inject, Singleton}
import scala.concurrent.{Await, ExecutionContext, Future}

@Singleton
class CollectionController @Inject()(
                                      messagesControllerComponents: MessagesControllerComponents,
                                      cached: Cached,
                                      withoutLoginAction: WithoutLoginAction,
                                      withoutLoginActionAsync: WithoutLoginActionAsync,
                                      withLoginActionAsync: WithLoginActionAsync,
                                      withLoginAction: WithLoginAction,
                                      nftsAnalysis: NFTsAnalysis,
                                      masterAccounts: master.Accounts,
                                      masterCollections: master.Collections,
                                      masterTransactionCollectionDrafts: masterTransaction.CollectionDrafts,
                                      masterTransactionTokenPrices: masterTransaction.TokenPrices,
                                      masterTransactionPublicListingNFTTransactions: masterTransaction.PublicListingNFTTransactions,
                                      masterTransactionSaleNFTTransactions: masterTransaction.SaleNFTTransactions,
                                      masterNFTs: master.NFTs,
                                      masterSales: master.Sales,
                                      masterPublicListings: master.PublicListings,
                                      masterNFTOwners: master.NFTOwners,
                                      masterTransactionNFTDrafts: masterTransaction.NFTDrafts,
                                      masterWhitelists: master.Whitelists,
                                      masterWhitelistMembers: master.WhitelistMembers,
                                      masterWishLists: master.WishLists,
                                      utilitiesNotification: utilities.Notification,
                                      masterSecondaryMarkets: master.SecondaryMarkets,
                                    )(implicit executionContext: ExecutionContext) extends AbstractController(messagesControllerComponents) with I18nSupport {

  implicit val logger: Logger = Logger(this.getClass)

  implicit val module: String = constants.Module.COLLECTION_CONTROLLER

  implicit val callbackOnSessionTimeout: Call = routes.CollectionController.viewCollections()

  def viewCollections(): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        Future(Ok(views.html.collection.viewCollections()))
    }
  }

  def viewCollection(id: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val collection = masterCollections.Service.tryGet(id)
        (for {
          collection <- collection
        } yield Ok(views.html.collection.viewCollection(collection))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def collectionsSection(): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        Future(Ok(views.html.collection.all.collectionsSection()))
    }
  }

  def collectionList(): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val totalCollections = masterCollections.Service.countPublicCollections

        (for {
          totalCollections <- totalCollections
        } yield Ok(views.html.collection.all.collectionList(totalCollections))
          ).recover {
          case baseException: BaseException => BadRequest(baseException.failure.message)
        }
    }
  }

  def collectionsPerPage(pageNumber: Int): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val collections = if (pageNumber < 1) constants.Response.INVALID_PAGE_NUMBER.throwBaseException()
        else masterCollections.Service.getPublicByPageNumber(pageNumber)

        (for {
          collections <- collections
        } yield Ok(views.html.collection.all.collectionsPerPage(collections))
          ).recover {
          case baseException: BaseException => BadRequest(baseException.failure.message)
        }
    }
  }

  def collectionNFTs(id: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val collection = masterCollections.Service.tryGet(id)

        (for {
          collection <- collection
        } yield Ok(views.html.collection.details.collectionNFTs(collection))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def collectionNFTsPerPage(id: String, pageNumber: Int): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit optionalLoginState =>
      implicit request =>
        val collection = if (pageNumber < 1) constants.Response.INVALID_PAGE_NUMBER.throwBaseException()
        else masterCollections.Service.tryGet(id)
        val tokenPrice = masterTransactionTokenPrices.Service.getLatestPrice

        def getNFTs(creatorId: String) = if (optionalLoginState.fold("")(_.username) == creatorId || pageNumber == 1) masterNFTs.Service.getByPageNumber(id, pageNumber) else Future(Seq())

        def nftDrafts(collection: Collection) = if (optionalLoginState.fold("")(_.username) == collection.creatorId) masterTransactionNFTDrafts.Service.getAllForCollection(id) else Future(Seq())

        def secondaryMarkets(nftIds: Seq[String]) = masterSecondaryMarkets.Service.getBySortedNFTIDs(nftIds)

        def getOwnersAndLiked(nftIds: Seq[String]) = if (optionalLoginState.isDefined && nftIds.nonEmpty) {
          val nftOwners = masterNFTOwners.Service.getByOwnerAndIds(ownerId = optionalLoginState.get.username, nftIDs = nftIds)
          val nftLiked = masterWishLists.Service.getByNFTIds(accountId = optionalLoginState.get.username, nftIDs = nftIds)

          for {
            nftOwners <- nftOwners
            nftLiked <- nftLiked
          } yield (nftOwners, nftLiked)
        } else Future(Seq(), Seq())

        (for {
          collection <- collection
          nfts <- getNFTs(collection.creatorId)
          (nftOwners, likedNFTs) <- getOwnersAndLiked(nfts.map(_.id))
          nftDrafts <- nftDrafts(collection)
          secondaryMarkets <- secondaryMarkets(nfts.map(_.id))
        } yield Ok(views.html.base.commonNFTsPerPage(collection, nfts, nftOwners, likedNFTs, nftDrafts, pageNumber, secondaryMarkets, showCreatorSection = true, tokenPrice = tokenPrice))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def info(id: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val collection = masterCollections.Service.tryGet(id)
        (for {
          collection <- collection
        } yield Ok(views.html.collection.details.collectionInfo(collection))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def topRightCard(id: String): Action[AnyContent] = withoutLoginActionAsync { implicit optionalLoginState =>
    implicit request =>
      val collection = masterCollections.Service.tryGet(id)
      val totalNFTs = masterNFTs.Service.countNFTs(id)

      (for {
        totalNFTs <- totalNFTs
        collection <- collection
      } yield Ok(views.html.collection.details.topRightCard(totalNFTs = totalNFTs, collection = collection))
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def commonCardInfo(id: String, statusId: Int): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val nftAnalysis = nftsAnalysis.Service.tryGet(id)
        val totalNFTs = masterNFTs.Service.countNFTs(id)
        val publicListing = if (statusId == 1) masterPublicListings.Service.getPublicListingByCollectionId(id) else Future(None)
        val sale = if (statusId == 2) masterSales.Service.getSalesByCollectionId(id) else Future(None)
        val tokenPrice = masterTransactionTokenPrices.Service.getLatestPrice

        def publicListingStatus(publicListing: Option[PublicListing]) = if (publicListing.isDefined) masterTransactionPublicListingNFTTransactions.Service.getTotalPublicListingSold(publicListing.get.id).map(x => publicListing.get.getStatus(x).id) else Future(0)

        (for {
          nftAnalysis <- nftAnalysis
          publicListing <- publicListing
          sale <- sale
          publicListingStatus <- publicListingStatus(publicListing)
        } yield {
          if (statusId == 0) {
            val lowestPrice = Seq(nftAnalysis.bestOffer, publicListing.fold(MicroNumber.zero)(_.price), sale.fold(MicroNumber.zero)(_.price)).filter(_ > MicroNumber.zero).min
            val saleStatus = if (lowestPrice == nftAnalysis.bestOffer) 3 else 0
            Ok(s"${totalNFTs.toString}|${s"${lowestPrice.toString} (${utilities.NumericOperation.formatNumber(lowestPrice.toDouble * tokenPrice)} $$)"}|${saleStatus}")
          } else if (statusId == 1) {
            Ok(s"${totalNFTs.toString}|${s"${publicListing.fold(MicroNumber.zero)(_.price).toString} (${utilities.NumericOperation.formatNumber(publicListing.fold(MicroNumber.zero)(_.price).toDouble * tokenPrice)} $$)"}|${publicListingStatus}")
          } else if (statusId == 2) {
            Ok(s"${totalNFTs.toString}|${s"${sale.fold(MicroNumber.zero)(_.price).toString} (${utilities.NumericOperation.formatNumber(sale.fold(MicroNumber.zero)(_.price).toDouble * tokenPrice)} $$)"}|${sale.fold(0)(_.getStatus.id)}")
          } else {
            Ok(s"${totalNFTs.toString}|${nftAnalysis.bestOffer.toString} (${utilities.NumericOperation.formatNumber(nftAnalysis.bestOffer.toDouble * tokenPrice)} $$)}|1")
          }
        }
          ).recover {
          case baseException: BaseException => BadRequest(baseException.failure.message)
        }
    }
  }

  def createdSection(accountId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        Future(Ok(views.html.profile.created.createdSection(accountId, allowCreateCollection = loginState.fold("")(_.username) == accountId)))
    }
  }

  def createdCollectionPerPage(accountId: String, pageNumber: Int): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit optionalLoginState =>
      implicit request =>
        val collections = masterCollections.Service.getByCreatorAndPage(accountId, pageNumber)
        val totalCreated = masterCollections.Service.totalCreated(accountId)
        val drafts = if (pageNumber == 1 && optionalLoginState.fold("")(_.username) == accountId) masterTransactionCollectionDrafts.Service.getByCreatorAndPage(accountId, pageNumber)
        else Future(Seq())

        (for {
          totalCreated <- totalCreated
          collections <- collections
          drafts <- drafts
        } yield Ok(views.html.profile.created.collectionPerPage(collections, drafts = drafts, totalCollections = totalCreated))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def createForm(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val totalDrafts = masterTransactionCollectionDrafts.Service.totalDrafts(loginState.username)
      for {
        totalDrafts <- totalDrafts
      } yield Ok(views.html.collection.create(totalDrafts = totalDrafts))
  }

  def create(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      Create.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.collection.create(formWithErrors, 0)))
        },
        createData => {
          //          val collectionDraft = if (loginState.isVerifiedCreator) masterTransactionCollectionDrafts.Service.add(name = createData.name, description = createData.description, socialProfiles = createData.getSocialProfiles, creatorId = loginState.username, nsfw = createData.nsfw, royalty = createData.royalty / 100)
          //          else constants.Response.NOT_VERIFIED_CREATOR.throwFutureBaseException()

          val collectionDraft = masterTransactionCollectionDrafts.Service.add(name = createData.name, detail = createData.getDetail, city = createData.city, category = createData.category, socialProfiles = createData.getSocialProfiles, creatorId = loginState.username, royalty = createData.royalty / 100)

          (for {
            collectionDraft <- collectionDraft
          } yield PartialContent(views.html.collection.uploadDraftFile(collectionDraft = collectionDraft))).recover {
            case baseException: BaseException => BadRequest(views.html.collection.create(Create.form.withGlobalError(baseException.failure.message), 0))
          }
        }
      )
  }

  def editForm(id: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val collectionDraft = masterTransactionCollectionDrafts.Service.tryGet(id)
      (for {
        collectionDraft <- collectionDraft
      } yield if (collectionDraft.creatorId == loginState.username) Ok(views.html.collection.edit(collectionDraft = collectionDraft)) else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def edit(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      Edit.form.bindFromRequest().fold(
        formWithErrors => {
          val collectionDraft = masterTransactionCollectionDrafts.Service.tryGet(formWithErrors.data.getOrElse(constants.FormField.COLLECTION_ID.name, ""))
          (for {
            collectionDraft <- collectionDraft
          } yield if (collectionDraft.creatorId == loginState.username) BadRequest(views.html.collection.edit(formWithErrors, collectionDraft)) else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
            ).recover {
            case baseException: BaseException => BadRequest(baseException.failure.message)
          }
        },
        editData => {
          val update = masterTransactionCollectionDrafts.Service.checkOwnerAndUpdate(id = editData.collectionId, name = editData.name, detail = editData.getDetail, city = editData.city, category = editData.category, socialProfiles = editData.getSocialProfiles, creatorId = loginState.username, royalty = editData.royalty / 100)

          (for {
            collectionDraft <- update
          } yield PartialContent(views.html.collection.uploadDraftFile(collectionDraft = collectionDraft))
            ).recover {
            case baseException: BaseException => {
              try {
                val collectionDraft = Await.result(masterTransactionCollectionDrafts.Service.tryGet(editData.collectionId), constants.Time.FiveSecond)
                BadRequest(views.html.collection.edit(Edit.form.withGlobalError(baseException.failure.message), collectionDraft))
              } catch {
                case exception: Exception => BadRequest(views.html.collection.edit(Edit.form.withGlobalError(exception.getLocalizedMessage), CollectionDraft("", "", "", Detail("", "", "", "", 0, 0), "", Seq(), "", None, None, 0)))
              }
            }
          }
        }
      )
  }

  def updateRoyaltyForm(id: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val collection = masterCollections.Service.tryGet(id)
      (for {
        collection <- collection
      } yield if (collection.creatorId == loginState.username) Ok(views.html.collection.updateRoyalty(collection = collection)) else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def updateRoyalty(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      UpdateRoyalty.form.bindFromRequest().fold(
        formWithErrors => {
          val collection = masterCollections.Service.tryGet(formWithErrors.data.getOrElse(constants.FormField.COLLECTION_ID.name, ""))
          (for {
            collection <- collection
          } yield if (collection.creatorId == loginState.username) BadRequest(views.html.collection.updateRoyalty(formWithErrors, collection)) else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
            ).recover {
            case baseException: BaseException => BadRequest(baseException.failure.message)
          }
        },
        updateRoyaltyData => {
          val collection = masterCollections.Service.tryGet(updateRoyaltyData.collectionId)

          def update(collection: Collection) = {
            val errors = Seq(
              if (collection.creatorId != loginState.username) Option(constants.Response.NOT_COLLECTION_OWNER) else None
            ).flatten
            if (errors.isEmpty) {
              for {
                _ <- masterCollections.Service.update(collection.copy(royalty = updateRoyaltyData.royalty / 100))
              } yield ()
            } else errors.head.throwBaseException()
          }

          (for {
            collection <- collection
            _ <- update(collection)
          } yield Ok(views.html.collection.updateRoyaltySuccess(updateRoyaltyData.royalty.toString()))
            ).recover {
            case baseException: BaseException => {
              BadRequest(views.html.collection.updateRoyalty(UpdateRoyalty.form.withGlobalError(baseException.failure.message), Await.result(collection, constants.Time.FiveSecond)))
            }
          }
        }
      )
  }

  def uploadCollectionDraftFilesForm(id: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val collectionDraft = masterTransactionCollectionDrafts.Service.tryGet(id)
      (for {
        collectionDraft <- collectionDraft
      } yield if (collectionDraft.creatorId == loginState.username) Ok(views.html.collection.uploadDraftFile(collectionDraft = collectionDraft)) else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def uploadCollectionDraftFileForm(id: String, documentType: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val checkCollectionOwner = masterTransactionCollectionDrafts.Service.isOwner(id = id, accountId = loginState.username)
      (for {
        collectionOwner <- checkCollectionOwner
      } yield if (collectionOwner) Ok(views.html.base.commonUploadFile(constants.File.COLLECTION_DRAFT_FILE_FORM, id = id, documentType = documentType))
      else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def storeCollectionDraftFile(id: String, documentType: String) = withLoginAction.applyMultipartFormData { implicit loginState =>
    implicit request =>
      UploadFile.form.bindFromRequest().fold(
        formWithErrors => {
          BadRequest(constants.View.BAD_REQUEST)
        },
        fileUploadInfo => {
          try {
            request.body.file(constants.File.KEY_FILE) match {
              case None => BadRequest(constants.View.BAD_REQUEST)
              case Some(file) => if (fileUploadInfo.resumableTotalSize <= constants.File.COLLECTION_DRAFT_FILE_FORM.maxFileSize) {
                utilities.FileOperations.savePartialFile(Files.readAllBytes(file.ref.path), fileUploadInfo, utilities.Collection.getFilePath(id))
                Ok
              } else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
            }
          } catch {
            case baseException: BaseException => BadRequest(baseException.failure.message)
          }
        }
      )
  }

  def uploadCollectionDraftFile(id: String, documentType: String, name: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val oldFilePath = utilities.Collection.getFilePath(id) + name
      val collectionDraft = if (new File(oldFilePath).length() <= constants.File.COLLECTION_DRAFT_FILE_FORM.maxFileSize) masterTransactionCollectionDrafts.Service.tryGet(id = id)
      else {
        utilities.FileOperations.deleteFile(oldFilePath)
        constants.Response.FILE_SIZE_GREATER_THAN_ALLOWED.throwBaseException()
      }
      val newFileName = utilities.FileOperations.getFileHash(oldFilePath) + "." + utilities.FileOperations.fileExtensionFromName(name)
      val awsKey = utilities.Collection.getOthersFileAwsKey(collectionId = id, fileName = newFileName)

      def uploadToAws(collectionDraft: CollectionDraft) = if (collectionDraft.creatorId == loginState.username) {
        val uploadLatest = Future(utilities.AmazonS3.uploadFile(objectKey = awsKey, filePath = oldFilePath))

        def deleteOldAws() = Future(documentType match {
          case constants.Collection.File.PROFILE => collectionDraft.profileFileName.map(x => utilities.AmazonS3.deleteObject(utilities.Collection.getOthersFileAwsKey(collectionId = id, fileName = x)))
          case constants.Collection.File.COVER => collectionDraft.coverFileName.map(x => utilities.AmazonS3.deleteObject(utilities.Collection.getOthersFileAwsKey(collectionId = id, fileName = x)))
          case _ => constants.Response.INVALID_DOCUMENT_TYPE.throwBaseException()
        })

        for {
          _ <- uploadLatest
          _ <- deleteOldAws()
        } yield ()
      } else {
        utilities.FileOperations.deleteFile(oldFilePath)
        constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
      }

      def deleteLocalFile() = Future(utilities.FileOperations.deleteFile(oldFilePath))

      def add = documentType match {
        case constants.Collection.File.PROFILE => masterTransactionCollectionDrafts.Service.updateProfile(id = id, fileName = newFileName)
        case constants.Collection.File.COVER => masterTransactionCollectionDrafts.Service.updateCover(id = id, fileName = newFileName)
        case _ => constants.Response.INVALID_DOCUMENT_TYPE.throwBaseException()
      }

      (for {
        collectionDraft <- collectionDraft
        _ <- uploadToAws(collectionDraft)
        _ <- deleteLocalFile()
        _ <- add
      } yield Ok(constants.CommonConfig.AmazonS3.s3BucketURL + awsKey)
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def deleteDraftForm(collectionId: String): Action[AnyContent] = withoutLoginAction { implicit request =>
    Ok(views.html.collection.deleteDraft(collectionId))
  }

  def deleteDraft(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      DeleteDraft.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest)
        },
        deleteDraftData => {
          val delete = masterTransactionCollectionDrafts.Service.checkOwnerAndDelete(id = deleteDraftData.collectionId, accountId = loginState.username)

          (for {
            _ <- delete
          } yield Ok
            ).recover {
            case baseException: BaseException => BadRequest(baseException.failure.message)
          }
        }
      )
  }

  def countForCreatorNotForSale(nftId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>

        val nft = masterNFTs.Service.tryGet(nftId)

        def collection(nft: NFT) = masterCollections.Service.tryGet(nft.collectionId)

        def creatorNFTOwner(collection: Collection) = masterNFTOwners.Service.tryGet(nftId = nftId, ownerId = collection.creatorId)

        (for {
          nft <- nft
          collection <- collection(nft)
          nftOwner <- creatorNFTOwner(collection)
        } yield {
          Ok(nftOwner.quantity.toString())
        }
          ).recover {
          case _: BaseException => BadRequest("0")
        }
    }
  }

  def uploadCollectionFilesForm(id: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val collection = masterCollections.Service.tryGet(id)
      (for {
        collection <- collection
      } yield if (collection.creatorId == loginState.username) Ok(views.html.collection.uploadFile(collection = collection)) else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def uploadCollectionFileForm(id: String, documentType: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val checkCollectionOwner = masterCollections.Service.isOwner(id = id, accountId = loginState.username)
      (for {
        collectionOwner <- checkCollectionOwner
      } yield if (collectionOwner) Ok(views.html.base.commonUploadFile(constants.File.COLLECTION_FILE_FORM, id = id, documentType = documentType))
      else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def storeCollectionFile(id: String, documentType: String) = withLoginAction.applyMultipartFormData { implicit loginState =>
    implicit request =>
      UploadFile.form.bindFromRequest().fold(
        formWithErrors => {
          BadRequest(constants.View.BAD_REQUEST)
        },
        fileUploadInfo => {
          try {
            request.body.file(constants.File.KEY_FILE) match {
              case None => BadRequest(constants.View.BAD_REQUEST)
              case Some(file) => if (fileUploadInfo.resumableTotalSize <= constants.File.COLLECTION_FILE_FORM.maxFileSize) {
                utilities.FileOperations.savePartialFile(Files.readAllBytes(file.ref.path), fileUploadInfo, utilities.Collection.getFilePath(id))
                Ok
              } else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
            }
          } catch {
            case baseException: BaseException => BadRequest(baseException.failure.message)
          }
        }
      )
  }

  def uploadCollectionFile(id: String, documentType: String, name: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val oldFilePath = utilities.Collection.getFilePath(id) + name
      val collection = if (new File(oldFilePath).length() <= constants.File.COLLECTION_FILE_FORM.maxFileSize) masterCollections.Service.tryGet(id = id)
      else {
        utilities.FileOperations.deleteFile(oldFilePath)
        constants.Response.FILE_SIZE_GREATER_THAN_ALLOWED.throwBaseException()
      }
      val newFileName = utilities.FileOperations.getFileHash(oldFilePath) + "." + utilities.FileOperations.fileExtensionFromName(name)
      val awsKey = utilities.Collection.getOthersFileAwsKey(collectionId = id, fileName = newFileName)

      def uploadToAws(collection: Collection) = if (collection.creatorId == loginState.username) {
        val uploadLatest = Future(utilities.AmazonS3.uploadFile(objectKey = awsKey, filePath = oldFilePath))

        def deleteOldAws() = Future(documentType match {
          case constants.Collection.File.PROFILE => collection.profileFileName.map(x => utilities.AmazonS3.deleteObject(utilities.Collection.getOthersFileAwsKey(collectionId = id, fileName = x)))
          case constants.Collection.File.COVER => collection.coverFileName.map(x => utilities.AmazonS3.deleteObject(utilities.Collection.getOthersFileAwsKey(collectionId = id, fileName = x)))
          case _ => constants.Response.INVALID_DOCUMENT_TYPE.throwBaseException()
        })

        for {
          _ <- uploadLatest
          _ <- deleteOldAws()
        } yield ()
      } else {
        utilities.FileOperations.deleteFile(oldFilePath)
        constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
      }

      def deleteLocalFile() = Future(utilities.FileOperations.deleteFile(oldFilePath))

      def updateFile = documentType match {
        case constants.Collection.File.PROFILE => masterCollections.Service.updateProfile(id = id, fileName = newFileName)
        case constants.Collection.File.COVER => masterCollections.Service.updateCover(id = id, fileName = newFileName)
        case _ => constants.Response.INVALID_DOCUMENT_TYPE.throwBaseException()
      }

      (for {
        collection <- collection
        _ <- uploadToAws(collection)
        _ <- deleteLocalFile()
        _ <- updateFile
      } yield Ok(constants.CommonConfig.AmazonS3.s3BucketURL + awsKey)
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def genesisTypeForm(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      Future(Ok(views.html.base.genesisTypeForm()))
  }
}