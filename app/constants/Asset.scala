package constants

import schema.id.base.ClassificationID

object Asset {

  val BondAmount = 2016L

  val Commission: BigDecimal = 0.2

  object EVENT_TYPE {
    val STAND_UP_COMEDY = "STAND_UP_COMEDY"
    val CONCERT = "CONCERT"
    val LIVE_MUSIC = "LIVE_MUSIC"
  }

  val ClassificationId: ClassificationID = ClassificationID("vTeCTcGBiIG4P1E3vzo8Y3jl2bk8djVvHUWAHNmi1U0=")

  object File {
    val PROFILE = "PROFILE"
    val COVER = "COVER"

    val AllCollectionsPath: String = constants.CommonConfig.Files.CollectionPath + "/"
  }

  object SocialProfile {
    val WEBSITE = "WEBSITE"
    val TWITTER = "TWITTER"
    val INSTAGRAM = "INSTAGRAM"
  }

  object Category {
    val ART = "ART"
    val PHOTOGRAPHY = "PHOTOGRAPHY"
    val MISCELLANEOUS = "MISCELLANEOUS"
  }

  case class CollectionStatus(name: String, id: Int)

  object Status {
    val NO_STATUS: CollectionStatus = CollectionStatus("NO_STATUS", 0)
    val PUBLIC_LISTED: CollectionStatus = CollectionStatus("PUBLIC_LISTED", 1)
    val WHITELIST_SALE: CollectionStatus = CollectionStatus("WHITELIST_SALE", 2)
    val MARKET: CollectionStatus = CollectionStatus("MARKET", 3)
  }

  object DefaultProperty {
    // Should be kept in lower case otherwise change in form constraints
    val NAME = "name"
    val DESCRIPTION = "description"
    val ADDRESS = "address"
    val POSTAL_CODE = "postalCode"
    val CITY = "city"
    val CONTACT_NUMBER = "contactNumber"
    val CREATOR_ID = "creatorId"
    val FILE_RESOURCE = "fileResource"
    val START_EPOCH_TIME = "startEpochTime"
    val END_EPOCH_TIME = "endEpochTime"
  }
}
