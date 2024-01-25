package models.masterTransaction

import constants.Scheduler
import exceptions.BaseException
import models.common.Collection._
import models.master.{Collection, Collections}
import models.masterTransaction.CollectionDrafts.CollectionDraftTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

case class CollectionDraft(id: String, creatorId: String, name: String, detail: Detail, city: String, socialProfiles: Seq[SocialProfile], category: String, profileFileName: Option[String], coverFileName: Option[String], royalty: BigDecimal, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def getWebsite: Option[String] = this.socialProfiles.find(_.name == constants.Collection.SocialProfile.WEBSITE).map(_.url)

  def getTwitter: Option[String] = this.socialProfiles.find(_.name == constants.Collection.SocialProfile.TWITTER).map(_.url)

  def getInstagram: Option[String] = this.socialProfiles.find(_.name == constants.Collection.SocialProfile.INSTAGRAM).map(_.url)

  def toCollection(public: Boolean = false): Collection = {
    Collection(
      id = this.id,
      creatorId = this.creatorId,
      name = this.name,
      detail = this.detail,
      city = this.city,
      socialProfiles = this.socialProfiles,
      category = this.category,
      profileFileName = this.profileFileName,
      coverFileName = this.coverFileName,
      royalty = this.royalty,
      rank = Int.MaxValue,
      onSecondaryMarket = false,
      public = true)
  }

  def getProfileFileURL: Option[String] = this.profileFileName.map(x => constants.CommonConfig.AmazonS3.s3BucketURL + utilities.Collection.getOthersFileAwsKey(collectionId = this.id, fileName = x))

  def getCoverFileURL: Option[String] = this.coverFileName.map(x => constants.CommonConfig.AmazonS3.s3BucketURL + utilities.Collection.getOthersFileAwsKey(collectionId = this.id, fileName = x))

  def serialize(): CollectionDrafts.CollectionDraftSerialized = CollectionDrafts.CollectionDraftSerialized(
    id = this.id,
    creatorId = this.creatorId,
    name = this.name,
    detail = Json.toJson(this.detail).toString(),
    city = this.city,
    socialProfiles = Json.toJson(this.socialProfiles).toString(),
    category = this.category,
    profileFileName = this.profileFileName,
    coverFileName = this.coverFileName,
    royalty = this.royalty,
    createdBy = this.createdBy, createdOnMillisEpoch = this.createdOnMillisEpoch, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch)

  def isFractionalized: Boolean = true
}

