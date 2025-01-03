// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/applications/fee/v1/query.proto

package com.ibc.applications.fee.v1;

public interface QueryIncentivizedPacketResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ibc.applications.fee.v1.QueryIncentivizedPacketResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * the identified fees for the incentivized packet
   * </pre>
   *
   * <code>.ibc.applications.fee.v1.IdentifiedPacketFees incentivized_packet = 1 [json_name = "incentivizedPacket", (.gogoproto.nullable) = false];</code>
   * @return Whether the incentivizedPacket field is set.
   */
  boolean hasIncentivizedPacket();
  /**
   * <pre>
   * the identified fees for the incentivized packet
   * </pre>
   *
   * <code>.ibc.applications.fee.v1.IdentifiedPacketFees incentivized_packet = 1 [json_name = "incentivizedPacket", (.gogoproto.nullable) = false];</code>
   * @return The incentivizedPacket.
   */
  com.ibc.applications.fee.v1.IdentifiedPacketFees getIncentivizedPacket();
  /**
   * <pre>
   * the identified fees for the incentivized packet
   * </pre>
   *
   * <code>.ibc.applications.fee.v1.IdentifiedPacketFees incentivized_packet = 1 [json_name = "incentivizedPacket", (.gogoproto.nullable) = false];</code>
   */
  com.ibc.applications.fee.v1.IdentifiedPacketFeesOrBuilder getIncentivizedPacketOrBuilder();
}
