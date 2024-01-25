// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/applications/fee/v1/query.proto

package com.ibc.applications.fee.v1;

public interface QueryCounterpartyPayeeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ibc.applications.fee.v1.QueryCounterpartyPayeeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * the counterparty payee address used to compensate forward relaying
   * </pre>
   *
   * <code>string counterparty_payee = 1 [json_name = "counterpartyPayee", (.gogoproto.moretags) = "yaml:&#92;"counterparty_payee&#92;""];</code>
   * @return The counterpartyPayee.
   */
  java.lang.String getCounterpartyPayee();
  /**
   * <pre>
   * the counterparty payee address used to compensate forward relaying
   * </pre>
   *
   * <code>string counterparty_payee = 1 [json_name = "counterpartyPayee", (.gogoproto.moretags) = "yaml:&#92;"counterparty_payee&#92;""];</code>
   * @return The bytes for counterpartyPayee.
   */
  com.google.protobuf.ByteString
      getCounterpartyPayeeBytes();
}