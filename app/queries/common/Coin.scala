package queries.common

import play.api.libs.functional.syntax._
import play.api.libs.json._
import utilities.MicroNumber
import models.common.{Coin => commonCoin}

case class Coin(denom: String, amount: MicroNumber) {
  def toCoin: commonCoin = commonCoin(denom = denom, amount = amount)
}

object Coin {
  def apply(denom: String, amount: String): Coin = new Coin(denom, new MicroNumber(BigDecimal(amount).toBigInt))

  implicit val coinReads: Reads[Coin] = (
    (JsPath \ "denom").read[String] and
      (JsPath \ "amount").read[String]
    ) (apply _)

}
