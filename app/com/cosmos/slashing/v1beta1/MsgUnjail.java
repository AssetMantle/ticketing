// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/slashing/v1beta1/tx.proto

package com.cosmos.slashing.v1beta1;

/**
 * <pre>
 * MsgUnjail defines the Msg/Unjail request type
 * </pre>
 *
 * Protobuf type {@code cosmos.slashing.v1beta1.MsgUnjail}
 */
public final class MsgUnjail extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cosmos.slashing.v1beta1.MsgUnjail)
    MsgUnjailOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MsgUnjail.newBuilder() to construct.
  private MsgUnjail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MsgUnjail() {
    validatorAddr_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MsgUnjail();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cosmos.slashing.v1beta1.TxProto.internal_static_cosmos_slashing_v1beta1_MsgUnjail_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cosmos.slashing.v1beta1.TxProto.internal_static_cosmos_slashing_v1beta1_MsgUnjail_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cosmos.slashing.v1beta1.MsgUnjail.class, com.cosmos.slashing.v1beta1.MsgUnjail.Builder.class);
  }

  public static final int VALIDATOR_ADDR_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object validatorAddr_ = "";
  /**
   * <code>string validator_addr = 1 [json_name = "validatorAddr", (.gogoproto.jsontag) = "address", (.gogoproto.moretags) = "yaml:&#92;"address&#92;""];</code>
   * @return The validatorAddr.
   */
  @java.lang.Override
  public java.lang.String getValidatorAddr() {
    java.lang.Object ref = validatorAddr_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      validatorAddr_ = s;
      return s;
    }
  }
  /**
   * <code>string validator_addr = 1 [json_name = "validatorAddr", (.gogoproto.jsontag) = "address", (.gogoproto.moretags) = "yaml:&#92;"address&#92;""];</code>
   * @return The bytes for validatorAddr.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getValidatorAddrBytes() {
    java.lang.Object ref = validatorAddr_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      validatorAddr_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(validatorAddr_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, validatorAddr_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(validatorAddr_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, validatorAddr_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.cosmos.slashing.v1beta1.MsgUnjail)) {
      return super.equals(obj);
    }
    com.cosmos.slashing.v1beta1.MsgUnjail other = (com.cosmos.slashing.v1beta1.MsgUnjail) obj;

    if (!getValidatorAddr()
        .equals(other.getValidatorAddr())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + VALIDATOR_ADDR_FIELD_NUMBER;
    hash = (53 * hash) + getValidatorAddr().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.slashing.v1beta1.MsgUnjail parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.cosmos.slashing.v1beta1.MsgUnjail prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * MsgUnjail defines the Msg/Unjail request type
   * </pre>
   *
   * Protobuf type {@code cosmos.slashing.v1beta1.MsgUnjail}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cosmos.slashing.v1beta1.MsgUnjail)
      com.cosmos.slashing.v1beta1.MsgUnjailOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.slashing.v1beta1.TxProto.internal_static_cosmos_slashing_v1beta1_MsgUnjail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.slashing.v1beta1.TxProto.internal_static_cosmos_slashing_v1beta1_MsgUnjail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.slashing.v1beta1.MsgUnjail.class, com.cosmos.slashing.v1beta1.MsgUnjail.Builder.class);
    }

    // Construct using com.cosmos.slashing.v1beta1.MsgUnjail.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      validatorAddr_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cosmos.slashing.v1beta1.TxProto.internal_static_cosmos_slashing_v1beta1_MsgUnjail_descriptor;
    }

    @java.lang.Override
    public com.cosmos.slashing.v1beta1.MsgUnjail getDefaultInstanceForType() {
      return com.cosmos.slashing.v1beta1.MsgUnjail.getDefaultInstance();
    }

    @java.lang.Override
    public com.cosmos.slashing.v1beta1.MsgUnjail build() {
      com.cosmos.slashing.v1beta1.MsgUnjail result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cosmos.slashing.v1beta1.MsgUnjail buildPartial() {
      com.cosmos.slashing.v1beta1.MsgUnjail result = new com.cosmos.slashing.v1beta1.MsgUnjail(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.cosmos.slashing.v1beta1.MsgUnjail result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.validatorAddr_ = validatorAddr_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.cosmos.slashing.v1beta1.MsgUnjail) {
        return mergeFrom((com.cosmos.slashing.v1beta1.MsgUnjail)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cosmos.slashing.v1beta1.MsgUnjail other) {
      if (other == com.cosmos.slashing.v1beta1.MsgUnjail.getDefaultInstance()) return this;
      if (!other.getValidatorAddr().isEmpty()) {
        validatorAddr_ = other.validatorAddr_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              validatorAddr_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object validatorAddr_ = "";
    /**
     * <code>string validator_addr = 1 [json_name = "validatorAddr", (.gogoproto.jsontag) = "address", (.gogoproto.moretags) = "yaml:&#92;"address&#92;""];</code>
     * @return The validatorAddr.
     */
    public java.lang.String getValidatorAddr() {
      java.lang.Object ref = validatorAddr_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        validatorAddr_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string validator_addr = 1 [json_name = "validatorAddr", (.gogoproto.jsontag) = "address", (.gogoproto.moretags) = "yaml:&#92;"address&#92;""];</code>
     * @return The bytes for validatorAddr.
     */
    public com.google.protobuf.ByteString
        getValidatorAddrBytes() {
      java.lang.Object ref = validatorAddr_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        validatorAddr_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string validator_addr = 1 [json_name = "validatorAddr", (.gogoproto.jsontag) = "address", (.gogoproto.moretags) = "yaml:&#92;"address&#92;""];</code>
     * @param value The validatorAddr to set.
     * @return This builder for chaining.
     */
    public Builder setValidatorAddr(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      validatorAddr_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string validator_addr = 1 [json_name = "validatorAddr", (.gogoproto.jsontag) = "address", (.gogoproto.moretags) = "yaml:&#92;"address&#92;""];</code>
     * @return This builder for chaining.
     */
    public Builder clearValidatorAddr() {
      validatorAddr_ = getDefaultInstance().getValidatorAddr();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string validator_addr = 1 [json_name = "validatorAddr", (.gogoproto.jsontag) = "address", (.gogoproto.moretags) = "yaml:&#92;"address&#92;""];</code>
     * @param value The bytes for validatorAddr to set.
     * @return This builder for chaining.
     */
    public Builder setValidatorAddrBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      validatorAddr_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:cosmos.slashing.v1beta1.MsgUnjail)
  }

  // @@protoc_insertion_point(class_scope:cosmos.slashing.v1beta1.MsgUnjail)
  private static final com.cosmos.slashing.v1beta1.MsgUnjail DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cosmos.slashing.v1beta1.MsgUnjail();
  }

  public static com.cosmos.slashing.v1beta1.MsgUnjail getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MsgUnjail>
      PARSER = new com.google.protobuf.AbstractParser<MsgUnjail>() {
    @java.lang.Override
    public MsgUnjail parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<MsgUnjail> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MsgUnjail> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cosmos.slashing.v1beta1.MsgUnjail getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
