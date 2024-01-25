package models.master

import models.master.NFTs.NFTTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import schema.id.base.{AssetID, HashID}
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import javax.xml.bind.DatatypeConverter
import scala.concurrent.{ExecutionContext, Future}

case class NFT(id: String, assetId: String, collectionId: String, name: String, description: String, totalSupply: BigInt, isMinted: Option[Boolean], fileExtension: String, saleId: Option[String], publicListingId: Option[String], createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def getFileHash: String = this.id

  def getExplorerUrl = s"${constants.CommonConfig.ExplorerUrl}/document/${this.getAssetID.asString}"

  def getFileHashID: HashID = HashID(DatatypeConverter.parseHexBinary(this.id))

  def getFileName: String = this.id + "." + this.fileExtension

  def getAssetID: AssetID = AssetID(HashID(utilities.Secrets.base64URLDecode(this.assetId)))

  def getAwsKey: String = utilities.NFT.getAWSKey(this.getFileName)

  def getS3Url: String = constants.CommonConfig.AmazonS3.s3BucketURL + this.getAwsKey

  def getServiceEndPoint: String = "https://marketplace.assetmantle.one/nftResource/" + this.id + "." + this.fileExtension

  def serialize: NFTs.NFTSerialized = NFTs.NFTSerialized(
    id = this.id, assetId = this.assetId, collectionId = this.collectionId, name = this.name, description = this.description, totalSupply = BigDecimal(this.totalSupply), isMinted = this.isMinted, fileExtension = this.fileExtension.toLowerCase, saleId = this.saleId, publicListingId = this.publicListingId, createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch
  )

  def isImageType: Boolean = true

  def isAudioType: Boolean = false

}

