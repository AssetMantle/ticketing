// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/vesting/v1beta1/vesting.proto

package com.cosmos.vesting.v1beta1;

public interface ContinuousVestingAccountOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.vesting.v1beta1.ContinuousVestingAccount)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.cosmos.vesting.v1beta1.BaseVestingAccount base_vesting_account = 1 [json_name = "baseVestingAccount", (.gogoproto.embed) = true];</code>
   * @return Whether the baseVestingAccount field is set.
   */
  boolean hasBaseVestingAccount();
  /**
   * <code>.cosmos.vesting.v1beta1.BaseVestingAccount base_vesting_account = 1 [json_name = "baseVestingAccount", (.gogoproto.embed) = true];</code>
   * @return The baseVestingAccount.
   */
  com.cosmos.vesting.v1beta1.BaseVestingAccount getBaseVestingAccount();
  /**
   * <code>.cosmos.vesting.v1beta1.BaseVestingAccount base_vesting_account = 1 [json_name = "baseVestingAccount", (.gogoproto.embed) = true];</code>
   */
  com.cosmos.vesting.v1beta1.BaseVestingAccountOrBuilder getBaseVestingAccountOrBuilder();

  /**
   * <code>int64 start_time = 2 [json_name = "startTime", (.gogoproto.moretags) = "yaml:&#92;"start_time&#92;""];</code>
   * @return The startTime.
   */
  long getStartTime();
}