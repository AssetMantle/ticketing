// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/params/v1beta1/query.proto

package com.cosmos.params.v1beta1;

public final class QueryProto {
  private QueryProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_params_v1beta1_QueryParamsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_params_v1beta1_QueryParamsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_params_v1beta1_QueryParamsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_params_v1beta1_QueryParamsResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!cosmos/params/v1beta1/query.proto\022\025cos" +
      "mos.params.v1beta1\032\024gogoproto/gogo.proto" +
      "\032\034google/api/annotations.proto\032\"cosmos/p" +
      "arams/v1beta1/params.proto\"B\n\022QueryParam" +
      "sRequest\022\032\n\010subspace\030\001 \001(\tR\010subspace\022\020\n\003" +
      "key\030\002 \001(\tR\003key\"U\n\023QueryParamsResponse\022>\n" +
      "\005param\030\001 \001(\0132\".cosmos.params.v1beta1.Par" +
      "amChangeB\004\310\336\037\000R\005param2\220\001\n\005Query\022\206\001\n\006Para" +
      "ms\022).cosmos.params.v1beta1.QueryParamsRe" +
      "quest\032*.cosmos.params.v1beta1.QueryParam" +
      "sResponse\"%\202\323\344\223\002\037\022\035/cosmos/params/v1beta" +
      "1/paramsB\323\001\n\031com.cosmos.params.v1beta1B\n" +
      "QueryProtoP\001Z4github.com/cosmos/cosmos-s" +
      "dk/x/params/types/proposal\242\002\003CPX\252\002\025Cosmo" +
      "s.Params.V1beta1\312\002\025Cosmos\\Params\\V1beta1" +
      "\342\002!Cosmos\\Params\\V1beta1\\GPBMetadata\352\002\027C" +
      "osmos::Params::V1beta1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.gogoproto.GogoProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.cosmos.params.v1beta1.ParamsProto.getDescriptor(),
        });
    internal_static_cosmos_params_v1beta1_QueryParamsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cosmos_params_v1beta1_QueryParamsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_params_v1beta1_QueryParamsRequest_descriptor,
        new java.lang.String[] { "Subspace", "Key", });
    internal_static_cosmos_params_v1beta1_QueryParamsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_cosmos_params_v1beta1_QueryParamsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_params_v1beta1_QueryParamsResponse_descriptor,
        new java.lang.String[] { "Param", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.gogoproto.GogoProto.nullable);
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.gogoproto.GogoProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.cosmos.params.v1beta1.ParamsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
