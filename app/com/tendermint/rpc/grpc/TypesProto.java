// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/rpc/grpc/types.proto

package com.tendermint.rpc.grpc;

public final class TypesProto {
  private TypesProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tendermint_rpc_grpc_RequestPing_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tendermint_rpc_grpc_RequestPing_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tendermint_rpc_grpc_RequestBroadcastTx_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tendermint_rpc_grpc_RequestBroadcastTx_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tendermint_rpc_grpc_ResponsePing_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tendermint_rpc_grpc_ResponsePing_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tendermint_rpc_grpc_ResponseBroadcastTx_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tendermint_rpc_grpc_ResponseBroadcastTx_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\037tendermint/rpc/grpc/types.proto\022\023tende" +
      "rmint.rpc.grpc\032\033tendermint/abci/types.pr" +
      "oto\"\r\n\013RequestPing\"$\n\022RequestBroadcastTx" +
      "\022\016\n\002tx\030\001 \001(\014R\002tx\"\016\n\014ResponsePing\"\225\001\n\023Res" +
      "ponseBroadcastTx\022;\n\010check_tx\030\001 \001(\0132 .ten" +
      "dermint.abci.ResponseCheckTxR\007checkTx\022A\n" +
      "\ndeliver_tx\030\002 \001(\0132\".tendermint.abci.Resp" +
      "onseDeliverTxR\tdeliverTx2\275\001\n\014BroadcastAP" +
      "I\022K\n\004Ping\022 .tendermint.rpc.grpc.RequestP" +
      "ing\032!.tendermint.rpc.grpc.ResponsePing\022`" +
      "\n\013BroadcastTx\022\'.tendermint.rpc.grpc.Requ" +
      "estBroadcastTx\032(.tendermint.rpc.grpc.Res" +
      "ponseBroadcastTxB\307\001\n\027com.tendermint.rpc." +
      "grpcB\nTypesProtoP\001Z2github.com/tendermin" +
      "t/tendermint/rpc/grpc;coregrpc\242\002\003TRG\252\002\023T" +
      "endermint.Rpc.Grpc\312\002\023Tendermint\\Rpc\\Grpc" +
      "\342\002\037Tendermint\\Rpc\\Grpc\\GPBMetadata\352\002\025Ten" +
      "dermint::Rpc::Grpcb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.tendermint.abci.TypesProto.getDescriptor(),
        });
    internal_static_tendermint_rpc_grpc_RequestPing_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tendermint_rpc_grpc_RequestPing_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tendermint_rpc_grpc_RequestPing_descriptor,
        new java.lang.String[] { });
    internal_static_tendermint_rpc_grpc_RequestBroadcastTx_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_tendermint_rpc_grpc_RequestBroadcastTx_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tendermint_rpc_grpc_RequestBroadcastTx_descriptor,
        new java.lang.String[] { "Tx", });
    internal_static_tendermint_rpc_grpc_ResponsePing_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_tendermint_rpc_grpc_ResponsePing_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tendermint_rpc_grpc_ResponsePing_descriptor,
        new java.lang.String[] { });
    internal_static_tendermint_rpc_grpc_ResponseBroadcastTx_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_tendermint_rpc_grpc_ResponseBroadcastTx_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tendermint_rpc_grpc_ResponseBroadcastTx_descriptor,
        new java.lang.String[] { "CheckTx", "DeliverTx", });
    com.tendermint.abci.TypesProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
