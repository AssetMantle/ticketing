// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/applications/fee/v1/query.proto

package com.ibc.applications.fee.v1;

public interface QueryPayeeRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ibc.applications.fee.v1.QueryPayeeRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * unique channel identifier
   * </pre>
   *
   * <code>string channel_id = 1 [json_name = "channelId", (.gogoproto.moretags) = "yaml:&#92;"channel_id&#92;""];</code>
   * @return The channelId.
   */
  java.lang.String getChannelId();
  /**
   * <pre>
   * unique channel identifier
   * </pre>
   *
   * <code>string channel_id = 1 [json_name = "channelId", (.gogoproto.moretags) = "yaml:&#92;"channel_id&#92;""];</code>
   * @return The bytes for channelId.
   */
  com.google.protobuf.ByteString
      getChannelIdBytes();

  /**
   * <pre>
   * the relayer address to which the distribution address is registered
   * </pre>
   *
   * <code>string relayer = 2 [json_name = "relayer"];</code>
   * @return The relayer.
   */
  java.lang.String getRelayer();
  /**
   * <pre>
   * the relayer address to which the distribution address is registered
   * </pre>
   *
   * <code>string relayer = 2 [json_name = "relayer"];</code>
   * @return The bytes for relayer.
   */
  com.google.protobuf.ByteString
      getRelayerBytes();
}
