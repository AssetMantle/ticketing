// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/types/block.proto

package com.tendermint.types;

public final class BlockProto {
  private BlockProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tendermint_types_Block_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tendermint_types_Block_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034tendermint/types/block.proto\022\020tendermi" +
      "nt.types\032\024gogoproto/gogo.proto\032\034tendermi" +
      "nt/types/types.proto\032\037tendermint/types/e" +
      "vidence.proto\"\356\001\n\005Block\0226\n\006header\030\001 \001(\0132" +
      "\030.tendermint.types.HeaderB\004\310\336\037\000R\006header\022" +
      "0\n\004data\030\002 \001(\0132\026.tendermint.types.DataB\004\310" +
      "\336\037\000R\004data\022@\n\010evidence\030\003 \001(\0132\036.tendermint" +
      ".types.EvidenceListB\004\310\336\037\000R\010evidence\0229\n\013l" +
      "ast_commit\030\004 \001(\0132\030.tendermint.types.Comm" +
      "itR\nlastCommitB\274\001\n\024com.tendermint.typesB" +
      "\nBlockProtoP\001Z7github.com/tendermint/ten" +
      "dermint/proto/tendermint/types\242\002\003TTX\252\002\020T" +
      "endermint.Types\312\002\020Tendermint\\Types\342\002\034Ten" +
      "dermint\\Types\\GPBMetadata\352\002\021Tendermint::" +
      "Typesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.gogoproto.GogoProto.getDescriptor(),
          com.tendermint.types.TypesProto.getDescriptor(),
          com.tendermint.types.EvidenceProto.getDescriptor(),
        });
    internal_static_tendermint_types_Block_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tendermint_types_Block_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tendermint_types_Block_descriptor,
        new java.lang.String[] { "Header", "Data", "Evidence", "LastCommit", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.gogoproto.GogoProto.nullable);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.gogoproto.GogoProto.getDescriptor();
    com.tendermint.types.TypesProto.getDescriptor();
    com.tendermint.types.EvidenceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
