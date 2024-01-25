package constants

import controllers.routes
import play.api.mvc.Call
import play.api.routing.JavaScriptReverseRoute

case class Form(name: String, get: JavaScriptReverseRoute, post: Call) {
  val title: String = Seq("FORM", name, "TITLE").mkString(".")
  val subTitle: String = Seq("FORM", name, "SUBTITLE").mkString(".")
  val submit: String = Seq("FORM", name, "SUBMIT").mkString(".")
  val button: String = Seq("FORM", name, "BUTTON").mkString(".")
}

object Form {

  //AccountController
  val SIGN_UP: Form = Form("SIGN_UP", routes.javascript.AccountController.signUpForm, routes.AccountController.signUp())
  val VERIFY_WALLET_MNEMONICS: Form = Form("VERIFY_WALLET_MNEMONICS", routes.javascript.AccountController.verifyWalletMnemonicsForm, routes.AccountController.verifyWalletMnemonics())
  val SIGN_IN_WITH_CALLBACK: Form = Form("SIGN_IN_WITH_CALLBACK", routes.javascript.AccountController.signInWithCallbackForm, routes.AccountController.signInWithCallback())
  val FORGET_PASSWORD: Form = Form("FORGET_PASSWORD", routes.javascript.AccountController.forgetPasswordForm, routes.AccountController.forgetPassword())
  val CHANGE_PASSWORD: Form = Form("CHANGE_PASSWORD", routes.javascript.AccountController.changePasswordForm, routes.AccountController.changePassword())
  val SIGN_OUT: Form = Form("SIGN_OUT", routes.javascript.AccountController.signOutForm, routes.AccountController.signOut())
  val MIGRATE_WALLET_TO_KEY: Form = Form("MIGRATE_WALLET_TO_KEY", routes.javascript.AccountController.migrateWalletToKeyForm, routes.AccountController.migrateWalletToKey())
  val CHANGE_ACTIVE_KEY: Form = Form("CHANGE_ACTIVE_KEY", routes.javascript.AccountController.changeActiveKeyForm, routes.AccountController.changeActiveKey())

  val CREATE_COLLECTION: Form = Form("CREATE_COLLECTION", routes.javascript.CollectionController.createForm, routes.CollectionController.create())
  val EDIT_COLLECTION: Form = Form("EDIT_COLLECTION", routes.javascript.CollectionController.editForm, routes.CollectionController.edit())
  val UPDATE_ROYALTY: Form = Form("UPDATE_ROYALTY", routes.javascript.CollectionController.updateRoyaltyForm, routes.CollectionController.updateRoyalty())

  val ADD_MANAGED_KEY: Form = Form("ADD_MANAGED_KEY", routes.javascript.SettingController.addManagedKeyForm, routes.SettingController.addManagedKey())
  val ADD_UNMANAGED_KEY: Form = Form("ADD_UNMANAGED_KEY", routes.javascript.SettingController.addUnmanagedKeyForm, routes.SettingController.addUnmanagedKey())
  val CHANGE_KEY_NAME: Form = Form("CHANGE_KEY_NAME", routes.javascript.SettingController.changeKeyNameForm, routes.SettingController.changeKeyName())
  val VIEW_MNEMONICS: Form = Form("VIEW_MNEMONICS", routes.javascript.SettingController.viewMnemonicsForm, routes.SettingController.viewMnemonics())
  val DELETE_KEY: Form = Form("DELETE_KEY", routes.javascript.SettingController.deleteKeyForm, routes.SettingController.deleteKey())
  val PROVISION_ADDRESS: Form = Form("PROVISION_ADDRESS", routes.javascript.SettingController.provisionAddressForm, routes.SettingController.provisionAddress())
  val CHANGE_MANAGED_TO_UNMANAGED: Form = Form("CHANGE_MANAGED_TO_UNMANAGED", routes.javascript.SettingController.deleteKeyForm, routes.SettingController.deleteKey())

  val CREATE_WHITELIST: Form = Form("CREATE_WHITELIST", routes.javascript.WhitelistController.createWhitelistForm, routes.WhitelistController.createWhitelist())
  val EDIT_WHITELIST: Form = Form("EDIT_WHITELIST", routes.javascript.WhitelistController.editWhitelistForm, routes.WhitelistController.editWhitelist())
  val DELETE_WHITELIST: Form = Form("DELETE_WHITELIST", routes.javascript.WhitelistController.deleteForm, routes.WhitelistController.delete())
  val ACCEPT_WHITELIST_INVITE: Form = Form("ACCEPT_WHITELIST_INVITE", JavaScriptReverseRoute("", ""), routes.WhitelistController.acceptInvite())
  val LEAVE_WHITELIST: Form = Form("LEAVE_WHITELIST", JavaScriptReverseRoute("", ""), routes.WhitelistController.leaveWhitelist())
  val ADD_FROM_NFT_OWNERS: Form = Form("ADD_FROM_NFT_OWNERS", routes.javascript.WhitelistController.addFromNFTOwnersForm, routes.WhitelistController.addFromNFTOwners())

  val NFT_BASIC_DETAIL: Form = Form("NFT_BASIC_DETAIL", routes.javascript.NFTController.basicDetailsForm, routes.NFTController.basicDetails())
  val REVEAL_PROPERTY: Form = Form("REVEAL_PROPERTY", routes.javascript.NFTController.revealPropertyForm, routes.NFTController.revealProperty())

  val CREATE_WHITELIST_SALE: Form = Form("CREATE_WHITELIST_SALE", routes.javascript.SaleController.createCollectionSaleForm, routes.SaleController.createCollectionSale())
  val STOP_WHITELIST_SALE: Form = Form("STOP_WHITELIST_SALE", routes.javascript.SaleController.stopForm, routes.SaleController.stop())
  val BUY_NFT_SALE: Form = Form("BUY_NFT_SALE", routes.javascript.SaleController.buySaleNFTForm, routes.SaleController.buySaleNFT())

  val CREATE_PUBLIC_LISTING: Form = Form("CREATE_PUBLIC_LISTING", routes.javascript.PublicListingController.createPublicListingForm, routes.PublicListingController.createPublicListing())
  val STOP_PUBLIC_LISTING: Form = Form("STOP_PUBLIC_LISTING", routes.javascript.PublicListingController.stopForm, routes.PublicListingController.stop())
  val BUY_NFT_PUBLIC_LISTING: Form = Form("BUY_NFT_PUBLIC_LISTING", routes.javascript.PublicListingController.buyNFTForm, routes.PublicListingController.buyNFT())

  val CREATE_SECONDARY_MARKET: Form = Form("CREATE_SECONDARY_MARKET", routes.javascript.SecondaryMarketController.createForm, routes.SecondaryMarketController.create())
  val CANCEL_SECONDARY_MARKET: Form = Form("CANCEL_SECONDARY_MARKET", routes.javascript.SecondaryMarketController.cancelForm, routes.SecondaryMarketController.cancel())
  val BUY_FROM_SECONDARY_MARKET: Form = Form("BUY_FROM_SECONDARY_MARKET", routes.javascript.SecondaryMarketController.buyForm, routes.SecondaryMarketController.buy())

  val WRAP_COIN: Form = Form("WRAP_COIN", routes.javascript.WalletController.wrapCoinForm, routes.WalletController.wrapCoin())
  val UNWRAP_TOKEN: Form = Form("UNWRAP_TOKEN", routes.javascript.WalletController.unwrapTokenForm, routes.WalletController.unwrapToken())

}
