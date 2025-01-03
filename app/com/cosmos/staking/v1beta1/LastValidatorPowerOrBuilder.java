// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/staking/v1beta1/genesis.proto

package com.cosmos.staking.v1beta1;

public interface LastValidatorPowerOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.staking.v1beta1.LastValidatorPower)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * address is the address of the validator.
   * </pre>
   *
   * <code>string address = 1 [json_name = "address"];</code>
   * @return The address.
   */
  java.lang.String getAddress();
  /**
   * <pre>
   * address is the address of the validator.
   * </pre>
   *
   * <code>string address = 1 [json_name = "address"];</code>
   * @return The bytes for address.
   */
  com.google.protobuf.ByteString
      getAddressBytes();

  /**
   * <pre>
   * power defines the power of the validator.
   * </pre>
   *
   * <code>int64 power = 2 [json_name = "power"];</code>
   * @return The power.
   */
  long getPower();
}
