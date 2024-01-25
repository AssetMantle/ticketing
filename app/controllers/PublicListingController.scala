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
import views.publicListing.companion._

import javax.inject.{Inject, Singleton}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

@Singleton
class PublicListingController @Inject()(
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
                                         masterCollections: master.Collections,
                                         masterNFTs: master.NFTs,
                                         masterSecondaryMarkets: master.SecondaryMarkets,
                                         masterPublicListings: master.PublicListings,
                                         masterWishLists: master.WishLists,
                                         masterNFTOwners: master.NFTOwners,
                                         masterTransactionPublicListingNFTTransactions: masterTransaction.PublicListingNFTTransactions,
                                         utilitiesNotification: utilities.Notification,
                                         utilitiesOperations: utilities.Operations,
                                         masterTransactionTokenPrices: masterTransaction.TokenPrices,
                                       )(implicit executionContext: ExecutionContext) extends AbstractController(messagesControllerComponents) with I18nSupport {

  implicit val logger: Logger = Logger(this.getClass)

  implicit val module: String = constants.Module.PUBLIC_LISTING_CONTROLLER

  implicit val callbackOnSessionTimeout: Call = routes.PublicListingController.viewCollections()

  def viewCollections(): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        Future(Ok(views.html.publicListing.viewCollections()))
    }
  }

  def collectionsSection(): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val totalCollections = masterPublicListings.Service.total
        (for {
          totalCollections <- totalCollections
        } yield Ok(views.html.publicListing.collectionsSection(totalCollections))
          ).recover {
          case baseException: BaseException => BadRequest(baseException.failure.message)
        }
    }
  }

  def collectionsPerPage(pageNumber: Int): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val publicListings = if (pageNumber < 1) constants.Response.INVALID_PAGE_NUMBER.throwBaseException()
        else masterPublicListings.Service.getByPageNumber(pageNumber)

        def collections(ids: Seq[String]) = masterCollections.Service.getCollections(ids)

        (for {
          publicListings <- publicListings
          collections <- collections(publicListings.map(_.collectionId))
        } yield Ok(views.html.publicListing.collectionsPerPage(collections))
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
        } yield Ok(views.html.publicListing.viewCollection(collection))
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
        } yield Ok(views.html.publicListing.collection.collectionNFTs(collection))
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

        def getNFTs(creatorId: String) = if (optionalLoginState.fold("")(_.username) == creatorId || pageNumber == 1) masterNFTs.Service.getForEarlyAccessByPageNumber(id, pageNumber) else Future(Seq())

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
        val publicListing = masterPublicListings.Service.getPublicListingByNFTId(id)

        (for {
          publicListing <- publicListing
        } yield Ok(views.html.publicListing.collection.topRightCard(publicListing))
          ).recover {
          case baseException: BaseException => InternalServerError(baseException.failure.message)
        }
    }
  }

  def createPublicListingForm(nftId: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val nft = masterNFTs.Service.tryGet(nftId)

      (for {
        nft <- nft
      } yield Ok(views.html.publicListing.createPublicListing(nft = nft))
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def createPublicListing(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      CreatePublicListing.form.bindFromRequest().fold(
        formWithErrors => {
          val nft = masterNFTs.Service.tryGet(formWithErrors.data.getOrElse(constants.FormField.SALE_NFT_ID.name, ""))

          for {
            nft <- nft
          } yield BadRequest(views.html.publicListing.createPublicListing(formWithErrors, nft = nft))
        },
        createData => {
          val nft = masterNFTs.Service.tryGet(createData.nftId)

          def collection(id: String) = masterCollections.Service.tryGet(id)

          def addToPublicListing(collection: Collection, nft: NFT) = {
            val errors = Seq(
              if (nft.publicListingId.nonEmpty) Option(constants.Response.CANNOT_CREATE_MORE_THAN_ONE_SALE) else None,
              if (!loginState.isVerifiedCreator) Option(constants.Response.NOT_VERIFIED_CREATOR) else None,
              if (collection.creatorId != loginState.username) Option(constants.Response.NOT_COLLECTION_OWNER) else None,
              if (!collection.public) Option(constants.Response.COLLECTION_NOT_PUBLIC) else None,
            ).flatten
            if (errors.isEmpty) {
              for {
                publicListingId <- masterPublicListings.Service.add(createData.toNewPublicListing(collection.id))
                _ <- masterNFTs.Service.addToPublishingSale(nft.id, publicListingId)
              } yield ()
            } else errors.head.throwBaseException()
          }

          def sendNotification(collectionName: String, collectionId: String) = utilitiesNotification.send(loginState.username, notification = constants.Notification.PUBLIC_LISTING_ON_COLLECTION, collectionName)(s"'${collectionId}'")

          (for {
            nft <- nft
            collection <- collection(nft.collectionId)
            _ <- addToPublicListing(collection, nft)
            _ <- sendNotification(collection.name, collection.id)
          } yield PartialContent(views.html.publicListing.createSuccessful())
            ).recover {
            case baseException: BaseException => {
              try {
                val nft = masterNFTs.Service.tryGet(createData.nftId)

                val result = for {
                  nft <- nft
                } yield BadRequest(views.html.publicListing.createPublicListing(CreatePublicListing.form.withGlobalError(baseException.failure.message), nft))
                Await.result(result, Duration.Inf)
              } catch {
                case baseException: BaseException => BadRequest
              }
            }
          }
        }
      )
  }

  def stopForm(publicListingId: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      val publicListing = masterPublicListings.Service.tryGet(publicListingId)

      (for {
        publicListing <- publicListing
      } yield Ok(views.html.publicListing.stop(publicListing = publicListing))
        ).recover {
        case baseException: BaseException => BadRequest(baseException.failure.message)
      }
  }

  def stop(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      StopPublicListing.form.bindFromRequest().fold(
        formWithErrors => {
          val publicListing = masterPublicListings.Service.tryGet(formWithErrors.data.getOrElse(constants.FormField.PUBLIC_LISTING_ID.name, ""))

          for {
            publicListing <- publicListing
          } yield BadRequest(views.html.publicListing.stop(formWithErrors, publicListing))
        },
        stopData => {
          val publicListing = masterPublicListings.Service.tryGet(stopData.publicListingId)

          def collection(id: String) = masterCollections.Service.tryGet(id = id)

          def stopPublicListing(collection: Collection, publicListing: PublicListing) = {
            val errors = Seq(
              if (collection.creatorId != loginState.username) Option(constants.Response.NOT_COLLECTION_OWNER) else None,
              if (!collection.public) Option(constants.Response.COLLECTION_NOT_PUBLIC) else None,
              if (utilities.Date.currentEpoch >= publicListing.endTimeEpoch) Option(constants.Response.SALE_EXPIRED) else None,
            ).flatten
            if (errors.isEmpty) {
              for {
                _ <- masterPublicListings.Service.markStop(stopData.publicListingId)
              } yield ()
            } else errors.head.throwBaseException()
          }

          (for {
            publicListing <- publicListing
            collection <- collection(publicListing.collectionId)
            _ <- stopPublicListing(collection, publicListing)
          } yield PartialContent(views.html.publicListing.stopSuccessful())
            ).recover {
            case baseException: BaseException => {
              try {
                val publicListing = masterPublicListings.Service.tryGet(stopData.publicListingId)

                val result = for {
                  publicListing <- publicListing
                } yield BadRequest(views.html.publicListing.stop(StopPublicListing.form.withGlobalError(baseException.failure.message), publicListing))
                Await.result(result, Duration.Inf)
              } catch {
                case baseException: BaseException => BadRequest(baseException.failure.message)
              }
            }
          }
        }
      )
  }

  def buyNFTForm(publicListingId: String): EssentialAction = cached(req => utilities.Session.getSessionCachingKey(req), constants.CommonConfig.WebAppCacheDuration) {
    withoutLoginActionAsync { implicit loginState =>
      implicit request =>
        val publicListing = masterPublicListings.Service.tryGet(publicListingId)

        def collection(id: String) = masterCollections.Service.tryGet(id)

        (for {
          publicListing <- publicListing
          collection <- collection(publicListing.collectionId)
        } yield Ok(views.html.publicListing.buyNFT(publicListing = publicListing, collection = collection))
          ).recover {
          case _: BaseException => BadRequest
        }
    }
  }

  def buyNFT(): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      BuyNFT.form.bindFromRequest().fold(
        formWithErrors => {
          val publicListing = masterPublicListings.Service.tryGet(formWithErrors.data.getOrElse(constants.FormField.PUBLIC_LISTING_ID.name, ""))

          def collection(id: String) = masterCollections.Service.tryGet(id)

          (for {
            publicListing <- publicListing
            collection <- collection(publicListing.collectionId)
          } yield BadRequest(views.html.publicListing.buyNFT(formWithErrors, publicListing, collection))
            ).recover {
            case _: BaseException => BadRequest
          }
        },
        buyNFTData => {
          val publicListing = masterPublicListings.Service.tryGet(buyNFTData.publicListingId)
          val verifyPassword = masterKeys.Service.validateActiveKeyUsernamePasswordAndGet(username = loginState.username, password = buyNFTData.password)
          val balance = blockchainBalances.Service.getTokenBalance(loginState.address)
          val countBuyerNFTsFromPublicListing = masterTransactionPublicListingNFTTransactions.Service.countBuyerNFTsFromPublicListing(buyerAccountId = loginState.username, publicListingId = buyNFTData.publicListingId)

          def collection(id: String) = masterCollections.Service.tryGet(id)

          def nft(publicListing: PublicListing) = masterNFTs.Service.tryGet(publicListing.nftId)

          def sellerKey(ownerId: String) = masterKeys.Service.tryGetActive(ownerId)

          def validateAndTransfer(verifyPassword: Boolean, publicListing: PublicListing, buyerKey: Key, collection: Collection, sellerKey: Key, balance: MicroNumber, nft: NFT, countBuyerNFTsFromPublicListing: Long) = {
            val errors = Seq(
              if (publicListing.startTimeEpoch > utilities.Date.currentEpoch) Option(constants.Response.EARLY_ACCESS_NOT_STARTED) else None,
              if (utilities.Date.currentEpoch >= publicListing.endTimeEpoch) Option(constants.Response.EARLY_ACCESS_ENDED) else None,
              if (balance == MicroNumber.zero || balance <= (publicListing.price * buyNFTData.buyNFTs)) Option(constants.Response.INSUFFICIENT_BALANCE) else None,
              if ((countBuyerNFTsFromPublicListing + buyNFTData.buyNFTs) > publicListing.maxPerAccount) Option(constants.Response.MAXIMUM_NFT_MINT_PER_ACCOUNT_REACHED) else None,
              if (!verifyPassword) Option(constants.Response.INVALID_PASSWORD) else None,
              if (publicListing.numberOfNFTs == publicListing.totalSold || publicListing.isOver) Option(constants.Response.SALE_STOPPED_OR_OVER) else None,
            ).flatten
            if (errors.isEmpty) {
              masterTransactionPublicListingNFTTransactions.Utility.transaction(
                buyerAccountId = loginState.username,
                sellerAccountId = sellerKey.accountId,
                publicListingId = publicListing.id,
                nft = nft,
                fromAddress = buyerKey.address,
                toAddress = sellerKey.address,
                price = publicListing.price,
                gasPrice = constants.Transaction.DefaultGasPrice,
                ecKey = ECKey.fromPrivate(utilities.Secrets.decryptData(buyerKey.encryptedPrivateKey, buyNFTData.password)),
                quantity = buyNFTData.buyNFTs
              )
            } else errors.head.throwBaseException()
          }

          (for {
            publicListing <- publicListing
            collection <- collection(publicListing.collectionId)
            sellerKey <- sellerKey(collection.creatorId)
            (verifyPassword, buyerKey) <- verifyPassword
            nft <- nft(publicListing)
            balance <- balance
            countBuyerNFTsFromPublicListing <- countBuyerNFTsFromPublicListing
            blockchainTransaction <- validateAndTransfer(verifyPassword = verifyPassword, publicListing = publicListing, buyerKey = buyerKey, collection = collection, sellerKey = sellerKey, balance = balance, nft = nft, countBuyerNFTsFromPublicListing = countBuyerNFTsFromPublicListing)
          } yield {
            val tweetURI = if (collection.getTwitterUsername.isDefined) Option(s"https://twitter.com/intent/tweet?text=Just bought ${collection.name} NFTs via Early Access Sale on MantlePlace. @${collection.getTwitterUsername.get} @AssetMantle Check here &url=https://marketplace.assetmantle.one/collection/${collection.id}&hashtags=NFT") else None
            PartialContent(views.html.transactionSuccessful(blockchainTransaction, tweetURI, Seq(nft)))
          }
            ).recover {
            case baseException: BaseException => {
              val badResult = {
                val publicListing = masterPublicListings.Service.tryGet(buyNFTData.publicListingId)

                def collection(id: String) = masterCollections.Service.tryGet(id)

                (for {
                  publicListing <- publicListing
                  collection <- collection(publicListing.collectionId)
                } yield BadRequest(views.html.publicListing.buyNFT(BuyNFT.form.withGlobalError(baseException.failure.message), publicListing, collection))
                  ).recover {
                  case _: BaseException => BadRequest
                }
              }
              Await.result(badResult, Duration.Inf)
            }
          }
        }
      )
  }

}
