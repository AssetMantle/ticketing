// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/applications/transfer/v1/genesis.proto

package com.ibc.applications.transfer.v1;

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
    internal_static_ibc_applications_transfer_v1_GenesisState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_applications_transfer_v1_GenesisState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n*ibc/applications/transfer/v1/genesis.p" +
      "roto\022\034ibc.applications.transfer.v1\032+ibc/" +
      "applications/transfer/v1/transfer.proto\032" +
      "\024gogoproto/gogo.proto\"\363\001\n\014GenesisState\022+" +
      "\n\007port_id\030\001 \001(\tB\022\362\336\037\016yaml:\"port_id\"R\006por" +
      "tId\022r\n\014denom_traces\030\002 \003(\0132(.ibc.applicat" +
      "ions.transfer.v1.DenomTraceB%\310\336\037\000\362\336\037\023yam" +
      "l:\"denom_traces\"\252\337\037\006TracesR\013denomTraces\022" +
      "B\n\006params\030\003 \001(\0132$.ibc.applications.trans" +
      "fer.v1.ParamsB\004\310\336\037\000R\006paramsB\374\001\n com.ibc." +
      "applications.transfer.v1B\014GenesisProtoP\001" +
      "Z7github.com/cosmos/ibc-go/v4/modules/ap" +
      "ps/transfer/types\242\002\003IAT\252\002\034Ibc.Applicatio" +
      "ns.Transfer.V1\312\002\034Ibc\\Applications\\Transf" +
      "er\\V1\342\002(Ibc\\Applications\\Transfer\\V1\\GPB" +
      "Metadata\352\002\037Ibc::Applications::Transfer::" +
      "V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.ibc.applications.transfer.v1.TransferProto.getDescriptor(),
          com.gogoproto.GogoProto.getDescriptor(),
        });
    internal_static_ibc_applications_transfer_v1_GenesisState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ibc_applications_transfer_v1_GenesisState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_applications_transfer_v1_GenesisState_descriptor,
        new java.lang.String[] { "PortId", "DenomTraces", "Params", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.gogoproto.GogoProto.castrepeated);
    registry.add(com.gogoproto.GogoProto.moretags);
    registry.add(com.gogoproto.GogoProto.nullable);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.ibc.applications.transfer.v1.TransferProto.getDescriptor();
    com.gogoproto.GogoProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}