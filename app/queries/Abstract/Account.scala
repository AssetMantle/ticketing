package queries.Abstract

import models.blockchain.{Account => blockchainAccount}
import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{JsObject, JsPath, Reads}
import queries.common.Accounts.accountApply

abstract class Account {
  val address: String

  def toSerializableAccount: blockchainAccount
}

object Account {
  implicit val accountReads: Reads[Account] = (
    (JsPath \ "@type").read[String] and
      JsPath.read[JsObject]
    ) (accountApply _)
}