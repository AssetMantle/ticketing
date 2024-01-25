package models.master

import models.master.Keys.KeyTable
import models.traits._
import org.bitcoinj.core.ECKey
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import schema.id.base.IdentityID
import slick.jdbc.H2Profile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class Key(accountId: String, address: String, passwordHash: Array[Byte], salt: Array[Byte], iterations: Int, encryptedPrivateKey: Array[Byte], partialMnemonics: Option[Seq[String]], name: Option[String], active: Boolean, verified: Option[Boolean], identityIssued: Option[Boolean], createdBy: Option[String] = None, createdOnMillisEpoch: Option[Long] = None, updatedBy: Option[String] = None, updatedOnMillisEpoch: Option[Long] = None) extends Logging {

  def getIdentityID: IdentityID = utilities.Identity.getMantlePlaceIdentityID(this.accountId)

  def serialize(): Keys.KeySerialized = Keys.KeySerialized(
    accountId = this.accountId,
    address = this.address,
    passwordHash = this.passwordHash,
    salt = this.salt,
    iterations = this.iterations,
    encryptedPrivateKey = this.encryptedPrivateKey,
    partialMnemonics = this.partialMnemonics.fold[Option[String]](None)(x => Option(Json.toJson(x).toString())),
    name = this.name,
    active = this.active,
    verified = this.verified,
    identityIssued = this.identityIssued,
    createdBy = this.createdBy,
    createdOnMillisEpoch = this.createdOnMillisEpoch,
    updatedBy = this.updatedBy,
    updatedOnMillisEpoch = this.updatedOnMillisEpoch)

  def getECKey(password: String): Option[ECKey] = if (this.encryptedPrivateKey.nonEmpty) Option(ECKey.fromPrivate(utilities.Secrets.decryptData(this.encryptedPrivateKey, password)))
  else None
}

private[master] object Keys {

  case class KeySerialized(accountId: String, address: String, passwordHash: Array[Byte], salt: Array[Byte], iterations: Int, encryptedPrivateKey: Array[Byte], partialMnemonics: Option[String], name: Option[String], active: Boolean, verified: Option[Boolean], identityIssued: Option[Boolean], createdBy: Option[String], createdOnMillisEpoch: Option[Long], updatedBy: Option[String], updatedOnMillisEpoch: Option[Long]) extends Entity2[String, String] {
    def deserialize()(implicit module: String, logger: Logger): Key = Key(
      accountId = accountId,
      address = address,
      passwordHash = passwordHash,
      salt = salt,
      iterations = iterations,
      encryptedPrivateKey = encryptedPrivateKey,
      partialMnemonics = partialMnemonics.fold[Option[Seq[String]]](None)(x => Option(utilities.JSON.convertJsonStringToObject[Seq[String]](x))),
      name = name,
      active = active,
      verified = verified,
      identityIssued = identityIssued,
      createdBy = createdBy, createdOnMillisEpoch = createdOnMillisEpoch, updatedBy = updatedBy, updatedOnMillisEpoch = updatedOnMillisEpoch)

    def id1: String = accountId

    def id2: String = address
  }

  class KeyTable(tag: Tag) extends Table[KeySerialized](tag, "Key") with ModelTable2[String, String] {

    def * = (accountId, address, passwordHash, salt, iterations, encryptedPrivateKey, partialMnemonics.?, name.?, active, verified.?, identityIssued.?, createdBy.?, createdOnMillisEpoch.?, updatedBy.?, updatedOnMillisEpoch.?) <> (KeySerialized.tupled, KeySerialized.unapply)

    def accountId = column[String]("accountId", O.PrimaryKey)

    def address = column[String]("address", O.PrimaryKey)

    def passwordHash = column[Array[Byte]]("passwordHash")

    def salt = column[Array[Byte]]("salt")

    def iterations = column[Int]("iterations")

    def encryptedPrivateKey = column[Array[Byte]]("encryptedPrivateKey")

    def partialMnemonics = column[String]("partialMnemonics")

    def name = column[String]("name")

    def active = column[Boolean]("active")

    def verified = column[Boolean]("verified")

    def identityIssued = column[Boolean]("identityIssued")

    def createdBy = column[String]("createdBy")

    def createdOnMillisEpoch = column[Long]("createdOnMillisEpoch")

    def updatedBy = column[String]("updatedBy")

    def updatedOnMillisEpoch = column[Long]("updatedOnMillisEpoch")

    override def id1 = accountId

    override def id2 = address
  }
}