private[master] object NFTs {

  case class NFTSerialized(id: String, assetId: String, collectionId: String, name: String, description: String, totalSupply: BigDecimal, isMinted: Option[Boolean], fileExtension: String, saleId: Option[String], publicListingId: Option[String], createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity[String] {

    def deserialize()(implicit module: String, logger: Logger): NFT = NFT(id = this.id, assetId = this.assetId, collectionId = this.collectionId, name = this.name, description = this.description, totalSupply = this.totalSupply.toBigInt, isMinted = this.isMinted, fileExtension = this.fileExtension, saleId = this.saleId, publicListingId = this.publicListingId, createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch)
  }

  class NFTTable(tag: Tag) extends Table[NFTSerialized](tag, "NFT") with ModelTable[String] {

    def * = (id, assetId, collectionId, name, description, totalSupply, isMinted.?, fileExtension, saleId.?, publicListingId.?, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (NFTSerialized.tupled, NFTSerialized.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def assetId = column[String]("assetId")

    def collectionId = column[String]("collectionId")

    def name = column[String]("name")

    def description = column[String]("description")

    def totalSupply = column[BigDecimal]("totalSupply")

    def isMinted = column[Boolean]("isMinted")

    def fileExtension = column[String]("fileExtension")

    def saleId = column[String]("saleId")

    def publicListingId = column[String]("publicListingId")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")
  }
}

@Singleton
class NFTs @Inject()(
                      protected val dbConfigProvider: DatabaseConfigProvider,
                    )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[NFTs.NFTTable, NFTs.NFTSerialized, String]() {

  implicit val module: String = constants.Module.MASTER_NFT

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new NFTTable(tag))

  object Service {
    def add(nft: NFT): Future[String] = create(nft.serialize).map(_.id)

    def tryGet(nftId: String): Future[NFT] = tryGetById(nftId).map(_.deserialize)

    def get(nftId: String): Future[Option[NFT]] = getById(nftId).map(_.map(_.deserialize()))

    def getAllIdsForCollection(collectionId: String): Future[Seq[String]] = filter(_.collectionId === collectionId).map(_.map(_.id))

    def getAllIdsForCollections(collectionIds: Seq[String]): Future[Seq[String]] = filter(_.collectionId.inSet(collectionIds)).map(_.map(_.id))

    def getAllINFTsForCollections(collectionIds: Seq[String]): Future[Seq[NFT]] = filter(_.collectionId.inSet(collectionIds)).map(_.map(_.deserialize))

    def getAllINFTsForCollection(collectionId: String): Future[Seq[NFT]] = filter(_.collectionId === collectionId).map(_.map(_.deserialize))

    def getByPageNumber(collectionId: String, pageNumber: Int): Future[Seq[NFT]] = filterAndSortWithPagination(_.collectionId === collectionId)(_.name)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.NFTsPerPage, limit = constants.CommonConfig.Pagination.NFTsPerPage).map(_.map(_.deserialize))

    def getForEarlyAccessByPageNumber(collectionId: String, pageNumber: Int): Future[Seq[NFT]] = filterAndSortWithPagination(x => x.collectionId === collectionId && x.publicListingId.?.isDefined)(_.name)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.NFTsPerPage, limit = constants.CommonConfig.Pagination.NFTsPerPage).map(_.map(_.deserialize))

    def getForWhitelistSaleByPageNumber(collectionId: String, pageNumber: Int): Future[Seq[NFT]] = filterAndSortWithPagination(x => x.collectionId === collectionId && x.saleId.?.isDefined)(_.name)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.NFTsPerPage, limit = constants.CommonConfig.Pagination.NFTsPerPage).map(_.map(_.deserialize))

    def checkExists(id: String): Future[Boolean] = exists(id)

    def getByIds(ids: Seq[String]): Future[Seq[NFT]] = filter(_.id.inSet(ids)).map(_.map(_.deserialize))

    def getForMinting: Future[Seq[NFT]] = filter(x => !x.isMinted).map(_.take(300)).map(_.map(_.deserialize))

    def deleteCollections(collectionIds: Seq[String]): Future[Int] = filterAndDelete(_.collectionId.inSet(collectionIds))

    def update(nft: NFT): Future[Unit] = updateById(nft.serialize)

    def countNFTs(collectionId: String): Future[Int] = filterAndCount(_.collectionId === collectionId)

    def markNFTsMintPending(ids: Seq[String]): Future[Int] = customUpdate(tableQuery.filter(_.id.inSet(ids)).map(_.isMinted.?).update(null))

    def markNFTsMinted(ids: Seq[String]): Future[Int] = customUpdate(tableQuery.filter(_.id.inSet(ids)).map(_.isMinted).update(true))

    def markNFTsMintFailed(ids: Seq[String]): Future[Int] = customUpdate(tableQuery.filter(_.id.inSet(ids)).map(_.isMinted).update(false))

    def updateAssetID(id: String, assetID: AssetID): Future[Int] = customUpdate(tableQuery.filter(_.id === id).map(_.assetId).update(assetID.asString))

    def fetchAllWithNullAssetID(): Future[Seq[NFT]] = filter(_.assetId.?.isEmpty).map(_.map(_.deserialize))

    def getRandomNFTs(collectionId: String, n: Int, filterOut: Seq[String]): Future[Seq[NFT]] = filter(x => x.collectionId === collectionId && !x.id.inSet(filterOut)).map(util.Random.shuffle(_).take(n)).map(_.map(_.deserialize))

    def getUnmintedNFTIDs(collectionId: String): Future[Seq[String]] = customQuery(tableQuery.filter(x => x.collectionId === collectionId && (!x.isMinted.?.getOrElse(true))).map(_.id).result)

    def getByAssetId(assetId: AssetID): Future[Option[NFT]] = filter(_.assetId === assetId.asString).map(_.headOption).map(_.map(_.deserialize))

    def getByAssetId(assetId: String): Future[Option[NFT]] = filter(_.assetId === assetId).map(_.headOption).map(_.map(_.deserialize))

    def delete(id: String): Future[Int] = deleteById(id)

    def getAllNFTs: Future[Seq[NFT]] = getAll.map(_.map(_.deserialize))

    def markSaleNull(saleId: String): Future[Int] = {
      val nullString: Option[String] = null
      customUpdate(tableQuery.filter(_.saleId === saleId).map(_.saleId.?).update(nullString))
    }

    def markPublicListingNull(publicListingId: String): Future[Int] = {
      val nullString: Option[String] = null
      customUpdate(tableQuery.filter(_.publicListingId === publicListingId).map(_.publicListingId.?).update(nullString))
    }

    def checkAnyPublicListingSaleExists(publicListingId: String): Future[Boolean] = filterAndExists(_.publicListingId === publicListingId)

    def checkAnySaleExists(saleId: String): Future[Boolean] = filterAndExists(_.saleId === saleId)

    def addToPublishingSale(id: String, publicListingId: String): Future[Unit] = {
      val nft = tryGet(id)

      def check(nft: NFT) = if (nft.publicListingId.isEmpty && nft.saleId.isEmpty) {
        update(nft.copy(publicListingId = Option(publicListingId)))
      } else constants.Response.NFT_ALREADY_ON_SALE.throwFutureBaseException()

      for {
        nft <- nft
        _ <- check(nft)
      } yield ()
    }

    def getNFTNames(ids: Seq[String]): Future[Map[String, String]] = filter(_.id.inSet(ids)).map(_.map(x => x.id -> x.name).toMap)

    def addToWhitelistSale(id: String, saleId: String): Future[Unit] = {
      val nft = tryGet(id)

      def check(nft: NFT) = if (nft.publicListingId.isEmpty && nft.saleId.isEmpty) {
        update(nft.copy(saleId = Option(saleId)))
      } else constants.Response.NFT_ALREADY_ON_SALE.throwFutureBaseException()

      for {
        nft <- nft
        _ <- check(nft)
      } yield ()
    }
  }
}