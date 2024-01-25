package views.collection.companion

import models.common.Collection._
import play.api.data.Form
import play.api.data.Forms.mapping

import java.net.URL

object Create {

  val form: Form[Data] = Form(
    mapping(
      constants.FormField.COLLECTION_NAME.mapping,
      constants.FormField.COLLECTION_DESCRIPTION.mapping,
      constants.FormField.ADDRESS.mapping,
      constants.FormField.POSTAL_CODE.mapping,
      constants.FormField.CITY.mapping,
      constants.FormField.CONTACT_NUMBER.mapping,
      constants.FormField.CATEGORY.mapping,
      constants.FormField.EVENT_START_EPOCH.mapping,
      constants.FormField.EVENT_END_EPOCH.mapping,
      constants.FormField.COLLECTION_WEBSITE.optionalMapping,
      constants.FormField.COLLECTION_TWITTER.optionalMapping,
      constants.FormField.COLLECTION_INSTAGRAM.optionalMapping,
      constants.FormField.CREATE_COLLECTION_TERMS_AND_CONDITION.mapping,
      constants.FormField.CREATE_COLLECTION_MOU.mapping,
      constants.FormField.COLLECTION_ROYALTY.mapping,
    )(Data.apply)(Data.unapply).verifying(constants.FormConstraint.createCollectionConstraint))

  case class Data(name: String, description: String, address: String, postalCode: String, city: String, contactNumber: String, category: String, startEpochTime: Int, endEpochTime: Int, website: Option[URL], twitter: Option[String], instagram: Option[String], termsAccepted: Boolean, mou: Boolean, royalty: BigDecimal) {
    def getSocialProfiles: Seq[SocialProfile] = Seq(
      this.website.fold[Option[SocialProfile]](None)(x => Option(SocialProfile(name = constants.Collection.SocialProfile.WEBSITE, url = x.toString))),
      this.twitter.fold[Option[SocialProfile]](None)(x => Option(SocialProfile(name = constants.Collection.SocialProfile.TWITTER, url = x))),
      this.instagram.fold[Option[SocialProfile]](None)(x => Option(SocialProfile(name = constants.Collection.SocialProfile.INSTAGRAM, url = x)))
    ).flatten

    def getDetail: Detail = Detail(description = this.description, address = this.address, postalCode = this.postalCode, contactNumber = this.contactNumber, startEpochTime = this.startEpochTime, endEpochTime = this.endEpochTime)
  }

}
