package models.masterTransaction

import constants.Scheduler
import exceptions.BaseException
import models.masterTransaction.SessionTokens.SessionTokenTable
import models.traits._
import org.joda.time.{DateTime, DateTimeZone}
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

case class SessionToken(accountId: String, sessionTokenHash: String, sessionTokenTime: Long, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging with Entity[String] {
  def id: String = accountId
}

private[masterTransaction] object SessionTokens {

  class SessionTokenTable(tag: Tag) extends Table[SessionToken](tag, "SessionToken") with ModelTable[String] {

    def * = (accountId, sessionTokenHash, sessionTokenTime, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (SessionToken.tupled, SessionToken.unapply)

    def accountId = column[String]("accountId", O.PrimaryKey)

    def sessionTokenHash = column[String]("sessionTokenHash")

    def sessionTokenTime = column[Long]("sessionTokenTime")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

    override def id = accountId
  }

}

@Singleton
class SessionTokens @Inject()(
                               protected val dbConfigProvider: DatabaseConfigProvider,
                             )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[SessionTokens.SessionTokenTable, SessionToken, String]() {

  implicit val module: String = constants.Module.MASTER_TRANSACTION_SESSION_TOKEN

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new SessionTokenTable(tag))

  object Service {

    def refresh(id: String): Future[String] = {
      val sessionToken: String = utilities.IdGenerator.getRandomHexadecimal
      val upsertToken = upsert(SessionToken(id, utilities.Secrets.sha256HashString(sessionToken), DateTime.now(DateTimeZone.UTC).getMillis))
      for {
        _ <- upsertToken
      } yield sessionToken
    }

    def tryGet(id: String): Future[SessionToken] = tryGetById(id)

    def tryVerifyingSessionToken(id: String, sessionToken: String): Future[Boolean] = {
      tryGetById(id).map { token =>
        if (token.sessionTokenHash == utilities.Secrets.sha256HashString(sessionToken)) true else false
      }
    }

    def tryVerifyingSessionTokenTime(id: String): Future[Boolean] = {
      tryGetById(id).map { token =>
        if (DateTime.now(DateTimeZone.UTC).getMillis - token.sessionTokenTime < constants.CommonConfig.SessionTokenTimeout) true else false
      }
    }

    def getTimedOutIDs: Future[Seq[String]] = filter(_.sessionTokenTime < DateTime.now(DateTimeZone.UTC).getMillis - constants.CommonConfig.SessionTokenTimeout).map(_.map(_.accountId))

    def delete(id: String): Future[Int] = deleteById(id)

    def deleteMultiple(ids: Seq[String]): Future[Unit] = deleteByIds(ids)

  }

  object Utility {
    val scheduler: Scheduler = new Scheduler {
      val name: String = module

      def runner(): Unit = {
        val ids = Service.getTimedOutIDs

        def deleteSessionTokens(ids: Seq[String]) = Service.deleteMultiple(ids)

        def deleteActors(ids: Seq[String]): Unit = ids.foreach(id => actors.Service.AppWebSocketActor ! actors.Message.RemoveActor(id))

        val forComplete = (for {
          ids <- ids
          _ <- deleteSessionTokens(ids)
        } yield deleteActors(ids)).recover {
          case baseException: BaseException => logger.error(baseException.failure.message)
        }
        Await.result(forComplete, Duration.Inf)
      }
    }
  }
}