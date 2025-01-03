// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/gov/v1beta1/tx.proto

package com.cosmos.gov.v1beta1;

public interface MsgVoteWeightedOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.gov.v1beta1.MsgVoteWeighted)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 proposal_id = 1 [json_name = "proposalId", (.gogoproto.moretags) = "yaml:&#92;"proposal_id&#92;""];</code>
   * @return The proposalId.
   */
  long getProposalId();

  /**
   * <code>string voter = 2 [json_name = "voter"];</code>
   * @return The voter.
   */
  java.lang.String getVoter();
  /**
   * <code>string voter = 2 [json_name = "voter"];</code>
   * @return The bytes for voter.
   */
  com.google.protobuf.ByteString
      getVoterBytes();

  /**
   * <code>repeated .cosmos.gov.v1beta1.WeightedVoteOption options = 3 [json_name = "options", (.gogoproto.nullable) = false];</code>
   */
  java.util.List<com.cosmos.gov.v1beta1.WeightedVoteOption> 
      getOptionsList();
  /**
   * <code>repeated .cosmos.gov.v1beta1.WeightedVoteOption options = 3 [json_name = "options", (.gogoproto.nullable) = false];</code>
   */
  com.cosmos.gov.v1beta1.WeightedVoteOption getOptions(int index);
  /**
   * <code>repeated .cosmos.gov.v1beta1.WeightedVoteOption options = 3 [json_name = "options", (.gogoproto.nullable) = false];</code>
   */
  int getOptionsCount();
  /**
   * <code>repeated .cosmos.gov.v1beta1.WeightedVoteOption options = 3 [json_name = "options", (.gogoproto.nullable) = false];</code>
   */
  java.util.List<? extends com.cosmos.gov.v1beta1.WeightedVoteOptionOrBuilder> 
      getOptionsOrBuilderList();
  /**
   * <code>repeated .cosmos.gov.v1beta1.WeightedVoteOption options = 3 [json_name = "options", (.gogoproto.nullable) = false];</code>
   */
  com.cosmos.gov.v1beta1.WeightedVoteOptionOrBuilder getOptionsOrBuilder(
      int index);
}
