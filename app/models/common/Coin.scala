package models.common

import com.cosmos.base.v1beta1.{Coin => protoCoin}
import play.api.Logger
import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{JsPath, Json, Reads, Writes}
import schema.id.base.AssetID
import utilities.MicroNumber

case class Coin(denom: String, amount: MicroNumber) {

  implicit val module: String = constants.Module.COIN

  implicit val logger: Logger = Logger(this.getClass)

  def isIBCDenom: Boolean = denom.startsWith("ibc/") && denom.length == 68

  def ibcDenomName: String = constants.CommonConfig.Blockchain.IBCDenoms.find(_.hash == denom).fold(denom)(_.name)

  def normalizeDenom: String = if (denom.startsWith("u")) denom.substring(1).toUpperCase()
  else if (isIBCDenom && ibcDenomName.startsWith("u")) ibcDenomName.substring(1).toUpperCase()
  else denom.toUpperCase()

  def getAmountWithNormalizedDenom(formatted: Boolean = true): String = if (formatted) s"${utilities.NumericOperation.formatNumber(amount)} $normalizeDenom" else s"${amount.toString} $normalizeDenom"

  def getMicroAmountWithDenom: String = s"${utilities.NumericOperation.formatNumber(number = amount, normalize = false)} $denom"

  def isNegative: Boolean = amount < 0

  def isZero: Boolean = amount == MicroNumber.zero

  def add(coin: Coin): Coin = {
    if (coin.denom != denom) {
      constants.Response.ARITHMETIC_OPERATION_ON_DIFFERENT_COIN.throwBaseException()
    } else Coin(denom = denom, amount = amount + coin.amount)
  }

  def subtract(coin: Coin): Coin = {
    val result = add(coin.copy(amount = amount * -1))
    if (result.isNegative) {
      constants.Response.COIN_AMOUNT_NEGATIVE.throwBaseException()
    } else result
  }

  def toProtoCoin: protoCoin = protoCoin.newBuilder().setDenom(this.denom).setAmount(this.amount.toMicroString).build()

  def getDenomAssetID: AssetID = schema.document.CoinAsset.getCoinAssetID(this.denom)
}

object Coin {

  def coinApply(denom: String, amount: String): Coin = Coin(denom = denom, amount = MicroNumber(BigInt(amount)))

  implicit val coinReads: Reads[Coin] = (
    (JsPath \ "denom").read[String] and
      (JsPath \ "amount").read[String]
    ) (coinApply _)

  implicit val coinWrites: Writes[Coin] = (coin: Coin) => Json.obj(
    "denom" -> coin.denom,
    "amount" -> coin.amount.toMicroString
  )

  def apply(coinProto: protoCoin): Coin = Coin(denom = coinProto.getDenom, amount = MicroNumber(BigInt(coinProto.getAmount)))

}
