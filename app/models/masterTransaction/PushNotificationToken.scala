package models.masterTransaction

import models.masterTransaction.PushNotificationTokens.PushNotificationTokenTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._

import java.sql.Timestamp
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class PushNotificationToken(accountId: String, token: String, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging with Entity[String] {
  def id: String = accountId
}

private[masterTransaction] object PushNotificationTokens {
  class PushNotificationTokenTable(tag: Tag) extends Table[PushNotificationToken](tag, "PushNotificationToken") with ModelTable[String] {

    def * = (accountId, token, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (PushNotificationToken.tupled, PushNotificationToken.unapply)

    def accountId = column[String]("accountId", O.PrimaryKey)

    def token = column[String]("token")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

    def id = accountId
  }
}

@Singleton
class PushNotificationTokens @Inject()(
                                        protected val dbConfigProvider: DatabaseConfigProvider,
                                      )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[PushNotificationTokens.PushNotificationTokenTable, PushNotificationToken, String]() {

  implicit val module: String = constants.Module.MASTER_TRANSACTION_PUSH_NOTIFICATION_TOKEN

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new PushNotificationTokenTable(tag))

  object Service {

    def upsert(id: String, token: String): Future[Unit] = {
      for {
        _ <- deleteById(id)
        _ <- create(PushNotificationToken(id, token))
      } yield ()
    }

    def getPushNotificationToken(id: String): Future[Option[String]] = getById(id).map(_.map(_.token))

    def delete(id: String): Future[Int] = deleteById(id)

  }

}

