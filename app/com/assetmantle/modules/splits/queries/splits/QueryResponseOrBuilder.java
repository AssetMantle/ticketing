// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: splits/queries/splits/query_response.proto

package com.assetmantle.modules.splits.queries.splits;

public interface QueryResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:assetmantle.modules.splits.queries.splits.QueryResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .assetmantle.modules.splits.record.Record list = 1 [json_name = "list"];</code>
   */
  java.util.List<com.assetmantle.modules.splits.record.Record> 
      getListList();
  /**
   * <code>repeated .assetmantle.modules.splits.record.Record list = 1 [json_name = "list"];</code>
   */
  com.assetmantle.modules.splits.record.Record getList(int index);
  /**
   * <code>repeated .assetmantle.modules.splits.record.Record list = 1 [json_name = "list"];</code>
   */
  int getListCount();
  /**
   * <code>repeated .assetmantle.modules.splits.record.Record list = 1 [json_name = "list"];</code>
   */
  java.util.List<? extends com.assetmantle.modules.splits.record.RecordOrBuilder> 
      getListOrBuilderList();
  /**
   * <code>repeated .assetmantle.modules.splits.record.Record list = 1 [json_name = "list"];</code>
   */
  com.assetmantle.modules.splits.record.RecordOrBuilder getListOrBuilder(
      int index);
}
