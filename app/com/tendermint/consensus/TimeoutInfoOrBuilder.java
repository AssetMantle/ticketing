// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/consensus/wal.proto

package com.tendermint.consensus;

public interface TimeoutInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tendermint.consensus.TimeoutInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Duration duration = 1 [json_name = "duration", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true];</code>
   * @return Whether the duration field is set.
   */
  boolean hasDuration();
  /**
   * <code>.google.protobuf.Duration duration = 1 [json_name = "duration", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true];</code>
   * @return The duration.
   */
  com.google.protobuf.Duration getDuration();
  /**
   * <code>.google.protobuf.Duration duration = 1 [json_name = "duration", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true];</code>
   */
  com.google.protobuf.DurationOrBuilder getDurationOrBuilder();

  /**
   * <code>int64 height = 2 [json_name = "height"];</code>
   * @return The height.
   */
  long getHeight();

  /**
   * <code>int32 round = 3 [json_name = "round"];</code>
   * @return The round.
   */
  int getRound();

  /**
   * <code>uint32 step = 4 [json_name = "step"];</code>
   * @return The step.
   */
  int getStep();
}
