// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: metas/transactions/reveal/message.proto

package com.assetmantle.modules.metas.transactions.reveal;

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
    internal_static_assetmantle_modules_metas_transactions_reveal_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assetmantle_modules_metas_transactions_reveal_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\'metas/transactions/reveal/message.prot" +
      "o\022-assetmantle.modules.metas.transaction" +
      "s.reveal\032\030data/base/any_data.proto\"X\n\007Me" +
      "ssage\022\022\n\004from\030\001 \001(\tR\004from\0229\n\004data\030\002 \001(\0132" +
      "%.assetmantle.schema.data.base.AnyDataR\004" +
      "dataB\327\002\n1com.assetmantle.modules.metas.t" +
      "ransactions.revealB\014MessageProtoP\001Z:gith" +
      "ub.com/AssetMantle/modules/x/metas/trans" +
      "actions/reveal\242\002\005AMMTR\252\002-Assetmantle.Mod" +
      "ules.Metas.Transactions.Reveal\312\002-Assetma" +
      "ntle\\Modules\\Metas\\Transactions\\Reveal\342\002" +
      "9Assetmantle\\Modules\\Metas\\Transactions\\" +
      "Reveal\\GPBMetadata\352\0021Assetmantle::Module" +
      "s::Metas::Transactions::Revealb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.assetmantle.schema.data.base.AnyDataProto.getDescriptor(),
        });
    internal_static_assetmantle_modules_metas_transactions_reveal_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_assetmantle_modules_metas_transactions_reveal_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assetmantle_modules_metas_transactions_reveal_Message_descriptor,
        new java.lang.String[] { "From", "Data", });
    com.assetmantle.schema.data.base.AnyDataProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
