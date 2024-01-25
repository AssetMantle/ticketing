// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/core/connection/v1/connection.proto

package com.ibc.core.connection.v1;

/**
 * <pre>
 * State defines if a connection is in one of the following states:
 * INIT, TRYOPEN, OPEN or UNINITIALIZED.
 * </pre>
 *
 * Protobuf enum {@code ibc.core.connection.v1.State}
 */
public enum State
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * Default State
   * </pre>
   *
   * <code>STATE_UNINITIALIZED_UNSPECIFIED = 0 [(.gogoproto.enumvalue_customname) = "UNINITIALIZED"];</code>
   */
  STATE_UNINITIALIZED_UNSPECIFIED(0),
  /**
   * <pre>
   * A connection end has just started the opening handshake.
   * </pre>
   *
   * <code>STATE_INIT = 1 [(.gogoproto.enumvalue_customname) = "INIT"];</code>
   */
  STATE_INIT(1),
  /**
   * <pre>
   * A connection end has acknowledged the handshake step on the counterparty
   * chain.
   * </pre>
   *
   * <code>STATE_TRYOPEN = 2 [(.gogoproto.enumvalue_customname) = "TRYOPEN"];</code>
   */
  STATE_TRYOPEN(2),
  /**
   * <pre>
   * A connection end has completed the handshake.
   * </pre>
   *
   * <code>STATE_OPEN = 3 [(.gogoproto.enumvalue_customname) = "OPEN"];</code>
   */
  STATE_OPEN(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * Default State
   * </pre>
   *
   * <code>STATE_UNINITIALIZED_UNSPECIFIED = 0 [(.gogoproto.enumvalue_customname) = "UNINITIALIZED"];</code>
   */
  public static final int STATE_UNINITIALIZED_UNSPECIFIED_VALUE = 0;
  /**
   * <pre>
   * A connection end has just started the opening handshake.
   * </pre>
   *
   * <code>STATE_INIT = 1 [(.gogoproto.enumvalue_customname) = "INIT"];</code>
   */
  public static final int STATE_INIT_VALUE = 1;
  /**
   * <pre>
   * A connection end has acknowledged the handshake step on the counterparty
   * chain.
   * </pre>
   *
   * <code>STATE_TRYOPEN = 2 [(.gogoproto.enumvalue_customname) = "TRYOPEN"];</code>
   */
  public static final int STATE_TRYOPEN_VALUE = 2;
  /**
   * <pre>
   * A connection end has completed the handshake.
   * </pre>
   *
   * <code>STATE_OPEN = 3 [(.gogoproto.enumvalue_customname) = "OPEN"];</code>
   */
  public static final int STATE_OPEN_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static State valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static State forNumber(int value) {
    switch (value) {
      case 0: return STATE_UNINITIALIZED_UNSPECIFIED;
      case 1: return STATE_INIT;
      case 2: return STATE_TRYOPEN;
      case 3: return STATE_OPEN;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<State>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      State> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<State>() {
          public State findValueByNumber(int number) {
            return State.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.ibc.core.connection.v1.ConnectionProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final State[] VALUES = values();

  public static State valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private State(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:ibc.core.connection.v1.State)
}