private[masterTransaction] object CollectionDrafts {

  case class CollectionDraftSerialized(id: String, creatorId: String, name: String, detail: String, city: String, socialProfiles: String, category: String, profileFileName: Option[String], coverFileName: Option[String], royalty: BigDecimal, createdBy: Option[String], createdOnMillisEpoch: Option[Long], updatedBy: Option[String], updatedOnMillisEpoch: Option[Long]) extends Entity[String] {
    def deserialize()(implicit module: String, logger: Logger): CollectionDraft = CollectionDraft(
      id = id,
      creatorId = creatorId,
      name = name,
      detail = utilities.JSON.convertJsonStringToObject[Detail](detail),
      city = city,
      socialProfiles = utilities.JSON.convertJsonStringToObject[Seq[SocialProfile]](socialProfiles),
      category = category,
      profileFileName = profileFileName,
      coverFileName = coverFileName,
      royalty = royalty,
      createdBy = createdBy, createdOnMillisEpoch = createdOnMillisEpoch, updatedBy = updatedBy, updatedOnMillisEpoch = updatedOnMillisEpoch)
  }

  class CollectionDraftTable(tag: Tag) extends Table[CollectionDraftSerialized](tag, "CollectionDraft") with ModelTable[String] {

    def * = (id, creatorId, city, name, detail, socialProfiles, category, profileFileName.?, coverFileName.?, royalty, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (CollectionDraftSerialized.tupled, CollectionDraftSerialized.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def creatorId = column[String]("creatorId")

    def name = column[String]("name")

    def detail = column[String]("detail")

    def socialProfiles = column[String]("socialProfiles")

    def city = column[String]("city")

    def category = column[String]("category")

    def profileFileName = column[String]("profileFileName")

    def coverFileName = column[String]("coverFileName")

    def royalty = column[BigDecimal]("royalty")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")
  }
}

@Singleton
class CollectionDrafts @Inject()(
                                  masterCollections: Collections,
                                  protected val dbConfigProvider: DatabaseConfigProvider,
                                )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[CollectionDrafts.CollectionDraftTable, CollectionDrafts.CollectionDraftSerialized, String]() {


  implicit val module: String = constants.Module.MASTER_TRANSACTION_COLLECTION_DRAFT

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new CollectionDraftTable(tag))

  object Service {

    def add(creatorId: String, name: String, detail: Detail, city: String, socialProfiles: Seq[SocialProfile], category: String, royalty: BigDecimal): Future[CollectionDraft] = {
      val id = utilities.IdGenerator.getRandomHexadecimal
      val collection = CollectionDraft(
        id = id,
        creatorId = creatorId,
        name = name,
        detail = detail,
        socialProfiles = socialProfiles,
        city = city,
        profileFileName = None,
        coverFileName = None,
        category = category,
        royalty = royalty)
      for {
        _ <- create(collection.serialize())
      } yield collection
    }

    def tryGet(id: String): Future[CollectionDraft] = tryGetById(id).map(_.deserialize)

    def checkOwnerAndUpdate(id: String, creatorId: String, name: String, detail: Detail, city: String, socialProfiles: Seq[SocialProfile], category: String, royalty: BigDecimal): Future[CollectionDraft] = {
      val collectionDraft = tryGet(id)

      def validateAndUpdate(collectionDraft: CollectionDraft) = if (collectionDraft.creatorId == creatorId) {
        updateById(collectionDraft.copy(name = name, detail = detail, city = city, socialProfiles = socialProfiles, category = category, royalty = royalty).serialize())
      } else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()

      for {
        collectionDraft <- collectionDraft
        _ <- validateAndUpdate(collectionDraft)
      } yield collectionDraft.copy(name = name, detail = detail, socialProfiles = socialProfiles)
    }

    def isOwner(id: String, accountId: String): Future[Boolean] = filterAndExists(x => x.id === id && x.creatorId === accountId)

    def updateProfile(id: String, fileName: String): Future[Unit] = {
      val collectionDraft = tryGet(id)
      for {
        collectionDraft <- collectionDraft
        _ <- updateById(collectionDraft.copy(profileFileName = Option(fileName)).serialize())
      } yield ()
    }

    def updateCover(id: String, fileName: String): Future[Unit] = {
      val collectionDraft = tryGet(id)
      for {
        collectionDraft <- collectionDraft
        _ <- updateById(collectionDraft.copy(coverFileName = Option(fileName)).serialize())
      } yield ()
    }

    def totalDrafts(creatorId: String): Future[Int] = filterAndCount(_.creatorId === creatorId)

    def getByCreatorAndPage(creatorId: String, pageNumber: Int): Future[Seq[CollectionDraft]] = filterAndSortWithPagination(_.creatorId === creatorId)(_.createdOnMillisEpoch)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.CollectionsPerPage, limit = constants.CommonConfig.Pagination.CollectionsPerPage).map(_.map(_.deserialize))

    def delete(id: String): Future[Int] = deleteById(id)

    def delete(ids: Seq[String]): Future[Int] = filterAndDelete(_.id.inSet(ids))

    def checkOwnerAndDelete(id: String, accountId: String): Future[Unit] = {
      val draft = tryGet(id)

      for {
        draft <- draft
        _ <- if (draft.creatorId == accountId) delete(id) else constants.Response.NOT_COLLECTION_OWNER.throwBaseException()
      } yield ()
    }

    def getCompleted: Future[Seq[CollectionDraft]] = filter(x => x.profileFileName.?.isDefined && x.coverFileName.?.isDefined).map(_.map(_.deserialize()))

  }

  object Utility {
    val scheduler: Scheduler = new Scheduler {
      val name: String = module


      def runner(): Unit = {
        val completedDrafts = Service.getCompleted

        def moveToCollection(completedDrafts: Seq[CollectionDraft]) = masterCollections.Service.add(completedDrafts.map(_.toCollection(true)))

        def delete(completedDrafts: Seq[CollectionDraft]) = Service.delete(completedDrafts.map(_.id))

        val forComplete = (for {
          completedDrafts <- completedDrafts
          _ <- moveToCollection(completedDrafts)
          _ <- delete(completedDrafts)
        } yield ()).recover {
          case baseException: BaseException => baseException.notifyLog("[PANIC]")
            logger.error("[PANIC] Something is seriously wrong with logic. Code should not reach here.")
        }

        Await.result(forComplete, Duration.Inf)
      }
    }
  }
}