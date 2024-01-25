// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/core/channel/v1/query.proto

package com.ibc.core.channel.v1;

public interface QueryPacketReceiptResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ibc.core.channel.v1.QueryPacketReceiptResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * success flag for if receipt exists
   * </pre>
   *
   * <code>bool received = 2 [json_name = "received"];</code>
   * @return The received.
   */
  boolean getReceived();

  /**
   * <pre>
   * merkle proof of existence
   * </pre>
   *
   * <code>bytes proof = 3 [json_name = "proof"];</code>
   * @return The proof.
   */
  com.google.protobuf.ByteString getProof();

  /**
   * <pre>
   * height at which the proof was retrieved
   * </pre>
   *
   * <code>.ibc.core.client.v1.Height proof_height = 4 [json_name = "proofHeight", (.gogoproto.nullable) = false];</code>
   * @return Whether the proofHeight field is set.
   */
  boolean hasProofHeight();
  /**
   * <pre>
   * height at which the proof was retrieved
   * </pre>
   *
   * <code>.ibc.core.client.v1.Height proof_height = 4 [json_name = "proofHeight", (.gogoproto.nullable) = false];</code>
   * @return The proofHeight.
   */
  com.ibc.core.client.v1.Height getProofHeight();
  /**
   * <pre>
   * height at which the proof was retrieved
   * </pre>
   *
   * <code>.ibc.core.client.v1.Height proof_height = 4 [json_name = "proofHeight", (.gogoproto.nullable) = false];</code>
   */
  com.ibc.core.client.v1.HeightOrBuilder getProofHeightOrBuilder();
}
