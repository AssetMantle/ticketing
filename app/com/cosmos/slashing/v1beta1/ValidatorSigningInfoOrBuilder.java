// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/slashing/v1beta1/slashing.proto

package com.cosmos.slashing.v1beta1;

public interface ValidatorSigningInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.slashing.v1beta1.ValidatorSigningInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string address = 1 [json_name = "address"];</code>
   * @return The address.
   */
  java.lang.String getAddress();
  /**
   * <code>string address = 1 [json_name = "address"];</code>
   * @return The bytes for address.
   */
  com.google.protobuf.ByteString
      getAddressBytes();

  /**
   * <pre>
   * Height at which validator was first a candidate OR was unjailed
   * </pre>
   *
   * <code>int64 start_height = 2 [json_name = "startHeight", (.gogoproto.moretags) = "yaml:&#92;"start_height&#92;""];</code>
   * @return The startHeight.
   */
  long getStartHeight();

  /**
   * <pre>
   * Index which is incremented each time the validator was a bonded
   * in a block and may have signed a precommit or not. This in conjunction with the
   * `SignedBlocksWindow` param determines the index in the `MissedBlocksBitArray`.
   * </pre>
   *
   * <code>int64 index_offset = 3 [json_name = "indexOffset", (.gogoproto.moretags) = "yaml:&#92;"index_offset&#92;""];</code>
   * @return The indexOffset.
   */
  long getIndexOffset();

  /**
   * <pre>
   * Timestamp until which the validator is jailed due to liveness downtime.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp jailed_until = 4 [json_name = "jailedUntil", (.gogoproto.nullable) = false, (.gogoproto.moretags) = "yaml:&#92;"jailed_until&#92;"", (.gogoproto.stdtime) = true];</code>
   * @return Whether the jailedUntil field is set.
   */
  boolean hasJailedUntil();
  /**
   * <pre>
   * Timestamp until which the validator is jailed due to liveness downtime.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp jailed_until = 4 [json_name = "jailedUntil", (.gogoproto.nullable) = false, (.gogoproto.moretags) = "yaml:&#92;"jailed_until&#92;"", (.gogoproto.stdtime) = true];</code>
   * @return The jailedUntil.
   */
  com.google.protobuf.Timestamp getJailedUntil();
  /**
   * <pre>
   * Timestamp until which the validator is jailed due to liveness downtime.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp jailed_until = 4 [json_name = "jailedUntil", (.gogoproto.nullable) = false, (.gogoproto.moretags) = "yaml:&#92;"jailed_until&#92;"", (.gogoproto.stdtime) = true];</code>
   */
  com.google.protobuf.TimestampOrBuilder getJailedUntilOrBuilder();

  /**
   * <pre>
   * Whether or not a validator has been tombstoned (killed out of validator set). It is set
   * once the validator commits an equivocation or for any other configured misbehiavor.
   * </pre>
   *
   * <code>bool tombstoned = 5 [json_name = "tombstoned"];</code>
   * @return The tombstoned.
   */
  boolean getTombstoned();

  /**
   * <pre>
   * A counter kept to avoid unnecessary array reads.
   * Note that `Sum(MissedBlocksBitArray)` always equals `MissedBlocksCounter`.
   * </pre>
   *
   * <code>int64 missed_blocks_counter = 6 [json_name = "missedBlocksCounter", (.gogoproto.moretags) = "yaml:&#92;"missed_blocks_counter&#92;""];</code>
   * @return The missedBlocksCounter.
   */
  long getMissedBlocksCounter();
}
