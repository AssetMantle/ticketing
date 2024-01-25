package models.master

import models.master.CollectionTags.CollectionTagTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class CollectionTag(tagName: String, collectionId: String, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Entity2[String, String] with Logging {
  def id1: String = tagName

  def id2: String = collectionId
}

private[master] object CollectionTags {

  class CollectionTagTable(tag: Tag) extends Table[CollectionTag](tag, "CollectionTag") with ModelTable2[String, String] {

    def * = (tagName, collectionId, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (CollectionTag.tupled, CollectionTag.unapply)

    def tagName = column[String]("tagName", O.PrimaryKey)

    def collectionId = column[String]("collectionId", O.PrimaryKey)

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

    def id1 = tagName

    def id2 = collectionId
  }
}

@Singleton
class CollectionTags @Inject()(
                                protected val dbConfigProvider: DatabaseConfigProvider,
                              )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl2[CollectionTags.CollectionTagTable, CollectionTag, String, String]() {

  implicit val module: String = constants.Module.MASTER_COLLECTION_TAG

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new CollectionTagTable(tag))

  object Service {

    def add(tagName: String, collectionId: String): Future[String] = create(CollectionTag(tagName = tagName, collectionId = collectionId)).map(_.collectionId)

    def add(collectionTags: Seq[CollectionTag]): Future[Int] = create(collectionTags)

    def getByTagName(tagName: String): Future[Seq[String]] = filter(_.tagName === tagName).map(_.map(_.collectionId))

    def getByTagNames(tagNames: Seq[String]): Future[Seq[String]] = filter(_.tagName.inSet(tagNames)).map(_.map(_.collectionId))

    def getTagNamesForCollection(collectionId: String): Future[Seq[String]] = filter(_.tagName === collectionId).map(_.map(_.tagName))

    def deleteByCollectionIds(collectionIDs: Seq[String]): Future[Int] = filterAndDelete(_.collectionId.inSet(collectionIDs))

    def deleteByCollectionId(collectionID: String): Future[Int] = filterAndDelete(_.collectionId === collectionID)

    def deleteByTagName(tagName: String): Future[Int] = filterAndDelete(_.tagName === tagName)

  }
}