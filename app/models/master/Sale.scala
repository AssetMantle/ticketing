package models.master

import models.history
import models.master.Sales.SaleTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._
import utilities.MicroNumber

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class Sale(id: String, nftId: String, whitelistId: String, collectionId: String, maxPerAccount: Long, price: MicroNumber, numberOfNFTs: BigInt, totalSold: BigInt, startTimeEpoch: Long, endTimeEpoch: Long, isOver: Boolean, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def getStatus(allSold: Boolean): constants.Sale.Status = {
    val currentEpoch = utilities.Date.currentEpoch
    if (allSold && currentEpoch >= this.startTimeEpoch && currentEpoch < this.endTimeEpoch) constants.Sale.SOLD_OUT // Sold out
    else if (currentEpoch >= this.startTimeEpoch && currentEpoch < this.endTimeEpoch) constants.Sale.LIVE // Live
    else if (currentEpoch >= this.endTimeEpoch) constants.Sale.ENDED // Expired
    else constants.Sale.NOT_STARTED //
  }

  def getStatus: constants.Sale.Status = {
    val currentEpoch = utilities.Date.currentEpoch
    if (currentEpoch >= this.startTimeEpoch && currentEpoch < this.endTimeEpoch) constants.Sale.LIVE
    else if (currentEpoch >= this.endTimeEpoch) constants.Sale.ENDED
    else constants.Sale.NOT_STARTED
  }

  def serialize(): Sales.SaleSerialized = Sales.SaleSerialized(
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
    updatedOnMillisEpoch = this.updatedOnMillisEpoch)

  def toHistory: history.MasterSale = history.MasterSale(
    id = this.id,
    nftId = this.nftId,
    whitelistId = this.whitelistId,
    collectionId = this.collectionId,
    maxPerAccount = this.maxPerAccount,
    price = this.price,
    numberOfNFTs = this.numberOfNFTs,
    totalSold = this.totalSold,
    startTimeEpoch = this.startTimeEpoch,
    endTimeEpoch = this.endTimeEpoch,
    isOver = this.isOver,
    createdBy = this.createdBy,
    createdOnMillisEpoch = this.createdOnMillisEpoch,
    updatedBy = this.updatedBy,
    updatedOnMillisEpoch = this.updatedOnMillisEpoch)
}

