package models.masterTransaction

import models.masterTransaction.Notifications.NotificationTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.i18n.{Lang, MessagesApi}
import play.api.libs.json.Json
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class Notification(id: String, accountID: Option[String], title: String, messageParameters: Seq[String], jsRoute: Option[String], read: Boolean = false, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None) extends Logging {
  def getTitle: String = Seq("NOTIFICATION", this.title, "TITLE").mkString(".")

  def message: String = Seq("NOTIFICATION", this.title, "MESSAGE").mkString(".")

  def serialize(): Notifications.NotificationSerializable = Notifications.NotificationSerializable(id = this.id, accountID = this.accountID, title = title, messageParameters = Json.toJson(this.messageParameters).toString, jsRoute = this.jsRoute, read = this.read, createdOnMillisEpoch = this.createdOnMillisEpoch, createdBy = this.createdBy, updatedBy = this.updatedBy, updatedOnMillisEpoch = this.updatedOnMillisEpoch)

  def isClickable: Boolean = this.jsRoute.isDefined

  def toClientMessage(toUser: String, messagesApi: MessagesApi, notificationType: String)(implicit lang: Lang): actors.Message.Notification = actors.Message.Notification(toUser = toUser, id = this.id, message = messagesApi(this.message, this.messageParameters: _*), title = messagesApi(this.getTitle), notificationType = notificationType)

}

private[masterTransaction] object Notifications {

  case class NotificationSerializable(id: String, accountID: Option[String], title: String, messageParameters: String, jsRoute: Option[String], read: Boolean, createdOnMillisEpoch: Option[Long], createdBy: Option[String], updatedOnMillisEpoch: Option[Long], updatedBy: Option[String]) extends Entity[String] {
    def deserialize()(implicit module: String, logger: Logger): Notification = Notification(id = id, accountID = accountID, title = title, messageParameters = utilities.JSON.convertJsonStringToObject[Seq[String]](messageParameters), jsRoute = jsRoute, read = read, createdOnMillisEpoch = createdOnMillisEpoch, createdBy = createdBy, updatedBy = updatedBy, updatedOnMillisEpoch = updatedOnMillisEpoch)

  }

  class NotificationTable(tag: Tag) extends Table[NotificationSerializable](tag, "Notification") with ModelTable[String] {

    def * = (id, accountID.?, title, messageParameters, jsRoute.?, read, createdOnMillisEpoch.?, createdBy.?, updatedOnMillisEpoch.?, updatedBy.?) <> (NotificationSerializable.tupled, NotificationSerializable.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def accountID = column[String]("accountID")

    def title = column[String]("title")

    def messageParameters = column[String]("messageParameters")

    def jsRoute = column[String]("jsRoute")

    def read = column[Boolean]("read")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def createdBy = column[String]("createdBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

  }

}

@Singleton
class Notifications @Inject()(protected val dbConfigProvider: DatabaseConfigProvider,
                              utilitiesOperations: utilities.Operations,
                             )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[Notifications.NotificationTable, Notifications.NotificationSerializable, String]() {

  implicit val module: String = constants.Module.MASTER_TRANSACTION_NOTIFICATION

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new NotificationTable(tag))

  object Service {

    def add(accountID: String, notification: constants.Notification, parameters: String*)(routeParameters: String = ""): Future[Notification] = {
      val masterNotification = Notification(id = utilities.IdGenerator.getRandomHexadecimal, accountID = Option(accountID), title = notification.name, messageParameters = parameters, jsRoute = notification.route.fold[Option[String]](None)(x => Option(utilities.JsRoutes.getJsRouteString(x, routeParameters))))
      for {
        _ <- create(masterNotification.serialize())
      } yield masterNotification
    }

    def addPublic(notification: constants.Notification, parameters: String*)(routeParameters: String = ""): Future[String] = create(Notification(id = utilities.IdGenerator.getRandomHexadecimal, accountID = None, title = notification.name, messageParameters = parameters, jsRoute = notification.route.fold[Option[String]](None)(x => Option(utilities.JsRoutes.getJsRouteString(x, routeParameters)))).serialize()).map(_.id)

    def add(accountIDs: Seq[String], notification: constants.Notification, parameters: String*)(routeParameters: String): Future[Int] = create(accountIDs.map { x =>
      Notification(id = utilities.IdGenerator.getRandomHexadecimal, accountID = Option(x), title = notification.name, messageParameters = parameters, jsRoute = notification.route.fold[Option[String]](None)(x => Option(utilities.JsRoutes.getJsRouteString(x, routeParameters)))).serialize()
    })

    def get(accountID: String, pageNumber: Int): Future[Seq[Notification]] = filterAndSortWithPagination(_.accountID === accountID)(_.createdOnMillisEpoch.desc)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.NotificationsPerPage, limit = constants.CommonConfig.Pagination.NotificationsPerPage).map(_.map(_.deserialize()))

    def getPublic(pageNumber: Int): Future[Seq[Notification]] = {
      val accountId: Option[String] = null
      filterAndSortWithPagination(_.accountID.? === accountId)(_.createdOnMillisEpoch.desc)(offset = (pageNumber - 1) * constants.CommonConfig.Pagination.NotificationsPerPage, limit = constants.CommonConfig.Pagination.NotificationsPerPage).map(_.map(_.deserialize()))
    }

    def getNumberOfUnread(accountID: String): Future[Int] = filterAndCount(x => x.accountID === accountID && !x.read)

    def update(notification: Notification): Future[Unit] = updateById(notification.serialize())

    def markNotificationRead(notificationId: String, accountId: String): Future[Int] = {
      val update = customUpdate(tableQuery.filter(x => x.id === notificationId && x.accountID === accountId).map(_.read).update(true))
      for {
        _ <- update
        unread <- getNumberOfUnread(accountId)
      } yield unread
    }

    // TODO optimize by creating filterAndUpdate
    def markAllRead(accountId: String): Future[Int] = customUpdate(tableQuery.filter(x => x.accountID === accountId && !x.read).map(_.read).update(true))
  }

}