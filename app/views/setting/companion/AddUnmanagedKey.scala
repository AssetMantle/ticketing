package views.setting.companion

import play.api.data.Form
import play.api.data.Forms.mapping

object AddUnmanagedKey {

  val form: Form[Data] = Form(
    mapping(
      constants.FormField.UNMANAGED_KEY_NAME.mapping,
      constants.FormField.UNMANAGED_KEY_ADDRESS.mapping,
      constants.FormField.PASSWORD.mapping,
    )(Data.apply)(Data.unapply))

  case class Data(keyName: String, address: String, password: String)

}