package models.master

import models.common.Collection._
import models.master.Collections.CollectionTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import schema.id.base.IdentityID
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class Collection(id: String, creatorId: String, name: String, detail: Detail, city: String, socialProfiles: Seq[SocialProfile], category: String, profileFileName: Option[String], coverFileName: Option[String], public: Boolean, royalty: BigDecimal, rank: Int, onSecondaryMarket: Boolean, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def getRoyaltyFee: BigDecimal = this.royalty

  def getCreatorIdentityID: IdentityID = utilities.Identity.getMantlePlaceIdentityID(this.creatorId)

  def getAddress: String = this.detail.address

  def getPostalCode: String = this.detail.postalCode


  def getContactNumber: String = this.detail.contactNumber

  def getStartTime: Long = this.detail.startEpochTime

  def getEndTime: Long = this.detail.endEpochTime

  def serialize(): Collections.CollectionSerialized = Collections.CollectionSerialized(
    id = this.id,
    creatorId = this.creatorId,
    name = this.name,
    detail = Json.toJson(this.detail).toString(),
    city = this.city,
    socialProfiles = Json.toJson(this.socialProfiles).toString(),
    category = this.category,
    profileFileName = this.profileFileName,
    coverFileName = this.coverFileName,
    public = this.public,
    royalty = this.royalty,
    rank = this.rank,
    onSecondaryMarket = this.onSecondaryMarket,
    createdBy = this.createdBy,
    createdOnMillisEpoch = this.createdOnMillisEpoch,
    updatedBy = this.updatedBy,
    updatedOnMillisEpoch = this.updatedOnMillisEpoch)

  def getWebsite: Option[String] = this.socialProfiles.find(_.name == constants.Collection.SocialProfile.WEBSITE).map(_.url)

  def getTwitter: Option[String] = this.socialProfiles.find(_.name == constants.Collection.SocialProfile.TWITTER).map("https://www.twitter.com/" + _.url)

  def getTwitterUsername: Option[String] = this.socialProfiles.find(_.name == constants.Collection.SocialProfile.TWITTER).map(_.url)

  def getInstagram: Option[String] = this.socialProfiles.find(_.name == constants.Collection.SocialProfile.INSTAGRAM).map("https://www.instagram.com/" + _.url)

  def getProfileFileURL: Option[String] = this.profileFileName.map(x => constants.CommonConfig.AmazonS3.s3BucketURL + utilities.Collection.getOthersFileAwsKey(collectionId = this.id, fileName = x))

  def getCoverFileURL: Option[String] = this.coverFileName.map(x => constants.CommonConfig.AmazonS3.s3BucketURL + utilities.Collection.getOthersFileAwsKey(collectionId = this.id, fileName = x))

  def isFractionalized: Boolean = true
}

