package controllers

import controllers.actions._
import exceptions.BaseException
import models.analytics.NFTsAnalysis
import models.master._
import models.{blockchain, master, masterTransaction}
import org.bitcoinj.core.ECKey
import play.api.Logger
import play.api.cache.Cached
import play.api.i18n.I18nSupport
import play.api.mvc._
import utilities.MicroNumber
import views.sale.companion._

import javax.inject.{Inject, Singleton}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

@Singleton
class SaleController @Inject()(
                                messagesControllerComponents: MessagesControllerComponents,
                                cached: Cached,
                                withoutLoginActionAsync: WithoutLoginActionAsync,
                                withLoginAction: WithLoginAction,
                                withLoginActionAsync: WithLoginActionAsync,
                                withoutLoginAction: WithoutLoginAction,
                                nftsAnalysis: NFTsAnalysis,
                                blockchainBalances: blockchain.Balances,
                                masterAccounts: master.Accounts,
                                masterKeys: master.Keys,
                                masterWhitelists: master.Whitelists,
                                masterCollections: master.Collections,
                                masterNFTs: master.NFTs,
                                masterNFTOwners: master.NFTOwners,
                                masterSales: master.Sales,
                                masterWishLists: master.WishLists,
                                masterSecondaryMarkets: master.SecondaryMarkets,
                                masterTransactionTokenPrices: masterTransaction.TokenPrices,
                                masterWhitelistMembers: master.WhitelistMembers,
                                masterTransactionSaleNFTTransactions: masterTransaction.SaleNFTTransactions,
                                utilitiesNotification: utilities.Notification,
                                utilitiesOperations: utilities.Operations,
                              )(implicit executionContext: ExecutionContext) extends AbstractController(messagesControllerComponents) with I18nSupport {

  implicit val logger: Logger = Logger(this.getClass)

  implicit val module: String = constants.Module.SALE_CONTROLLER

  implicit val callbackOnSessionTimeout: Call = routes.SaleController.viewCollections()

  def viewCollections(): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        Future(Ok(views.html.sale.viewCollections()))
    }
  }

  def collectionsSection(): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val totalCollections = masterSales.Service.total
        (for {
          totalCollections <- totalCollections
        } yield Ok(views.html.sale.collectionsSection(totalCollections))
          ).recover {
          case baseException: BaseException => BadRequest(baseException.failure.message)
        }
    }
  }

  def collectionsPerPage(pageNumber: Int): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val sales = if (pageNumber < 1) constants.Response.INVALID_PAGE_NUMBER.throwBaseException()
        else masterSales.Service.getByPageNumber(pageNumber)

        def collections(ids: Seq[String]) = masterCollections.Service.getCollections(ids)

        (for {
          sales <- sales
          collections <- collections(sales.map(_.collectionId))
        } yield Ok(views.html.sale.collectionsPerPage(collections))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def viewCollection(id: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val collection = masterCollections.Service.tryGet(id)
        (for {
          collection <- collection
        } yield Ok(views.html.sale.viewCollection(collection))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def collectionNFTs(id: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val collection = masterCollections.Service.tryGet(id)

        (for {
          collection <- collection
        } yield Ok(views.html.sale.collection.collectionNFTs(collection))
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

        def getNFTs(creatorId: String) = if (optionalLoginState.fold("")(_.username) == creatorId || pageNumber == 1) masterNFTs.Service.getForWhitelistSaleByPageNumber(id, pageNumber) else Future(Seq())

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
          secondaryMarkets <- secondaryMarkets(nfts.map(_.id))
        } yield Ok(views.html.base.commonNFTsPerPage(collection, nfts, nftOwners, likedNFTs, Seq(), pageNumber, secondaryMarkets, showCreatorSection = true, tokenPrice = 1))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def collectionTopRightCard(id: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit optionalLoginState =>
      implicit request =>
        val sale = masterSales.Service.getByNFTId(id)
        (for {
          sale <- sale
        } yield Ok(views.html.sale.collection.topRightCard(sale))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def createCollectionSaleForm(whitelistId: Option[String], nftId: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val whitelists = masterWhitelists.Service.getIdNameMapForOwner(loginState.username)
      val nft = masterNFTs.Service.tryGet(nftId)

      for {
        whitelists <- whitelists
        nft <- nft
      } yield if (whitelists.nonEmpty) Ok(views.html.sale.createCollectionSale(nft = nft, whitelistId = whitelistId, whitelists = whitelists))
      else BadRequest(constants.Response.COLLECTION_ID_OR_WHITELIST_ID_DOES_NOT_EXIST.message)
  }

  def createCollectionSale(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      CreateCollectionSale.form.bindFromRequest().fold(
        formWithErrors => {
          val nft = masterNFTs.Service.tryGet(formWithErrors.data.getOrElse(constants.FormField.SALE_NFT_ID.name, ""))
          val whitelists = masterWhitelists.Service.getIdNameMapForOwner(loginState.username)

          for {
            whitelists <- whitelists
            nft <- nft
          } yield BadRequest(views.html.sale.createCollectionSale(formWithErrors, whitelists = whitelists, whitelistId = formWithErrors.data.get(constants.FormField.SELECT_WHITELIST_ID.name), nft = nft))
        },
        createData => {
          def collection(id: String) = masterCollections.Service.tryGet(id)

          val whitelistMembers = masterWhitelistMembers.Service.getAllMembers(createData.whitelistId)
          val nft = masterNFTs.Service.tryGet(createData.nftId)

          def addToSale(collection: Collection, nft: NFT) = {
            val errors = Seq(
              if (nft.saleId.nonEmpty) Option(constants.Response.CANNOT_CREATE_MORE_THAN_ONE_SALE) else None,
              if (!loginState.isVerifiedCreator) Option(constants.Response.NOT_VERIFIED_CREATOR) else None,
              if (collection.creatorId != loginState.username) Option(constants.Response.NOT_COLLECTION_OWNER) else None,
              if (!collection.public) Option(constants.Response.COLLECTION_NOT_PUBLIC) else None,
            ).flatten
            if (errors.isEmpty) {
              for {
                saleId <- masterSales.Service.add(createData.toNewSale(collection.id))
                _ <- masterNFTs.Service.addToWhitelistSale(nft.id, saleId)
              } yield ()
            } else errors.head.throwBaseException()
          }

          def sendNotifications(whitelistMembers: Seq[String], collectionName: String): Unit = whitelistMembers.foreach { member =>
            utilitiesNotification.send(accountID = member, constants.Notification.SALE_ON_WHITELIST, collectionName)(s"'$member', '${constants.View.WHITELIST}'")
          }

          (for {
            nft <- nft
            collection <- collection(nft.collectionId)
            whitelistMembers <- whitelistMembers
            _ <- addToSale(collection = collection, nft = nft)
          } yield {
            sendNotifications(whitelistMembers, collection.name)
            PartialContent(views.html.sale.createSuccessful())
          }
            ).recover {
            case baseException: BaseException => {
              try {
                val nft = masterNFTs.Service.tryGet(createData.nftId)
                val whitelists = masterWhitelists.Service.getIdNameMapForOwner(loginState.username)

                val result = for {
                  whitelists <- whitelists
                  nft <- nft
                } yield BadRequest(views.html.sale.createCollectionSale(CreateCollectionSale.form.withGlobalError(baseException.failure.message), nft = nft, whitelists = whitelists, whitelistId = Option(createData.whitelistId)))
                Await.result(result, Duration.Inf)
              } catch {
                case baseException: BaseException => BadRequest
              }
            }
          }
        }
      )
  }

  def buySaleNFTForm(saleId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val sale = masterSales.Service.tryGet(saleId)

        def collection(id: String) = masterCollections.Service.tryGet(id)

        (for {
          sale <- sale
          collection <- collection(sale.collectionId)
        } yield Ok(views.html.sale.buySaleNFT(sale = sale, collection = collection))
          ).recover {
          case _: Exception => BadRequest
        }
    }
  }

  def buySaleNFT(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      BuySaleNFT.form.bindFromRequest().fold(
        formWithErrors => {
          val sale = masterSales.Service.tryGet(formWithErrors.data.getOrElse(constants.FormField.SALE_ID.name, ""))

          def collection(id: String) = masterCollections.Service.tryGet(id)

          (for {
            sale <- sale
            collection <- collection(sale.collectionId)
          } yield BadRequest(views.html.sale.buySaleNFT(formWithErrors, sale = sale, collection = collection))
            ).recover {
            case _: Exception => BadRequest
          }
        },
        buySaleNFTData => {
          val sale = masterSales.Service.tryGet(buySaleNFTData.saleId)
          val verifyPassword = masterKeys.Service.validateActiveKeyUsernamePasswordAndGet(username = loginState.username, password = buySaleNFTData.password)
          val balance = blockchainBalances.Service.getTokenBalance(loginState.address)
          val countBuyerNFTsFromSale = masterTransactionSaleNFTTransactions.Service.countBuyerNFTsFromSale(buyerAccountId = loginState.username, saleId = buySaleNFTData.saleId)

          def collection(id: String) = masterCollections.Service.tryGet(id)

          def nft(nftId: String) = masterNFTs.Service.tryGet(nftId)

          def sellerKey(ownerId: String) = masterKeys.Service.tryGetActive(ownerId)

          def isWhitelistMember(sale: Sale) = masterWhitelistMembers.Service.isMember(whitelistId = sale.whitelistId, accountId = loginState.username)

          def validateAndTransfer(verifyPassword: Boolean, sale: Sale, isWhitelistMember: Boolean, buyerKey: Key, sellerKey: Key, balance: MicroNumber, nft: NFT, countBuyerNFTsFromSale: Long) = {
            val errors = Seq(
              if (!isWhitelistMember) Option(constants.Response.NOT_MEMBER_OF_WHITELIST) else None,
              if (sale.startTimeEpoch > utilities.Date.currentEpoch) Option(constants.Response.SALE_NOT_STARTED) else None,
              if (utilities.Date.currentEpoch >= sale.endTimeEpoch) Option(constants.Response.SALE_EXPIRED) else None,
              if (balance == MicroNumber.zero || balance <= (sale.price * buySaleNFTData.buyNFTs)) Option(constants.Response.INSUFFICIENT_BALANCE) else None,
              if ((countBuyerNFTsFromSale + buySaleNFTData.buyNFTs) > sale.maxPerAccount) Option(constants.Response.MAXIMUM_NFT_MINT_PER_ACCOUNT_REACHED) else None,
              if (!verifyPassword) Option(constants.Response.INVALID_PASSWORD) else None,
              if (sale.numberOfNFTs == sale.totalSold || sale.isOver) Option(constants.Response.SALE_STOPPED_OR_OVER) else None,
            ).flatten
            if (errors.isEmpty) {
              masterTransactionSaleNFTTransactions.Utility.transaction(
                buyerAccountId = loginState.username,
                sellerAccountId = sellerKey.accountId,
                saleId = sale.id,
                nft = nft,
                fromAddress = buyerKey.address,
                toAddress = sellerKey.address,
                price = sale.price,
                quantity = buySaleNFTData.buyNFTs,
                gasPrice = constants.Transaction.DefaultGasPrice,
                ecKey = ECKey.fromPrivate(utilities.Secrets.decryptData(buyerKey.encryptedPrivateKey, buySaleNFTData.password))
              )
            } else errors.head.throwBaseException()
          }

          (for {
            sale <- sale
            collection <- collection(sale.collectionId)
            nft <- nft(sale.nftId)
            sellerKey <- sellerKey(collection.creatorId)
            (verifyPassword, buyerKey) <- verifyPassword
            isWhitelistMember <- isWhitelistMember(sale)
            balance <- balance
            countBuyerNFTsFromSale <- countBuyerNFTsFromSale
            blockchainTransaction <- validateAndTransfer(verifyPassword = verifyPassword, sale = sale, isWhitelistMember = isWhitelistMember, buyerKey = buyerKey, sellerKey = sellerKey, balance = balance, nft = nft, countBuyerNFTsFromSale = countBuyerNFTsFromSale)
          } yield {
            val tweetURI = if (collection.getTwitterUsername.isDefined) Option(s"https://twitter.com/intent/tweet?text=Just bought ${collection.name} NFTs via Launchpad Sale on MantlePlace. @${collection.getTwitterUsername.get} @AssetMantle Check here &url=https://marketplace.assetmantle.one/collection/${collection.id}&hashtags=NFT") else None
            PartialContent(views.html.transactionSuccessful(blockchainTransaction, tweetURI, Seq(nft)))
          }
            ).recover {
            case baseException: BaseException => {
              val badResult = {
                val sale = masterSales.Service.tryGet(buySaleNFTData.saleId)

                def collection(id: String) = masterCollections.Service.tryGet(id)

                (for {
                  sale <- sale
                  collection <- collection(sale.collectionId)
                } yield BadRequest(views.html.sale.buySaleNFT(BuySaleNFT.form.withGlobalError(baseException.failure.message), sale = sale, collection = collection))
                  ).recover {
                  case _: Exception => BadRequest
                }
              }
              Await.result(badResult, Duration.Inf)
            }
          }
        }
      )
  }

  def stopForm(saleId: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val sale = masterSales.Service.tryGet(saleId)

      (for {
        sale <- sale
      } yield Ok(views.html.sale.stop(sale = sale))
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def stop(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      StopSale.form.bindFromRequest().fold(
        formWithErrors => {
          val sale = masterSales.Service.tryGet(formWithErrors.data.getOrElse(constants.FormField.PUBLIC_LISTING_ID.name, ""))

          for {
            sale <- sale
          } yield BadRequest(views.html.sale.stop(formWithErrors, sale))
        },
        stopData => {
          val sale = masterSales.Service.tryGet(stopData.saleId)

          def collection(id: String) = masterCollections.Service.tryGet(id = id)

          def stopSale(collection: Collection, sale: Sale) = {
            val errors = Seq(
              if (collection.creatorId != loginState.username) Option(constants.Response.NOT_COLLECTION_OWNER) else None,
              if (!collection.public) Option(constants.Response.COLLECTION_NOT_PUBLIC) else None,
              if (utilities.Date.currentEpoch >= sale.endTimeEpoch) Option(constants.Response.SALE_EXPIRED) else None,
            ).flatten
            if (errors.isEmpty) {
              for {
                _ <- masterSales.Service.markStop(stopData.saleId)
              } yield ()
            } else errors.head.throwBaseException()
          }

          (for {
            sale <- sale
            collection <- collection(sale.collectionId)
            _ <- stopSale(collection, sale)
          } yield PartialContent(views.html.sale.stopSuccessful())
            ).recover {
            case baseException: BaseException => {
              try {
                val sale = masterSales.Service.tryGet(stopData.saleId)

                val result = for {
                  sale <- sale
                } yield BadRequest(views.html.sale.stop(StopSale.form.withGlobalError(baseException.failure.message), sale))
                Await.result(result, Duration.Inf)
              } catch {
                case baseException: BaseException => BadRequest(baseException.failure.message)
              }
            }
          }
        }
      )
  }

}
