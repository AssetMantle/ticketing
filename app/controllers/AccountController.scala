package controllers

import controllers.actions._
import controllers.result.WithUsernameToken
import exceptions.BaseException
import models.{master, masterTransaction}
import play.api.Logger
import play.api.cache.Cached
import play.api.i18n.I18nSupport
import play.api.mvc._
import views.account.companion._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class AccountController @Inject()(
                                   messagesControllerComponents: MessagesControllerComponents,
                                   cached: Cached,
                                   withoutLoginActionAsync: WithoutLoginActionAsync,
                                   withoutLoginAction: WithoutLoginAction,
                                   masterAccounts: master.Accounts,
                                   masterKeys: master.Keys,
                                   masterTransactionSessionTokens: masterTransaction.SessionTokens,
                                   masterTransactionPushNotificationTokens: masterTransaction.PushNotificationTokens,
                                   withUsernameToken: WithUsernameToken,
                                   withLoginActionAsync: WithLoginActionAsync,
                                   utilitiesNotification: utilities.Notification,
                                 )(implicit executionContext: ExecutionContext) extends AbstractController(messagesControllerComponents) with I18nSupport {

  implicit val logger: Logger = Logger(this.getClass)

  implicit val module: String = constants.Module.ACCOUNT_CONTROLLER

  implicit val callbackOnSessionTimeout: Call = routes.SettingController.viewSettings()

  def signUpForm(): Action[AnyContent] = withoutLoginAction { implicit request =>
    Ok(views.html.account.signUp())
  }

  def signUp: Action[AnyContent] = withoutLoginActionAsync { implicit loginState =>
    implicit request =>
      SignUp.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.account.signUp(formWithErrors)))
        },
        signUpData => {
          val checkVerifiedKeyExists = masterKeys.Service.checkVerifiedKeyExists(signUpData.username)
          val wallet = utilities.Wallet.getRandomWallet

          def addMasterAccount(checkVerifiedKeyExists: Boolean) = if (!checkVerifiedKeyExists) {
            val addAccount = masterAccounts.Service.upsertOnSignUp(username = signUpData.username, lang = request.lang, accountType = constants.Account.Type.USER)
            val deleteUnverifiedKeys = masterKeys.Service.deleteUnverifiedKeys(signUpData.username)

            for {
              _ <- addAccount
              _ <- deleteUnverifiedKeys
            } yield ()
          } else constants.Response.USERNAME_UNAVAILABLE.throwBaseException()

          def addKey() = masterKeys.Service.addOnSignUp(
            accountId = signUpData.username,
            address = wallet.address,
            partialMnemonics = wallet.mnemonics.take(wallet.mnemonics.length - constants.Blockchain.MnemonicShown),
            name = constants.Account.Key.DEFAULT_NAME,
            retryCounter = 0,
            active = true,
            backupUsed = false,
            verified = None)

          (for {
            checkVerifiedKeyExists <- checkVerifiedKeyExists
            _ <- addMasterAccount(checkVerifiedKeyExists)
            _ <- addKey()
          } yield PartialContent(views.html.account.showWalletMnemonics(username = signUpData.username, address = wallet.address, partialMnemonics = wallet.mnemonics.takeRight(constants.Blockchain.MnemonicShown)))
            ).recover {
            case baseException: BaseException => BadRequest(views.html.account.signUp(SignUp.form.withGlobalError(baseException.failure.message)))
          }
        }
      )
  }

  def verifyWalletMnemonicsForm(): Action[AnyContent] = withoutLoginAction { implicit request =>
    BadRequest
  }

  def verifyWalletMnemonics: Action[AnyContent] = withoutLoginActionAsync { implicit loginState =>
    implicit request =>
      VerifyMnemonics.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.account.verifyWalletMnemonics(formWithErrors, formWithErrors.data.getOrElse(constants.FormField.CONFIRM_USERNAME.name, ""))))
        },
        walletMnemonicsData => {
          val key = masterKeys.Service.tryGetActive(walletMnemonicsData.username)

          def updateAndGetResult(key: master.Key) = if (key.partialMnemonics.isDefined) {
            val mnemonics = key.partialMnemonics.get ++ Seq(walletMnemonicsData.seed1, walletMnemonicsData.seed2, walletMnemonicsData.seed3, walletMnemonicsData.seed4)
            val wallet = utilities.Wallet.getWallet(mnemonics)
            if (wallet.address == walletMnemonicsData.walletAddress && key.address == walletMnemonicsData.walletAddress && key.accountId == walletMnemonicsData.username) {
              val updateWallet = masterKeys.Service.updateOnVerifyMnemonics(key, password = walletMnemonicsData.password, privateKey = wallet.privateKey)

              for {
                _ <- updateWallet
              } yield PartialContent(views.html.account.walletSuccess(username = key.accountId, address = walletMnemonicsData.walletAddress))
            } else constants.Response.INVALID_MNEMONICS_OR_USERNAME.throwBaseException()
          } else constants.Response.INVALID_ACTIVE_KEY.throwBaseException()

          (for {
            key <- key
            result <- updateAndGetResult(key)
          } yield result
            ).recover {
            case baseException: BaseException => BadRequest(views.html.account.verifyWalletMnemonics(walletMnemonicsForm = VerifyMnemonics.form.withGlobalError(baseException.failure.message), username = walletMnemonicsData.username))
          }
        }
      )
  }

  def signInWithCallbackForm(callbackUrl: String): Action[AnyContent] = withoutLoginAction { implicit request =>
    Ok(views.html.account.signInWithCallback(callbackUrl = callbackUrl))
  }

  def signInWithCallback: Action[AnyContent] = withoutLoginActionAsync { implicit loginState =>
    implicit request =>
      SignInWithCallback.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.account.signInWithCallback(formWithErrors, formWithErrors.data.getOrElse(constants.FormField.CALLBACK_URL.name, routes.SecondaryMarketController.viewCollections().url))))
        },
        signInData => {
          val masterAccount = masterAccounts.Service.tryGet(signInData.username)
          val masterKey = masterKeys.Service.getActiveByAccountId(signInData.username)

          def verifyUpdateAndGetResult(account: master.Account, key: Option[master.Key]): Future[Result] = {
            val validPassword = utilities.Secrets.verifyPassword(password = signInData.password, passwordHash = key.get.passwordHash, salt = key.get.salt, iterations = key.get.iterations)

            if (validPassword) {
              if (key.get.encryptedPrivateKey.isEmpty) Future(PartialContent(views.html.account.migrateWalletToKey(username = signInData.username, address = key.get.address)))
              else {
                if (!key.get.verified.getOrElse(false)) {
                  val wallet = utilities.Wallet.getRandomWallet
                  val addKey = masterKeys.Service.addOnSignUp(
                    accountId = signInData.username,
                    address = wallet.address,
                    partialMnemonics = wallet.mnemonics.take(wallet.mnemonics.length - constants.Blockchain.MnemonicShown),
                    name = constants.Account.Key.DEFAULT_NAME,
                    retryCounter = 0,
                    active = true,
                    backupUsed = false,
                    verified = None)

                  def deleteUnverifiedKey() = masterKeys.Service.delete(accountId = key.get.accountId, address = key.get.address)

                  for {
                    _ <- addKey
                    _ <- deleteUnverifiedKey()
                  } yield PartialContent(views.html.account.showWalletMnemonics(username = signInData.username, address = wallet.address, partialMnemonics = wallet.mnemonics.takeRight(constants.Blockchain.MnemonicShown)))
                } else {
                  implicit val optionalLoginState: Option[LoginState] = Option(LoginState(username = signInData.username, address = key.get.address, accountType = account.accountType))
                  implicit val loginState: LoginState = LoginState(username = signInData.username, address = key.get.address, accountType = account.accountType)
                  val pushNotificationTokenUpdate = masterTransactionPushNotificationTokens.Service.upsert(id = loginState.username, token = signInData.pushNotificationToken)
                  val result = if (signInData.callbackUrl != "/") withUsernameToken.InternalRedirectOnSubmitForm(signInData.callbackUrl)
                  else withUsernameToken.Ok(views.html.secondaryMarket.viewCollections())
                  for {
                    _ <- pushNotificationTokenUpdate
                    result <- result
                  } yield result
                }
              }
            } else constants.Response.INVALID_USERNAME_OR_PASSWORD.throwBaseException()
          }

          (for {
            masterAccount <- masterAccount
            masterKey <- masterKey
            result <- verifyUpdateAndGetResult(masterAccount, masterKey)
            _ <- utilitiesNotification.send(accountID = signInData.username, notification = constants.Notification.LOGIN)()
          } yield result
            ).recover {
            case baseException: BaseException => NotFound(views.html.account.signInWithCallback(SignInWithCallback.form.withGlobalError(baseException.failure.message), signInData.callbackUrl))
          }
        }
      )
  }

  def migrateWalletToKeyForm(): Action[AnyContent] = withoutLoginAction { implicit request =>
    BadRequest
  }

  def migrateWalletToKey: Action[AnyContent] = withoutLoginActionAsync { implicit loginState =>
    implicit request =>
      MigrateWalletToKey.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.account.migrateWalletToKey(formWithErrors, formWithErrors.data.getOrElse(constants.FormField.USERNAME.name, ""), formWithErrors.data.getOrElse(constants.FormField.WALLET_ADDRESS.name, ""))))
        },
        migrateWalletToKeyData => {
          val validateAndKey = masterKeys.Service.validateActiveKeyUsernamePasswordAndGet(migrateWalletToKeyData.username, password = migrateWalletToKeyData.password)
          val account = masterAccounts.Service.tryGet(migrateWalletToKeyData.username)

          def update(validated: Boolean, key: master.Key, account: master.Account) = if (validated) {
            val wallet = Future(utilities.Wallet.getWallet(key.partialMnemonics.get ++ Seq(migrateWalletToKeyData.seed1, migrateWalletToKeyData.seed2, migrateWalletToKeyData.seed3, migrateWalletToKeyData.seed4), hdPath = constants.Blockchain.DefaultHDPath))

            def updateKey(wallet: utilities.Wallet) = masterKeys.Service.updateOnMigration(key = key, password = migrateWalletToKeyData.password, privateKey = wallet.privateKey)

            def getResult(username: String, address: String) = {
              implicit val optionalLoginState: Option[LoginState] = Option(LoginState(username = username, address = address, accountType = account.accountType))
              implicit val loginState: LoginState = LoginState(username = username, address = address, accountType = account.accountType)
              withUsernameToken.Ok(views.html.publicListing.viewCollections())
            }

            for {
              wallet <- wallet
              _ <- updateKey(wallet)
              result <- getResult(username = migrateWalletToKeyData.username, address = wallet.address)
            } yield result
          } else constants.Response.INVALID_USERNAME_OR_PASSWORD.throwBaseException()

          (for {
            (validated, key) <- validateAndKey
            account <- account
            result <- update(validated, key, account)
          } yield result
            ).recover {
            case baseException: BaseException => BadRequest(views.html.account.migrateWalletToKey(MigrateWalletToKey.form.withGlobalError(baseException.failure.message), migrateWalletToKeyData.username, migrateWalletToKeyData.walletAddress))
          }
        }
      )
  }

  def signOutForm: Action[AnyContent] = withoutLoginAction { implicit request =>
    Ok(views.html.account.signOut())
  }

  def signOut: Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      SignOut.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.account.signOut(formWithErrors)))
        },
        signOutData => {
          val pushNotificationTokenDelete = if (!signOutData.receiveNotifications) masterTransactionPushNotificationTokens.Service.delete(loginState.username) else Future()
          val deleteSessionToken = masterTransactionSessionTokens.Service.delete(loginState.username)

          (for {
            _ <- pushNotificationTokenDelete
            _ <- deleteSessionToken
            _ <- utilitiesNotification.send(accountID = loginState.username, notification = constants.Notification.LOG_OUT)()
          } yield {
            actors.Service.AppWebSocketActor ! actors.Message.RemoveActor(loginState.username)
            Ok(views.html.index()).withNewSession
          }
            ).recover {
            case _: BaseException => InternalServerError(views.html.index())
          }
        }
      )
  }

  def checkUsernameAvailable(username: String): Action[AnyContent] = withoutLoginActionAsync { implicit loginState =>
    implicit request =>
      val verifiedMnemonicExists = masterKeys.Service.checkVerifiedKeyExists(username)
      for {
        verifiedMnemonicExists <- verifiedMnemonicExists
      } yield if (!verifiedMnemonicExists) Ok else NoContent
  }

  def forgetPasswordForm(): Action[AnyContent] = withoutLoginAction { implicit request =>
    Ok(views.html.account.forgetPassword())
  }

  def forgetPassword: Action[AnyContent] = withoutLoginActionAsync { implicit loginState =>
    implicit request =>
      ForgotPassword.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.account.forgetPassword(formWithErrors)))
        },
        forgetPasswordData => {
          val lastWords = Seq(forgetPasswordData.phrase1, forgetPasswordData.phrase2, forgetPasswordData.phrase3, forgetPasswordData.phrase4)
          val update = masterKeys.Service.updateOnForgotPassword(accountId = forgetPasswordData.username, address = forgetPasswordData.address, lastWords = lastWords, newPassword = forgetPasswordData.newPassword)

          (for {
            _ <- update
          } yield PartialContent(views.html.account.successfullPasswordChange())
            ).recover {
            case baseException: BaseException => BadRequest(views.html.account.forgetPassword(ForgotPassword.form.withGlobalError(baseException.failure.message)))
          }
        }
      )
  }

  def changePasswordForm(): Action[AnyContent] = withoutLoginAction { implicit request =>
    Ok(views.html.account.changePassword())
  }

  def changePassword: Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      ChangePassword.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.account.changePassword(formWithErrors)))
        },
        changePasswordData => {
          val changePassword = masterKeys.Service.changePassword(accountId = loginState.username, address = loginState.address, oldPassword = changePasswordData.oldPassword, newPassword = changePasswordData.newPassword)

          def signOut = masterTransactionSessionTokens.Service.delete(loginState.username)

          (for {
            _ <- changePassword
            _ <- signOut
          } yield PartialContent(views.html.account.successfullPasswordChange()).withNewSession
            ).recover {
            case baseException: BaseException => BadRequest(views.html.account.changePassword(ChangePassword.form.withGlobalError(baseException.failure.message)))
          }
        }
      )
  }

  def changeActiveKeyForm(address: String): Action[AnyContent] = withLoginActionAsync { implicit loginState =>
    implicit request =>
      Future(Ok(views.html.setting.changeActiveKey(address = address)))
  }

  def changeActiveKey(): Action[AnyContent] = withLoginActionAsync { oldLoginState =>
    implicit request =>
      ChangeActiveKey.form.bindFromRequest().fold(
        formWithErrors => {
          Future(BadRequest(views.html.setting.changeActiveKey(formWithErrors, address = formWithErrors.data.getOrElse(constants.FormField.WALLET_ADDRESS.name, ""))))
        },
        changeKeyData => {
          val changeActive = masterKeys.Service.changeActive(accountId = oldLoginState.username, oldAddress = oldLoginState.address, newAddress = changeKeyData.address, newKeyPassword = changeKeyData.password)

          def getResult = {
            implicit val loginState: LoginState = LoginState(username = oldLoginState.username, address = changeKeyData.address, accountType = oldLoginState.accountType)
            withUsernameToken.Ok(views.html.setting.viewSettings())
          }

          (for {
            _ <- changeActive
            result <- getResult
          } yield result
            ).recover {
            case baseException: BaseException => BadRequest(views.html.setting.changeActiveKey(ChangeActiveKey.form.withGlobalError(baseException.failure.message), address = changeKeyData.address))
          }
        }
      )
  }

}