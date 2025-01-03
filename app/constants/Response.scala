package constants

import exceptions.BaseException
import play.api.Logger
import play.api.routing.JavaScriptReverseRoute

import scala.concurrent.{ExecutionContext, Future}

object Response {

  private val PREFIX = "RESPONSE."
  private val FAILURE_PREFIX = "FAILURE."
  private val WARNING_PREFIX = "WARNING."
  private val SUCCESS_PREFIX = "SUCCESS."
  private val INFO_PREFIX = "INFO."
  private val LOG_PREFIX = "LOG."

  val LOGGED_OUT = new Success("LOGGED_OUT")

  val INVALID_USERNAME_OR_PASSWORD: Failure = Failure("INVALID_USERNAME_OR_PASSWORD")
  val INVALID_PASSWORD: Failure = Failure("INVALID_PASSWORD")
  val PASSWORDS_DO_NOT_MATCH: Failure = Failure("PASSWORDS_DO_NOT_MATCH")
  val TERMS_AND_CONDITION_NOT_ACCEPTED: Failure = Failure("TERMS_AND_CONDITION_NOT_ACCEPTED")
  val MOU_NOT_ACCEPTED: Failure = Failure("MOU_NOT_ACCEPTED")
  val USERNAME_UNAVAILABLE: Failure = Failure("USERNAME_UNAVAILABLE")
  val PASSWORD_VALIDATION_FAILED: Failure = Failure("PASSWORD_VALIDATION_FAILED")
  val OLD_AND_NEW_SAME_PASSWORD: Failure = Failure("OLD_AND_NEW_SAME_PASSWORD")
  val INVALID_SEEDS_OR_ADDRESS: Failure = Failure("INVALID_SEEDS_OR_ADDRESS")
  val MNEMONICS_LENGTH_NOT_12_OR_24: Failure = Failure("MNEMONICS_LENGTH_NOT_12_OR_24")

  val JSON_PARSE_EXCEPTION: Failure = Failure("JSON_PARSE_EXCEPTION")
  val JSON_MAPPING_EXCEPTION: Failure = Failure("JSON_MAPPING_EXCEPTION")
  val CONNECT_EXCEPTION: Failure = Failure("CONNECT_EXCEPTION")
  val NUMBER_FORMAT_EXCEPTION: Failure = Failure("NUMBER_FORMAT_EXCEPTION")
  val DATE_FORMAT_ERROR: Failure = Failure("DATE_FORMAT_ERROR")
  val INVALID_DATA_TYPE: Failure = Failure("INVALID_DATA_TYPE")

  val INVALID_MNEMONICS: Failure = Failure("INVALID_MNEMONICS")
  val INVALID_MNEMONICS_OR_USERNAME: Failure = Failure("INVALID_MNEMONICS_OR_USERNAME")
  val INVALID_ACTIVE_KEY: Failure = Failure("INVALID_ACTIVE_KEY")
  val ACTIVATING_UNMANAGED_KEY: Failure = Failure("ACTIVATING_UNMANAGED_KEY")
  val KEY_NOT_PROVISIONED: Failure = Failure("KEY_NOT_PROVISIONED")

  val IPFS_UPLOAD_FAILED: Failure = Failure("IPFS_UPLOAD_FAILED")
  val AMAZON_S3_UPLOAD_FAILURE: Failure = Failure("AMAZON_S3_UPLOAD_FAILURE")
  val AMAZON_S3_PROCESS_FAILURE: Failure = Failure("AMAZON_S3_PROCESS_FAILURE")
  val AMAZON_S3_CLIENT_CONNECTION_FAILURE: Failure = Failure("AMAZON_S3_CLIENT_CONNECTION_FAILURE")
  val AMAZON_S3_NON_VERSIONED_BUCKET: Failure = Failure("AMAZON_S3_NON_VERSIONED_BUCKET")

  val GENERIC_JSON_EXCEPTION: Failure = Failure("GENERIC_JSON_EXCEPTION")
  val NO_SUCH_ELEMENT_EXCEPTION: Failure = Failure("NO_SUCH_ELEMENT_EXCEPTION")
  val NULL_POINTER_EXCEPTION: Failure = Failure("NULL_POINTER_EXCEPTION")
  val INVALID_FILE_PATH_EXCEPTION: Failure = Failure("INVALID_FILE_PATH_EXCEPTION")
  val FILE_SECURITY_EXCEPTION: Failure = Failure("FILE_SECURITY_EXCEPTION")
  val GENERIC_EXCEPTION: Failure = Failure("GENERIC_EXCEPTION")
  val I_O_EXCEPTION: Failure = Failure("I_O_EXCEPTION")
  val FILE_NOT_FOUND_EXCEPTION: Failure = Failure("FILE_NOT_FOUND_EXCEPTION")
  val FILE_ILLEGAL_ARGUMENT_EXCEPTION: Failure = Failure("FILE_ILLEGAL_ARGUMENT_EXCEPTION")
  val CLASS_CAST_EXCEPTION: Failure = Failure("CLASS_CAST_EXCEPTION")
  val FILE_UNSUPPORTED_OPERATION_EXCEPTION: Failure = Failure("FILE_UNSUPPORTED_OPERATION_EXCEPTION")
  val NO_SUCH_FILE_EXCEPTION: Failure = Failure("NO_SUCH_FILE_EXCEPTION")

