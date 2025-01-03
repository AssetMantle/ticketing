// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/lightclients/solomachine/v1/solomachine.proto

package com.ibc.lightclients.solomachine.v1;

public final class SolomachineProto {
  private SolomachineProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_ClientState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_ClientState_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_ConsensusState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_ConsensusState_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_Header_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_Header_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_Misbehaviour_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_Misbehaviour_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_SignatureAndData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_SignatureAndData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_TimestampedSignatureData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_TimestampedSignatureData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_SignBytes_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_SignBytes_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_HeaderData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_HeaderData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_ClientStateData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_ClientStateData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_ConsensusStateData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_ConsensusStateData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_ConnectionStateData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_ConnectionStateData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_ChannelStateData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_ChannelStateData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_PacketCommitmentData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_PacketCommitmentData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_PacketAcknowledgementData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_PacketAcknowledgementData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_PacketReceiptAbsenceData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_PacketReceiptAbsenceData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ibc_lightclients_solomachine_v1_NextSequenceRecvData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ibc_lightclients_solomachine_v1_NextSequenceRecvData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n1ibc/lightclients/solomachine/v1/soloma" +
      "chine.proto\022\037ibc.lightclients.solomachin" +
      "e.v1\032\'ibc/core/connection/v1/connection." +
      "proto\032!ibc/core/channel/v1/channel.proto" +
      "\032\024gogoproto/gogo.proto\032\031google/protobuf/" +
      "any.proto\"\321\002\n\013ClientState\022\032\n\010sequence\030\001 " +
      "\001(\004R\010sequence\022C\n\017frozen_sequence\030\002 \001(\004B\032" +
      "\362\336\037\026yaml:\"frozen_sequence\"R\016frozenSequen" +
      "ce\022t\n\017consensus_state\030\003 \001(\0132/.ibc.lightc" +
      "lients.solomachine.v1.ConsensusStateB\032\362\336" +
      "\037\026yaml:\"consensus_state\"R\016consensusState" +
      "\022e\n\033allow_update_after_proposal\030\004 \001(\010B&\362" +
      "\336\037\"yaml:\"allow_update_after_proposal\"R\030a" +
      "llowUpdateAfterProposal:\004\210\240\037\000\"\242\001\n\016Consen" +
      "susState\022J\n\npublic_key\030\001 \001(\0132\024.google.pr" +
      "otobuf.AnyB\025\362\336\037\021yaml:\"public_key\"R\tpubli" +
      "cKey\022 \n\013diversifier\030\002 \001(\tR\013diversifier\022\034" +
      "\n\ttimestamp\030\003 \001(\004R\ttimestamp:\004\210\240\037\000\"\202\002\n\006H" +
      "eader\022\032\n\010sequence\030\001 \001(\004R\010sequence\022\034\n\ttim" +
      "estamp\030\002 \001(\004R\ttimestamp\022\034\n\tsignature\030\003 \001" +
      "(\014R\tsignature\022U\n\016new_public_key\030\004 \001(\0132\024." +
      "google.protobuf.AnyB\031\362\336\037\025yaml:\"new_publi" +
      "c_key\"R\014newPublicKey\022C\n\017new_diversifier\030" +
      "\005 \001(\tB\032\362\336\037\026yaml:\"new_diversifier\"R\016newDi" +
      "versifier:\004\210\240\037\000\"\307\002\n\014Misbehaviour\0221\n\tclie" +
      "nt_id\030\001 \001(\tB\024\362\336\037\020yaml:\"client_id\"R\010clien" +
      "tId\022\032\n\010sequence\030\002 \001(\004R\010sequence\022p\n\rsigna" +
      "ture_one\030\003 \001(\01321.ibc.lightclients.soloma" +
      "chine.v1.SignatureAndDataB\030\362\336\037\024yaml:\"sig" +
      "nature_one\"R\014signatureOne\022p\n\rsignature_t" +
      "wo\030\004 \001(\01321.ibc.lightclients.solomachine." +
      "v1.SignatureAndDataB\030\362\336\037\024yaml:\"signature" +
      "_two\"R\014signatureTwo:\004\210\240\037\000\"\306\001\n\020SignatureA" +
      "ndData\022\034\n\tsignature\030\001 \001(\014R\tsignature\022\\\n\t" +
      "data_type\030\002 \001(\0162).ibc.lightclients.solom" +
      "achine.v1.DataTypeB\024\362\336\037\020yaml:\"data_type\"" +
      "R\010dataType\022\022\n\004data\030\003 \001(\014R\004data\022\034\n\ttimest" +
      "amp\030\004 \001(\004R\ttimestamp:\004\210\240\037\000\"\200\001\n\030Timestamp" +
      "edSignatureData\022@\n\016signature_data\030\001 \001(\014B" +
      "\031\362\336\037\025yaml:\"signature_data\"R\rsignatureDat" +
      "a\022\034\n\ttimestamp\030\002 \001(\004R\ttimestamp:\004\210\240\037\000\"\337\001" +
      "\n\tSignBytes\022\032\n\010sequence\030\001 \001(\004R\010sequence\022" +
      "\034\n\ttimestamp\030\002 \001(\004R\ttimestamp\022 \n\013diversi" +
      "fier\030\003 \001(\tR\013diversifier\022\\\n\tdata_type\030\004 \001" +
      "(\0162).ibc.lightclients.solomachine.v1.Dat" +
      "aTypeB\024\362\336\037\020yaml:\"data_type\"R\010dataType\022\022\n" +
      "\004data\030\005 \001(\014R\004data:\004\210\240\037\000\"\245\001\n\nHeaderData\022L" +
      "\n\013new_pub_key\030\001 \001(\0132\024.google.protobuf.An" +
      "yB\026\362\336\037\022yaml:\"new_pub_key\"R\tnewPubKey\022C\n\017" +
      "new_diversifier\030\002 \001(\tB\032\362\336\037\026yaml:\"new_div" +
      "ersifier\"R\016newDiversifier:\004\210\240\037\000\"}\n\017Clien" +
      "tStateData\022\022\n\004path\030\001 \001(\014R\004path\022P\n\014client" +
      "_state\030\002 \001(\0132\024.google.protobuf.AnyB\027\362\336\037\023" +
      "yaml:\"client_state\"R\013clientState:\004\210\240\037\000\"\211" +
      "\001\n\022ConsensusStateData\022\022\n\004path\030\001 \001(\014R\004pat" +
      "h\022Y\n\017consensus_state\030\002 \001(\0132\024.google.prot" +
      "obuf.AnyB\032\362\336\037\026yaml:\"consensus_state\"R\016co" +
      "nsensusState:\004\210\240\037\000\"v\n\023ConnectionStateDat" +
      "a\022\022\n\004path\030\001 \001(\014R\004path\022E\n\nconnection\030\002 \001(" +
      "\0132%.ibc.core.connection.v1.ConnectionEnd" +
      "R\nconnection:\004\210\240\037\000\"d\n\020ChannelStateData\022\022" +
      "\n\004path\030\001 \001(\014R\004path\0226\n\007channel\030\002 \001(\0132\034.ib" +
      "c.core.channel.v1.ChannelR\007channel:\004\210\240\037\000" +
      "\"J\n\024PacketCommitmentData\022\022\n\004path\030\001 \001(\014R\004" +
      "path\022\036\n\ncommitment\030\002 \001(\014R\ncommitment\"Y\n\031" +
      "PacketAcknowledgementData\022\022\n\004path\030\001 \001(\014R" +
      "\004path\022(\n\017acknowledgement\030\002 \001(\014R\017acknowle" +
      "dgement\".\n\030PacketReceiptAbsenceData\022\022\n\004p" +
      "ath\030\001 \001(\014R\004path\"h\n\024NextSequenceRecvData\022" +
      "\022\n\004path\030\001 \001(\014R\004path\022<\n\rnext_seq_recv\030\002 \001" +
      "(\004B\030\362\336\037\024yaml:\"next_seq_recv\"R\013nextSeqRec" +
      "v*\214\004\n\010DataType\0228\n#DATA_TYPE_UNINITIALIZE" +
      "D_UNSPECIFIED\020\000\032\017\212\235 \013UNSPECIFIED\022&\n\026DATA" +
      "_TYPE_CLIENT_STATE\020\001\032\n\212\235 \006CLIENT\022,\n\031DATA" +
      "_TYPE_CONSENSUS_STATE\020\002\032\r\212\235 \tCONSENSUS\022." +
      "\n\032DATA_TYPE_CONNECTION_STATE\020\003\032\016\212\235 \nCONN" +
      "ECTION\022(\n\027DATA_TYPE_CHANNEL_STATE\020\004\032\013\212\235 " +
      "\007CHANNEL\0225\n\033DATA_TYPE_PACKET_COMMITMENT\020" +
      "\005\032\024\212\235 \020PACKETCOMMITMENT\022?\n DATA_TYPE_PAC" +
      "KET_ACKNOWLEDGEMENT\020\006\032\031\212\235 \025PACKETACKNOWL" +
      "EDGEMENT\022>\n DATA_TYPE_PACKET_RECEIPT_ABS" +
      "ENCE\020\007\032\030\212\235 \024PACKETRECEIPTABSENCE\0226\n\034DATA" +
      "_TYPE_NEXT_SEQUENCE_RECV\020\010\032\024\212\235 \020NEXTSEQU" +
      "ENCERECV\022 \n\020DATA_TYPE_HEADER\020\t\032\n\212\235 \006HEAD" +
      "ER\032\004\210\243\036\000B\226\002\n#com.ibc.lightclients.soloma" +
      "chine.v1B\020SolomachineProtoP\001Z>github.com" +
      "/cosmos/ibc-go/v4/modules/core/02-client" +
      "/legacy/v100\242\002\003ILS\252\002\037Ibc.Lightclients.So" +
      "lomachine.V1\312\002\037Ibc\\Lightclients\\Solomach" +
      "ine\\V1\342\002+Ibc\\Lightclients\\Solomachine\\V1" +
      "\\GPBMetadata\352\002\"Ibc::Lightclients::Soloma" +
      "chine::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.ibc.core.connection.v1.ConnectionProto.getDescriptor(),
          com.ibc.core.channel.v1.ChannelProto.getDescriptor(),
          com.gogoproto.GogoProto.getDescriptor(),
          com.google.protobuf.AnyProto.getDescriptor(),
        });
    internal_static_ibc_lightclients_solomachine_v1_ClientState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ibc_lightclients_solomachine_v1_ClientState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_ClientState_descriptor,
        new java.lang.String[] { "Sequence", "FrozenSequence", "ConsensusState", "AllowUpdateAfterProposal", });
    internal_static_ibc_lightclients_solomachine_v1_ConsensusState_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ibc_lightclients_solomachine_v1_ConsensusState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_ConsensusState_descriptor,
        new java.lang.String[] { "PublicKey", "Diversifier", "Timestamp", });
    internal_static_ibc_lightclients_solomachine_v1_Header_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ibc_lightclients_solomachine_v1_Header_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_Header_descriptor,
        new java.lang.String[] { "Sequence", "Timestamp", "Signature", "NewPublicKey", "NewDiversifier", });
    internal_static_ibc_lightclients_solomachine_v1_Misbehaviour_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ibc_lightclients_solomachine_v1_Misbehaviour_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_Misbehaviour_descriptor,
        new java.lang.String[] { "ClientId", "Sequence", "SignatureOne", "SignatureTwo", });
    internal_static_ibc_lightclients_solomachine_v1_SignatureAndData_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ibc_lightclients_solomachine_v1_SignatureAndData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_SignatureAndData_descriptor,
        new java.lang.String[] { "Signature", "DataType", "Data", "Timestamp", });
    internal_static_ibc_lightclients_solomachine_v1_TimestampedSignatureData_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ibc_lightclients_solomachine_v1_TimestampedSignatureData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_TimestampedSignatureData_descriptor,
        new java.lang.String[] { "SignatureData", "Timestamp", });
    internal_static_ibc_lightclients_solomachine_v1_SignBytes_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ibc_lightclients_solomachine_v1_SignBytes_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_SignBytes_descriptor,
        new java.lang.String[] { "Sequence", "Timestamp", "Diversifier", "DataType", "Data", });
    internal_static_ibc_lightclients_solomachine_v1_HeaderData_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ibc_lightclients_solomachine_v1_HeaderData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_HeaderData_descriptor,
        new java.lang.String[] { "NewPubKey", "NewDiversifier", });
    internal_static_ibc_lightclients_solomachine_v1_ClientStateData_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_ibc_lightclients_solomachine_v1_ClientStateData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_ClientStateData_descriptor,
        new java.lang.String[] { "Path", "ClientState", });
    internal_static_ibc_lightclients_solomachine_v1_ConsensusStateData_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_ibc_lightclients_solomachine_v1_ConsensusStateData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_ConsensusStateData_descriptor,
        new java.lang.String[] { "Path", "ConsensusState", });
    internal_static_ibc_lightclients_solomachine_v1_ConnectionStateData_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ibc_lightclients_solomachine_v1_ConnectionStateData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_ConnectionStateData_descriptor,
        new java.lang.String[] { "Path", "Connection", });
    internal_static_ibc_lightclients_solomachine_v1_ChannelStateData_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_ibc_lightclients_solomachine_v1_ChannelStateData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_ChannelStateData_descriptor,
        new java.lang.String[] { "Path", "Channel", });
    internal_static_ibc_lightclients_solomachine_v1_PacketCommitmentData_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_ibc_lightclients_solomachine_v1_PacketCommitmentData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_PacketCommitmentData_descriptor,
        new java.lang.String[] { "Path", "Commitment", });
    internal_static_ibc_lightclients_solomachine_v1_PacketAcknowledgementData_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_ibc_lightclients_solomachine_v1_PacketAcknowledgementData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_PacketAcknowledgementData_descriptor,
        new java.lang.String[] { "Path", "Acknowledgement", });
    internal_static_ibc_lightclients_solomachine_v1_PacketReceiptAbsenceData_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_ibc_lightclients_solomachine_v1_PacketReceiptAbsenceData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_PacketReceiptAbsenceData_descriptor,
        new java.lang.String[] { "Path", });
    internal_static_ibc_lightclients_solomachine_v1_NextSequenceRecvData_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_ibc_lightclients_solomachine_v1_NextSequenceRecvData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ibc_lightclients_solomachine_v1_NextSequenceRecvData_descriptor,
        new java.lang.String[] { "Path", "NextSeqRecv", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.gogoproto.GogoProto.enumvalueCustomname);
    registry.add(com.gogoproto.GogoProto.goprotoEnumPrefix);
    registry.add(com.gogoproto.GogoProto.goprotoGetters);
    registry.add(com.gogoproto.GogoProto.moretags);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.ibc.core.connection.v1.ConnectionProto.getDescriptor();
    com.ibc.core.channel.v1.ChannelProto.getDescriptor();
    com.gogoproto.GogoProto.getDescriptor();
    com.google.protobuf.AnyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
