// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/core/channel/v1/tx.proto

package com.ibc.core.channel.v1;

public interface MsgChannelOpenInitResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ibc.core.channel.v1.MsgChannelOpenInitResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string channel_id = 1 [json_name = "channelId", (.gogoproto.moretags) = "yaml:&#92;"channel_id&#92;""];</code>
   * @return The channelId.
   */
  java.lang.String getChannelId();
  /**
   * <code>string channel_id = 1 [json_name = "channelId", (.gogoproto.moretags) = "yaml:&#92;"channel_id&#92;""];</code>
   * @return The bytes for channelId.
   */
  com.google.protobuf.ByteString
      getChannelIdBytes();

  /**
   * <code>string version = 2 [json_name = "version"];</code>
   * @return The version.
   */
  java.lang.String getVersion();
  /**
   * <code>string version = 2 [json_name = "version"];</code>
   * @return The bytes for version.
   */
  com.google.protobuf.ByteString
      getVersionBytes();
}
