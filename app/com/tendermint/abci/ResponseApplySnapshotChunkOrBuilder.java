// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/abci/types.proto

package com.tendermint.abci;

public interface ResponseApplySnapshotChunkOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tendermint.abci.ResponseApplySnapshotChunk)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.tendermint.abci.ResponseApplySnapshotChunk.Result result = 1 [json_name = "result"];</code>
   * @return The enum numeric value on the wire for result.
   */
  int getResultValue();
  /**
   * <code>.tendermint.abci.ResponseApplySnapshotChunk.Result result = 1 [json_name = "result"];</code>
   * @return The result.
   */
  com.tendermint.abci.ResponseApplySnapshotChunk.Result getResult();

  /**
   * <pre>
   * Chunks to refetch and reapply
   * </pre>
   *
   * <code>repeated uint32 refetch_chunks = 2 [json_name = "refetchChunks"];</code>
   * @return A list containing the refetchChunks.
   */
  java.util.List<java.lang.Integer> getRefetchChunksList();
  /**
   * <pre>
   * Chunks to refetch and reapply
   * </pre>
   *
   * <code>repeated uint32 refetch_chunks = 2 [json_name = "refetchChunks"];</code>
   * @return The count of refetchChunks.
   */
  int getRefetchChunksCount();
  /**
   * <pre>
   * Chunks to refetch and reapply
   * </pre>
   *
   * <code>repeated uint32 refetch_chunks = 2 [json_name = "refetchChunks"];</code>
   * @param index The index of the element to return.
   * @return The refetchChunks at the given index.
   */
  int getRefetchChunks(int index);

  /**
   * <pre>
   * Chunk senders to reject and ban
   * </pre>
   *
   * <code>repeated string reject_senders = 3 [json_name = "rejectSenders"];</code>
   * @return A list containing the rejectSenders.
   */
  java.util.List<java.lang.String>
      getRejectSendersList();
  /**
   * <pre>
   * Chunk senders to reject and ban
   * </pre>
   *
   * <code>repeated string reject_senders = 3 [json_name = "rejectSenders"];</code>
   * @return The count of rejectSenders.
   */
  int getRejectSendersCount();
  /**
   * <pre>
   * Chunk senders to reject and ban
   * </pre>
   *
   * <code>repeated string reject_senders = 3 [json_name = "rejectSenders"];</code>
   * @param index The index of the element to return.
   * @return The rejectSenders at the given index.
   */
  java.lang.String getRejectSenders(int index);
  /**
   * <pre>
   * Chunk senders to reject and ban
   * </pre>
   *
   * <code>repeated string reject_senders = 3 [json_name = "rejectSenders"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the rejectSenders at the given index.
   */
  com.google.protobuf.ByteString
      getRejectSendersBytes(int index);
}