private[master] object Collections {

  case class CollectionSerialized(id: String, creatorId: String, name: String, detail: String, city: String, socialProfiles: String, category: String, profileFileName: Option[String], coverFileName: Option[String], public: Boolean, royalty: BigDecimal, rank: Int, onSecondaryMarket: Boolean, createdBy: Option[String], createdOnMillisEpoch: Option[Long], updatedBy: Option[String], updatedOnMillisEpoch: Option[Long]) extends Entity[String] {
    def deserialize()(implicit module: String, logger: Logger): Collection = Collection(
      id = id,
      creatorId = creatorId,
      name = name,
      detail = utilities.JSON.convertJsonStringToObject[Detail](detail),
      city = city,
      socialProfiles = utilities.JSON.convertJsonStringToObject[Seq[SocialProfile]](socialProfiles),
      category = category,
      profileFileName = profileFileName,
      coverFileName = coverFileName,
      public = public,
      royalty = royalty,
      rank = rank,
      onSecondaryMarket = onSecondaryMarket,
      createdBy = createdBy, createdOnMillisEpoch = createdOnMillisEpoch, updatedBy = updatedBy, updatedOnMillisEpoch = updatedOnMillisEpoch)
  }

  class CollectionTable(tag: Tag) extends Table[CollectionSerialized](tag, "Collection") with ModelTable[String] {

    def * = (id, creatorId, city, name, detail, socialProfiles, category, profileFileName.?, coverFileName.?, public, royalty, rank, onSecondaryMarket, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (CollectionSerialized.tupled, CollectionSerialized.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def creatorId = column[String]("creatorId")

    def name = column[String]("name")

    def detail = column[String]("detail")

    def socialProfiles = column[String]("socialProfiles")

    def city = column[String]("city")

    def category = column[String]("category")

    def profileFileName = column[String]("profileFileName")

    def coverFileName = column[String]("coverFileName")

    def public = column[Boolean]("public")

    def royalty = column[BigDecimal]("royalty")

    def rank = column[Int]("rank")

    def onSecondaryMarket = column[Boolean]("onSecondaryMarket")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")


  }
}

@Singleton
class Collections @Inject()(
                             protected val dbConfigProvider: DatabaseConfigProvider,
                           )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[Collections.CollectionTable, Collections.CollectionSerialized, String]() {

  implicit val module: String = constants.Module.MASTER_COLLECTION

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new CollectionTable(tag))

  object Service {

    def add(collection: Collection): Future[String] = create(collection.serialize()).map(_.id)

    def add(collections: Seq[Collection]): Future[Int] = create(collections.map(_.serialize()))

    def update(collection: Collection): Future[Unit] = updateById(collection.serialize())

    def fetchAll(): Future[Seq[Collection]] = getAll.map(_.map(_.deserialize))

    def markListedOnSecondaryMarket(id: String): Future[Int] = customUpdate(tableQuery.filter(_.id === id).map(_.onSecondaryMarket).update(true))

    def removeFromListedOnSecondaryMarket(id: String): Future[Int] = customUpdate(tableQuery.filter(_.id === id).map(_.onSecondaryMarket).update(false))

    def totalOnSecondaryMarket: Future[Int] = filterAndCount(_.onSecondaryMarket)

    def get(id: String): Future[Option[Collection]] = getById(id).map(_.map(_.deserialize))

    def tryGet(id: String): Future[Collection] = tryGetById(id).map(_.deserialize)

    def getPublicByPageNumber(pageNumber: Int): Future[Seq[Collection]] = filterAndSortWithPagination(_.public)(_.createdOnMillisEpoch)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.CollectionsPerPage, limit = constants.CommonConfig.Pagination.CollectionsPerPage).map(_.map(_.deserialize))

    def getCollectionsByPage(collectionIds: Seq[String], pageNumber: Int): Future[Seq[Collection]] = filterAndSortWithPagination(_.id.inSet(collectionIds))(_.createdOnMillisEpoch)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.CollectionsPerPage, limit = constants.CommonConfig.Pagination.CollectionsPerPage).map(_.map(_.deserialize))

    def getCollections(collectionIds: Seq[String]): Future[Seq[Collection]] = filter(_.id.inSet(collectionIds)).map(_.map(_.deserialize))

    def totalCreated(creatorId: String): Future[Int] = filterAndCount(_.creatorId === creatorId)

    def countPublicCollections: Future[Int] = filterAndCount(_.public)

    def getByCreatorAndPage(creatorId: String, pageNumber: Int): Future[Seq[Collection]] = filterAndSortWithPagination(_.creatorId === creatorId)(_.createdOnMillisEpoch)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.CollectionsPerPage, limit = constants.CommonConfig.Pagination.CollectionsPerPage).map(_.map(_.deserialize))

    def getByCreator(creatorId: String): Future[Seq[(String, String)]] = filterAndSort(_.creatorId === creatorId)(_.name).map(_.map(x => x.id -> x.name))

    def isOwner(id: String, accountId: String): Future[Boolean] = filterAndExists(x => x.id === id && x.creatorId === accountId)

    def updateProfile(id: String, fileName: String): Future[Unit] = {
      val collection = tryGet(id)
      for {
        collection <- collection
        _ <- updateById(collection.copy(profileFileName = Option(fileName)).serialize())
      } yield ()
    }

    def updateCover(id: String, fileName: String): Future[Unit] = {
      val collection = tryGet(id)
      for {
        collection <- collection
        _ <- updateById(collection.copy(coverFileName = Option(fileName)).serialize())
      } yield ()
    }

    def countCreated(accountId: String): Future[Int] = filterAndCount(_.creatorId === accountId)

    def getCollectionNames(ids: Seq[String]): Future[Map[String, String]] = filter(_.id.inSet(ids)).map(_.map(x => x.id -> x.name).toMap)

    def delete(ids: Seq[String]): Future[Int] = filterAndDelete(_.id.inSet(ids))

    def getAllPublic: Future[Seq[Collection]] = filter(_.public).map(_.map(_.deserialize))

    def getSecondaryMarketByPageNumber(pageNumber: Int): Future[Seq[Collection]] = filterAndSortWithPagination(_.onSecondaryMarket)(_.rank)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.CollectionsPerPage, limit = constants.CommonConfig.Pagination.CollectionsPerPage).map(_.map(_.deserialize))

  }
}