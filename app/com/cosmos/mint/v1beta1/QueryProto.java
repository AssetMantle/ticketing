// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/mint/v1beta1/query.proto

package com.cosmos.mint.v1beta1;

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
    internal_static_cosmos_mint_v1beta1_QueryParamsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_mint_v1beta1_QueryParamsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_mint_v1beta1_QueryParamsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_mint_v1beta1_QueryParamsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_mint_v1beta1_QueryInflationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_mint_v1beta1_QueryInflationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_mint_v1beta1_QueryInflationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_mint_v1beta1_QueryInflationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\037cosmos/mint/v1beta1/query.proto\022\023cosmo" +
      "s.mint.v1beta1\032\024gogoproto/gogo.proto\032\034go" +
      "ogle/api/annotations.proto\032\036cosmos/mint/" +
      "v1beta1/mint.proto\"\024\n\022QueryParamsRequest" +
      "\"P\n\023QueryParamsResponse\0229\n\006params\030\001 \001(\0132" +
      "\033.cosmos.mint.v1beta1.ParamsB\004\310\336\037\000R\006para" +
      "ms\"\027\n\025QueryInflationRequest\"f\n\026QueryInfl" +
      "ationResponse\022L\n\tinflation\030\001 \001(\014B.\310\336\037\000\332\336" +
      "\037&github.com/cosmos/cosmos-sdk/types.Dec" +
      "R\tinflation\"\036\n\034QueryAnnualProvisionsRequ" +
      "est\"|\n\035QueryAnnualProvisionsResponse\022[\n\021" +
      "annual_provisions\030\001 \001(\014B.\310\336\037\000\332\336\037&github." +
      "com/cosmos/cosmos-sdk/types.DecR\020annualP" +
      "rovisions2\305\003\n\005Query\022\200\001\n\006Params\022\'.cosmos." +
      "mint.v1beta1.QueryParamsRequest\032(.cosmos" +
      ".mint.v1beta1.QueryParamsResponse\"#\202\323\344\223\002" +
      "\035\022\033/cosmos/mint/v1beta1/params\022\214\001\n\tInfla" +
      "tion\022*.cosmos.mint.v1beta1.QueryInflatio" +
      "nRequest\032+.cosmos.mint.v1beta1.QueryInfl" +
      "ationResponse\"&\202\323\344\223\002 \022\036/cosmos/mint/v1be" +
      "ta1/inflation\022\251\001\n\020AnnualProvisions\0221.cos" +
      "mos.mint.v1beta1.QueryAnnualProvisionsRe" +
      "quest\0322.cosmos.mint.v1beta1.QueryAnnualP" +
      "rovisionsResponse\".\202\323\344\223\002(\022&/cosmos/mint/" +
      "v1beta1/annual_provisionsB\276\001\n\027com.cosmos" +
      ".mint.v1beta1B\nQueryProtoP\001Z)github.com/" +
      "cosmos/cosmos-sdk/x/mint/types\242\002\003CMX\252\002\023C" +
      "osmos.Mint.V1beta1\312\002\023Cosmos\\Mint\\V1beta1" +
      "\342\002\037Cosmos\\Mint\\V1beta1\\GPBMetadata\352\002\025Cos" +
      "mos::Mint::V1beta1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.gogoproto.GogoProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
          com.cosmos.mint.v1beta1.MintProto.getDescriptor(),
        });
    internal_static_cosmos_mint_v1beta1_QueryParamsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cosmos_mint_v1beta1_QueryParamsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_mint_v1beta1_QueryParamsRequest_descriptor,
        new java.lang.String[] { });
    internal_static_cosmos_mint_v1beta1_QueryParamsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_cosmos_mint_v1beta1_QueryParamsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_mint_v1beta1_QueryParamsResponse_descriptor,
        new java.lang.String[] { "Params", });
    internal_static_cosmos_mint_v1beta1_QueryInflationRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_cosmos_mint_v1beta1_QueryInflationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_mint_v1beta1_QueryInflationRequest_descriptor,
        new java.lang.String[] { });
    internal_static_cosmos_mint_v1beta1_QueryInflationResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_cosmos_mint_v1beta1_QueryInflationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_mint_v1beta1_QueryInflationResponse_descriptor,
        new java.lang.String[] { "Inflation", });
    internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsRequest_descriptor,
        new java.lang.String[] { });
    internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_mint_v1beta1_QueryAnnualProvisionsResponse_descriptor,
        new java.lang.String[] { "AnnualProvisions", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.gogoproto.GogoProto.customtype);
    registry.add(com.gogoproto.GogoProto.nullable);
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.gogoproto.GogoProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
    com.cosmos.mint.v1beta1.MintProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}