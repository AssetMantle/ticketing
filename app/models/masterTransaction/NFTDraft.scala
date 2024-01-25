package models.masterTransaction

import models.master._
import models.masterTransaction.NFTDrafts.NFTDraftTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import schema.id.base.HashID
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import javax.xml.bind.DatatypeConverter
import scala.concurrent.{ExecutionContext, Future}

case class NFTDraft(id: String, collectionId: String, name: Option[String], description: Option[String], totalSupply: Option[BigInt], fileExtension: String, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def getFileHashID: HashID = HashID(DatatypeConverter.parseHexBinary(this.id))

  def getFileHash: String = id

  def getFileName: String = this.id + "." + this.fileExtension

  def getServiceEndPoint: String = utilities.Asset.getServiceEndPoint(id = this.id, fileExtension = this.fileExtension)

  def toNFT(collection: Collection): NFT = NFT(
    id = id,
    assetId = if (this.name.isDefined) utilities.Asset.getAssetID(
      constants.Asset.ClassificationId,
      utilities.Asset.getImmutables(
        name = this.name.getOrElse(""),
        creatorId = collection.creatorId,
        description = this.description.getOrElse(""),
        address = collection.getAddress,
        postalCode = collection.getPostalCode,
        city = collection.city,
        contactNumber = collection.getContactNumber,
        startEpochTime = collection.getStartTime,
        endEpochTime = collection.getEndTime,
        supply = this.totalSupply.getOrElse(0),
        fileHashID = this.getFileHashID,
        fileExtension = this.fileExtension,
        serviceEndpoint = this.getServiceEndPoint,
      )).asString else "",
    fileExtension = fileExtension,
    collectionId = collectionId,
    name = name.getOrElse(""),
    description = description.getOrElse(""),
    totalSupply = this.totalSupply.getOrElse(0),
    isMinted = Option(false),
    saleId = None,
    publicListingId = None)

  def toNFTOwner(ownerID: String, creatorId: String): NFTOwner = NFTOwner(nftId = id, ownerId = ownerID, creatorId = creatorId, collectionId = collectionId, quantity = this.totalSupply.getOrElse(0))

  def serialize(): NFTDrafts.NFTDraftSerialized = NFTDrafts.NFTDraftSerialized(
    id = this.id,
    collectionId = collectionId,
    name = this.name,
    description = this.description,
    fileExtension = this.fileExtension.toLowerCase,
    totalSupply = this.totalSupply.map(BigDecimal(_)),
    createdBy = this.createdBy,
    createdOnMillisEpoch = this.createdOnMillisEpoch,
    updatedBy = this.updatedBy,
    updatedOnMillisEpoch = this.updatedOnMillisEpoch)
}

private[masterTransaction] object NFTDrafts {

  case class NFTDraftSerialized(id: String, collectionId: String, name: Option[String], description: Option[String], totalSupply: Option[BigDecimal], fileExtension: String, createdBy: Option[String], createdOnMillisEpoch: Option[Long], updatedBy: Option[String], updatedOnMillisEpoch: Option[Long]) extends Entity[String] {
    def deserialize()(implicit module: String, logger: Logger): NFTDraft = NFTDraft(id = id, collectionId = collectionId, name = name, description = description, fileExtension = fileExtension, totalSupply = totalSupply.map(_.toBigInt), createdBy = createdBy, createdOnMillisEpoch = createdOnMillisEpoch, updatedBy = updatedBy, updatedOnMillisEpoch = updatedOnMillisEpoch)

  }

  class NFTDraftTable(tag: Tag) extends Table[NFTDraftSerialized](tag, "NFTDraft") with ModelTable[String] {

    def * = (id, collectionId, name.?, description.?, totalSupply.?, fileExtension, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (NFTDraftSerialized.tupled, NFTDraftSerialized.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def collectionId = column[String]("collectionId")

    def name = column[String]("name")

    def description = column[String]("description")

    def totalSupply = column[BigDecimal]("totalSupply")

    def fileExtension = column[String]("fileExtension")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

  }
}

@Singleton
class NFTDrafts @Inject()(
                           protected val dbConfigProvider: DatabaseConfigProvider,
                         )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[NFTDrafts.NFTDraftTable, NFTDrafts.NFTDraftSerialized, String]() {

  implicit val module: String = constants.Module.MASTER_TRANSACTION_NFT_DRAFT

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new NFTDraftTable(tag))

  object Service {

    def add(id: String, fileExtension: String, collectionId: String): Future[String] = {
      val nft = NFTDraft(
        id = id,
        fileExtension = fileExtension,
        collectionId = collectionId,
        name = None,
        description = None,
        totalSupply = None,
      )
      create(nft.serialize()).map(_.id)
    }

    def tryGet(id: String): Future[NFTDraft] = tryGetById(id).map(_.deserialize)

    def getByPageNumber(collectionId: String, pageNumber: Int): Future[Seq[NFTDraft]] = filterAndSortWithPagination(_.collectionId === collectionId)(_.updatedOnMillisEpoch.desc)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.NFTsPerPage, limit = constants.CommonConfig.Pagination.NFTsPerPage).map(_.map(_.deserialize))

    def getAllForCollection(collectionId: String): Future[Seq[NFTDraft]] = filter(_.collectionId === collectionId).map(_.map(_.deserialize))

    def get(id: String): Future[Option[NFTDraft]] = getById(id).map(_.map(_.deserialize))

    def countAllForCollection(collectionId: String): Future[Int] = filterAndCount(_.collectionId === collectionId)

    def checkExists(id: String): Future[Boolean] = exists(id)

    def deleteByCollectionId(id: String): Future[Int] = filterAndDelete(_.collectionId === id)

    def deleteNFT(id: String): Future[Int] = filterAndDelete(_.id === id)

    def getByIds(ids: Seq[String]): Future[Seq[NFTDraft]] = filter(_.id.inSet(ids)).map(_.map(_.deserialize))

    def delete(id: String): Future[Int] = deleteById(id)

    def deleteByCollectionIds(ids: Seq[String]): Future[Int] = filterAndDelete(_.collectionId.inSet(ids))

    def getAllNFTs: Future[Seq[NFTDraft]] = getAll.map(_.map(_.deserialize))

    def updateDetails(id: String, name: String, description: String, totalSupply: BigInt): Future[NFTDraft] = {
      val draft = tryGet(id)
      for {
        draft <- draft
        _ <- updateById(draft.copy(name = Option(name), description = Option(description), totalSupply = Option(totalSupply)).serialize())
      } yield draft.copy(name = Option(name), description = Option(description), totalSupply = Option(totalSupply))
    }

  }
}