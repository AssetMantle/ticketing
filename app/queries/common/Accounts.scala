package queries.common

import models.blockchain.{Account => BlockchainAccount}
import models.common.{Account => modelCommonAccount}
import play.api.Logger
import play.api.libs.json.{JsObject, Json, Reads}
import queries.Abstract.Account

object Accounts {

  implicit val module: String = constants.Module.ACCOUNT_RESPONSE

  implicit val logger: Logger = Logger(this.getClass)

  case class BaseAccount(address: String, account_number: String, sequence: String) extends Account {
    def toSerializableAccount: BlockchainAccount = BlockchainAccount(address = address, accountType = Option(constants.Blockchain.Account.BASE), publicKey = None, accountNumber = account_number.toInt, sequence = sequence.toInt)
  }

  implicit val baseAccountReads: Reads[BaseAccount] = Json.reads[BaseAccount]

  case class ModuleAccount(base_account: BaseAccount, name: String, permissions: Seq[String]) extends Account {
    val address: String = base_account.address

    def toSerializableAccount: BlockchainAccount = BlockchainAccount(address = address, accountType = Option(constants.Blockchain.Account.MODULE), publicKey = None, accountNumber = base_account.account_number.toInt, sequence = base_account.sequence.toInt)
  }

  implicit val moduleAccountReads: Reads[ModuleAccount] = Json.reads[ModuleAccount]

  case class BaseVestingAccount(base_account: BaseAccount, original_vesting: Seq[Coin], delegated_free: Seq[Coin], delegated_vesting: Seq[Coin], end_time: String)

  implicit val baseVestingAccountReads: Reads[BaseVestingAccount] = Json.reads[BaseVestingAccount]

  case class DelayedVestingAccount(base_vesting_account: BaseVestingAccount) extends Account {
    val address: String = base_vesting_account.base_account.address

    def toSerializableAccount: BlockchainAccount = BlockchainAccount(address = base_vesting_account.base_account.address, accountType = Option(constants.Blockchain.Account.DELAYED_VESTING), publicKey = None, accountNumber = base_vesting_account.base_account.account_number.toInt, sequence = base_vesting_account.base_account.sequence.toInt)
  }

  implicit val delayedVestingAccountReads: Reads[DelayedVestingAccount] = Json.reads[DelayedVestingAccount]

  case class ContinuousVestingAccount(base_vesting_account: BaseVestingAccount, start_time: String) extends Account {
    val address: String = base_vesting_account.base_account.address

    def toSerializableAccount: BlockchainAccount = BlockchainAccount(address = base_vesting_account.base_account.address, accountType = Option(constants.Blockchain.Account.CONTINUOUS_VESTING), publicKey = None, accountNumber = base_vesting_account.base_account.account_number.toInt, sequence = base_vesting_account.base_account.sequence.toInt)
  }

  implicit val continuousVestingAccountReads: Reads[ContinuousVestingAccount] = Json.reads[ContinuousVestingAccount]

  case class VestingPeriod(length: String, amount: Seq[Coin]) {
    def toSerializableVestingPeriod: modelCommonAccount.Vesting.VestingPeriod = modelCommonAccount.Vesting.VestingPeriod(length = length, amount = amount.map(_.toCoin))
  }

  implicit val vestingPeriodReads: Reads[VestingPeriod] = Json.reads[VestingPeriod]

  case class PeriodicVestingAccount(base_vesting_account: BaseVestingAccount, start_time: String, vesting_periods: Seq[VestingPeriod]) extends Account {
    val address: String = base_vesting_account.base_account.address

    def toSerializableAccount: BlockchainAccount = BlockchainAccount(address = base_vesting_account.base_account.address, accountType = Option(constants.Blockchain.Account.CONTINUOUS_VESTING), publicKey = None, accountNumber = base_vesting_account.base_account.account_number.toInt, sequence = base_vesting_account.base_account.sequence.toInt)
  }

  implicit val periodicVestingAccountReads: Reads[PeriodicVestingAccount] = Json.reads[PeriodicVestingAccount]

  def accountApply(accountType: String, value: JsObject): Account = accountType match {
    case constants.Blockchain.Account.BASE => utilities.JSON.convertJsonStringToObject[BaseAccount](value.toString)
    case constants.Blockchain.Account.MODULE => utilities.JSON.convertJsonStringToObject[ModuleAccount](value.toString)
    case constants.Blockchain.Account.DELAYED_VESTING => utilities.JSON.convertJsonStringToObject[DelayedVestingAccount](value.toString)
    case constants.Blockchain.Account.CONTINUOUS_VESTING => utilities.JSON.convertJsonStringToObject[ContinuousVestingAccount](value.toString)
    case constants.Blockchain.Account.PERIODIC_VESTING => utilities.JSON.convertJsonStringToObject[PeriodicVestingAccount](value.toString)
    case _ => constants.Response.ACCOUNT_TYPE_NOT_FOUND.throwBaseException()
  }
}
