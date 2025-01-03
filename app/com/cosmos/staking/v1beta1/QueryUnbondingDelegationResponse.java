// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/staking/v1beta1/query.proto

package com.cosmos.staking.v1beta1;

/**
 * <pre>
 * QueryDelegationResponse is response type for the Query/UnbondingDelegation
 * RPC method.
 * </pre>
 *
 * Protobuf type {@code cosmos.staking.v1beta1.QueryUnbondingDelegationResponse}
 */
public final class QueryUnbondingDelegationResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cosmos.staking.v1beta1.QueryUnbondingDelegationResponse)
    QueryUnbondingDelegationResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QueryUnbondingDelegationResponse.newBuilder() to construct.
  private QueryUnbondingDelegationResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QueryUnbondingDelegationResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new QueryUnbondingDelegationResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryUnbondingDelegationResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryUnbondingDelegationResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse.class, com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse.Builder.class);
  }

  public static final int UNBOND_FIELD_NUMBER = 1;
  private com.cosmos.staking.v1beta1.UnbondingDelegation unbond_;
  /**
   * <pre>
   * unbond defines the unbonding information of a delegation.
   * </pre>
   *
   * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
   * @return Whether the unbond field is set.
   */
  @java.lang.Override
  public boolean hasUnbond() {
    return unbond_ != null;
  }
  /**
   * <pre>
   * unbond defines the unbonding information of a delegation.
   * </pre>
   *
   * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
   * @return The unbond.
   */
  @java.lang.Override
  public com.cosmos.staking.v1beta1.UnbondingDelegation getUnbond() {
    return unbond_ == null ? com.cosmos.staking.v1beta1.UnbondingDelegation.getDefaultInstance() : unbond_;
  }
  /**
   * <pre>
   * unbond defines the unbonding information of a delegation.
   * </pre>
   *
   * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
   */
  @java.lang.Override
  public com.cosmos.staking.v1beta1.UnbondingDelegationOrBuilder getUnbondOrBuilder() {
    return unbond_ == null ? com.cosmos.staking.v1beta1.UnbondingDelegation.getDefaultInstance() : unbond_;
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
    if (unbond_ != null) {
      output.writeMessage(1, getUnbond());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (unbond_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getUnbond());
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
    if (!(obj instanceof com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse)) {
      return super.equals(obj);
    }
    com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse other = (com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse) obj;

    if (hasUnbond() != other.hasUnbond()) return false;
    if (hasUnbond()) {
      if (!getUnbond()
          .equals(other.getUnbond())) return false;
    }
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
    if (hasUnbond()) {
      hash = (37 * hash) + UNBOND_FIELD_NUMBER;
      hash = (53 * hash) + getUnbond().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse parseFrom(
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
  public static Builder newBuilder(com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse prototype) {
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
   * QueryDelegationResponse is response type for the Query/UnbondingDelegation
   * RPC method.
   * </pre>
   *
   * Protobuf type {@code cosmos.staking.v1beta1.QueryUnbondingDelegationResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cosmos.staking.v1beta1.QueryUnbondingDelegationResponse)
      com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryUnbondingDelegationResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryUnbondingDelegationResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse.class, com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse.Builder.class);
    }

    // Construct using com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse.newBuilder()
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
      unbond_ = null;
      if (unbondBuilder_ != null) {
        unbondBuilder_.dispose();
        unbondBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryUnbondingDelegationResponse_descriptor;
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse getDefaultInstanceForType() {
      return com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse build() {
      com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse buildPartial() {
      com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse result = new com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.unbond_ = unbondBuilder_ == null
            ? unbond_
            : unbondBuilder_.build();
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
      if (other instanceof com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse) {
        return mergeFrom((com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse other) {
      if (other == com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse.getDefaultInstance()) return this;
      if (other.hasUnbond()) {
        mergeUnbond(other.getUnbond());
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
              input.readMessage(
                  getUnbondFieldBuilder().getBuilder(),
                  extensionRegistry);
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

    private com.cosmos.staking.v1beta1.UnbondingDelegation unbond_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.cosmos.staking.v1beta1.UnbondingDelegation, com.cosmos.staking.v1beta1.UnbondingDelegation.Builder, com.cosmos.staking.v1beta1.UnbondingDelegationOrBuilder> unbondBuilder_;
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     * @return Whether the unbond field is set.
     */
    public boolean hasUnbond() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     * @return The unbond.
     */
    public com.cosmos.staking.v1beta1.UnbondingDelegation getUnbond() {
      if (unbondBuilder_ == null) {
        return unbond_ == null ? com.cosmos.staking.v1beta1.UnbondingDelegation.getDefaultInstance() : unbond_;
      } else {
        return unbondBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     */
    public Builder setUnbond(com.cosmos.staking.v1beta1.UnbondingDelegation value) {
      if (unbondBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        unbond_ = value;
      } else {
        unbondBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     */
    public Builder setUnbond(
        com.cosmos.staking.v1beta1.UnbondingDelegation.Builder builderForValue) {
      if (unbondBuilder_ == null) {
        unbond_ = builderForValue.build();
      } else {
        unbondBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     */
    public Builder mergeUnbond(com.cosmos.staking.v1beta1.UnbondingDelegation value) {
      if (unbondBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          unbond_ != null &&
          unbond_ != com.cosmos.staking.v1beta1.UnbondingDelegation.getDefaultInstance()) {
          getUnbondBuilder().mergeFrom(value);
        } else {
          unbond_ = value;
        }
      } else {
        unbondBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     */
    public Builder clearUnbond() {
      bitField0_ = (bitField0_ & ~0x00000001);
      unbond_ = null;
      if (unbondBuilder_ != null) {
        unbondBuilder_.dispose();
        unbondBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     */
    public com.cosmos.staking.v1beta1.UnbondingDelegation.Builder getUnbondBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getUnbondFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     */
    public com.cosmos.staking.v1beta1.UnbondingDelegationOrBuilder getUnbondOrBuilder() {
      if (unbondBuilder_ != null) {
        return unbondBuilder_.getMessageOrBuilder();
      } else {
        return unbond_ == null ?
            com.cosmos.staking.v1beta1.UnbondingDelegation.getDefaultInstance() : unbond_;
      }
    }
    /**
     * <pre>
     * unbond defines the unbonding information of a delegation.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.UnbondingDelegation unbond = 1 [json_name = "unbond", (.gogoproto.nullable) = false];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.cosmos.staking.v1beta1.UnbondingDelegation, com.cosmos.staking.v1beta1.UnbondingDelegation.Builder, com.cosmos.staking.v1beta1.UnbondingDelegationOrBuilder> 
        getUnbondFieldBuilder() {
      if (unbondBuilder_ == null) {
        unbondBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.cosmos.staking.v1beta1.UnbondingDelegation, com.cosmos.staking.v1beta1.UnbondingDelegation.Builder, com.cosmos.staking.v1beta1.UnbondingDelegationOrBuilder>(
                getUnbond(),
                getParentForChildren(),
                isClean());
        unbond_ = null;
      }
      return unbondBuilder_;
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


    // @@protoc_insertion_point(builder_scope:cosmos.staking.v1beta1.QueryUnbondingDelegationResponse)
  }

  // @@protoc_insertion_point(class_scope:cosmos.staking.v1beta1.QueryUnbondingDelegationResponse)
  private static final com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse();
  }

  public static com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QueryUnbondingDelegationResponse>
      PARSER = new com.google.protobuf.AbstractParser<QueryUnbondingDelegationResponse>() {
    @java.lang.Override
    public QueryUnbondingDelegationResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<QueryUnbondingDelegationResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QueryUnbondingDelegationResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cosmos.staking.v1beta1.QueryUnbondingDelegationResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

