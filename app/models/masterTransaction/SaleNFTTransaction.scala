package models.masterTransaction

import constants.Scheduler
import constants.Transaction.TxUtil
import exceptions.BaseException
import models.analytics.NFTsAnalysis
import models.blockchainTransaction.{UserTransaction, UserTransactions}
import models.common.Coin
import models.master
import models.master.{NFT, Sale}
import models.masterTransaction.SaleNFTTransactions.SaleNFTTransactionTable
import models.traits._
import org.bitcoinj.core.ECKey
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._
import utilities.MicroNumber

import javax.inject.{Inject, Singleton}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

case class SaleNFTTransaction(txHash: String, nftId: String, buyerAccountId: String, sellerAccountId: String, quantity: Long, saleId: String, status: Option[Boolean], createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def serialize: SaleNFTTransactions.SaleNFTTransactionSerialize = SaleNFTTransactions.SaleNFTTransactionSerialize(
    txHash = this.txHash,
    nftId = this.nftId,
    buyerAccountId = this.buyerAccountId,
    sellerAccountId = this.sellerAccountId,
    quantity = this.quantity,
    saleId = this.saleId,
    status = this.status,
    createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch
  )
}

private[masterTransaction] object SaleNFTTransactions {

  case class SaleNFTTransactionSerialize(txHash: String, nftId: String, buyerAccountId: String, sellerAccountId: String, quantity: Long, saleId: String, status: Option[Boolean], createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity2[String, String] {
    def id1: String = txHash

    def id2: String = nftId

    def deserialize()(implicit module: String, logger: Logger): SaleNFTTransaction = SaleNFTTransaction(
      txHash = this.txHash,
      nftId = this.nftId,
      buyerAccountId = this.buyerAccountId,
      sellerAccountId = this.sellerAccountId,
      quantity = this.quantity,
      saleId = this.saleId,
      status = this.status,
      createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch
    )
  }

  class SaleNFTTransactionTable(tag: Tag) extends Table[SaleNFTTransactionSerialize](tag, "SaleNFTTransaction") with ModelTable2[String, String] {

    def * = (txHash, nftId, buyerAccountId, sellerAccountId, quantity, saleId, status.?, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (SaleNFTTransactionSerialize.tupled, SaleNFTTransactionSerialize.unapply)

    def txHash = column[String]("txHash", O.PrimaryKey)

    def nftId = column[String]("nftId", O.PrimaryKey)

    def buyerAccountId = column[String]("buyerAccountId")

    def sellerAccountId = column[String]("sellerAccountId")

    def quantity = column[Long]("quantity")

    def saleId = column[String]("saleId")

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
class SaleNFTTransactions @Inject()(
                                     protected val dbConfigProvider: DatabaseConfigProvider,
                                     utilitiesOperations: utilities.Operations,
                                     masterNFTOwners: master.NFTOwners,
                                     masterNFTs: master.NFTs,
                                     masterSales: master.Sales,
                                     userTransactions: UserTransactions,
                                     utilitiesTransaction: utilities.Transaction,
                                     nftsAnalysis: NFTsAnalysis,
                                     utilitiesNotification: utilities.Notification,
                                   )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl2[SaleNFTTransactions.SaleNFTTransactionTable, SaleNFTTransactions.SaleNFTTransactionSerialize, String, String]() {

  implicit val logger: Logger = Logger(this.getClass)

  implicit val module: String = constants.Module.MASTER_TRANSACTION_SALE_NFT_TRANSACTION

  val tableQuery = new TableQuery(tag => new SaleNFTTransactionTable(tag))

  object Service {
    def addWithNoneStatus(buyerAccountId: String, sellerAccountId: String, txHash: String, nftId: String, saleId: String, quantity: Long): Future[String] = create(SaleNFTTransaction(buyerAccountId = buyerAccountId, sellerAccountId = sellerAccountId, txHash = txHash, nftId = nftId, saleId = saleId, status = None, quantity = quantity).serialize).map(_.txHash)

    def update(saleNFTTransaction: SaleNFTTransaction): Future[Int] = updateById1AndId2(saleNFTTransaction.serialize)

    def checkAlreadySold(nftId: String, saleId: String): Future[Boolean] = {
      val nullStatus: Option[Boolean] = null
      filterAndExists(x => x.nftId === nftId && x.saleId === saleId && (x.status || x.status.? === nullStatus))
    }

    def checkAlreadySold(nftIds: Seq[String], saleId: String): Future[Boolean] = {
      val nullStatus: Option[Boolean] = null
      filter(x => x.nftId.inSet(nftIds) && x.saleId === saleId && (x.status || x.status.? === nullStatus)).map(_.nonEmpty)
    }

    def countBuyerNFTsFromSale(buyerAccountId: String, saleId: String): Future[Long] = {
      val nullStatus: Option[Boolean] = null
      filter(x => x.buyerAccountId === buyerAccountId && x.saleId === saleId && (x.status.? === nullStatus || x.status)).map(_.map(_.quantity).sum)
    }

    def getByTxHash(txHash: String): Future[Seq[SaleNFTTransaction]] = filter(_.txHash === txHash).map(_.map(_.deserialize))

    def getByTxHashes(txHashes: Seq[String]): Future[Seq[SaleNFTTransaction]] = filter(_.txHash.inSet(txHashes)).map(_.map(_.deserialize))

    def markSuccess(txHash: String): Future[Int] = customUpdate(tableQuery.filter(_.txHash === txHash).map(_.status).update(true))

    def markFailed(txHash: String): Future[Int] = customUpdate(tableQuery.filter(_.txHash === txHash).map(_.status).update(false))

    def getAllPendingStatus: Future[Seq[SaleNFTTransaction]] = filter(_.status.?.isEmpty).map(_.map(_.deserialize))

    def getTotalWhitelistSaleSold(saleId: String): Future[Int] = {
      val nullStatus: Option[Boolean] = null
      filterAndCount(x => x.saleId === saleId && (x.status.? === nullStatus || x.status))
    }

    def checkAnyPendingTx(saleIDs: Seq[String]): Future[Seq[String]] = customQuery(tableQuery.filter(x => x.saleId.inSet(saleIDs) && x.status.?.isEmpty).map(_.saleId).distinct.result)
  }

  object Utility {

    implicit val txUtil: TxUtil = TxUtil("WHITELIST_SALE", 300000)

    def transaction(buyerAccountId: String, sellerAccountId: String, nft: NFT, saleId: String, quantity: Long, fromAddress: String, toAddress: String, price: MicroNumber, gasPrice: BigDecimal, ecKey: ECKey): Future[UserTransaction] = {
      val messages = Seq(utilities.BlockchainTransaction.getSendCoinMsgAsAny(fromAddress = fromAddress, toAddress = toAddress, amount = Seq(Coin(denom = constants.Blockchain.StakingToken, amount = price * quantity))))

      def masterTxFunc(txHash: String) = Service.addWithNoneStatus(buyerAccountId = buyerAccountId, sellerAccountId = sellerAccountId, txHash = txHash, nftId = nft.id, saleId = saleId, quantity = quantity)

      val userTx = utilitiesTransaction.doUserTx(messages = messages, gasPrice = gasPrice, accountId = buyerAccountId, fromAddress = fromAddress, ecKey = ecKey, masterTxFunction = masterTxFunc)

      for {
        (userTx, _) <- userTx
      } yield userTx
    }

    val scheduler: Scheduler = new Scheduler {
      val name: String = module

      def runner(): Unit = {
        val saleNFTTxS = Service.getAllPendingStatus

        def checkAndUpdate(saleNFTTxs: Seq[SaleNFTTransaction]) = utilitiesOperations.traverse(saleNFTTxs) { saleNFTTx =>
          val userTransaction = userTransactions.Service.tryGet(saleNFTTx.txHash)

          def onTxComplete(userTransaction: UserTransaction) = if (userTransaction.status.isDefined) {
            if (userTransaction.status.get) {
              val markMasterSuccess = Service.markSuccess(userTransaction.txHash)
              val sale = masterSales.Service.tryGet(saleNFTTx.saleId)
              val nft = masterNFTs.Service.tryGet(saleNFTTx.nftId)

              def transferNFTOwnership = masterNFTOwners.Service.markNFTSoldFromSale(nftId = saleNFTTx.nftId, creatorId = saleNFTTx.sellerAccountId, buyerAccountId = saleNFTTx.buyerAccountId, quantity = saleNFTTx.quantity)

              def sendNotifications = {
                utilitiesNotification.send(saleNFTTx.sellerAccountId, constants.Notification.SELLER_BUY_NFT_SUCCESSFUL_FROM_SALE, saleNFTTx.quantity.toString)("")
                utilitiesNotification.send(saleNFTTx.buyerAccountId, constants.Notification.BUYER_BUY_NFT_SUCCESSFUL_FROM_SALE, saleNFTTx.quantity.toString)(s"'${saleNFTTx.buyerAccountId}', '${constants.View.COLLECTED}'")
              }

              def updateSale(sale: Sale) = masterSales.Service.updateTotalSold(sale.id, saleNFTTx.quantity)

              def updateAnalytics() = nftsAnalysis.Utility.onSuccessfulSellFromSale(nftId = saleNFTTx.nftId, quantity = saleNFTTx.quantity)


              for {
                _ <- markMasterSuccess
                _ <- transferNFTOwnership
                sale <- sale
                nft <- nft
                _ <- sendNotifications
                _ <- updateSale(sale)
                _ <- updateAnalytics()
              } yield ()
            } else {
              val boughtNFTs = Service.getByTxHash(userTransaction.txHash)
              val markMasterFailed = Service.markFailed(userTransaction.txHash)

              def sendNotifications(buyNFTTx: SaleNFTTransaction, count: Int) = utilitiesNotification.send(buyNFTTx.buyerAccountId, constants.Notification.BUYER_BUY_NFT_FAILED, count.toString)("")

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
          saleNFTTxS <- saleNFTTxS
          _ <- checkAndUpdate(saleNFTTxS)
        } yield ()).recover {
          case baseException: BaseException => baseException.notifyLog("[PANIC]")
            logger.error("[PANIC] Something is seriously wrong with logic. Code should not reach here.")
        }

        Await.result(forComplete, Duration.Inf)
      }
    }
  }
}