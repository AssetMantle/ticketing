// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/types/types.proto

package com.tendermint.types;

public interface PartOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tendermint.types.Part)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 index = 1 [json_name = "index"];</code>
   * @return The index.
   */
  int getIndex();

  /**
   * <code>bytes bytes = 2 [json_name = "bytes"];</code>
   * @return The bytes.
   */
  com.google.protobuf.ByteString getBytes();

  /**
   * <code>.tendermint.crypto.Proof proof = 3 [json_name = "proof", (.gogoproto.nullable) = false];</code>
   * @return Whether the proof field is set.
   */
  boolean hasProof();
  /**
   * <code>.tendermint.crypto.Proof proof = 3 [json_name = "proof", (.gogoproto.nullable) = false];</code>
   * @return The proof.
   */
  com.tendermint.crypto.Proof getProof();
  /**
   * <code>.tendermint.crypto.Proof proof = 3 [json_name = "proof", (.gogoproto.nullable) = false];</code>
   */
  com.tendermint.crypto.ProofOrBuilder getProofOrBuilder();
}
