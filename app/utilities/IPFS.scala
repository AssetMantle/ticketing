package utilities

import okhttp3._
import okio.{BufferedSink, Okio}
import org.json.JSONObject
import play.api.Logger
import play.api.libs.json.{Json, OWrites, Reads}

import java.io._
import java.net.URL
import javax.net.ssl.HttpsURLConnection

// https://github.com/zinebfadili/pinata-java-sdk/blob/main/src/main/java/pinata/Pinata.java
object IPFS {

  implicit val module: String = constants.Module.UTILITIES_IPFS

  implicit val logger: Logger = Logger(this.getClass)

  case class Success(IpfsHash: String, PinSize: Int, Timestamp: String, isDuplicate: Option[Boolean])

  implicit val successReads: Reads[Success] = Json.reads[Success]

  case class MetaData(blockchain: String)

  implicit val metaDataWrites: OWrites[MetaData] = Json.writes[MetaData]

  case class PinataMetaData(name: String, keyvalues: MetaData)

  implicit val pinataMetaDataWrites: OWrites[PinataMetaData] = Json.writes[PinataMetaData]

  case class PinataOptions(cidVersion: Int, wrapWithDirectory: Boolean) {
    def validate: Boolean = this.cidVersion == 0 || this.cidVersion == 1
  }

  implicit val pinataOptionsWrites: OWrites[PinataOptions] = Json.writes[PinataOptions]

  case class PinataData(pinataMetadata: PinataMetaData)

  implicit val pinataDataWrites: OWrites[PinataData] = Json.writes[PinataData]

  private val jwtToken = "Bearer " + constants.CommonConfig.IPFS.JwtToken

  private class InputStreamRequestBody(val inputStream: InputStream, val mediaType: MediaType) extends RequestBody {
    def contentType: MediaType = mediaType

    override def isOneShot = true

    def writeTo(sink: BufferedSink): Unit = {
      try {
        val source = Okio.source(inputStream)
        try sink.writeAll(source)
        finally if (source != null) source.close()
      }
    }
  }

  private def postOrPutRequest(method: String, requestBody: RequestBody): Success = {
    val client = new OkHttpClient().newBuilder.build
    val request = new Request.Builder().url(constants.CommonConfig.IPFS.UploadEndPoint).method(method, requestBody)
      .addHeader("Authorization", jwtToken)
      .addHeader("Content-Type", "application/json").build
    val response = client.newCall(request).execute
    if (response.code == 200) {
      utilities.JSON.convertJsonStringToObject[Success](response.body().string())
    } else {
      logger.error(response.body().string())
      constants.Response.IPFS_UPLOAD_FAILED.throwBaseException()
    }
  }

  def pinFile(file: File, filename: String, metaData: Option[MetaData] = None, pinataOptions: PinataOptions = PinataOptions(1, wrapWithDirectory = true)): Success = {
    val body = metaData.fold {
      var builder = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", filename, new InputStreamRequestBody(new FileInputStream(file), MediaType.parse("application/octet-stream")))
      builder.addFormDataPart("pinataOptions", Json.toJson(pinataOptions).toString)
      builder
    } { data =>
      var builder = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", filename, new InputStreamRequestBody(new FileInputStream(file), MediaType.parse("application/octet-stream")))
      builder.addFormDataPart("pinataOptions", Json.toJson(pinataOptions).toString)
      val options = new JSONObject(Json.toJsObject(PinataData(PinataMetaData(filename, data))).toString())
      if (options.has("pinataMetadata")) {
        builder.addFormDataPart("pinataMetadata", options.getJSONObject("pinataMetadata").toString)
      }
      builder
    }.build()
    postOrPutRequest("POST", body)
  }

  def pinJson(pinataBody: JSONObject, options: Option[JSONObject] = None): Success = {
    val bodyContent = options.fold(pinataBody) { pinataOptions =>
      var content = new JSONObject()
      content.put("pinataContent", pinataBody)
      if (pinataOptions.has("pinataOptions")) content.put("pinataOptions", pinataOptions.getJSONObject("pinataOptions"))
      if (pinataOptions.has("pinataMetadata")) content.put("pinataMetadata", pinataOptions.getJSONObject("pinataMetadata"))
      content
    }
    postOrPutRequest("POST", RequestBody.create(MediaType.parse("application/json"), bodyContent.toString))
  }

  def downloadFile(fileUrl: String, downloadPath: String): Boolean = {
    try {
      val url = new URL(constants.CommonConfig.IPFS.DownloadEndPoint + "/" + fileUrl)
      val connection = url.openConnection().asInstanceOf[HttpsURLConnection]
      connection.setRequestMethod("GET")
      connection.setRequestProperty("x-pinata-gateway-token", constants.CommonConfig.IPFS.DownloadAccessToken)
      var in = connection.getInputStream
      var out = new BufferedOutputStream(new FileOutputStream(downloadPath))
      val byteArray = LazyList.continually(in.read).takeWhile(_ != -1).map(_.toByte).toArray
      out.write(byteArray)
      true
    } catch {
      case exception: Exception => logger.error(exception.getLocalizedMessage)
        false
    }
  }
}
