// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/crisis/v1beta1/genesis.proto

package com.cosmos.crisis.v1beta1;

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
    internal_static_cosmos_crisis_v1beta1_GenesisState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_crisis_v1beta1_GenesisState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n#cosmos/crisis/v1beta1/genesis.proto\022\025c" +
      "osmos.crisis.v1beta1\032\024gogoproto/gogo.pro" +
      "to\032\036cosmos/base/v1beta1/coin.proto\"i\n\014Ge" +
      "nesisState\022Y\n\014constant_fee\030\003 \001(\0132\031.cosmo" +
      "s.base.v1beta1.CoinB\033\310\336\037\000\362\336\037\023yaml:\"const" +
      "ant_fee\"R\013constantFeeB\314\001\n\031com.cosmos.cri" +
      "sis.v1beta1B\014GenesisProtoP\001Z+github.com/" +
      "cosmos/cosmos-sdk/x/crisis/types\242\002\003CCX\252\002" +
      "\025Cosmos.Crisis.V1beta1\312\002\025Cosmos\\Crisis\\V" +
      "1beta1\342\002!Cosmos\\Crisis\\V1beta1\\GPBMetada" +
      "ta\352\002\027Cosmos::Crisis::V1beta1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.gogoproto.GogoProto.getDescriptor(),
          com.cosmos.base.v1beta1.CoinProto.getDescriptor(),
        });
    internal_static_cosmos_crisis_v1beta1_GenesisState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cosmos_crisis_v1beta1_GenesisState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_crisis_v1beta1_GenesisState_descriptor,
        new java.lang.String[] { "ConstantFee", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.gogoproto.GogoProto.moretags);
    registry.add(com.gogoproto.GogoProto.nullable);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.gogoproto.GogoProto.getDescriptor();
    com.cosmos.base.v1beta1.CoinProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
