// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: identities/transactions/provision/service.proto

package com.assetmantle.modules.identities.transactions.provision;

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
      "\n/identities/transactions/provision/serv" +
      "ice.proto\0225assetmantle.modules.identitie" +
      "s.transactions.provision\032\034google/api/ann" +
      "otations.proto\032/identities/transactions/" +
      "provision/message.proto\032<identities/tran" +
      "sactions/provision/transaction_response." +
      "proto2\302\001\n\003Msg\022\272\001\n\006Handle\022>.assetmantle.m" +
      "odules.identities.transactions.provision" +
      ".Message\032J.assetmantle.modules.identitie" +
      "s.transactions.provision.TransactionResp" +
      "onse\"$\202\323\344\223\002\036\"\034/mantle/identities/provisi" +
      "onB\207\003\n9com.assetmantle.modules.identitie" +
      "s.transactions.provisionB\014ServiceProtoP\001" +
      "ZBgithub.com/AssetMantle/modules/x/ident" +
      "ities/transactions/provision\242\002\005AMITP\252\0025A" +
      "ssetmantle.Modules.Identities.Transactio" +
      "ns.Provision\312\0025Assetmantle\\Modules\\Ident" +
      "ities\\Transactions\\Provision\342\002AAssetmant" +
      "le\\Modules\\Identities\\Transactions\\Provi" +
      "sion\\GPBMetadata\352\0029Assetmantle::Modules:" +
      ":Identities::Transactions::Provisionb\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.assetmantle.modules.identities.transactions.provision.MessageProto.getDescriptor(),
          com.assetmantle.modules.identities.transactions.provision.TransactionResponseProto.getDescriptor(),
        });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.assetmantle.modules.identities.transactions.provision.MessageProto.getDescriptor();
    com.assetmantle.modules.identities.transactions.provision.TransactionResponseProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
