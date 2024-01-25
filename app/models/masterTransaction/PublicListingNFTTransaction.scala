package models.masterTransaction

import constants.Scheduler
import constants.Transaction.TxUtil
import exceptions.BaseException
import models.analytics.NFTsAnalysis
import models.blockchainTransaction.{UserTransaction, UserTransactions}
import models.common.Coin
import models.master
import models.master.{NFT, PublicListing}
import models.masterTransaction.PublicListingNFTTransactions.PublicListingNFTTransactionTable
import models.traits._
import org.bitcoinj.core.ECKey
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._
import utilities.MicroNumber

import javax.inject.{Inject, Singleton}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

case class PublicListingNFTTransaction(txHash: String, nftId: String, buyerAccountId: String, sellerAccountId: String, quantity: Long, publicListingId: String, status: Option[Boolean], createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def serialize: PublicListingNFTTransactions.PublicListingNFTTransactionSerialize = PublicListingNFTTransactions.PublicListingNFTTransactionSerialize(
    txHash = this.txHash,
    nftId = this.nftId,
    buyerAccountId = this.buyerAccountId,
    sellerAccountId = this.sellerAccountId,
    quantity = this.quantity,
    publicListingId = this.publicListingId,
    status = this.status,
    createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch)
}

private[masterTransaction] object PublicListingNFTTransactions {
  case class PublicListingNFTTransactionSerialize(txHash: String, nftId: String, buyerAccountId: String, sellerAccountId: String, quantity: Long, publicListingId: String, status: Option[Boolean], createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity2[String, String] {
    def id1: String = txHash

    def id2: String = nftId

    def deserialize()(implicit module: String, logger: Logger): PublicListingNFTTransaction = PublicListingNFTTransaction(
      txHash = this.txHash,
      nftId = this.nftId,
      buyerAccountId = this.buyerAccountId,
      sellerAccountId = this.sellerAccountId,
      quantity = this.quantity,
      publicListingId = this.publicListingId,
      status = this.status,
      createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch)
  }

  class PublicListingNFTTransactionTable(tag: Tag) extends Table[PublicListingNFTTransactionSerialize](tag, "PublicListingNFTTransaction") with ModelTable2[String, String] {

    def * = (txHash, nftId, buyerAccountId, sellerAccountId, quantity, publicListingId, status.?, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (PublicListingNFTTransactionSerialize.tupled, PublicListingNFTTransactionSerialize.unapply)

    def txHash = column[String]("txHash", O.PrimaryKey)

    def nftId = column[String]("nftId", O.PrimaryKey)

    def buyerAccountId = column[String]("buyerAccountId")

    def sellerAccountId = column[String]("sellerAccountId")

    def quantity = column[Long]("quantity")

    def publicListingId = column[String]("publicListingId")

    def status = column[Boolean]("status")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

    def id1 = txHash

    def id2 = nftId

  }

}

@Singleton
class PublicListingNFTTransactions @Inject()(
                                              protected val dbConfigProvider: DatabaseConfigProvider,
                                              utilitiesOperations: utilities.Operations,
                                              masterCollections: master.Collections,
                                              masterNFTs: master.NFTs,
                                              masterNFTOwners: master.NFTOwners,
                                              masterSales: master.Sales,
                                              masterPublicListings: master.PublicListings,
                                              utilitiesTransaction: utilities.Transaction,
                                              utilitiesNotification: utilities.Notification,
                                              nftsAnalysis: NFTsAnalysis,
                                              userTransactions: UserTransactions,
                                            )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl2[PublicListingNFTTransactions.PublicListingNFTTransactionTable, PublicListingNFTTransactions.PublicListingNFTTransactionSerialize, String, String]() {

  implicit val logger: Logger = Logger(this.getClass)

  implicit val module: String = constants.Module.MASTER_TRANSACTION_PUBLIC_LISTING_NFT_TRANSACTION

  val tableQuery = new TableQuery(tag => new PublicListingNFTTransactionTable(tag))

  object Service {

    def addWithNoneStatus(buyerAccountId: String, sellerAccountId: String, txHash: String, nftId: String, publicListingId: String, quantity: Long): Future[String] = create(PublicListingNFTTransaction(buyerAccountId = buyerAccountId, sellerAccountId = sellerAccountId, txHash = txHash, nftId = nftId, publicListingId = publicListingId, status = None, quantity = quantity).serialize).map(_.txHash)

    def update(publicListingNFTTransaction: PublicListingNFTTransaction): Future[Int] = updateById1AndId2(publicListingNFTTransaction.serialize)

    def checkAlreadySold(nftIds: Seq[String], publicListingId: String): Future[Boolean] = {
      val nullStatus: Option[Boolean] = null
      filter(x => x.nftId.inSet(nftIds) && x.publicListingId === publicListingId && (x.status || x.status.? === nullStatus)).map(_.nonEmpty)
    }

    def countBuyerNFTsFromPublicListing(buyerAccountId: String, publicListingId: String): Future[Long] = {
      val nullStatus: Option[Boolean] = null
      filter(x => x.buyerAccountId === buyerAccountId && x.publicListingId === publicListingId && (x.status.? === nullStatus || x.status)).map(_.map(_.quantity).sum)
    }

    def getTotalPublicListingSold(publicListingId: String): Future[Int] = {
      val nullStatus: Option[Boolean] = null
      filterAndCount(x => x.publicListingId === publicListingId && (x.status.? === nullStatus || x.status))
    }

    def getByTxHash(txHash: String): Future[Seq[PublicListingNFTTransaction]] = filter(_.txHash === txHash).map(_.map(_.deserialize))

    def getByTxHashes(txHashes: Seq[String]): Future[Seq[PublicListingNFTTransaction]] = filter(_.txHash.inSet(txHashes)).map(_.map(_.deserialize))

    def markSuccess(txHash: String): Future[Int] = customUpdate(tableQuery.filter(_.txHash === txHash).map(_.status).update(true))

    def markFailed(txHash: String): Future[Int] = customUpdate(tableQuery.filter(_.txHash === txHash).map(_.status).update(false))

    def getAllPendingStatus: Future[Seq[PublicListingNFTTransaction]] = filter(_.status.?.isEmpty).map(_.map(_.deserialize))

    def checkAnyPendingTx(publicListingIDs: Seq[String]): Future[Seq[String]] = customQuery(tableQuery.filter(x => x.publicListingId.inSet(publicListingIDs) && x.status.?.isEmpty).map(_.publicListingId).distinct.result)
  }

  object Utility {
    implicit val txUtil: TxUtil = TxUtil("PUBLIC_SALE", 300000)

    def transaction(buyerAccountId: String, sellerAccountId: String, nft: NFT, publicListingId: String, quantity: Long, fromAddress: String, toAddress: String, price: MicroNumber, gasPrice: BigDecimal, ecKey: ECKey): Future[UserTransaction] = {
      val messages = Seq(utilities.BlockchainTransaction.getSendCoinMsgAsAny(fromAddress = fromAddress, toAddress = toAddress, amount = Seq(Coin(denom = constants.Blockchain.StakingToken, amount = price * quantity))))

      def masterTxFunc(txHash: String) = Service.addWithNoneStatus(buyerAccountId = buyerAccountId, sellerAccountId = sellerAccountId, txHash = txHash, nftId = nft.id, publicListingId = publicListingId, quantity = quantity)

      val userTx = utilitiesTransaction.doUserTx(messages = messages, gasPrice = gasPrice, accountId = buyerAccountId, fromAddress = fromAddress, ecKey = ecKey, masterTxFunction = masterTxFunc)

      for {
        (userTx, _) <- userTx
      } yield userTx
    }

    val scheduler: Scheduler = new Scheduler {
      val name: String = module

      def runner(): Unit = {
        val nftPublicListingTxs = Service.getAllPendingStatus

        def checkAndUpdate(nftPublicListingTxs: Seq[PublicListingNFTTransaction]) = utilitiesOperations.traverse(nftPublicListingTxs) { nftPublicListingTx =>
          val userTransaction = userTransactions.Service.tryGet(nftPublicListingTx.txHash)

          def onTxComplete(userTransaction: UserTransaction) = if (userTransaction.status.isDefined) {
            if (userTransaction.status.get) {
              val markSuccess = Service.markSuccess(nftPublicListingTx.txHash)
              val publicListing = masterPublicListings.Service.tryGet(nftPublicListingTx.publicListingId)
              val nft = masterNFTs.Service.tryGet(nftPublicListingTx.nftId)

              def transferNFTOwnership = masterNFTOwners.Service.markNFTSoldFromPublicListing(nftId = nftPublicListingTx.nftId, creatorId = nftPublicListingTx.sellerAccountId, buyerAccountId = nftPublicListingTx.buyerAccountId, quantity = nftPublicListingTx.quantity)


              def sendNotifications = {
                utilitiesNotification.send(nftPublicListingTx.sellerAccountId, constants.Notification.SELLER_BUY_NFT_SUCCESSFUL_FROM_PUBLIC_LISTING, nftPublicListingTx.quantity.toString)("")
                utilitiesNotification.send(nftPublicListingTx.buyerAccountId, constants.Notification.BUYER_BUY_NFT_SUCCESSFUL_FROM_PUBLIC_LISTING, nftPublicListingTx.quantity.toString)(s"'${nftPublicListingTx.buyerAccountId}', '${constants.View.COLLECTED}'")
              }

              def updatePublicListing(publicListing: PublicListing) = masterPublicListings.Service.updateTotalSold(publicListing.id, nftPublicListingTx.quantity)

              def updateAnalytics = nftsAnalysis.Utility.onSuccessfulSellFromSale(nftId = nftPublicListingTx.nftId, quantity = nftPublicListingTx.quantity)


              for {
                _ <- markSuccess
                publicListing <- publicListing
                _ <- transferNFTOwnership
                nft <- nft
                _ <- sendNotifications
                _ <- updatePublicListing(publicListing)
                _ <- updateAnalytics
              } yield ()
            } else {
              val boughtNFTs = Service.getByTxHash(nftPublicListingTx.txHash)
              val markMasterFailed = Service.markFailed(nftPublicListingTx.txHash)

              def sendNotifications(buyNFTTx: PublicListingNFTTransaction, count: Int) = utilitiesNotification.send(buyNFTTx.buyerAccountId, constants.Notification.BUYER_BUY_NFT_FAILED, count.toString)("")

              for {
                boughtNFTs <- boughtNFTs
                _ <- markMasterFailed
                _ <- sendNotifications(boughtNFTs.head, boughtNFTs.length)
              } yield ()
            }
          } else Future()

          for {
            userTransaction <- userTransaction
            _ <- onTxComplete(userTransaction)
          } yield ()

        }

        val forComplete = (for {
          nftPublicListingTxs <- nftPublicListingTxs
          _ <- checkAndUpdate(nftPublicListingTxs)
        } yield ()).recover {
          case baseException: BaseException => baseException.notifyLog("[PANIC]")
            logger.error("[PANIC] Something is seriously wrong with logic. Code should not reach here.")
        }

        Await.result(forComplete, Duration.Inf)
      }
    }
  }

}