private[master] object Sales {
  case class SaleSerialized(id: String, nftId: String, whitelistId: String, collectionId: String, maxPerAccount: Long, price: BigDecimal, numberOfNFTs: BigDecimal, totalSold: BigDecimal, startTimeEpoch: Long, endTimeEpoch: Long, isOver: Boolean, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity[String] {

    def deserialize()(implicit module: String, logger: Logger): Sale = Sale(id = id, nftId = this.nftId, whitelistId = whitelistId, collectionId = collectionId, maxPerAccount = maxPerAccount, price = MicroNumber(price), numberOfNFTs = numberOfNFTs.toBigInt, totalSold = this.totalSold.toBigInt, startTimeEpoch = startTimeEpoch, endTimeEpoch = endTimeEpoch, isOver = isOver, createdBy = createdBy, createdOnMillisEpoch = createdOnMillisEpoch, updatedBy = updatedBy, updatedOnMillisEpoch = updatedOnMillisEpoch)
  }

  class SaleTable(tag: Tag) extends Table[SaleSerialized](tag, "Sale") with ModelTable[String] {

    def * = (id, nftId, whitelistId, collectionId, maxPerAccount, price, numberOfNFTs, totalSold, startTimeEpoch, endTimeEpoch, isOver, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (SaleSerialized.tupled, SaleSerialized.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def nftId = column[String]("nftId")

    def whitelistId = column[String]("whitelistId")

    def collectionId = column[String]("collectionId")

    def maxPerAccount = column[Long]("maxPerAccount")

    def numberOfNFTs = column[BigDecimal]("numberOfNFTs")

    def price = column[BigDecimal]("price")

    def totalSold = column[BigDecimal]("totalSold")

    def denom = column[String]("denom")

    def startTimeEpoch = column[Long]("startTimeEpoch")

    def endTimeEpoch = column[Long]("endTimeEpoch")

    def isOver = column[Boolean]("isOver")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")
  }
}

@Singleton
class Sales @Inject()(
                       protected val dbConfigProvider: DatabaseConfigProvider,
                       masterNFTs: NFTs,
                     )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[Sales.SaleTable, Sales.SaleSerialized, String]() {

  implicit val module: String = constants.Module.MASTER_SALE

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new SaleTable(tag))

  object Service {

    def add(sale: Sale): Future[String] = create(sale.serialize()).map(_.id)

    def add(sales: Seq[Sale]): Future[Int] = create(sales.map(_.serialize()))

    def tryGet(id: String): Future[Sale] = filterHead(_.id === id).map(_.deserialize)

    def get(ids: Seq[String]): Future[Seq[Sale]] = filter(_.id.inSet(ids)).map(_.map(_.deserialize))

    def getByWhitelistId(whitelistId: String): Future[Seq[Sale]] = filter(_.whitelistId === whitelistId).map(_.map(_.deserialize))

    def getByNFTId(nftId: String): Future[Option[Sale]] = filter(_.nftId === nftId).map(_.headOption.map(_.deserialize()))

    def tryGetWhitelistId(id: String): Future[String] = filterHead(_.id === id).map(_.whitelistId)

    def getLiveSales: Future[Seq[String]] = {
      val currentEpoch = utilities.Date.currentEpoch
      filter(x => x.startTimeEpoch <= currentEpoch && x.endTimeEpoch > currentEpoch).map(_.map(_.id))
    }

    def getForDeletion: Future[Seq[Sale]] = filter(x => x.endTimeEpoch <= (utilities.Date.currentEpoch - constants.Date.DaySeconds) || x.isOver).map(_.map(_.deserialize))

    def getIdsCurrentOnSaleByWhitelistIds(whitelistIds: Seq[String]): Future[Seq[String]] = {
      val currentEpoch = utilities.Date.currentEpoch
      filter(x => x.whitelistId.inSet(whitelistIds) && x.endTimeEpoch > currentEpoch).map(_.map(_.id))
    }

    def markSoldOut(id: String): Future[Int] = customUpdate(tableQuery.filter(_.id === id).map(_.isOver).update(true))

    def markStop(id: String): Future[Int] = customUpdate(tableQuery.filter(_.id === id).map(_.isOver).update(true))

    def getSaleByCollectionId(collectionId: String): Future[Option[Sale]] = filter(_.collectionId === collectionId).map(_.map(_.deserialize).headOption)

    def tryGetSaleByCollectionId(collectionId: String): Future[Sale] = filterHead(_.collectionId === collectionId).map(_.deserialize)

    def delete(saleId: String): Future[Int] = deleteById(saleId)

    def total: Future[Int] = countTotal()

    def getSalesByCollectionId(collectionId: String): Future[Option[Sale]] = filter(_.collectionId === collectionId).map(_.map(_.deserialize).headOption)

    def getByPageNumber(pageNumber: Int): Future[Seq[Sale]] = sortWithPagination(_.endTimeEpoch)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.CollectionsPerPage, limit = constants.CommonConfig.Pagination.CollectionsPerPage).map(_.map(_.deserialize))

    def checkExistsByCollectionId(collectionId: String): Future[Boolean] = filterAndExists(_.collectionId === collectionId)

    def updateTotalSold(id: String, addQuantity: Long): Future[Unit] = {
      val sale = tryGet(id)

      def checkAndUpdate(sale: Sale) = if (sale.totalSold + addQuantity >= sale.numberOfNFTs) {
        upsert(sale.copy(totalSold = sale.totalSold + addQuantity, isOver = true).serialize())
      } else upsert(sale.copy(totalSold = sale.totalSold + addQuantity, isOver = false).serialize())

      for {
        sale <- sale
        _ <- checkAndUpdate(sale)
      } yield ()
    }
  }

}