// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: maintainers/genesis/genesis.proto

package com.assetmantle.modules.maintainers.genesis;

public final class GenesisProto {
  private GenesisProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assetmantle_modules_maintainers_genesis_Genesis_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assetmantle_modules_maintainers_genesis_Genesis_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!maintainers/genesis/genesis.proto\022\'ass" +
      "etmantle.modules.maintainers.genesis\032\024go" +
      "goproto/gogo.proto\032\037maintainers/record/r" +
      "ecord.proto\032\037lists/base/parameter_list.p" +
      "roto\"\256\001\n\007Genesis\022H\n\007records\030\001 \003(\0132..asse" +
      "tmantle.modules.maintainers.record.Recor" +
      "dR\007records\022S\n\016parameter_list\030\002 \001(\0132,.ass" +
      "etmantle.schema.lists.base.ParameterList" +
      "R\rparameterList:\004\210\240\037\000B\261\002\n+com.assetmantl" +
      "e.modules.maintainers.genesisB\014GenesisPr" +
      "otoP\001Z4github.com/AssetMantle/modules/x/" +
      "maintainers/genesis\242\002\004AMMG\252\002\'Assetmantle" +
      ".Modules.Maintainers.Genesis\312\002\'Assetmant" +
      "le\\Modules\\Maintainers\\Genesis\342\0023Assetma" +
      "ntle\\Modules\\Maintainers\\Genesis\\GPBMeta" +
      "data\352\002*Assetmantle::Modules::Maintainers" +
      "::Genesisb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.gogoproto.GogoProto.getDescriptor(),
          com.assetmantle.modules.maintainers.record.RecordProto.getDescriptor(),
          com.assetmantle.schema.lists.base.ParameterListProto.getDescriptor(),
        });
    internal_static_assetmantle_modules_maintainers_genesis_Genesis_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_assetmantle_modules_maintainers_genesis_Genesis_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assetmantle_modules_maintainers_genesis_Genesis_descriptor,
        new java.lang.String[] { "Records", "ParameterList", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.gogoproto.GogoProto.goprotoGetters);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.gogoproto.GogoProto.getDescriptor();
    com.assetmantle.modules.maintainers.record.RecordProto.getDescriptor();
    com.assetmantle.schema.lists.base.ParameterListProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
