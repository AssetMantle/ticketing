package views.nft.companion

import play.api.data.Form
import play.api.data.Forms.mapping

object NFTBasicDetail {

  val form: Form[Data] = Form(
    mapping(
      constants.FormField.NFT_NAME.mapping,
      constants.FormField.NFT_DESCRIPTION.mapping,
      constants.FormField.NFT_TOTAL_SUPPLY.mapping,
      constants.FormField.COLLECTION_ID.mapping,
      constants.FormField.NFT_ID.mapping,
      constants.FormField.SAVE_NFT_DRAFT.mapping,
    )(Data.apply)(Data.unapply))

  case class Data(name: String, description: String, totalSupply: Long, collectionId: String, nftId: String, saveAsDraft: Boolean)

}