  val USERNAME_NOT_FOUND: Failure = Failure("USERNAME_NOT_FOUND")
  val ADDRESS_NOT_FOUND: Failure = Failure("ADDRESS_NOT_FOUND")
  val TOKEN_NOT_FOUND: Failure = Failure("TOKEN_NOT_FOUND")
  val INVALID_SESSION: Failure = Failure("INVALID_SESSION")
  val INVALID_PAGE_NUMBER: Failure = Failure("INVALID_PAGE_NUMBER")
  val INVALID_SEEDS: Failure = Failure("INVALID_SEEDS")
  val SEEDS_NOT_FOUND: Failure = Failure("SEEDS_NOT_FOUND")
  val HD_PATH_NOT_FOUND: Failure = Failure("HD_PATH_NOT_FOUND")
  val START_TIME_GREATER_THAN_EQUAL_TO_END_TIME: Failure = Failure("START_TIME_GREATER_THAN_EQUAL_TO_END_TIME")
  val START_TIME_LESS_THAN_CURRENT_TIME: Failure = Failure("START_TIME_LESS_THAN_CURRENT_TIME")
  val CANNOT_DELETE_ACTIVE_KEY: Failure = Failure("CANNOT_DELETE_ACTIVE_KEY")
  val MICRO_NUMBER_PRECISION_MORE_THAN_REQUIRED: Failure = Failure("MICRO_NUMBER_PRECISION_MORE_THAN_REQUIRED")
  val FROM_AND_TO_ADDRESS_SAME: Failure = Failure("FROM_AND_TO_ADDRESS_SAME")
  val INSUFFICIENT_BALANCE: Failure = Failure("INSUFFICIENT_BALANCE")
  val INSUFFICIENT_NFT_BALANCE: Failure = Failure("INSUFFICIENT_NFT_BALANCE")
  val TO_ACCOUNT_ID_DOES_NOT_EXISTS: Failure = Failure("TO_ACCOUNT_ID_DOES_NOT_EXISTS")
  val MAXIMUM_COLLECTION_PROPERTIES_EXCEEDED: Failure = Failure("MAXIMUM_COLLECTION_PROPERTIES_EXCEEDED")
  val CANNOT_SEND_TO_YOURSELF: Failure = Failure("CANNOT_SEND_TO_YOURSELF")
  val COLLECTION_PROPERTIES_CONTAINS_DEFAULT_PROPERTIES: Failure = Failure("COLLECTION_PROPERTIES_CONTAINS_DEFAULT_PROPERTIES")
  val COLLECTION_PROPERTIES_CONTAINS_DUPLICATE_PROPERTIES: Failure = Failure("COLLECTION_PROPERTIES_CONTAINS_DUPLICATE_PROPERTIES")
  val COLLECTION_PROPERTIES_CONTAINS_RESTRICTED_PROPERTIES: Failure = Failure("COLLECTION_PROPERTIES_CONTAINS_RESTRICTED_PROPERTIES")
  val INVALID_NFT_TAGS_LENGTH: Failure = Failure("INVALID_NFT_TAGS_LENGTH")
  val MAXIMUM_NFT_TAGS_EXCEEDED: Failure = Failure("MAXIMUM_NFT_TAGS_EXCEEDED")
  val INVALID_NFT_TAG: Failure = Failure("INVALID_NFT_TAG")
  val REPEATED_NFT_TAGS: Failure = Failure("REPEATED_NFT_TAGS")
  val INVALID_ORDER: Failure = Failure("INVALID_ORDER")
  val ORDER_NOT_CREATED_ON_BLOCKCHAIN: Failure = Failure("ORDER_NOT_CREATED_ON_BLOCKCHAIN")
  val KEY_PROVISION_STATE_UNKNOWN: Failure = Failure("KEY_PROVISION_STATE_UNKNOWN")
  val PARAMETER_NOT_FOUND: Failure = Failure("PARAMETER_NOT_FOUND")

