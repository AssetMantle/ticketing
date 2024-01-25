package models.master

import models.history
import models.master.PublicListings.PublicListingTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._
import utilities.MicroNumber

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class PublicListing(id: String, nftId: String, collectionId: String, maxPerAccount: Long, price: MicroNumber, numberOfNFTs: BigInt, totalSold: BigInt, startTimeEpoch: Long, endTimeEpoch: Long, isOver: Boolean = false, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def getStatus(numberOfSold: BigInt): constants.PublicListing.Status = {
    val currentEpoch = utilities.Date.currentEpoch
    if (numberOfSold >= numberOfNFTs) constants.PublicListing.SOLD_OUT // Sold out
    else if (currentEpoch >= this.startTimeEpoch && currentEpoch < this.endTimeEpoch) constants.PublicListing.LIVE // Live
    else if (currentEpoch >= this.endTimeEpoch) constants.PublicListing.ENDED // Expired
    else constants.PublicListing.NOT_STARTED //
  }

  def serialize(): PublicListings.PublicListingSerialized = PublicListings.PublicListingSerialized(
    id = this.id,
    nftId = this.nftId,
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

  def toHistory: history.MasterPublicListing = history.MasterPublicListing(
    id = this.id,
    nftId = this.nftId,
    collectionId = this.collectionId,
    numberOfNFTs = this.numberOfNFTs,
    maxPerAccount = this.maxPerAccount,
    price = this.price,
    totalSold = this.totalSold,
    startTimeEpoch = this.startTimeEpoch,
    endTimeEpoch = this.endTimeEpoch,
    isOver = this.isOver,
    createdBy = this.createdBy,
    createdOnMillisEpoch = this.createdOnMillisEpoch,
    updatedBy = this.updatedBy,
    updatedOnMillisEpoch = this.updatedOnMillisEpoch)
}

private[master] object PublicListings {

  case class PublicListingSerialized(id: String, nftId: String, collectionId: String, maxPerAccount: Long, price: BigDecimal, numberOfNFTs: BigDecimal, totalSold: BigDecimal, startTimeEpoch: Long, endTimeEpoch: Long, isOver: Boolean, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity[String] {

    def deserialize()(implicit module: String, logger: Logger): PublicListing = PublicListing(id = id, nftId = nftId, collectionId = collectionId, maxPerAccount = maxPerAccount, price = MicroNumber(price), numberOfNFTs = numberOfNFTs.toBigInt, totalSold = this.totalSold.toBigInt, startTimeEpoch = startTimeEpoch, endTimeEpoch = endTimeEpoch, isOver = isOver, createdBy = createdBy, createdOnMillisEpoch = createdOnMillisEpoch, updatedBy = updatedBy, updatedOnMillisEpoch = updatedOnMillisEpoch)
  }

  class PublicListingTable(tag: Tag) extends Table[PublicListingSerialized](tag, "PublicListing") with ModelTable[String] {

    def * = (id, nftId, collectionId, maxPerAccount, price, numberOfNFTs, totalSold, startTimeEpoch, endTimeEpoch, isOver, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (PublicListingSerialized.tupled, PublicListingSerialized.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def nftId = column[String]("nftId")

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
  }
}

@Singleton
class PublicListings @Inject()(
                                protected val dbConfigProvider: DatabaseConfigProvider,
                                utilitiesOperations: utilities.Operations,
                                masterNFTs: NFTs,
                              )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[PublicListings.PublicListingTable, PublicListings.PublicListingSerialized, String]() {

  implicit val module: String = constants.Module.MASTER_PUBLIC_LISTING

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new PublicListingTable(tag))

  object Service {

    def add(publicListing: PublicListing): Future[String] = create(publicListing.serialize()).map(_.id)

    def update(publicListing: PublicListing): Future[Unit] = updateById(publicListing.serialize())

    def tryGet(id: String): Future[PublicListing] = filterHead(_.id === id).map(_.deserialize)

    def get(ids: Seq[String]): Future[Seq[PublicListing]] = filter(_.id.inSet(ids)).map(_.map(_.deserialize))

    def getLivePublicListingIDs: Future[Seq[String]] = {
      val currentEpoch = utilities.Date.currentEpoch
      filter(x => x.startTimeEpoch <= currentEpoch && x.endTimeEpoch > currentEpoch).map(_.map(_.id))
    }

    def markSoldOut(id: String): Future[Int] = customUpdate(tableQuery.filter(_.id === id).map(_.isOver).update(true))

    def markStop(id: String): Future[Int] = customUpdate(tableQuery.filter(_.id === id).map(_.isOver).update(true))

    def getForDeletion: Future[Seq[PublicListing]] = filter(x => x.endTimeEpoch <= (utilities.Date.currentEpoch - constants.Date.DaySeconds) || x.isOver).map(_.map(_.deserialize))

    def getPublicListingByCollectionId(collectionId: String): Future[Option[PublicListing]] = filter(_.collectionId === collectionId).map(_.map(_.deserialize).headOption)

    def tryGetPublicListingByCollectionId(collectionId: String): Future[PublicListing] = filterHead(_.collectionId === collectionId).map(_.deserialize)

    def getPublicListingByNFTId(nftId: String): Future[Option[PublicListing]] = filter(_.nftId === nftId).map(_.headOption.map(_.deserialize()))

    def delete(publicListingId: String): Future[Int] = deleteById(publicListingId)

    def total: Future[Int] = countTotal()

    def getByPageNumber(pageNumber: Int): Future[Seq[PublicListing]] = sortWithPagination(_.endTimeEpoch)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.CollectionsPerPage, limit = constants.CommonConfig.Pagination.CollectionsPerPage).map(_.map(_.deserialize))

    def checkExistsByCollectionId(collectionId: String): Future[Boolean] = filterAndExists(_.collectionId === collectionId)

    def updateTotalSold(id: String, addQuantity: Long): Future[Unit] = {
      val publicListing = tryGet(id)

      def checkAndUpdate(publicListing: PublicListing) = if (publicListing.totalSold + addQuantity >= publicListing.numberOfNFTs) {
        update(publicListing.copy(totalSold = publicListing.totalSold + addQuantity, isOver = true))
      } else update(publicListing.copy(totalSold = publicListing.totalSold + addQuantity, isOver = false))

      for {
        publicListing <- publicListing
        _ <- checkAndUpdate(publicListing)
      } yield ()
    }
  }

}