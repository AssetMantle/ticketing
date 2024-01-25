// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/base/reflection/v2alpha1/reflection.proto

package com.cosmos.base.reflection.v2alpha1;

public interface InterfaceImplementerDescriptorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.base.reflection.v2alpha1.InterfaceImplementerDescriptor)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * fullname is the protobuf queryable name of the interface implementer
   * </pre>
   *
   * <code>string fullname = 1 [json_name = "fullname"];</code>
   * @return The fullname.
   */
  java.lang.String getFullname();
  /**
   * <pre>
   * fullname is the protobuf queryable name of the interface implementer
   * </pre>
   *
   * <code>string fullname = 1 [json_name = "fullname"];</code>
   * @return The bytes for fullname.
   */
  com.google.protobuf.ByteString
      getFullnameBytes();

  /**
   * <pre>
   * type_url defines the type URL used when marshalling the type as any
   * this is required so we can provide type safe google.protobuf.Any marshalling and
   * unmarshalling, making sure that we don't accept just 'any' type
   * in our interface fields
   * </pre>
   *
   * <code>string type_url = 2 [json_name = "typeUrl"];</code>
   * @return The typeUrl.
   */
  java.lang.String getTypeUrl();
  /**
   * <pre>
   * type_url defines the type URL used when marshalling the type as any
   * this is required so we can provide type safe google.protobuf.Any marshalling and
   * unmarshalling, making sure that we don't accept just 'any' type
   * in our interface fields
   * </pre>
   *
   * <code>string type_url = 2 [json_name = "typeUrl"];</code>
   * @return The bytes for typeUrl.
   */
  com.google.protobuf.ByteString
      getTypeUrlBytes();
}