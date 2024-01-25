package utilities

import schema.data.base._
import schema.id.base._
import schema.property.base.{MesaProperty, MetaProperty}
import schema.qualified.{Immutables, Mutables}

object Asset {

  private val others = "/others/"
  private val nfts = "/nfts/"

  def getFilePath: String = utilities.FileOperations.checkAndCreateDirectory(constants.Asset.File.AllCollectionsPath + others)

  def getNFTFilePath: String = utilities.FileOperations.checkAndCreateDirectory(constants.Asset.File.AllCollectionsPath + nfts)

  def getOthersFileAwsKey(fileName: String): String = others + fileName

  def getOldNFTFileAwsKey(fileName: String): String = nfts + fileName

  def getDefaultImmutableMetaProperties(name: String, creatorId: String, description: String, address: String, postalCode: String, city: String, contactNumber: String, startEpochTime: Long, endEpochTime: Long, supply: BigInt, fileHashID: HashID, fileExtension: String, serviceEndpoint: String): Seq[MetaProperty] = Seq(
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.CREATOR_ID), typeID = schema.id.constants.IdentityIDType), data = IDData(utilities.Identity.getMantlePlaceIdentityID(creatorId))),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.NAME), typeID = schema.data.constants.StringDataTypeID), data = StringData(name)),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.DESCRIPTION), typeID = schema.data.constants.StringDataTypeID), data = StringData(description)),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.ADDRESS), typeID = schema.data.constants.StringDataTypeID), data = StringData(address)),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.POSTAL_CODE), typeID = schema.data.constants.StringDataTypeID), data = StringData(postalCode)),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.CITY), typeID = schema.data.constants.StringDataTypeID), data = StringData(city)),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.CONTACT_NUMBER), typeID = schema.data.constants.StringDataTypeID), data = StringData(contactNumber)),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.START_EPOCH_TIME), typeID = schema.data.constants.NumberDataTypeID), data = NumberData(startEpochTime)),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.END_EPOCH_TIME), typeID = schema.data.constants.NumberDataTypeID), data = NumberData(endEpochTime)),
    MetaProperty(id = PropertyID(keyID = StringID(constants.Asset.DefaultProperty.FILE_RESOURCE), typeID = schema.data.constants.LinkedDataTypeID), data = LinkedData(resourceID = fileHashID, extensionID = StringID(fileExtension), serviceEndpoint = serviceEndpoint)),
    schema.constants.Properties.SupplyProperty.copy(data = NumberData(supply))
  )

  def getDefaultImmutableMesaProperties: Seq[MesaProperty] = Seq()

  def getDefaultMutableMetaProperties: Seq[MetaProperty] = Seq(
    schema.constants.Properties.BondAmountProperty.copy(data = NumberData(constants.Asset.BondAmount))
  )

  def getDefaultMutableMesaProperties: Seq[MesaProperty] = Seq()

  def getImmutables(name: String, creatorId: String, description: String, address: String, postalCode: String, city: String, contactNumber: String, startEpochTime: Long, endEpochTime: Long, supply: BigInt, fileHashID: HashID, fileExtension: String, serviceEndpoint: String): Immutables =
    Immutables(
      getDefaultImmutableMetaProperties(name = name, creatorId = creatorId, description = description, address = address, postalCode = postalCode, city = city, contactNumber = contactNumber, startEpochTime = startEpochTime, endEpochTime = endEpochTime, supply = supply, fileHashID = fileHashID, fileExtension = fileExtension, serviceEndpoint = serviceEndpoint)
    )

  def getMutables: Mutables = Mutables(getDefaultMutableMetaProperties)

  def getServiceEndPoint(id: String, fileExtension: String): String = "https://marketplace.assetmantle.one/nftResource/" + id + "." + fileExtension

  // TODO BondRate from parameters
  def getAssetID(classificationID: ClassificationID, immutables: Immutables): AssetID = schema.utilities.ID.getAssetID(classificationID, immutables)

}
