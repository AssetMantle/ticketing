// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/consensus/types.proto

package com.tendermint.consensus;

public interface ProposalOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tendermint.consensus.Proposal)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.tendermint.types.Proposal proposal = 1 [json_name = "proposal", (.gogoproto.nullable) = false];</code>
   * @return Whether the proposal field is set.
   */
  boolean hasProposal();
  /**
   * <code>.tendermint.types.Proposal proposal = 1 [json_name = "proposal", (.gogoproto.nullable) = false];</code>
   * @return The proposal.
   */
  com.tendermint.types.Proposal getProposal();
  /**
   * <code>.tendermint.types.Proposal proposal = 1 [json_name = "proposal", (.gogoproto.nullable) = false];</code>
   */
  com.tendermint.types.ProposalOrBuilder getProposalOrBuilder();
}
