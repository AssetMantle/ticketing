// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/core/client/v1/client.proto

package com.ibc.core.client.v1;

public interface UpgradeProposalOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ibc.core.client.v1.UpgradeProposal)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string title = 1 [json_name = "title"];</code>
   * @return The title.
   */
  java.lang.String getTitle();
  /**
   * <code>string title = 1 [json_name = "title"];</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string description = 2 [json_name = "description"];</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 2 [json_name = "description"];</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>.cosmos.upgrade.v1beta1.Plan plan = 3 [json_name = "plan", (.gogoproto.nullable) = false];</code>
   * @return Whether the plan field is set.
   */
  boolean hasPlan();
  /**
   * <code>.cosmos.upgrade.v1beta1.Plan plan = 3 [json_name = "plan", (.gogoproto.nullable) = false];</code>
   * @return The plan.
   */
  com.cosmos.upgrade.v1beta1.Plan getPlan();
  /**
   * <code>.cosmos.upgrade.v1beta1.Plan plan = 3 [json_name = "plan", (.gogoproto.nullable) = false];</code>
   */
  com.cosmos.upgrade.v1beta1.PlanOrBuilder getPlanOrBuilder();

  /**
   * <pre>
   * An UpgradedClientState must be provided to perform an IBC breaking upgrade.
   * This will make the chain commit to the correct upgraded (self) client state
   * before the upgrade occurs, so that connecting chains can verify that the
   * new upgraded client is valid by verifying a proof on the previous version
   * of the chain. This will allow IBC connections to persist smoothly across
   * planned chain upgrades
   * </pre>
   *
   * <code>.google.protobuf.Any upgraded_client_state = 4 [json_name = "upgradedClientState", (.gogoproto.moretags) = "yaml:&#92;"upgraded_client_state&#92;""];</code>
   * @return Whether the upgradedClientState field is set.
   */
  boolean hasUpgradedClientState();
  /**
   * <pre>
   * An UpgradedClientState must be provided to perform an IBC breaking upgrade.
   * This will make the chain commit to the correct upgraded (self) client state
   * before the upgrade occurs, so that connecting chains can verify that the
   * new upgraded client is valid by verifying a proof on the previous version
   * of the chain. This will allow IBC connections to persist smoothly across
   * planned chain upgrades
   * </pre>
   *
   * <code>.google.protobuf.Any upgraded_client_state = 4 [json_name = "upgradedClientState", (.gogoproto.moretags) = "yaml:&#92;"upgraded_client_state&#92;""];</code>
   * @return The upgradedClientState.
   */
  com.google.protobuf.Any getUpgradedClientState();
  /**
   * <pre>
   * An UpgradedClientState must be provided to perform an IBC breaking upgrade.
   * This will make the chain commit to the correct upgraded (self) client state
   * before the upgrade occurs, so that connecting chains can verify that the
   * new upgraded client is valid by verifying a proof on the previous version
   * of the chain. This will allow IBC connections to persist smoothly across
   * planned chain upgrades
   * </pre>
   *
   * <code>.google.protobuf.Any upgraded_client_state = 4 [json_name = "upgradedClientState", (.gogoproto.moretags) = "yaml:&#92;"upgraded_client_state&#92;""];</code>
   */
  com.google.protobuf.AnyOrBuilder getUpgradedClientStateOrBuilder();
}
