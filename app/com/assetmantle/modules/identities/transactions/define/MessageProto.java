// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: identities/transactions/define/message.proto

package com.assetmantle.modules.identities.transactions.define;

public final class MessageProto {
  private MessageProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assetmantle_modules_identities_transactions_define_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assetmantle_modules_identities_transactions_define_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n,identities/transactions/define/message" +
      ".proto\0222assetmantle.modules.identities.t" +
      "ransactions.define\032\032ids/base/identity_id" +
      ".proto\032\036lists/base/property_list.proto\"\352" +
      "\003\n\007Message\022\022\n\004from\030\001 \001(\tR\004from\022A\n\010from_i" +
      "_d\030\002 \001(\0132\'.assetmantle.schema.ids.base.I" +
      "dentityIDR\006fromID\022g\n\031immutable_meta_prop" +
      "erties\030\003 \001(\0132+.assetmantle.schema.lists." +
      "base.PropertyListR\027immutableMetaProperti" +
      "es\022^\n\024immutable_properties\030\004 \001(\0132+.asset" +
      "mantle.schema.lists.base.PropertyListR\023i" +
      "mmutableProperties\022c\n\027mutable_meta_prope" +
      "rties\030\005 \001(\0132+.assetmantle.schema.lists.b" +
      "ase.PropertyListR\025mutableMetaProperties\022" +
      "Z\n\022mutable_properties\030\006 \001(\0132+.assetmantl" +
      "e.schema.lists.base.PropertyListR\021mutabl" +
      "ePropertiesB\365\002\n6com.assetmantle.modules." +
      "identities.transactions.defineB\014MessageP" +
      "rotoP\001Z?github.com/AssetMantle/modules/x" +
      "/identities/transactions/define\242\002\005AMITD\252" +
      "\0022Assetmantle.Modules.Identities.Transac" +
      "tions.Define\312\0022Assetmantle\\Modules\\Ident" +
      "ities\\Transactions\\Define\342\002>Assetmantle\\" +
      "Modules\\Identities\\Transactions\\Define\\G" +
      "PBMetadata\352\0026Assetmantle::Modules::Ident" +
      "ities::Transactions::Defineb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.assetmantle.schema.ids.base.IdentityIdProto.getDescriptor(),
          com.assetmantle.schema.lists.base.PropertyListProto.getDescriptor(),
        });
    internal_static_assetmantle_modules_identities_transactions_define_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_assetmantle_modules_identities_transactions_define_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assetmantle_modules_identities_transactions_define_Message_descriptor,
        new java.lang.String[] { "From", "FromID", "ImmutableMetaProperties", "ImmutableProperties", "MutableMetaProperties", "MutableProperties", });
    com.assetmantle.schema.ids.base.IdentityIdProto.getDescriptor();
    com.assetmantle.schema.lists.base.PropertyListProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
