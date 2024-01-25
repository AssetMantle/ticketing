package models.Abstract

import models.common.PublicKeys._
import play.api.Logger
import play.api.libs.functional.syntax.toAlternativeOps
import play.api.libs.json._

abstract class PublicKey {
  val publicKeyType: String
  val value: String

  def isValidatorKey: Boolean = publicKeyType == constants.Blockchain.PublicKey.VALIDATOR

  def getAccountAddress: String = utilities.Crypto.convertAccountPublicKeyToAccountAddress(value)
}

object PublicKey {
  implicit val module: String = constants.Module.PUBLIC_KEYS

  implicit val logger: Logger = Logger(this.getClass)

  implicit val publicKeyWrites: Writes[PublicKey] = {
    case singlePublicKey: SinglePublicKey => Json.toJson(singlePublicKey)
    case multiSigPublicKey: MultiSigPublicKey => Json.toJson(multiSigPublicKey)
    case _ => constants.Response.NO_SUCH_PUBLIC_KEY_TYPE.throwBaseException()
  }
  implicit val publicKeyReads: Reads[PublicKey] = {
    Json.format[SinglePublicKey].map(x => x: SinglePublicKey) or
      Json.format[MultiSigPublicKey].map(x => x: MultiSigPublicKey)
  }
}