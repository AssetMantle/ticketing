// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/params/v1beta1/query.proto

package com.cosmos.params.v1beta1;

public interface QueryParamsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.params.v1beta1.QueryParamsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * param defines the queried parameter.
   * </pre>
   *
   * <code>.cosmos.params.v1beta1.ParamChange param = 1 [json_name = "param", (.gogoproto.nullable) = false];</code>
   * @return Whether the param field is set.
   */
  boolean hasParam();
  /**
   * <pre>
   * param defines the queried parameter.
   * </pre>
   *
   * <code>.cosmos.params.v1beta1.ParamChange param = 1 [json_name = "param", (.gogoproto.nullable) = false];</code>
   * @return The param.
   */
  com.cosmos.params.v1beta1.ParamChange getParam();
  /**
   * <pre>
   * param defines the queried parameter.
   * </pre>
   *
   * <code>.cosmos.params.v1beta1.ParamChange param = 1 [json_name = "param", (.gogoproto.nullable) = false];</code>
   */
  com.cosmos.params.v1beta1.ParamChangeOrBuilder getParamOrBuilder();
}