// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: assets/transactions/renumerate/message.proto

package com.assetmantle.modules.assets.transactions.renumerate;

public interface MessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:assetmantle.modules.assets.transactions.renumerate.Message)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string from = 1 [json_name = "from"];</code>
   * @return The from.
   */
  java.lang.String getFrom();
  /**
   * <code>string from = 1 [json_name = "from"];</code>
   * @return The bytes for from.
   */
  com.google.protobuf.ByteString
      getFromBytes();

  /**
   * <code>.assetmantle.schema.ids.base.IdentityID from_i_d = 2 [json_name = "fromID"];</code>
   * @return Whether the fromID field is set.
   */
  boolean hasFromID();
  /**
   * <code>.assetmantle.schema.ids.base.IdentityID from_i_d = 2 [json_name = "fromID"];</code>
   * @return The fromID.
   */
  com.assetmantle.schema.ids.base.IdentityID getFromID();
  /**
   * <code>.assetmantle.schema.ids.base.IdentityID from_i_d = 2 [json_name = "fromID"];</code>
   */
  com.assetmantle.schema.ids.base.IdentityIDOrBuilder getFromIDOrBuilder();

  /**
   * <code>.assetmantle.schema.ids.base.AssetID asset_i_d = 3 [json_name = "assetID"];</code>
   * @return Whether the assetID field is set.
   */
  boolean hasAssetID();
  /**
   * <code>.assetmantle.schema.ids.base.AssetID asset_i_d = 3 [json_name = "assetID"];</code>
   * @return The assetID.
   */
  com.assetmantle.schema.ids.base.AssetID getAssetID();
  /**
   * <code>.assetmantle.schema.ids.base.AssetID asset_i_d = 3 [json_name = "assetID"];</code>
   */
  com.assetmantle.schema.ids.base.AssetIDOrBuilder getAssetIDOrBuilder();
}