  val ARITHMETIC_OPERATION_ON_DIFFERENT_COIN: Failure = Failure("ARITHMETIC_OPERATION_ON_DIFFERENT_COIN")
  val COIN_AMOUNT_NEGATIVE: Failure = Failure("COIN_AMOUNT_NEGATIVE")
  val INVALID_SIGNATURE: Failure = Failure("INVALID_SIGNATURE")
  val INVALID_BASE64_ENCODING: Failure = Failure("INVALID_BASE64_ENCODING")
  val NO_SUCH_PUBLIC_KEY_TYPE: Failure = Failure("NO_SUCH_PUBLIC_KEY_TYPE")
  val TRANSACTION_ALREADY_IN_MEMPOOL: Failure = Failure("TRANSACTION_ALREADY_IN_MEMPOOL")
  val ACCOUNT_TYPE_NOT_FOUND: Failure = Failure("ACCOUNT_TYPE_NOT_FOUND")
  val BALANCE_FETCH_FAILED: Failure = Failure("BALANCE_FETCH_FAILED")
  val NO_COLLECTION_TO_CREATE_WHITELIST: Failure = Failure("NO_COLLECTION_TO_CREATE_WHITELIST")
  val CANNOT_CREATE_MORE_ALLOWED_WHITELISTS: Failure = Failure("CANNOT_CREATE_MORE_ALLOWED_WHITELISTS")
  val WHITELIST_MAX_MEMBERS_REACHED: Failure = Failure("WHITELIST_MAX_MEMBERS_REACHED")
  val NOT_WHITELIST_CREATOR: Failure = Failure("NOT_WHITELIST_CREATOR")
  val NOT_COLLECTION_OWNER: Failure = Failure("NOT_COLLECTION_OWNER")
  val NOT_NFT_OWNER: Failure = Failure("NOT_NFT_OWNER")
  val FILE_SIZE_GREATER_THAN_ALLOWED: Failure = Failure("FILE_SIZE_GREATER_THAN_ALLOWED")
  val NOT_ENOUGH_QUANTITY: Failure = Failure("NOT_ENOUGH_QUANTITY")
  val NFT_OWNER_NOT_FOUND: Failure = Failure("NFT_OWNER_NOT_FOUND")
  val NFT_NOT_MINTED: Failure = Failure("NFT_NOT_MINTED")
  val SELLING_MINT_E_COLLECTIONS_NOT_ALLOWED: Failure = Failure("SELLING_MINT_E_COLLECTIONS_NOT_ALLOWED")
  val INVALID_DOCUMENT_TYPE: Failure = Failure("INVALID_DOCUMENT_TYPE")
  val INVALID_DEFAULT_VALUE: Failure = Failure("INVALID_DEFAULT_VALUE")
  val NFT_PROPERTY_NOT_FOUND: Failure = Failure("NFT_PROPERTY_NOT_FOUND")
  val BOND_AMOUNT_LESS_THAN_MINIMUM: Failure = Failure("BOND_AMOUNT_LESS_THAN_MINIMUM")
  val NFT_PROPERTY_TYPE_NOT_FOUND: Failure = Failure("NFT_PROPERTY_TYPE_NOT_FOUND")
  val INVALID_NFT_PROPERTY: Failure = Failure("INVALID_NFT_PROPERTY")
  val NOT_GENESIS_CREATOR: Failure = Failure("NOT_GENESIS_CREATOR")
  val NOT_VERIFIED_CREATOR: Failure = Failure("NOT_VERIFIED_CREATOR")
  val COLLECTION_NOT_FOUND: Failure = Failure("COLLECTION_NOT_FOUND")
  val COLLECTION_NOT_PUBLIC: Failure = Failure("COLLECTION_NOT_PUBLIC")
  val FRACTIONALIZED_COLLECTION_NOT_ALLOWED: Failure = Failure("FRACTIONALIZED_COLLECTION_NOT_ALLOWED")
  val NFT_ALREADY_ON_SALE: Failure = Failure("NFT_ALREADY_ON_SALE")
  val CANNOT_CREATE_MORE_THAN_ONE_SALE: Failure = Failure("CANNOT_CREATE_MORE_THAN_ONE_SALE")
  val COLLECTION_ID_OR_WHITELIST_ID_DOES_NOT_EXIST: Failure = Failure("COLLECTION_ID_OR_WHITELIST_ID_DOES_NOT_EXIST")
  val NOT_ENOUGH_NFTS_IN_COLLECTION: Failure = Failure("NOT_ENOUGH_NFTS_IN_COLLECTION")
  val NFT_NOT_FOUND: Failure = Failure("NFT_NOT_FOUND")
  val CANNOT_SELL_MORE_THAN_ALLOWED_LIMIT: Failure = Failure("CANNOT_SELL_MORE_THAN_ALLOWED_LIMIT")
  val DIRECTORY_CREATION_FAILED: Failure = Failure("DIRECTORY_CREATION_FAILED")
  val CANNOT_SELL_TO_YOURSELF: Failure = Failure("CANNOT_SELL_TO_YOURSELF")
  val NOT_MEMBER_OF_WHITELIST: Failure = Failure("NOT_MEMBER_OF_WHITELIST")
  val SALE_NOT_STARTED: Failure = Failure("SALE_NOT_STARTED")
  val EARLY_ACCESS_NOT_STARTED: Failure = Failure("EARLY_ACCESS_NOT_STARTED")
  val SALE_EXPIRED: Failure = Failure("SALE_EXPIRED")
  val EARLY_ACCESS_ENDED: Failure = Failure("EARLY_ACCESS_ENDED")
  val NFT_NOT_ON_SALE: Failure = Failure("NFT_NOT_ON_SALE")
  val NFT_WHITELIST_SALE_NOT_FOUND: Failure = Failure("NFT_WHITELIST_SALE_NOT_FOUND")
  val NFT_PUBLIC_LISTING_SALE_NOT_FOUND: Failure = Failure("NFT_PUBLIC_LISTING_SALE_NOT_FOUND")
  val NFT_NOT_ON_PUBLIC_LISTING: Failure = Failure("NFT_NOT_ON_PUBLIC_LISTING")
  val NFT_ALREADY_MINTED: Failure = Failure("NFT_ALREADY_MINTED")
  val NFT_TOTAL_SUPPLY_AND_OWNED_DIFFERENT: Failure = Failure("NFT_TOTAL_SUPPLY_AND_OWNED_DIFFERENT")
  val MAXIMUM_NFT_MINT_PER_ACCOUNT_REACHED: Failure = Failure("MAXIMUM_NFT_MINT_PER_ACCOUNT_REACHED")
  val NFT_ALREADY_SOLD: Failure = Failure("NFT_ALREADY_SOLD")
  val SIGNING_FAILED: Failure = Failure("SIGNING_FAILED")
  val TRANSACTION_BROADCASTING_FAILED_AND_TIMED_OUT: Failure = Failure("TRANSACTION_BROADCASTING_FAILED_AND_TIMED_OUT")
  val ORDER_ID_NOT_FOUND: Failure = Failure("ORDER_ID_NOT_FOUND")
  val INVALID_IDENTITY_ISSUE_MESSAGE: Failure = Failure("INVALID_IDENTITY_ISSUE_MESSAGE")
  val ADDRESS_ALREADY_PROVISIONED: Failure = Failure("ADDRESS_ALREADY_PROVISIONED")
  val IDENTITY_DOES_NOT_EXIST_TO_MINT: Failure = Failure("IDENTITY_DOES_NOT_EXIST_TO_MINT")
  val TAKE_ORDER_MORE_QUANTITY: Failure = Failure("TAKE_ORDER_MORE_QUANTITY")
  val INVALID_QUANTITY_FOR_NFT_SECONDARY_MARKET: Failure = Failure("INVALID_QUANTITY_FOR_NFT_SECONDARY_MARKET")
  val INVALID_QUANTITY: Failure = Failure("INVALID_QUANTITY")
  val TRANSACTION_HEIGHT_NOT_FOUND: Failure = Failure("TRANSACTION_HEIGHT_NOT_FOUND")
  val NFT_ON_SALE_CANNOT_BE_MINTED: Failure = Failure("NFT_ON_SALE_CANNOT_BE_MINTED")
  val SALE_STOPPED_OR_OVER: Failure = Failure("SALE_STOPPED_OR_OVER")
  val SECRET_KEY_ID_NOT_FOUND: Failure = Failure("SECRET_KEY_ID_NOT_FOUND")
  val PROPERTY_ALREADY_REVEALED: Failure = Failure("PROPERTY_ALREADY_REVEALED")

  case class Failure(private val response: String) {
    def message: String = PREFIX + FAILURE_PREFIX + response

    def logMessage: String = LOG_PREFIX + response

    def getBaseException(exception: Exception = null)(implicit module: String, logger: Logger) = new BaseException(this, exception)

    def throwBaseException(exception: Exception = null)(implicit module: String, logger: Logger) = throw this.getBaseException(exception)

    def throwFutureBaseException(exception: Exception = null)(implicit module: String, logger: Logger, executionContext: ExecutionContext) = Future(throw this.getBaseException(exception))
  }

  class Warning(private val response: String, private val actionController: JavaScriptReverseRoute = null) {
    val message: String = PREFIX + WARNING_PREFIX + response
  }

  class Success(private val response: String) {
    val message: String = Response.PREFIX + Response.SUCCESS_PREFIX + response
  }

  class Info(private val response: String) {
    val message: String = PREFIX + INFO_PREFIX + response
  }

}
