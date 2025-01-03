// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/staking/v1beta1/query.proto

package com.cosmos.staking.v1beta1;

/**
 * <pre>
 * QueryHistoricalInfoResponse is response type for the Query/HistoricalInfo RPC
 * method.
 * </pre>
 *
 * Protobuf type {@code cosmos.staking.v1beta1.QueryHistoricalInfoResponse}
 */
public final class QueryHistoricalInfoResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cosmos.staking.v1beta1.QueryHistoricalInfoResponse)
    QueryHistoricalInfoResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QueryHistoricalInfoResponse.newBuilder() to construct.
  private QueryHistoricalInfoResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QueryHistoricalInfoResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new QueryHistoricalInfoResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryHistoricalInfoResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryHistoricalInfoResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse.class, com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse.Builder.class);
  }

  public static final int HIST_FIELD_NUMBER = 1;
  private com.cosmos.staking.v1beta1.HistoricalInfo hist_;
  /**
   * <pre>
   * hist defines the historical info at the given height.
   * </pre>
   *
   * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
   * @return Whether the hist field is set.
   */
  @java.lang.Override
  public boolean hasHist() {
    return hist_ != null;
  }
  /**
   * <pre>
   * hist defines the historical info at the given height.
   * </pre>
   *
   * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
   * @return The hist.
   */
  @java.lang.Override
  public com.cosmos.staking.v1beta1.HistoricalInfo getHist() {
    return hist_ == null ? com.cosmos.staking.v1beta1.HistoricalInfo.getDefaultInstance() : hist_;
  }
  /**
   * <pre>
   * hist defines the historical info at the given height.
   * </pre>
   *
   * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
   */
  @java.lang.Override
  public com.cosmos.staking.v1beta1.HistoricalInfoOrBuilder getHistOrBuilder() {
    return hist_ == null ? com.cosmos.staking.v1beta1.HistoricalInfo.getDefaultInstance() : hist_;
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
    if (hist_ != null) {
      output.writeMessage(1, getHist());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (hist_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getHist());
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
    if (!(obj instanceof com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse)) {
      return super.equals(obj);
    }
    com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse other = (com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse) obj;

    if (hasHist() != other.hasHist()) return false;
    if (hasHist()) {
      if (!getHist()
          .equals(other.getHist())) return false;
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
    if (hasHist()) {
      hash = (37 * hash) + HIST_FIELD_NUMBER;
      hash = (53 * hash) + getHist().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse parseFrom(
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
  public static Builder newBuilder(com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse prototype) {
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
   * QueryHistoricalInfoResponse is response type for the Query/HistoricalInfo RPC
   * method.
   * </pre>
   *
   * Protobuf type {@code cosmos.staking.v1beta1.QueryHistoricalInfoResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cosmos.staking.v1beta1.QueryHistoricalInfoResponse)
      com.cosmos.staking.v1beta1.QueryHistoricalInfoResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryHistoricalInfoResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryHistoricalInfoResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse.class, com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse.Builder.class);
    }

    // Construct using com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse.newBuilder()
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
      hist_ = null;
      if (histBuilder_ != null) {
        histBuilder_.dispose();
        histBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cosmos.staking.v1beta1.QueryProto.internal_static_cosmos_staking_v1beta1_QueryHistoricalInfoResponse_descriptor;
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse getDefaultInstanceForType() {
      return com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse build() {
      com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse buildPartial() {
      com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse result = new com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.hist_ = histBuilder_ == null
            ? hist_
            : histBuilder_.build();
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
      if (other instanceof com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse) {
        return mergeFrom((com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse other) {
      if (other == com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse.getDefaultInstance()) return this;
      if (other.hasHist()) {
        mergeHist(other.getHist());
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
                  getHistFieldBuilder().getBuilder(),
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

    private com.cosmos.staking.v1beta1.HistoricalInfo hist_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.cosmos.staking.v1beta1.HistoricalInfo, com.cosmos.staking.v1beta1.HistoricalInfo.Builder, com.cosmos.staking.v1beta1.HistoricalInfoOrBuilder> histBuilder_;
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     * @return Whether the hist field is set.
     */
    public boolean hasHist() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     * @return The hist.
     */
    public com.cosmos.staking.v1beta1.HistoricalInfo getHist() {
      if (histBuilder_ == null) {
        return hist_ == null ? com.cosmos.staking.v1beta1.HistoricalInfo.getDefaultInstance() : hist_;
      } else {
        return histBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     */
    public Builder setHist(com.cosmos.staking.v1beta1.HistoricalInfo value) {
      if (histBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        hist_ = value;
      } else {
        histBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     */
    public Builder setHist(
        com.cosmos.staking.v1beta1.HistoricalInfo.Builder builderForValue) {
      if (histBuilder_ == null) {
        hist_ = builderForValue.build();
      } else {
        histBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     */
    public Builder mergeHist(com.cosmos.staking.v1beta1.HistoricalInfo value) {
      if (histBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          hist_ != null &&
          hist_ != com.cosmos.staking.v1beta1.HistoricalInfo.getDefaultInstance()) {
          getHistBuilder().mergeFrom(value);
        } else {
          hist_ = value;
        }
      } else {
        histBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     */
    public Builder clearHist() {
      bitField0_ = (bitField0_ & ~0x00000001);
      hist_ = null;
      if (histBuilder_ != null) {
        histBuilder_.dispose();
        histBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     */
    public com.cosmos.staking.v1beta1.HistoricalInfo.Builder getHistBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getHistFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     */
    public com.cosmos.staking.v1beta1.HistoricalInfoOrBuilder getHistOrBuilder() {
      if (histBuilder_ != null) {
        return histBuilder_.getMessageOrBuilder();
      } else {
        return hist_ == null ?
            com.cosmos.staking.v1beta1.HistoricalInfo.getDefaultInstance() : hist_;
      }
    }
    /**
     * <pre>
     * hist defines the historical info at the given height.
     * </pre>
     *
     * <code>.cosmos.staking.v1beta1.HistoricalInfo hist = 1 [json_name = "hist"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.cosmos.staking.v1beta1.HistoricalInfo, com.cosmos.staking.v1beta1.HistoricalInfo.Builder, com.cosmos.staking.v1beta1.HistoricalInfoOrBuilder> 
        getHistFieldBuilder() {
      if (histBuilder_ == null) {
        histBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.cosmos.staking.v1beta1.HistoricalInfo, com.cosmos.staking.v1beta1.HistoricalInfo.Builder, com.cosmos.staking.v1beta1.HistoricalInfoOrBuilder>(
                getHist(),
                getParentForChildren(),
                isClean());
        hist_ = null;
      }
      return histBuilder_;
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


    // @@protoc_insertion_point(builder_scope:cosmos.staking.v1beta1.QueryHistoricalInfoResponse)
  }

  // @@protoc_insertion_point(class_scope:cosmos.staking.v1beta1.QueryHistoricalInfoResponse)
  private static final com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse();
  }

  public static com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QueryHistoricalInfoResponse>
      PARSER = new com.google.protobuf.AbstractParser<QueryHistoricalInfoResponse>() {
    @java.lang.Override
    public QueryHistoricalInfoResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<QueryHistoricalInfoResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QueryHistoricalInfoResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cosmos.staking.v1beta1.QueryHistoricalInfoResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

