package models.master

import models.master.Accounts.AccountTable
import models.traits._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.i18n.Lang
import schema.id.base.IdentityID
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class Account(id: String, identityId: Option[String], accountType: String, language: String, createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging with Entity[String] {

  def getIdentityID: IdentityID = utilities.Identity.getMantlePlaceIdentityID(this.id)

  def getLang: Lang = Lang(this.language)

  def isCreator: Boolean = utilities.Account.isCreator(this.accountType)

  def isVerifiedCreator: Boolean = utilities.Account.isVerifiedCreator(this.accountType)
}

private[master] object Accounts {

  class AccountTable(tag: Tag) extends Table[Account](tag, "Account") with ModelTable[String] {

    def * = (id, identityId.?, accountType, language, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (Account.tupled, Account.unapply)

    def id = column[String]("id", O.PrimaryKey)

    def accountType = column[String]("accountType")

    def language = column[String]("language")

    def identityId = column[String]("identityId")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

  }
}

@Singleton
class Accounts @Inject()(
                          protected val dbConfigProvider: DatabaseConfigProvider,
                        )(implicit val executionContext: ExecutionContext)
  extends GenericDaoImpl[Accounts.AccountTable, Account, String]() {

  implicit val module: String = constants.Module.MASTER_ACCOUNT

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new AccountTable(tag))

  object Service {

    def upsertOnSignUp(username: String, lang: Lang, accountType: String): Future[Unit] = {
      val account = Account(
        id = username,
        language = lang.language,
        accountType = accountType,
        identityId = Option(utilities.Identity.getMantlePlaceIdentityID(username).asString),
      )
      for {
        _ <- upsert(account)
      } yield ()
    }

    def update(account: Account): Future[Unit] = updateById(account)

    def updateAccountToCreator(accountId: String): Future[Unit] = {
      val account = tryGetById(accountId)

      def update(account: Account) = if (!account.isCreator) updateById(account.copy(accountType = constants.Account.Type.CREATOR)) else Future()

      for {
        account <- account
        _ <- update(account)
      } yield ()
    }

    def tryGet(username: String): Future[Account] = tryGetById(username)

    def get(username: String): Future[Option[Account]] = getById(username)

    def getEmptyIdentityID: Future[Seq[String]] = customQuery(tableQuery.filter(_.identityId.?.isEmpty).map(_.id).result)

    def updateIdentityId(accountId: String): Future[Int] = customUpdate(tableQuery.filter(_.id === accountId).map(_.identityId).update(utilities.Identity.getMantlePlaceIdentityID(accountId).asString))

    def getByIdentityId(identityID: IdentityID): Future[Option[Account]] = filter(_.identityId === identityID.asString).map(_.headOption)
  }
}