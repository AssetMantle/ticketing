package models.master

import models.master.NFTOwners.NFTOwnerTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import schema.id.base.IdentityID
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class NFTOwner(nftId: String, ownerId: String, creatorId: String, collectionId: String, quantity: BigInt, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def getCreatorIdentityID: IdentityID = utilities.Identity.getMantlePlaceIdentityID(this.creatorId)

  def getOwnerIdentityID: IdentityID = utilities.Identity.getMantlePlaceIdentityID(this.ownerId)

  def serialize: NFTOwners.NFTOwnerSerialized = NFTOwners.NFTOwnerSerialized(nftId = this.nftId, ownerId = this.ownerId, creatorId = this.creatorId, collectionId = this.collectionId, quantity = BigDecimal(this.quantity), createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch)

}

private[master] object NFTOwners {
  case class NFTOwnerSerialized(nftId: String, ownerId: String, creatorId: String, collectionId: String, quantity: BigDecimal, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity2[String, String] {
    def id1: String = nftId

    def id2: String = ownerId

    def deserialize()(implicit module: String, logger: Logger): NFTOwner = NFTOwner(nftId = this.nftId, ownerId = this.ownerId, creatorId = this.creatorId, collectionId = this.collectionId, quantity = this.quantity.toBigInt, createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch)
  }

  class NFTOwnerTable(tag: Tag) extends Table[NFTOwners.NFTOwnerSerialized](tag, "NFTOwner") with ModelTable2[String, String] {

    def * = (nftId, ownerId, creatorId, collectionId, quantity, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (NFTOwners.NFTOwnerSerialized.tupled, NFTOwners.NFTOwnerSerialized.unapply)

    def nftId = column[String]("nftId", O.PrimaryKey)

    def ownerId = column[String]("ownerId", O.PrimaryKey)

    def creatorId = column[String]("creatorId")

    def collectionId = column[String]("collectionId")

    def quantity = column[BigDecimal]("quantity")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

    def id1 = nftId

    def id2 = ownerId
  }
}

@Singleton
class NFTOwners @Inject()(
                           protected val dbConfigProvider: DatabaseConfigProvider,
                         )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl2[NFTOwners.NFTOwnerTable, NFTOwners.NFTOwnerSerialized, String, String]() {

  implicit val module: String = constants.Module.MASTER_NFT_OWNER

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new NFTOwnerTable(tag))

  object Service {

    def add(nftOwner: NFTOwner): Future[String] = create(nftOwner.serialize).map(_.nftId)

    def add(nftOwners: Seq[NFTOwner]): Future[Int] = create(nftOwners.map(_.serialize))

    def update(NFTOwner: NFTOwner): Future[Int] = updateById1AndId2(NFTOwner.serialize)

    def onSecondaryMarket(nftId: String, ownerId: String, sellQuantity: BigInt): Future[Int] = {
      val nftOwner = tryGet(nftId = nftId, ownerId = ownerId)

      def checkAndUpdate(nftOwner: NFTOwner) = if (nftOwner.quantity > sellQuantity) update(nftOwner.copy(quantity = nftOwner.quantity - sellQuantity))
      else if (nftOwner.quantity == sellQuantity) delete(nftId = nftId, ownerId = ownerId)
      else constants.Response.INVALID_QUANTITY_FOR_NFT_SECONDARY_MARKET.throwBaseException()

      for {
        nftOwner <- nftOwner
        result <- checkAndUpdate(nftOwner)
      } yield result
    }

    def delete(nftId: String, ownerId: String): Future[Int] = deleteById1AndId2(id1 = nftId, id2 = ownerId)

    def deleteByNFT(nftId: String): Future[Int] = filterAndDelete(_.nftId === nftId)

    def getAllByCollectionID(collectionID: String): Future[Seq[NFTOwner]] = filter(_.collectionId === collectionID).map(_.map(_.deserialize()))

    def onSuccessfulBuyFromSecondaryMarket(nftId: String, collection: Collection, totalSold: BigInt, buyerId: String): Future[Unit] = {
      val oldNFTOwner = get(nftId = nftId, ownerId = buyerId)

      def verifyAndUpdate(oldNFTOwner: Option[NFTOwner]) = if (oldNFTOwner.isDefined) {
        for {
          _ <- update(oldNFTOwner.get.copy(quantity = oldNFTOwner.get.quantity + totalSold))
        } yield ()
      } else {
        for {
          _ <- add(NFTOwner(nftId = nftId, ownerId = buyerId, creatorId = collection.creatorId, collectionId = collection.id, quantity = totalSold))
        } yield ()
      }

      for {
        oldNFTOwner <- oldNFTOwner
        _ <- verifyAndUpdate(oldNFTOwner)
      } yield ()
    }

    def tryGet(nftId: String, ownerId: String): Future[NFTOwner] = tryGetById1AndId2(id1 = nftId, id2 = ownerId).map(_.deserialize)

    def get(nftId: String, ownerId: String): Future[Option[NFTOwner]] = getById(id1 = nftId, id2 = ownerId).map(_.map(_.deserialize))

    def getOwners(nftId: String): Future[Seq[NFTOwner]] = filter(_.id1 === nftId).map(_.map(_.deserialize))

    def getOwnersByCollectionId(collectionId: String): Future[Seq[String]] = customQuery(tableQuery.filter(_.collectionId === collectionId).map(_.ownerId).result)

    def checkExists(nftId: String, ownerId: String): Future[Boolean] = exists(id1 = nftId, id2 = ownerId)

    def unlistFromSecondaryMarket(nft: NFT, collection: Collection, ownerId: String, sellQuantity: BigInt): Future[Unit] = {
      val nftOwner = get(nftId = nft.id, ownerId = ownerId)

      def checkAndUpdate(nftOwner: Option[NFTOwner]) = if (nftOwner.isEmpty) {
        add(NFTOwner(nftId = nft.id, ownerId = ownerId, creatorId = collection.creatorId, collectionId = collection.id, quantity = sellQuantity))
      } else update(nftOwner.get.copy(quantity = nftOwner.get.quantity + sellQuantity))

      for {
        nftOwner <- nftOwner
        _ <- checkAndUpdate(nftOwner)
      } yield ()
    }

    def countOwnedNFTs(accountId: String): Future[Int] = filterAndCount(x => x.ownerId === accountId && x.creatorId =!= accountId)

    def countCollectionOwnedNFTs(accountId: String, collectionID: String): Future[Int] = filterAndCount(x => x.ownerId === accountId && x.creatorId =!= accountId && x.collectionId === collectionID)

    def deleteCollections(collectionIds: Seq[String]): Future[Int] = filterAndDelete(_.collectionId.inSet(collectionIds))

    def getCollectedCollection(accountId: String): Future[Seq[String]] = filter(x => x.ownerId === accountId && x.creatorId =!= accountId).map(_.map(_.collectionId).distinct)

    def getByCollectionAndPageNumber(accountId: String, collectionId: String, pageNumber: Int): Future[Seq[NFTOwner]] = filterAndSortWithPagination(x => x.ownerId === accountId && x.creatorId =!= accountId && x.collectionId === collectionId)(_.updatedOnMillisEpoch)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.NFTsPerPage, limit = constants.CommonConfig.Pagination.NFTsPerPage).map(_.map(_.deserialize()))

    def getSoldNFTs(collectionIDs: Seq[String]): Future[Seq[String]] = filter(x => x.ownerId =!= x.creatorId && x.collectionId.inSet(collectionIDs)).map(_.map(_.nftId))

    def getByIds(nftIDs: Seq[String]): Future[Seq[NFTOwner]] = filter(_.nftId.inSet(nftIDs)).map(_.map(_.deserialize))

    def getByOwnerAndIds(ownerId: String, nftIDs: Seq[String]): Future[Seq[NFTOwner]] = filter(x => x.ownerId === ownerId && x.nftId.inSet(nftIDs)).map(_.map(_.deserialize))

    def countOwners(nftId: String): Future[Int] = filterAndCount(_.nftId === nftId)

    def getByNFTID(nftId: String): Future[NFTOwner] = filterHead(_.nftId === nftId).map(_.deserialize)

    def onSuccessfulNFTTransfer(nftId: String, fromOwnerID: String, quantity: Long, toOwnerID: String): Future[Unit] = {
      val fromNFTOwner = tryGet(nftId = nftId, ownerId = fromOwnerID)
      val toNFTOwner = get(nftId = nftId, ownerId = toOwnerID)

      def fromUpdate(fromOwner: NFTOwner) = if (fromOwner.quantity - quantity >= 0) {
        if (fromOwner.quantity - quantity == 0) delete(nftId = nftId, ownerId = fromOwnerID) else update(fromOwner.copy(quantity = fromOwner.quantity - quantity))
      } else constants.Response.INSUFFICIENT_NFT_BALANCE.throwBaseException()

      def toUpdate(fromOwner: NFTOwner, toOwner: Option[NFTOwner]) = if (toOwner.isDefined) update(toOwner.get.copy(quantity = toOwner.get.quantity + quantity)) else add(fromOwner.copy(ownerId = toOwnerID, quantity = quantity))

      for {
        fromNFTOwner <- fromNFTOwner
        toNFTOwner <- toNFTOwner
        _ <- fromUpdate(fromNFTOwner)
        _ <- toUpdate(fromNFTOwner, toNFTOwner)
      } yield ()
    }

    def markNFTSoldFromPublicListing(nftId: String, creatorId: String, buyerAccountId: String, quantity: Long): Future[Unit] = if (quantity > 0) {
      val oldCreatorNFTOwner = tryGet(nftId = nftId, ownerId = creatorId)
      val oldBuyerNFTOwner = get(nftId = nftId, ownerId = buyerAccountId)

      def verifyAndUpdate(oldCreatorNFTOwner: NFTOwner, oldBuyerNFTOwner: Option[NFTOwner]) = {
        val creatorNFTOwner = oldCreatorNFTOwner.copy(quantity = oldCreatorNFTOwner.quantity - quantity)
        val buyerNFTOwner = if (oldBuyerNFTOwner.isDefined) oldBuyerNFTOwner.get.copy(quantity = oldBuyerNFTOwner.get.quantity + quantity)
        else oldCreatorNFTOwner.copy(ownerId = buyerAccountId, quantity = quantity)
        val deleteOrUpdate = if (creatorNFTOwner.quantity == 0) delete(nftId = nftId, ownerId = creatorId)
        else upsert(creatorNFTOwner.serialize)
        for {
          _ <- deleteOrUpdate
          _ <- upsert(buyerNFTOwner.serialize)
        } yield ()
        //        } else constants.Response.HANDLE_MULTIPLE_NFT_QUANTITY_CASE.throwBaseException()
      }

      for {
        oldCreatorNFTOwner <- oldCreatorNFTOwner
        oldBuyerNFTOwner <- oldBuyerNFTOwner
        _ <- verifyAndUpdate(oldCreatorNFTOwner, oldBuyerNFTOwner)
      } yield ()
    } else constants.Response.INVALID_QUANTITY.throwFutureBaseException()

    def markNFTSoldFromSale(nftId: String, creatorId: String, buyerAccountId: String, quantity: Long): Future[Unit] = if (quantity > 0) {
      val oldCreatorNFTOwner = tryGet(nftId = nftId, ownerId = creatorId)
      val oldBuyerNFTOwner = get(nftId = nftId, ownerId = buyerAccountId)

      def verifyAndUpdate(oldCreatorNFTOwner: NFTOwner, oldBuyerNFTOwner: Option[NFTOwner]) = {
        val creatorNFTOwner = oldCreatorNFTOwner.copy(quantity = oldCreatorNFTOwner.quantity - quantity)
        val buyerNFTOwner = if (oldBuyerNFTOwner.isDefined) oldBuyerNFTOwner.get.copy(quantity = oldBuyerNFTOwner.get.quantity + quantity)
        else oldCreatorNFTOwner.copy(ownerId = buyerAccountId, quantity = quantity)
        val deleteOrUpdate = if (creatorNFTOwner.quantity == 0) delete(nftId = nftId, ownerId = creatorId)
        else upsert(creatorNFTOwner.serialize)
        for {
          _ <- deleteOrUpdate
          _ <- upsert(buyerNFTOwner.serialize)
        } yield ()
        //        } else constants.Response.HANDLE_MULTIPLE_NFT_QUANTITY_CASE.throwBaseException()
      }

      for {
        oldCreatorNFTOwner <- oldCreatorNFTOwner
        oldBuyerNFTOwner <- oldBuyerNFTOwner
        _ <- verifyAndUpdate(oldCreatorNFTOwner, oldBuyerNFTOwner)
      } yield ()
    } else constants.Response.INVALID_QUANTITY.throwFutureBaseException()
    //    https://scala-slick.org/doc/3.1.1/sql-to-slick.html#id21
    //    def getQuery = tableQuery.filter(x => x.ownerId === "asd" && x.creatorId)
  }
}