@Singleton
class Keys @Inject()(
                      protected val dbConfigProvider: DatabaseConfigProvider,
                    )(implicit executionContext: ExecutionContext)
  extends GenericDaoImpl2[Keys.KeyTable, Keys.KeySerialized, String, String]() {

  implicit val module: String = constants.Module.MASTER_KEY

  implicit val logger: Logger = Logger(this.getClass)

  val tableQuery = new TableQuery(tag => new KeyTable(tag))

  object Service {

    def addOnSignUp(accountId: String, address: String, partialMnemonics: Seq[String], name: String, retryCounter: Int, active: Boolean, backupUsed: Boolean, verified: Option[Boolean]): Future[String] = {
      val salt = utilities.Secrets.getNewSalt
      val key = Key(
        accountId = accountId,
        address = address,
        passwordHash = Array[Byte](),
        salt = salt,
        iterations = constants.Security.DefaultIterations,
        partialMnemonics = Option(partialMnemonics),
        name = Option(name),
        encryptedPrivateKey = Array[Byte](),
        active = active,
        verified = verified,
        identityIssued = Option(false),
      )
      create(key.serialize()).map(_.accountId)
    }

    def addManagedKey(accountId: String, address: String, password: String, privateKey: Array[Byte], partialMnemonics: Option[Seq[String]], name: String, retryCounter: Int, active: Boolean, backupUsed: Boolean, verified: Option[Boolean]): Future[String] = {
      val salt = utilities.Secrets.getNewSalt
      create(Key(
        accountId = accountId,
        address = address,
        passwordHash = if (password != "") utilities.Secrets.hashPassword(password = password, salt = salt, iterations = constants.Security.DefaultIterations) else Array[Byte](),
        salt = salt,
        iterations = constants.Security.DefaultIterations,
        partialMnemonics = partialMnemonics,
        name = Option(name),
        encryptedPrivateKey = if (privateKey.nonEmpty) utilities.Secrets.encryptData(privateKey, password) else Array[Byte](),
        active = active,
        verified = verified,
        identityIssued = Option(false),
      ).serialize()).map(_.accountId)
    }

    def addUnmanagedKey(accountId: String, address: String, password: String, name: String, retryCounter: Int, active: Boolean, backupUsed: Boolean, verified: Option[Boolean]): Future[String] = {
      val salt = utilities.Secrets.getNewSalt
      create(Key(
        accountId = accountId,
        address = address,
        passwordHash = if (password != "") utilities.Secrets.hashPassword(password = password, salt = salt, iterations = constants.Security.DefaultIterations) else Array[Byte](),
        salt = salt,
        iterations = constants.Security.DefaultIterations,
        partialMnemonics = None,
        name = Option(name),
        encryptedPrivateKey = Array[Byte](),
        active = active,
        verified = verified,
        identityIssued = Option(false),
      ).serialize()).map(_.accountId)
    }

    def addOnMigration(accountId: String, address: String, partialMnemonics: Seq[String], passwordHash: Array[Byte], salt: Array[Byte], iterations: Int, name: String, retryCounter: Int, active: Boolean, backupUsed: Boolean, verified: Option[Boolean]): Future[String] = {
      create(Key(
        accountId = accountId,
        address = address,
        passwordHash = passwordHash,
        salt = salt,
        iterations = iterations,
        partialMnemonics = Option(partialMnemonics),
        name = Option(name),
        encryptedPrivateKey = Array[Byte](),
        active = active,
        verified = verified,
        identityIssued = Option(false),
      ).serialize()).map(_.accountId)
    }

    def updateOnVerifyMnemonics(key: Key, password: String, privateKey: Array[Byte]): Future[Int] = updateKey(key.copy(
      passwordHash = utilities.Secrets.hashPassword(password = password, salt = key.salt, iterations = key.iterations),
      encryptedPrivateKey = utilities.Secrets.encryptData(privateKey, password),
      verified = Option(true)
    ))

    def updateOnMigration(key: Key, password: String, privateKey: Array[Byte]): Future[Int] = updateKey(key.copy(
      encryptedPrivateKey = utilities.Secrets.encryptData(privateKey, password),
      verified = Option(true)
    ))

    def validateUsernamePasswordAndGetKey(username: String, address: String, password: String): Future[(Boolean, Key)] = {
      val key = tryGetById1AndId2(username, address)
      for {
        key <- key
      } yield (utilities.Secrets.verifyPassword(password = password, passwordHash = key.passwordHash, salt = key.salt, iterations = key.iterations), key.deserialize)
    }

    def validateActiveKeyUsernamePasswordAndGet(username: String, password: String): Future[(Boolean, Key)] = {
      val key = tryGetActive(username)
      for {
        key <- key
      } yield (utilities.Secrets.verifyPassword(password = password, passwordHash = key.passwordHash, salt = key.salt, iterations = key.iterations), key)
    }

    def getAllActiveKeys(accountIds: Seq[String]): Future[Seq[Key]] = filter(x => x.accountId.inSet(accountIds) && x.active).map(_.map(_.deserialize))

    def getAllKeys(accountIds: Seq[String]): Future[Seq[Key]] = filter(x => x.accountId.inSet(accountIds)).map(_.map(_.deserialize))

    def tryGetActive(accountId: String): Future[Key] = filterHead(x => x.id1 === accountId && x.active).map(_.deserialize)

    def getActive(accountId: String): Future[Option[Key]] = filter(x => x.id1 === accountId && x.active).map(_.headOption.map(_.deserialize))

    def updateKey(key: Key): Future[Int] = updateById1AndId2(key.serialize())

    def getActiveByAccountId(accountId: String): Future[Option[Key]] = filter(x => x.id1 === accountId && x.active).map(_.map(_.deserialize).headOption)

    def delete(accountId: String, address: String): Future[Int] = deleteById1AndId2(accountId, address)

    def tryGet(accountId: String, address: String): Future[Key] = tryGetById1AndId2(id1 = accountId, id2 = address).map(_.deserialize)

    def updateKeyName(accountId: String, address: String, keyName: String): Future[Unit] = {
      val key = tryGet(accountId = accountId, address = address)
      for {
        key <- key
        _ <- updateKey(key.copy(name = Option(keyName)))
      } yield ()
    }

    def fetchAllForId(accountId: String): Future[Seq[Key]] = filter(_.id1 === accountId).map(_.map(_.deserialize))

    def updateOnForgotPassword(accountId: String, address: String, lastWords: Seq[String], newPassword: String): Future[Unit] = {
      val key = tryGet(accountId = accountId, address = address)

      def getWallet(key: Key) = if (key.partialMnemonics.isDefined) {
        Future(utilities.Wallet.getWallet(mnemonics = key.partialMnemonics.get ++ lastWords))
      } else constants.Response.INVALID_ACTIVE_KEY.throwBaseException()

      def updatePassword(key: Key, wallet: utilities.Wallet) = if (key.address == wallet.address) {
        updateById1AndId2(key.copy(
          passwordHash = utilities.Secrets.hashPassword(password = newPassword, salt = key.salt, iterations = constants.Security.DefaultIterations),
          encryptedPrivateKey = utilities.Secrets.encryptData(data = wallet.privateKey, secret = newPassword)
        ).serialize())
      } else constants.Response.INVALID_ACTIVE_KEY.throwBaseException()

      for {
        key <- key
        wallet <- getWallet(key)
        _ <- updatePassword(key, wallet)
      } yield ()
    }

    def changePassword(accountId: String, address: String, oldPassword: String, newPassword: String): Future[Unit] = {
      val validateAndOldKey = validateActiveKeyUsernamePasswordAndGet(username = accountId, password = oldPassword)

      def updatePassword(passwordValidated: Boolean, oldKey: Key) = if (passwordValidated) {
        if (oldKey.encryptedPrivateKey.nonEmpty && oldKey.partialMnemonics.isDefined) {
          val decryptedPrivateKey = utilities.Secrets.decryptData(encryptedData = oldKey.encryptedPrivateKey, secret = oldPassword)
          updateById1AndId2(oldKey.copy(
            passwordHash = utilities.Secrets.hashPassword(password = newPassword, salt = oldKey.salt, iterations = constants.Security.DefaultIterations),
            encryptedPrivateKey = utilities.Secrets.encryptData(data = decryptedPrivateKey, secret = newPassword),
          ).serialize())
        } else constants.Response.INVALID_ACTIVE_KEY.throwBaseException()
      } else constants.Response.INVALID_PASSWORD.throwBaseException()

      for {
        (passwordValidated, oldKey) <- validateAndOldKey
        _ <- updatePassword(passwordValidated, oldKey)
      } yield ()
    }

    def changeActive(accountId: String, oldAddress: String, newAddress: String, newKeyPassword: String): Future[Unit] = {
      val oldKey = tryGet(accountId = accountId, address = oldAddress)
      val newKey = tryGet(accountId = accountId, address = newAddress)

      def updateKeys(oldKey: Key, newKey: Key) = {
        val errors = Seq(
          if (!utilities.Secrets.verifyPassword(password = newKeyPassword, passwordHash = newKey.passwordHash, salt = newKey.salt, iterations = newKey.iterations)) Option(constants.Response.INVALID_PASSWORD) else None,
          if (newKey.encryptedPrivateKey.isEmpty) Option(constants.Response.ACTIVATING_UNMANAGED_KEY) else None,
          if (!newKey.identityIssued.getOrElse(false)) Option(constants.Response.KEY_NOT_PROVISIONED) else None,
        ).flatten
        if (errors.isEmpty) {
          for {
            _ <- updateById1AndId2(oldKey.copy(active = false).serialize())
            _ <- updateById1AndId2(newKey.copy(active = true).serialize())
          } yield ()
        } else errors.head.throwBaseException()
      }

      for {
        oldKey <- oldKey
        newKey <- newKey
        _ <- updateKeys(oldKey = oldKey, newKey = newKey)
      } yield ()
    }

    def changeManagedToUnmanaged(accountId: String, address: String, password: String): Future[Unit] = {
      val validate = validateUsernamePasswordAndGetKey(username = accountId, address = address, password = password)

      def validateAndUpdate(validated: Boolean, key: Key) = if (validated) updateById1AndId2(key.copy(encryptedPrivateKey = Array[Byte](), partialMnemonics = None).serialize())
      else constants.Response.INVALID_PASSWORD.throwBaseException()

      for {
        (validated, key) <- validate
        _ <- validateAndUpdate(validated, key)
      } yield ()
    }

    def checkVerifiedKeyExists(accountId: String): Future[Boolean] = filter(x => x.accountId === accountId && x.verified).map(_.nonEmpty)

    def deleteUnverifiedKeys(accountId: String): Future[Int] = {
      val verified: Option[Boolean] = null
      filterAndDelete(x => x.accountId === accountId && x.verified.? === verified)
    }

    def insertOrUpdateMultiple(keys: Seq[Keys.KeySerialized]): Future[Int] = upsertMultiple(keys)

    def fetchAllActive: Future[Seq[Keys.KeySerialized]] = filter(_.active)

    def getNotIssuedIdentityAccountIDs: Future[Seq[String]] = filterAndSortWithPagination(x => !x.identityIssued && x.verified && x.active)(_.accountId)(offset = 0, limit = 500).map(_.map(_.accountId))

    def markIdentityIssuePending(accountIds: Seq[String]): Future[Int] = customUpdate(tableQuery.filter(_.accountId.inSet(accountIds)).map(_.identityIssued.?).update(null))

    def markIdentityIssued(accountIds: Seq[String]): Future[Int] = customUpdate(tableQuery.filter(_.accountId.inSet(accountIds)).map(_.identityIssued).update(true))

    def markIdentityFailed(accountIds: Seq[String]): Future[Int] = customUpdate(tableQuery.filter(_.accountId.inSet(accountIds)).map(_.identityIssued).update(false))

    def markAddressProvisioned(accountId: String, address: String): Future[Int] = customUpdate(tableQuery.filter(x => x.accountId === accountId && x.address === address).map(_.identityIssued).update(true))

    def markAddressProvisionFailed(accountId: String, address: String): Future[Int] = customUpdate(tableQuery.filter(x => x.accountId === accountId && x.address === address).map(_.identityIssued).update(false))

    def getKeysByAddresses(addresses: Seq[String]): Future[Seq[Key]] = filter(_.address.inSet(addresses)).map(_.map(_.deserialize))

    def countKeys(id: String): Future[Int] = filterAndCount(_.accountId === id)
  }

}