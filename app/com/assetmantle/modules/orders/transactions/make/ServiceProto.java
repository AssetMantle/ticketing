// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: orders/transactions/make/service.proto

package com.assetmantle.modules.orders.transactions.make;

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
      "\n&orders/transactions/make/service.proto" +
      "\022,assetmantle.modules.orders.transaction" +
      "s.make\032\034google/api/annotations.proto\032&or" +
      "ders/transactions/make/message.proto\0323or" +
      "ders/transactions/make/transaction_respo" +
      "nse.proto2\247\001\n\003Msg\022\237\001\n\006Handle\0225.assetmant" +
      "le.modules.orders.transactions.make.Mess" +
      "age\032A.assetmantle.modules.orders.transac" +
      "tions.make.TransactionResponse\"\033\202\323\344\223\002\025\"\023" +
      "/mantle/orders/makeB\321\002\n0com.assetmantle." +
      "modules.orders.transactions.makeB\014Servic" +
      "eProtoP\001Z9github.com/AssetMantle/modules" +
      "/x/orders/transactions/make\242\002\005AMOTM\252\002,As" +
      "setmantle.Modules.Orders.Transactions.Ma" +
      "ke\312\002,Assetmantle\\Modules\\Orders\\Transact" +
      "ions\\Make\342\0028Assetmantle\\Modules\\Orders\\T" +
      "ransactions\\Make\\GPBMetadata\352\0020Assetmant" +
      "le::Modules::Orders::Transactions::Makeb" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.assetmantle.modules.orders.transactions.make.MessageProto.getDescriptor(),
          com.assetmantle.modules.orders.transactions.make.TransactionResponseProto.getDescriptor(),
        });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.assetmantle.modules.orders.transactions.make.MessageProto.getDescriptor();
    com.assetmantle.modules.orders.transactions.make.TransactionResponseProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
