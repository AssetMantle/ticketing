package models.common

import play.api.libs.json.{Json, OFormat, Reads, Writes}

object Collection {

  case class Detail(description: String, address: String, postalCode: String, contactNumber: String, startEpochTime: Long, endEpochTime: Long)

  implicit val DetailWrites: Writes[Detail] = Json.writes[Detail]

  implicit val DetailReads: Reads[Detail] = Json.reads[Detail]

  implicit val DetailFormat: OFormat[Detail] = Json.using[Json.WithDefaultValues].format[Detail]

  case class SocialProfile(name: String, url: String)

  implicit val writes: Writes[SocialProfile] = Json.writes[SocialProfile]

  implicit val reads: Reads[SocialProfile] = Json.reads[SocialProfile]

}
