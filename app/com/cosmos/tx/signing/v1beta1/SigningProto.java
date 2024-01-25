// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/tx/signing/v1beta1/signing.proto

package com.cosmos.tx.signing.v1beta1;

public final class SigningProto {
  private SigningProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptors_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptors_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Single_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Single_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Multi_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Multi_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\'cosmos/tx/signing/v1beta1/signing.prot" +
      "o\022\031cosmos.tx.signing.v1beta1\032-cosmos/cry" +
      "pto/multisig/v1beta1/multisig.proto\032\031goo" +
      "gle/protobuf/any.proto\"f\n\024SignatureDescr" +
      "iptors\022N\n\nsignatures\030\001 \003(\0132..cosmos.tx.s" +
      "igning.v1beta1.SignatureDescriptorR\nsign" +
      "atures\"\365\004\n\023SignatureDescriptor\0223\n\npublic" +
      "_key\030\001 \001(\0132\024.google.protobuf.AnyR\tpublic" +
      "Key\022G\n\004data\030\002 \001(\01323.cosmos.tx.signing.v1" +
      "beta1.SignatureDescriptor.DataR\004data\022\032\n\010" +
      "sequence\030\003 \001(\004R\010sequence\032\303\003\n\004Data\022T\n\006sin" +
      "gle\030\001 \001(\0132:.cosmos.tx.signing.v1beta1.Si" +
      "gnatureDescriptor.Data.SingleH\000R\006single\022" +
      "Q\n\005multi\030\002 \001(\01329.cosmos.tx.signing.v1bet" +
      "a1.SignatureDescriptor.Data.MultiH\000R\005mul" +
      "ti\032_\n\006Single\0227\n\004mode\030\001 \001(\0162#.cosmos.tx.s" +
      "igning.v1beta1.SignModeR\004mode\022\034\n\tsignatu" +
      "re\030\002 \001(\014R\tsignature\032\251\001\n\005Multi\022K\n\010bitarra" +
      "y\030\001 \001(\0132/.cosmos.crypto.multisig.v1beta1" +
      ".CompactBitArrayR\010bitarray\022S\n\nsignatures" +
      "\030\002 \003(\01323.cosmos.tx.signing.v1beta1.Signa" +
      "tureDescriptor.DataR\nsignaturesB\005\n\003sum*\213" +
      "\001\n\010SignMode\022\031\n\025SIGN_MODE_UNSPECIFIED\020\000\022\024" +
      "\n\020SIGN_MODE_DIRECT\020\001\022\025\n\021SIGN_MODE_TEXTUA" +
      "L\020\002\022\037\n\033SIGN_MODE_LEGACY_AMINO_JSON\020\177\022\026\n\021" +
      "SIGN_MODE_EIP_191\020\277\001B\343\001\n\035com.cosmos.tx.s" +
      "igning.v1beta1B\014SigningProtoP\001Z-github.c" +
      "om/cosmos/cosmos-sdk/types/tx/signing\242\002\003" +
      "CTS\252\002\031Cosmos.Tx.Signing.V1beta1\312\002\031Cosmos" +
      "\\Tx\\Signing\\V1beta1\342\002%Cosmos\\Tx\\Signing\\" +
      "V1beta1\\GPBMetadata\352\002\034Cosmos::Tx::Signin" +
      "g::V1beta1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.cosmos.crypto.multisig.v1beta1.MultisigProto.getDescriptor(),
          com.google.protobuf.AnyProto.getDescriptor(),
        });
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptors_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptors_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptors_descriptor,
        new java.lang.String[] { "Signatures", });
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_descriptor,
        new java.lang.String[] { "PublicKey", "Data", "Sequence", });
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_descriptor =
      internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_descriptor.getNestedTypes().get(0);
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_descriptor,
        new java.lang.String[] { "Single", "Multi", "Sum", });
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Single_descriptor =
      internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_descriptor.getNestedTypes().get(0);
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Single_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Single_descriptor,
        new java.lang.String[] { "Mode", "Signature", });
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Multi_descriptor =
      internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_descriptor.getNestedTypes().get(1);
    internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Multi_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_tx_signing_v1beta1_SignatureDescriptor_Data_Multi_descriptor,
        new java.lang.String[] { "Bitarray", "Signatures", });
    com.cosmos.crypto.multisig.v1beta1.MultisigProto.getDescriptor();
    com.google.protobuf.AnyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
