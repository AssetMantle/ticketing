// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/core/channel/v1/query.proto

package com.ibc.core.channel.v1;

/**
 * <pre>
 * QueryUnreceivedAcksResponse is the response type for the
 * Query/UnreceivedAcks RPC method
 * </pre>
 *
 * Protobuf type {@code ibc.core.channel.v1.QueryUnreceivedAcksResponse}
 */
public final class QueryUnreceivedAcksResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ibc.core.channel.v1.QueryUnreceivedAcksResponse)
    QueryUnreceivedAcksResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QueryUnreceivedAcksResponse.newBuilder() to construct.
  private QueryUnreceivedAcksResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QueryUnreceivedAcksResponse() {
    sequences_ = emptyLongList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new QueryUnreceivedAcksResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ibc.core.channel.v1.QueryProto.internal_static_ibc_core_channel_v1_QueryUnreceivedAcksResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ibc.core.channel.v1.QueryProto.internal_static_ibc_core_channel_v1_QueryUnreceivedAcksResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ibc.core.channel.v1.QueryUnreceivedAcksResponse.class, com.ibc.core.channel.v1.QueryUnreceivedAcksResponse.Builder.class);
  }

  public static final int SEQUENCES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private com.google.protobuf.Internal.LongList sequences_;
  /**
   * <pre>
   * list of unreceived acknowledgement sequences
   * </pre>
   *
   * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
   * @return A list containing the sequences.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getSequencesList() {
    return sequences_;
  }
  /**
   * <pre>
   * list of unreceived acknowledgement sequences
   * </pre>
   *
   * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
   * @return The count of sequences.
   */
  public int getSequencesCount() {
    return sequences_.size();
  }
  /**
   * <pre>
   * list of unreceived acknowledgement sequences
   * </pre>
   *
   * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
   * @param index The index of the element to return.
   * @return The sequences at the given index.
   */
  public long getSequences(int index) {
    return sequences_.getLong(index);
  }
  private int sequencesMemoizedSerializedSize = -1;

  public static final int HEIGHT_FIELD_NUMBER = 2;
  private com.ibc.core.client.v1.Height height_;
  /**
   * <pre>
   * query block height
   * </pre>
   *
   * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
   * @return Whether the height field is set.
   */
  @java.lang.Override
  public boolean hasHeight() {
    return height_ != null;
  }
  /**
   * <pre>
   * query block height
   * </pre>
   *
   * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
   * @return The height.
   */
  @java.lang.Override
  public com.ibc.core.client.v1.Height getHeight() {
    return height_ == null ? com.ibc.core.client.v1.Height.getDefaultInstance() : height_;
  }
  /**
   * <pre>
   * query block height
   * </pre>
   *
   * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
   */
  @java.lang.Override
  public com.ibc.core.client.v1.HeightOrBuilder getHeightOrBuilder() {
    return height_ == null ? com.ibc.core.client.v1.Height.getDefaultInstance() : height_;
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
    getSerializedSize();
    if (getSequencesList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(sequencesMemoizedSerializedSize);
    }
    for (int i = 0; i < sequences_.size(); i++) {
      output.writeUInt64NoTag(sequences_.getLong(i));
    }
    if (height_ != null) {
      output.writeMessage(2, getHeight());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < sequences_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt64SizeNoTag(sequences_.getLong(i));
      }
      size += dataSize;
      if (!getSequencesList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      sequencesMemoizedSerializedSize = dataSize;
    }
    if (height_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getHeight());
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
    if (!(obj instanceof com.ibc.core.channel.v1.QueryUnreceivedAcksResponse)) {
      return super.equals(obj);
    }
    com.ibc.core.channel.v1.QueryUnreceivedAcksResponse other = (com.ibc.core.channel.v1.QueryUnreceivedAcksResponse) obj;

    if (!getSequencesList()
        .equals(other.getSequencesList())) return false;
    if (hasHeight() != other.hasHeight()) return false;
    if (hasHeight()) {
      if (!getHeight()
          .equals(other.getHeight())) return false;
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
    if (getSequencesCount() > 0) {
      hash = (37 * hash) + SEQUENCES_FIELD_NUMBER;
      hash = (53 * hash) + getSequencesList().hashCode();
    }
    if (hasHeight()) {
      hash = (37 * hash) + HEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getHeight().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse parseFrom(
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
  public static Builder newBuilder(com.ibc.core.channel.v1.QueryUnreceivedAcksResponse prototype) {
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
   * QueryUnreceivedAcksResponse is the response type for the
   * Query/UnreceivedAcks RPC method
   * </pre>
   *
   * Protobuf type {@code ibc.core.channel.v1.QueryUnreceivedAcksResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ibc.core.channel.v1.QueryUnreceivedAcksResponse)
      com.ibc.core.channel.v1.QueryUnreceivedAcksResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ibc.core.channel.v1.QueryProto.internal_static_ibc_core_channel_v1_QueryUnreceivedAcksResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ibc.core.channel.v1.QueryProto.internal_static_ibc_core_channel_v1_QueryUnreceivedAcksResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ibc.core.channel.v1.QueryUnreceivedAcksResponse.class, com.ibc.core.channel.v1.QueryUnreceivedAcksResponse.Builder.class);
    }

    // Construct using com.ibc.core.channel.v1.QueryUnreceivedAcksResponse.newBuilder()
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
      sequences_ = emptyLongList();
      height_ = null;
      if (heightBuilder_ != null) {
        heightBuilder_.dispose();
        heightBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ibc.core.channel.v1.QueryProto.internal_static_ibc_core_channel_v1_QueryUnreceivedAcksResponse_descriptor;
    }

    @java.lang.Override
    public com.ibc.core.channel.v1.QueryUnreceivedAcksResponse getDefaultInstanceForType() {
      return com.ibc.core.channel.v1.QueryUnreceivedAcksResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.ibc.core.channel.v1.QueryUnreceivedAcksResponse build() {
      com.ibc.core.channel.v1.QueryUnreceivedAcksResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ibc.core.channel.v1.QueryUnreceivedAcksResponse buildPartial() {
      com.ibc.core.channel.v1.QueryUnreceivedAcksResponse result = new com.ibc.core.channel.v1.QueryUnreceivedAcksResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.ibc.core.channel.v1.QueryUnreceivedAcksResponse result) {
      if (((bitField0_ & 0x00000001) != 0)) {
        sequences_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.sequences_ = sequences_;
    }

    private void buildPartial0(com.ibc.core.channel.v1.QueryUnreceivedAcksResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.height_ = heightBuilder_ == null
            ? height_
            : heightBuilder_.build();
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
      if (other instanceof com.ibc.core.channel.v1.QueryUnreceivedAcksResponse) {
        return mergeFrom((com.ibc.core.channel.v1.QueryUnreceivedAcksResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ibc.core.channel.v1.QueryUnreceivedAcksResponse other) {
      if (other == com.ibc.core.channel.v1.QueryUnreceivedAcksResponse.getDefaultInstance()) return this;
      if (!other.sequences_.isEmpty()) {
        if (sequences_.isEmpty()) {
          sequences_ = other.sequences_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureSequencesIsMutable();
          sequences_.addAll(other.sequences_);
        }
        onChanged();
      }
      if (other.hasHeight()) {
        mergeHeight(other.getHeight());
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
            case 8: {
              long v = input.readUInt64();
              ensureSequencesIsMutable();
              sequences_.addLong(v);
              break;
            } // case 8
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              ensureSequencesIsMutable();
              while (input.getBytesUntilLimit() > 0) {
                sequences_.addLong(input.readUInt64());
              }
              input.popLimit(limit);
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getHeightFieldBuilder().getBuilder(),
                  extensionRegistry);
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

    private com.google.protobuf.Internal.LongList sequences_ = emptyLongList();
    private void ensureSequencesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        sequences_ = mutableCopy(sequences_);
        bitField0_ |= 0x00000001;
      }
    }
    /**
     * <pre>
     * list of unreceived acknowledgement sequences
     * </pre>
     *
     * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
     * @return A list containing the sequences.
     */
    public java.util.List<java.lang.Long>
        getSequencesList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(sequences_) : sequences_;
    }
    /**
     * <pre>
     * list of unreceived acknowledgement sequences
     * </pre>
     *
     * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
     * @return The count of sequences.
     */
    public int getSequencesCount() {
      return sequences_.size();
    }
    /**
     * <pre>
     * list of unreceived acknowledgement sequences
     * </pre>
     *
     * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
     * @param index The index of the element to return.
     * @return The sequences at the given index.
     */
    public long getSequences(int index) {
      return sequences_.getLong(index);
    }
    /**
     * <pre>
     * list of unreceived acknowledgement sequences
     * </pre>
     *
     * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
     * @param index The index to set the value at.
     * @param value The sequences to set.
     * @return This builder for chaining.
     */
    public Builder setSequences(
        int index, long value) {

      ensureSequencesIsMutable();
      sequences_.setLong(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * list of unreceived acknowledgement sequences
     * </pre>
     *
     * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
     * @param value The sequences to add.
     * @return This builder for chaining.
     */
    public Builder addSequences(long value) {

      ensureSequencesIsMutable();
      sequences_.addLong(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * list of unreceived acknowledgement sequences
     * </pre>
     *
     * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
     * @param values The sequences to add.
     * @return This builder for chaining.
     */
    public Builder addAllSequences(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureSequencesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, sequences_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * list of unreceived acknowledgement sequences
     * </pre>
     *
     * <code>repeated uint64 sequences = 1 [json_name = "sequences"];</code>
     * @return This builder for chaining.
     */
    public Builder clearSequences() {
      sequences_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private com.ibc.core.client.v1.Height height_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ibc.core.client.v1.Height, com.ibc.core.client.v1.Height.Builder, com.ibc.core.client.v1.HeightOrBuilder> heightBuilder_;
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     * @return Whether the height field is set.
     */
    public boolean hasHeight() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     * @return The height.
     */
    public com.ibc.core.client.v1.Height getHeight() {
      if (heightBuilder_ == null) {
        return height_ == null ? com.ibc.core.client.v1.Height.getDefaultInstance() : height_;
      } else {
        return heightBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     */
    public Builder setHeight(com.ibc.core.client.v1.Height value) {
      if (heightBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        height_ = value;
      } else {
        heightBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     */
    public Builder setHeight(
        com.ibc.core.client.v1.Height.Builder builderForValue) {
      if (heightBuilder_ == null) {
        height_ = builderForValue.build();
      } else {
        heightBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     */
    public Builder mergeHeight(com.ibc.core.client.v1.Height value) {
      if (heightBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          height_ != null &&
          height_ != com.ibc.core.client.v1.Height.getDefaultInstance()) {
          getHeightBuilder().mergeFrom(value);
        } else {
          height_ = value;
        }
      } else {
        heightBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     */
    public Builder clearHeight() {
      bitField0_ = (bitField0_ & ~0x00000002);
      height_ = null;
      if (heightBuilder_ != null) {
        heightBuilder_.dispose();
        heightBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     */
    public com.ibc.core.client.v1.Height.Builder getHeightBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getHeightFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     */
    public com.ibc.core.client.v1.HeightOrBuilder getHeightOrBuilder() {
      if (heightBuilder_ != null) {
        return heightBuilder_.getMessageOrBuilder();
      } else {
        return height_ == null ?
            com.ibc.core.client.v1.Height.getDefaultInstance() : height_;
      }
    }
    /**
     * <pre>
     * query block height
     * </pre>
     *
     * <code>.ibc.core.client.v1.Height height = 2 [json_name = "height", (.gogoproto.nullable) = false];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ibc.core.client.v1.Height, com.ibc.core.client.v1.Height.Builder, com.ibc.core.client.v1.HeightOrBuilder> 
        getHeightFieldBuilder() {
      if (heightBuilder_ == null) {
        heightBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.ibc.core.client.v1.Height, com.ibc.core.client.v1.Height.Builder, com.ibc.core.client.v1.HeightOrBuilder>(
                getHeight(),
                getParentForChildren(),
                isClean());
        height_ = null;
      }
      return heightBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ibc.core.channel.v1.QueryUnreceivedAcksResponse)
  }

  // @@protoc_insertion_point(class_scope:ibc.core.channel.v1.QueryUnreceivedAcksResponse)
  private static final com.ibc.core.channel.v1.QueryUnreceivedAcksResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ibc.core.channel.v1.QueryUnreceivedAcksResponse();
  }

  public static com.ibc.core.channel.v1.QueryUnreceivedAcksResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QueryUnreceivedAcksResponse>
      PARSER = new com.google.protobuf.AbstractParser<QueryUnreceivedAcksResponse>() {
    @java.lang.Override
    public QueryUnreceivedAcksResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<QueryUnreceivedAcksResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QueryUnreceivedAcksResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ibc.core.channel.v1.QueryUnreceivedAcksResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

