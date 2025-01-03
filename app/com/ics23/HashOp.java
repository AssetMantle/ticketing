// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: confio/proofs.proto

package com.ics23;

/**
 * Protobuf enum {@code ics23.HashOp}
 */
public enum HashOp
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * NO_HASH is the default if no data passed. Note this is an illegal argument some places.
   * </pre>
   *
   * <code>NO_HASH = 0;</code>
   */
  NO_HASH(0),
  /**
   * <code>SHA256 = 1;</code>
   */
  SHA256(1),
  /**
   * <code>SHA512 = 2;</code>
   */
  SHA512(2),
  /**
   * <code>KECCAK = 3;</code>
   */
  KECCAK(3),
  /**
   * <code>RIPEMD160 = 4;</code>
   */
  RIPEMD160(4),
  /**
   * <pre>
   * ripemd160(sha256(x))
   * </pre>
   *
   * <code>BITCOIN = 5;</code>
   */
  BITCOIN(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * NO_HASH is the default if no data passed. Note this is an illegal argument some places.
   * </pre>
   *
   * <code>NO_HASH = 0;</code>
   */
  public static final int NO_HASH_VALUE = 0;
  /**
   * <code>SHA256 = 1;</code>
   */
  public static final int SHA256_VALUE = 1;
  /**
   * <code>SHA512 = 2;</code>
   */
  public static final int SHA512_VALUE = 2;
  /**
   * <code>KECCAK = 3;</code>
   */
  public static final int KECCAK_VALUE = 3;
  /**
   * <code>RIPEMD160 = 4;</code>
   */
  public static final int RIPEMD160_VALUE = 4;
  /**
   * <pre>
   * ripemd160(sha256(x))
   * </pre>
   *
   * <code>BITCOIN = 5;</code>
   */
  public static final int BITCOIN_VALUE = 5;


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
  public static HashOp valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static HashOp forNumber(int value) {
    switch (value) {
      case 0: return NO_HASH;
      case 1: return SHA256;
      case 2: return SHA512;
      case 3: return KECCAK;
      case 4: return RIPEMD160;
      case 5: return BITCOIN;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<HashOp>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      HashOp> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<HashOp>() {
          public HashOp findValueByNumber(int number) {
            return HashOp.forNumber(number);
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
    return com.ics23.ProofsProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final HashOp[] VALUES = values();

  public static HashOp valueOf(
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

  private HashOp(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:ics23.HashOp)
}

