// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/tx/v1beta1/service.proto

package com.cosmos.tx.v1beta1;

public interface GetTxsEventRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cosmos.tx.v1beta1.GetTxsEventRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * events is the list of transaction event type.
   * </pre>
   *
   * <code>repeated string events = 1 [json_name = "events"];</code>
   * @return A list containing the events.
   */
  java.util.List<java.lang.String>
      getEventsList();
  /**
   * <pre>
   * events is the list of transaction event type.
   * </pre>
   *
   * <code>repeated string events = 1 [json_name = "events"];</code>
   * @return The count of events.
   */
  int getEventsCount();
  /**
   * <pre>
   * events is the list of transaction event type.
   * </pre>
   *
   * <code>repeated string events = 1 [json_name = "events"];</code>
   * @param index The index of the element to return.
   * @return The events at the given index.
   */
  java.lang.String getEvents(int index);
  /**
   * <pre>
   * events is the list of transaction event type.
   * </pre>
   *
   * <code>repeated string events = 1 [json_name = "events"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the events at the given index.
   */
  com.google.protobuf.ByteString
      getEventsBytes(int index);

  /**
   * <pre>
   * pagination defines a pagination for the request.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageRequest pagination = 2 [json_name = "pagination"];</code>
   * @return Whether the pagination field is set.
   */
  boolean hasPagination();
  /**
   * <pre>
   * pagination defines a pagination for the request.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageRequest pagination = 2 [json_name = "pagination"];</code>
   * @return The pagination.
   */
  com.cosmos.base.query.v1beta1.PageRequest getPagination();
  /**
   * <pre>
   * pagination defines a pagination for the request.
   * </pre>
   *
   * <code>.cosmos.base.query.v1beta1.PageRequest pagination = 2 [json_name = "pagination"];</code>
   */
  com.cosmos.base.query.v1beta1.PageRequestOrBuilder getPaginationOrBuilder();

  /**
   * <code>.cosmos.tx.v1beta1.OrderBy order_by = 3 [json_name = "orderBy"];</code>
   * @return The enum numeric value on the wire for orderBy.
   */
  int getOrderByValue();
  /**
   * <code>.cosmos.tx.v1beta1.OrderBy order_by = 3 [json_name = "orderBy"];</code>
   * @return The orderBy.
   */
  com.cosmos.tx.v1beta1.OrderBy getOrderBy();
}
