// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: assets/transactions/send/service.proto

package com.assetmantle.modules.assets.transactions.send;

public final class ServiceProto {
  private ServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n&assets/transactions/send/service.proto" +
      "\022,assetmantle.modules.assets.transaction" +
      "s.send\032\034google/api/annotations.proto\032&as" +
      "sets/transactions/send/message.proto\0323as" +
      "sets/transactions/send/transaction_respo" +
      "nse.proto2\247\001\n\003Msg\022\237\001\n\006Handle\0225.assetmant" +
      "le.modules.assets.transactions.send.Mess" +
      "age\032A.assetmantle.modules.assets.transac" +
      "tions.send.TransactionResponse\"\033\202\323\344\223\002\025\"\023" +
      "/mantle/assets/sendB\321\002\n0com.assetmantle." +
      "modules.assets.transactions.sendB\014Servic" +
      "eProtoP\001Z9github.com/AssetMantle/modules" +
      "/x/assets/transactions/send\242\002\005AMATS\252\002,As" +
      "setmantle.Modules.Assets.Transactions.Se" +
      "nd\312\002,Assetmantle\\Modules\\Assets\\Transact" +
      "ions\\Send\342\0028Assetmantle\\Modules\\Assets\\T" +
      "ransactions\\Send\\GPBMetadata\352\0020Assetmant" +
      "le::Modules::Assets::Transactions::Sendb" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.assetmantle.modules.assets.transactions.send.MessageProto.getDescriptor(),
          com.assetmantle.modules.assets.transactions.send.TransactionResponseProto.getDescriptor(),
        });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.assetmantle.modules.assets.transactions.send.MessageProto.getDescriptor();
    com.assetmantle.modules.assets.transactions.send.TransactionResponseProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
