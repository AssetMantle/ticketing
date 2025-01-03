// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/applications/fee/v1/query.proto

package com.ibc.applications.fee.v1;

public interface QueryIncentivizedPacketsForChannelResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ibc.applications.fee.v1.QueryIncentivizedPacketsForChannelResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Map of all incentivized_packets
   * </pre>
   *
   * <code>repeated .ibc.applications.fee.v1.IdentifiedPacketFees incentivized_packets = 1 [json_name = "incentivizedPackets"];</code>
   */
  java.util.List<com.ibc.applications.fee.v1.IdentifiedPacketFees> 
      getIncentivizedPacketsList();
  /**
   * <pre>
   * Map of all incentivized_packets
   * </pre>
   *
   * <code>repeated .ibc.applications.fee.v1.IdentifiedPacketFees incentivized_packets = 1 [json_name = "incentivizedPackets"];</code>
   */
  com.ibc.applications.fee.v1.IdentifiedPacketFees getIncentivizedPackets(int index);
  /**
   * <pre>
   * Map of all incentivized_packets
   * </pre>
   *
   * <code>repeated .ibc.applications.fee.v1.IdentifiedPacketFees incentivized_packets = 1 [json_name = "incentivizedPackets"];</code>
   */
  int getIncentivizedPacketsCount();
  /**
   * <pre>
   * Map of all incentivized_packets
   * </pre>
   *
   * <code>repeated .ibc.applications.fee.v1.IdentifiedPacketFees incentivized_packets = 1 [json_name = "incentivizedPackets"];</code>
   */
  java.util.List<? extends com.ibc.applications.fee.v1.IdentifiedPacketFeesOrBuilder> 
      getIncentivizedPacketsOrBuilderList();
  /**
   * <pre>
   * Map of all incentivized_packets
   * </pre>
   *
   * <code>repeated .ibc.applications.fee.v1.IdentifiedPacketFees incentivized_packets = 1 [json_name = "incentivizedPackets"];</code>
   */
  com.ibc.applications.fee.v1.IdentifiedPacketFeesOrBuilder getIncentivizedPacketsOrBuilder(
      int index);
}
