// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/authz/v1beta1/query.proto

package com.cosmos.authz.v1beta1;

public interface QueryGrantsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.authz.v1beta1.QueryGrantsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * authorizations is a list of grants granted for grantee by granter.
   * </pre>
   *
   * <code>repeated .cosmos.authz.v1beta1.Grant grants = 1 [json_name = "grants"];</code>
   */
  java.util.List<com.cosmos.authz.v1beta1.Grant> 
      getGrantsList();
  /**
   * <pre>
   * authorizations is a list of grants granted for grantee by granter.
   * </pre>
   *
   * <code>repeated .cosmos.authz.v1beta1.Grant grants = 1 [json_name = "grants"];</code>
   */
  com.cosmos.authz.v1beta1.Grant getGrants(int index);
  /**
   * <pre>
   * authorizations is a list of grants granted for grantee by granter.
   * </pre>
   *
   * <code>repeated .cosmos.authz.v1beta1.Grant grants = 1 [json_name = "grants"];</code>
   */
  int getGrantsCount();
  /**
   * <pre>
   * authorizations is a list of grants granted for grantee by granter.
   * </pre>
   *
   * <code>repeated .cosmos.authz.v1beta1.Grant grants = 1 [json_name = "grants"];</code>
   */
  java.util.List<? extends com.cosmos.authz.v1beta1.GrantOrBuilder> 
      getGrantsOrBuilderList();
  /**
   * <pre>
   * authorizations is a list of grants granted for grantee by granter.
   * </pre>
   *
   * <code>repeated .cosmos.authz.v1beta1.Grant grants = 1 [json_name = "grants"];</code>
   */
  com.cosmos.authz.v1beta1.GrantOrBuilder getGrantsOrBuilder(
      int index);

  /**
   * <pre>
   * pagination defines an pagination for the response.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageResponse pagination = 2 [json_name = "pagination"];</code>
   * @return Whether the pagination field is set.
   */
  boolean hasPagination();
  /**
   * <pre>
   * pagination defines an pagination for the response.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageResponse pagination = 2 [json_name = "pagination"];</code>
   * @return The pagination.
   */
  com.cosmos.base.query.v1beta1.PageResponse getPagination();
  /**
   * <pre>
   * pagination defines an pagination for the response.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageResponse pagination = 2 [json_name = "pagination"];</code>
   */
  com.cosmos.base.query.v1beta1.PageResponseOrBuilder getPaginationOrBuilder();
}
