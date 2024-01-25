package models.history

import constants.Scheduler
import exceptions.BaseException
import models.history.MasterSales.MasterSaleTable
import models.master.Sales
import models.traits._
import models.{master, masterTransaction}
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._
import utilities.MicroNumber

import javax.inject.{Inject, Singleton}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

case class MasterSale(id: String, nftId: String, whitelistId: String, collectionId: String, maxPerAccount: Long, price: MicroNumber, numberOfNFTs: BigInt, totalSold: BigInt, startTimeEpoch: Long, endTimeEpoch: Long, isOver: Boolean, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None, deletedBy: Option[String] = None, deletedOnMillisEpoch: Option[Long] = None) extends HistoryLogging {

  def serialize(): MasterSales.MasterSaleSerialized = MasterSales.MasterSaleSerialized(
    id = this.id,
    nftId = this.nftId,
    whitelistId = this.whitelistId,
    collectionId = this.collectionId,
    maxPerAccount = this.maxPerAccount,
    price = this.price.toBigDecimal,
    numberOfNFTs = BigDecimal(this.numberOfNFTs),
    totalSold = BigDecimal(this.totalSold),
    startTimeEpoch = this.startTimeEpoch,
    endTimeEpoch = this.endTimeEpoch,
    isOver = this.isOver,
    createdBy = this.createdBy,
    createdOnMillisEpoch = this.createdOnMillisEpoch,
    updatedBy = this.updatedBy,
    updatedOnMillisEpoch = this.updatedOnMillisEpoch,
    deletedBy = this.deletedBy,
    deletedOnMillisEpoch = this.deletedOnMillisEpoch)

}

private[history] object MasterSales {

  case class MasterSaleSerialized(id: String, nftId: String, whitelistId: String, collectionId: String, maxPerAccount: Long, price: BigDecimal, numberOfNFTs: BigDecimal, totalSold: BigDecimal, startTimeEpoch: Long, endTimeEpoch: Long, isOver: Boolean, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None, deletedBy: Option[String] = None, deletedOnMillisEpoch: Option[Long] = None) extends Entity[String] {

    def deserialize()(implicit module: String, logger: Logger): MasterSale = MasterSale(id = id, nftId = this.nftId, whitelistId = whitelistId, collectionId = collectionId, numberOfNFTs = numberOfNFTs.toBigInt, maxPerAccount = maxPerAccount, price = MicroNumber(price), totalSold = this.totalSold.toBigInt, startTimeEpoch = startTimeEpoch, endTimeEpoch = endTimeEpoch, isOver = isOver, createdBy = createdBy, createdOnMillisEpoch = createdOnMillisEpoch, updatedBy = updatedBy, updatedOnMillisEpoch = updatedOnMillisEpoch, deletedBy = this.deletedBy, deletedOnMillisEpoch = this.deletedOnMillisEpoch)
  }

  class MasterSaleTable(tag: Tag) extends Table[MasterSaleSerialized](tag, "MasterSale") with ModelTable[String] {

    def * = (id, nftId, whitelistId, collectionId, maxPerAccount, price, numberOfNFTs, totalSold, startTimeEpoch, endTimeEpoch, isOver, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?, deletedBy.?, deletedOnMillisEpoch.?) <> (MasterSaleSerialized.tupled, MasterSaleSerialized.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def nftId = column[String]("nftId")

    def whitelistId = column[String]("whitelistId")

    def collectionId = column[String]("collectionId")

    def maxPerAccount = column[Long]("maxPerAccount")

    def price = column[BigDecimal]("price")

    def numberOfNFTs = column[BigDecimal]("numberOfNFTs")

    def totalSold = column[BigDecimal]("totalSold")

    def startTimeEpoch = column[Long]("startTimeEpoch")

    def endTimeEpoch = column[Long]("endTimeEpoch")

    def isOver = column[Boolean]("isOver")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

    def deletedBy = column[String]("deletedBy")

    def deletedOnMillisEpoch = column[Long]("deletedOnMillisEpoch")
  }
}

@Singleton
class MasterSales @Inject()(
                             sales: Sales,
                             utilitiesOperations: utilities.Operations,
                             masterNFTOwners: master.NFTOwners,
                             masterNFTs: master.NFTs,
                             SaleNFTTransactions: masterTransaction.SaleNFTTransactions,
                             protected val dbConfigProvider: DatabaseConfigProvider,
                           )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[MasterSales.MasterSaleTable, MasterSales.MasterSaleSerialized, String]() {

  implicit val module: String = constants.Module.HISTORY_MASTER_SALE

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new MasterSaleTable(tag))

  object Service {

    def insertOrUpdate(masterSale: MasterSale): Future[Int] = upsert(masterSale.serialize())

    def add(masterSales: Seq[MasterSale]): Future[Int] = create(masterSales.map(_.serialize()))

    def tryGet(id: String): Future[MasterSale] = filterHead(_.id === id).map(_.deserialize)

    def get(ids: Seq[String]): Future[Seq[MasterSale]] = filter(_.id.inSet(ids)).map(_.map(_.deserialize))

    def getByWhitelistId(whitelistId: String): Future[Seq[MasterSale]] = filter(_.whitelistId === whitelistId).map(_.map(_.deserialize))

    def tryGetWhitelistId(id: String): Future[String] = filterHead(_.id === id).map(_.whitelistId)

  }

  object Utility {

    val scheduler: Scheduler = new Scheduler {
      val name: String = module

      def runner(): Unit = {
        val deleteSales = sales.Service.getForDeletion

        def salesWithPendingTx(ids: Seq[String]) = SaleNFTTransactions.Service.checkAnyPendingTx(ids)

        def deleteExpiredSales(deleteSales: Seq[master.Sale]) = utilitiesOperations.traverse(deleteSales) { sale =>
          val addToHistory = Service.insertOrUpdate(sale.toHistory)

          def markSaleNull = masterNFTs.Service.markSaleNull(sale.id)

          def deleteSale() = sales.Service.delete(sale.id)


          for {
            _ <- addToHistory
            _ <- markSaleNull
            _ <- deleteSale()
          } yield ()

        }

        val forComplete = (for {
          deleteSales <- deleteSales
          salesWithPendingTx <- salesWithPendingTx(deleteSales.map(_.id))
          _ <- deleteExpiredSales(deleteSales.filterNot(x => salesWithPendingTx.contains(x.id)))
        } yield ()).recover {
          case _: BaseException => logger.error("FAILED_IN_" + module)
        }

        Await.result(forComplete, Duration.Inf)
      }
    }
  }

}