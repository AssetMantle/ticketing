// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: assets/transactions/revoke/message.proto

package com.assetmantle.modules.assets.transactions.revoke;

public interface MessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:assetmantle.modules.assets.transactions.revoke.Message)
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
   * <code>.assetmantle.schema.ids.base.IdentityID to_i_d = 3 [json_name = "toID"];</code>
   * @return Whether the toID field is set.
   */
  boolean hasToID();
  /**
   * <code>.assetmantle.schema.ids.base.IdentityID to_i_d = 3 [json_name = "toID"];</code>
   * @return The toID.
   */
  com.assetmantle.schema.ids.base.IdentityID getToID();
  /**
   * <code>.assetmantle.schema.ids.base.IdentityID to_i_d = 3 [json_name = "toID"];</code>
   */
  com.assetmantle.schema.ids.base.IdentityIDOrBuilder getToIDOrBuilder();

  /**
   * <code>.assetmantle.schema.ids.base.ClassificationID classification_i_d = 4 [json_name = "classificationID"];</code>
   * @return Whether the classificationID field is set.
   */
  boolean hasClassificationID();
  /**
   * <code>.assetmantle.schema.ids.base.ClassificationID classification_i_d = 4 [json_name = "classificationID"];</code>
   * @return The classificationID.
   */
  com.assetmantle.schema.ids.base.ClassificationID getClassificationID();
  /**
   * <code>.assetmantle.schema.ids.base.ClassificationID classification_i_d = 4 [json_name = "classificationID"];</code>
   */
  com.assetmantle.schema.ids.base.ClassificationIDOrBuilder getClassificationIDOrBuilder();
}
