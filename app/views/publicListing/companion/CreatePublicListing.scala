package views.publicListing.companion

import models.master.PublicListing
import play.api.data.Form
import play.api.data.Forms.mapping
import utilities.MicroNumber

object CreatePublicListing {
  val form: Form[Data] = Form(
    mapping(
      constants.FormField.SALE_NFT_ID.mapping,
      constants.FormField.PUBLIC_LISTING_MAX_PER_ACCOUNT.mapping,
      constants.FormField.PUBLIC_LISTING_PRICE.mapping,
      constants.FormField.PUBLIC_LISTING_NFT_NUMBER.mapping,
      constants.FormField.PUBLIC_LISTING_START_EPOCH.mapping,
      constants.FormField.PUBLIC_LISTING_END_EPOCH.mapping,
    )(Data.apply)(Data.unapply).verifying(constants.FormConstraint.createPublicListing))

  case class Data(nftId: String, maxPerAccount: Int, price: MicroNumber, numberOfNFTs: Int, startEpoch: Int, endEpoch: Int) {

    def toNewPublicListing(collectionId: String): PublicListing = PublicListing(nftId = nftId, id = utilities.IdGenerator.getRandomHexadecimal, collectionId = collectionId, numberOfNFTs = numberOfNFTs, maxPerAccount = maxPerAccount, price = price, totalSold = 0, startTimeEpoch = startEpoch, endTimeEpoch = endEpoch)
  }
}
