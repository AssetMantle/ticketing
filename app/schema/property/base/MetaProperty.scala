package schema.property.base

import com.assetmantle.schema.data.base.AnyData
import com.assetmantle.schema.properties.base.{AnyProperty, MetaProperty => protoMetaProperty}
import schema.data.Data
import schema.id.base.{DataID, PropertyID, StringID}
import schema.property.Property

case class MetaProperty(id: PropertyID, data: Data) extends Property {

  require(this.id.typeID.value == this.data.getType.value, "META_PROPERTY_TYPE_ID_AND_DATA_TYPE_MISMATCH")

  def getID: PropertyID = this.id

  def getBondedWeight: Int = this.getData.getBondWeight

  def getData: Data = this.data

  def getAnyData: AnyData = this.data.toAnyData

  def getDataID: DataID = this.getData.getDataID

  def getKey: StringID = this.id.keyID

  def getType: StringID = this.getData.getType

  def isMeta: Boolean = true

  def isMesa: Boolean = false

  def asProtoMetaProperty: protoMetaProperty = protoMetaProperty.newBuilder().setID(this.id.asProtoPropertyID).setData(this.data.toAnyData).build()

  def toAnyProperty: AnyProperty = AnyProperty.newBuilder().setMetaProperty(this.asProtoMetaProperty).build()

  def scrub(): MesaProperty = MesaProperty(id = this.id, dataID = this.getDataID)

  def getProtoBytes: Array[Byte] = this.asProtoMetaProperty.toByteString.toByteArray

  def mutate(data: Data): Property = MetaProperty(id = this.id, data = data)
}

object MetaProperty {

  def apply(value: protoMetaProperty): MetaProperty = MetaProperty(id = PropertyID(value.getID), data = Data(value.getData))

  def apply(protoBytes: Array[Byte]): MetaProperty = MetaProperty(protoMetaProperty.parseFrom(protoBytes))

  def apply(keyID: StringID, data: Data): MetaProperty = MetaProperty(id = PropertyID(keyID = keyID, typeID = data.getType), data = data)

}