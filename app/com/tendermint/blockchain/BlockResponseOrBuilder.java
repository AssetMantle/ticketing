// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/blockchain/types.proto

package com.tendermint.blockchain;

public interface BlockResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tendermint.blockchain.BlockResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.tendermint.types.Block block = 1 [json_name = "block"];</code>
   * @return Whether the block field is set.
   */
  boolean hasBlock();
  /**
   * <code>.tendermint.types.Block block = 1 [json_name = "block"];</code>
   * @return The block.
   */
  com.tendermint.types.Block getBlock();
  /**
   * <code>.tendermint.types.Block block = 1 [json_name = "block"];</code>
   */
  com.tendermint.types.BlockOrBuilder getBlockOrBuilder();
}
