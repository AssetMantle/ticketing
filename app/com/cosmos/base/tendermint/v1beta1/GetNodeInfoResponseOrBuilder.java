// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/base/tendermint/v1beta1/query.proto

package com.cosmos.base.tendermint.v1beta1;

public interface GetNodeInfoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.base.tendermint.v1beta1.GetNodeInfoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.tendermint.p2p.DefaultNodeInfo default_node_info = 1 [json_name = "defaultNodeInfo"];</code>
   * @return Whether the defaultNodeInfo field is set.
   */
  boolean hasDefaultNodeInfo();
  /**
   * <code>.tendermint.p2p.DefaultNodeInfo default_node_info = 1 [json_name = "defaultNodeInfo"];</code>
   * @return The defaultNodeInfo.
   */
  com.tendermint.p2p.DefaultNodeInfo getDefaultNodeInfo();
  /**
   * <code>.tendermint.p2p.DefaultNodeInfo default_node_info = 1 [json_name = "defaultNodeInfo"];</code>
   */
  com.tendermint.p2p.DefaultNodeInfoOrBuilder getDefaultNodeInfoOrBuilder();

  /**
   * <code>.cosmos.base.tendermint.v1beta1.VersionInfo application_version = 2 [json_name = "applicationVersion"];</code>
   * @return Whether the applicationVersion field is set.
   */
  boolean hasApplicationVersion();
  /**
   * <code>.cosmos.base.tendermint.v1beta1.VersionInfo application_version = 2 [json_name = "applicationVersion"];</code>
   * @return The applicationVersion.
   */
  com.cosmos.base.tendermint.v1beta1.VersionInfo getApplicationVersion();
  /**
   * <code>.cosmos.base.tendermint.v1beta1.VersionInfo application_version = 2 [json_name = "applicationVersion"];</code>
   */
  com.cosmos.base.tendermint.v1beta1.VersionInfoOrBuilder getApplicationVersionOrBuilder();
}
