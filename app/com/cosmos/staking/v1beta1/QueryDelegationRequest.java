// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/staking/v1beta1/query.proto

package com.cosmos.staking.v1beta1;

/**
 * <pre>
 * QueryDelegationRequest is request type for the Query/Delegation RPC method.
 * </pre>
 *
 * Protobuf type {@code cosmos.staking.v1beta1.QueryDelegationRequest}
 */
public final class QueryDelegationRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cosmos.staking.v1beta1.QueryDelegationRequest)
    QueryDelegationRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QueryDelegationRequest.newBuilder() to construct.
  private QueryDelegationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QueryDelegationRequest() {
    delegatorAddr_ = "";
    validatorAddr_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new QueryDelegationRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryDelegationRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryDelegationRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cosmos.staking.v1beta1.QueryDelegationRequest.class, com.cosmos.staking.v1beta1.QueryDelegationRequest.Builder.class);
  }

  public static final int DELEGATOR_ADDR_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object delegatorAddr_ = "";
  /**
   * <pre>
   * delegator_addr defines the delegator address to query for.
   * </pre>
   *
   * <code>string delegator_addr = 1 [json_name = "delegatorAddr"];</code>
   * @return The delegatorAddr.
   */
  @java.lang.Override
  public java.lang.String getDelegatorAddr() {
    java.lang.Object ref = delegatorAddr_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      delegatorAddr_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * delegator_addr defines the delegator address to query for.
   * </pre>
   *
   * <code>string delegator_addr = 1 [json_name = "delegatorAddr"];</code>
   * @return The bytes for delegatorAddr.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDelegatorAddrBytes() {
    java.lang.Object ref = delegatorAddr_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      delegatorAddr_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VALIDATOR_ADDR_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object validatorAddr_ = "";
  /**
   * <pre>
   * validator_addr defines the validator address to query for.
   * </pre>
   *
   * <code>string validator_addr = 2 [json_name = "validatorAddr"];</code>
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
   * <pre>
   * validator_addr defines the validator address to query for.
   * </pre>
   *
   * <code>string validator_addr = 2 [json_name = "validatorAddr"];</code>
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(delegatorAddr_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, delegatorAddr_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(validatorAddr_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, validatorAddr_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(delegatorAddr_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, delegatorAddr_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(validatorAddr_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, validatorAddr_);
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
    if (!(obj instanceof com.cosmos.staking.v1beta1.QueryDelegationRequest)) {
      return super.equals(obj);
    }
    com.cosmos.staking.v1beta1.QueryDelegationRequest other = (com.cosmos.staking.v1beta1.QueryDelegationRequest) obj;

    if (!getDelegatorAddr()
        .equals(other.getDelegatorAddr())) return false;
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
    hash = (37 * hash) + DELEGATOR_ADDR_FIELD_NUMBER;
    hash = (53 * hash) + getDelegatorAddr().hashCode();
    hash = (37 * hash) + VALIDATOR_ADDR_FIELD_NUMBER;
    hash = (53 * hash) + getValidatorAddr().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryDelegationRequest parseFrom(
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
  public static Builder newBuilder(com.cosmos.staking.v1beta1.QueryDelegationRequest prototype) {
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
   * QueryDelegationRequest is request type for the Query/Delegation RPC method.
   * </pre>
   *
   * Protobuf type {@code cosmos.staking.v1beta1.QueryDelegationRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cosmos.staking.v1beta1.QueryDelegationRequest)
      com.cosmos.staking.v1beta1.QueryDelegationRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryDelegationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryDelegationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.staking.v1beta1.QueryDelegationRequest.class, com.cosmos.staking.v1beta1.QueryDelegationRequest.Builder.class);
    }

    // Construct using com.cosmos.staking.v1beta1.QueryDelegationRequest.newBuilder()
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
      delegatorAddr_ = "";
      validatorAddr_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryDelegationRequest_descriptor;
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryDelegationRequest getDefaultInstanceForType() {
      return com.cosmos.staking.v1beta1.QueryDelegationRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryDelegationRequest build() {
      com.cosmos.staking.v1beta1.QueryDelegationRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryDelegationRequest buildPartial() {
      com.cosmos.staking.v1beta1.QueryDelegationRequest result = new com.cosmos.staking.v1beta1.QueryDelegationRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.cosmos.staking.v1beta1.QueryDelegationRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.delegatorAddr_ = delegatorAddr_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
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
      if (other instanceof com.cosmos.staking.v1beta1.QueryDelegationRequest) {
        return mergeFrom((com.cosmos.staking.v1beta1.QueryDelegationRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cosmos.staking.v1beta1.QueryDelegationRequest other) {
      if (other == com.cosmos.staking.v1beta1.QueryDelegationRequest.getDefaultInstance()) return this;
      if (!other.getDelegatorAddr().isEmpty()) {
        delegatorAddr_ = other.delegatorAddr_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getValidatorAddr().isEmpty()) {
        validatorAddr_ = other.validatorAddr_;
        bitField0_ |= 0x00000002;
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
              delegatorAddr_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              validatorAddr_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private java.lang.Object delegatorAddr_ = "";
    /**
     * <pre>
     * delegator_addr defines the delegator address to query for.
     * </pre>
     *
     * <code>string delegator_addr = 1 [json_name = "delegatorAddr"];</code>
     * @return The delegatorAddr.
     */
    public java.lang.String getDelegatorAddr() {
      java.lang.Object ref = delegatorAddr_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        delegatorAddr_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * delegator_addr defines the delegator address to query for.
     * </pre>
     *
     * <code>string delegator_addr = 1 [json_name = "delegatorAddr"];</code>
     * @return The bytes for delegatorAddr.
     */
    public com.google.protobuf.ByteString
        getDelegatorAddrBytes() {
      java.lang.Object ref = delegatorAddr_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        delegatorAddr_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * delegator_addr defines the delegator address to query for.
     * </pre>
     *
     * <code>string delegator_addr = 1 [json_name = "delegatorAddr"];</code>
     * @param value The delegatorAddr to set.
     * @return This builder for chaining.
     */
    public Builder setDelegatorAddr(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      delegatorAddr_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * delegator_addr defines the delegator address to query for.
     * </pre>
     *
     * <code>string delegator_addr = 1 [json_name = "delegatorAddr"];</code>
     * @return This builder for chaining.
     */
    public Builder clearDelegatorAddr() {
      delegatorAddr_ = getDefaultInstance().getDelegatorAddr();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * delegator_addr defines the delegator address to query for.
     * </pre>
     *
     * <code>string delegator_addr = 1 [json_name = "delegatorAddr"];</code>
     * @param value The bytes for delegatorAddr to set.
     * @return This builder for chaining.
     */
    public Builder setDelegatorAddrBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      delegatorAddr_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object validatorAddr_ = "";
    /**
     * <pre>
     * validator_addr defines the validator address to query for.
     * </pre>
     *
     * <code>string validator_addr = 2 [json_name = "validatorAddr"];</code>
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
     * <pre>
     * validator_addr defines the validator address to query for.
     * </pre>
     *
     * <code>string validator_addr = 2 [json_name = "validatorAddr"];</code>
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
     * <pre>
     * validator_addr defines the validator address to query for.
     * </pre>
     *
     * <code>string validator_addr = 2 [json_name = "validatorAddr"];</code>
     * @param value The validatorAddr to set.
     * @return This builder for chaining.
     */
    public Builder setValidatorAddr(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      validatorAddr_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * validator_addr defines the validator address to query for.
     * </pre>
     *
     * <code>string validator_addr = 2 [json_name = "validatorAddr"];</code>
     * @return This builder for chaining.
     */
    public Builder clearValidatorAddr() {
      validatorAddr_ = getDefaultInstance().getValidatorAddr();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * validator_addr defines the validator address to query for.
     * </pre>
     *
     * <code>string validator_addr = 2 [json_name = "validatorAddr"];</code>
     * @param value The bytes for validatorAddr to set.
     * @return This builder for chaining.
     */
    public Builder setValidatorAddrBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      validatorAddr_ = value;
      bitField0_ |= 0x00000002;
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


    // @@protoc_insertion_point(builder_scope:cosmos.staking.v1beta1.QueryDelegationRequest)
  }

  // @@protoc_insertion_point(class_scope:cosmos.staking.v1beta1.QueryDelegationRequest)
  private static final com.cosmos.staking.v1beta1.QueryDelegationRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cosmos.staking.v1beta1.QueryDelegationRequest();
  }

  public static com.cosmos.staking.v1beta1.QueryDelegationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QueryDelegationRequest>
      PARSER = new com.google.protobuf.AbstractParser<QueryDelegationRequest>() {
    @java.lang.Override
    public QueryDelegationRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<QueryDelegationRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QueryDelegationRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cosmos.staking.v1beta1.QueryDelegationRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
