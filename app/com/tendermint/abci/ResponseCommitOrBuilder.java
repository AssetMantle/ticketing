// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/abci/types.proto

package com.tendermint.abci;

public interface ResponseCommitOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tendermint.abci.ResponseCommit)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * reserve 1
   * </pre>
   *
   * <code>bytes data = 2 [json_name = "data"];</code>
   * @return The data.
   */
  com.google.protobuf.ByteString getData();

  /**
   * <code>int64 retain_height = 3 [json_name = "retainHeight"];</code>
   * @return The retainHeight.
   */
  long getRetainHeight();
}
