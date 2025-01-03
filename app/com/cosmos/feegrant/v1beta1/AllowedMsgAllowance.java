// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/feegrant/v1beta1/feegrant.proto

package com.cosmos.feegrant.v1beta1;

/**
 * <pre>
 * AllowedMsgAllowance creates allowance only for specified message types.
 * </pre>
 *
 * Protobuf type {@code cosmos.feegrant.v1beta1.AllowedMsgAllowance}
 */
public final class AllowedMsgAllowance extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cosmos.feegrant.v1beta1.AllowedMsgAllowance)
    AllowedMsgAllowanceOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AllowedMsgAllowance.newBuilder() to construct.
  private AllowedMsgAllowance(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AllowedMsgAllowance() {
    allowedMessages_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AllowedMsgAllowance();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cosmos.feegrant.v1beta1.FeegrantProto.internal_static_cosmos_feegrant_v1beta1_AllowedMsgAllowance_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cosmos.feegrant.v1beta1.FeegrantProto.internal_static_cosmos_feegrant_v1beta1_AllowedMsgAllowance_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cosmos.feegrant.v1beta1.AllowedMsgAllowance.class, com.cosmos.feegrant.v1beta1.AllowedMsgAllowance.Builder.class);
  }

  public static final int ALLOWANCE_FIELD_NUMBER = 1;
  private com.google.protobuf.Any allowance_;
  /**
   * <pre>
   * allowance can be any of basic and filtered fee allowance.
   * </pre>
   *
   * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
   * @return Whether the allowance field is set.
   */
  @java.lang.Override
  public boolean hasAllowance() {
    return allowance_ != null;
  }
  /**
   * <pre>
   * allowance can be any of basic and filtered fee allowance.
   * </pre>
   *
   * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
   * @return The allowance.
   */
  @java.lang.Override
  public com.google.protobuf.Any getAllowance() {
    return allowance_ == null ? com.google.protobuf.Any.getDefaultInstance() : allowance_;
  }
  /**
   * <pre>
   * allowance can be any of basic and filtered fee allowance.
   * </pre>
   *
   * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
   */
  @java.lang.Override
  public com.google.protobuf.AnyOrBuilder getAllowanceOrBuilder() {
    return allowance_ == null ? com.google.protobuf.Any.getDefaultInstance() : allowance_;
  }

  public static final int ALLOWED_MESSAGES_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringList allowedMessages_;
  /**
   * <pre>
   * allowed_messages are the messages for which the grantee has the access.
   * </pre>
   *
   * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
   * @return A list containing the allowedMessages.
   */
  public com.google.protobuf.ProtocolStringList
      getAllowedMessagesList() {
    return allowedMessages_;
  }
  /**
   * <pre>
   * allowed_messages are the messages for which the grantee has the access.
   * </pre>
   *
   * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
   * @return The count of allowedMessages.
   */
  public int getAllowedMessagesCount() {
    return allowedMessages_.size();
  }
  /**
   * <pre>
   * allowed_messages are the messages for which the grantee has the access.
   * </pre>
   *
   * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
   * @param index The index of the element to return.
   * @return The allowedMessages at the given index.
   */
  public java.lang.String getAllowedMessages(int index) {
    return allowedMessages_.get(index);
  }
  /**
   * <pre>
   * allowed_messages are the messages for which the grantee has the access.
   * </pre>
   *
   * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the allowedMessages at the given index.
   */
  public com.google.protobuf.ByteString
      getAllowedMessagesBytes(int index) {
    return allowedMessages_.getByteString(index);
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
    if (allowance_ != null) {
      output.writeMessage(1, getAllowance());
    }
    for (int i = 0; i < allowedMessages_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, allowedMessages_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (allowance_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAllowance());
    }
    {
      int dataSize = 0;
      for (int i = 0; i < allowedMessages_.size(); i++) {
        dataSize += computeStringSizeNoTag(allowedMessages_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getAllowedMessagesList().size();
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
    if (!(obj instanceof com.cosmos.feegrant.v1beta1.AllowedMsgAllowance)) {
      return super.equals(obj);
    }
    com.cosmos.feegrant.v1beta1.AllowedMsgAllowance other = (com.cosmos.feegrant.v1beta1.AllowedMsgAllowance) obj;

    if (hasAllowance() != other.hasAllowance()) return false;
    if (hasAllowance()) {
      if (!getAllowance()
          .equals(other.getAllowance())) return false;
    }
    if (!getAllowedMessagesList()
        .equals(other.getAllowedMessagesList())) return false;
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
    if (hasAllowance()) {
      hash = (37 * hash) + ALLOWANCE_FIELD_NUMBER;
      hash = (53 * hash) + getAllowance().hashCode();
    }
    if (getAllowedMessagesCount() > 0) {
      hash = (37 * hash) + ALLOWED_MESSAGES_FIELD_NUMBER;
      hash = (53 * hash) + getAllowedMessagesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance parseFrom(
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
  public static Builder newBuilder(com.cosmos.feegrant.v1beta1.AllowedMsgAllowance prototype) {
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
   * AllowedMsgAllowance creates allowance only for specified message types.
   * </pre>
   *
   * Protobuf type {@code cosmos.feegrant.v1beta1.AllowedMsgAllowance}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cosmos.feegrant.v1beta1.AllowedMsgAllowance)
      com.cosmos.feegrant.v1beta1.AllowedMsgAllowanceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.feegrant.v1beta1.FeegrantProto.internal_static_cosmos_feegrant_v1beta1_AllowedMsgAllowance_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.feegrant.v1beta1.FeegrantProto.internal_static_cosmos_feegrant_v1beta1_AllowedMsgAllowance_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.feegrant.v1beta1.AllowedMsgAllowance.class, com.cosmos.feegrant.v1beta1.AllowedMsgAllowance.Builder.class);
    }

    // Construct using com.cosmos.feegrant.v1beta1.AllowedMsgAllowance.newBuilder()
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
      allowance_ = null;
      if (allowanceBuilder_ != null) {
        allowanceBuilder_.dispose();
        allowanceBuilder_ = null;
      }
      allowedMessages_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cosmos.feegrant.v1beta1.FeegrantProto.internal_static_cosmos_feegrant_v1beta1_AllowedMsgAllowance_descriptor;
    }

    @java.lang.Override
    public com.cosmos.feegrant.v1beta1.AllowedMsgAllowance getDefaultInstanceForType() {
      return com.cosmos.feegrant.v1beta1.AllowedMsgAllowance.getDefaultInstance();
    }

    @java.lang.Override
    public com.cosmos.feegrant.v1beta1.AllowedMsgAllowance build() {
      com.cosmos.feegrant.v1beta1.AllowedMsgAllowance result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cosmos.feegrant.v1beta1.AllowedMsgAllowance buildPartial() {
      com.cosmos.feegrant.v1beta1.AllowedMsgAllowance result = new com.cosmos.feegrant.v1beta1.AllowedMsgAllowance(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.cosmos.feegrant.v1beta1.AllowedMsgAllowance result) {
      if (((bitField0_ & 0x00000002) != 0)) {
        allowedMessages_ = allowedMessages_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.allowedMessages_ = allowedMessages_;
    }

    private void buildPartial0(com.cosmos.feegrant.v1beta1.AllowedMsgAllowance result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.allowance_ = allowanceBuilder_ == null
            ? allowance_
            : allowanceBuilder_.build();
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
      if (other instanceof com.cosmos.feegrant.v1beta1.AllowedMsgAllowance) {
        return mergeFrom((com.cosmos.feegrant.v1beta1.AllowedMsgAllowance)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cosmos.feegrant.v1beta1.AllowedMsgAllowance other) {
      if (other == com.cosmos.feegrant.v1beta1.AllowedMsgAllowance.getDefaultInstance()) return this;
      if (other.hasAllowance()) {
        mergeAllowance(other.getAllowance());
      }
      if (!other.allowedMessages_.isEmpty()) {
        if (allowedMessages_.isEmpty()) {
          allowedMessages_ = other.allowedMessages_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureAllowedMessagesIsMutable();
          allowedMessages_.addAll(other.allowedMessages_);
        }
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
              input.readMessage(
                  getAllowanceFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureAllowedMessagesIsMutable();
              allowedMessages_.add(s);
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

    private com.google.protobuf.Any allowance_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> allowanceBuilder_;
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     * @return Whether the allowance field is set.
     */
    public boolean hasAllowance() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     * @return The allowance.
     */
    public com.google.protobuf.Any getAllowance() {
      if (allowanceBuilder_ == null) {
        return allowance_ == null ? com.google.protobuf.Any.getDefaultInstance() : allowance_;
      } else {
        return allowanceBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     */
    public Builder setAllowance(com.google.protobuf.Any value) {
      if (allowanceBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        allowance_ = value;
      } else {
        allowanceBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     */
    public Builder setAllowance(
        com.google.protobuf.Any.Builder builderForValue) {
      if (allowanceBuilder_ == null) {
        allowance_ = builderForValue.build();
      } else {
        allowanceBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     */
    public Builder mergeAllowance(com.google.protobuf.Any value) {
      if (allowanceBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          allowance_ != null &&
          allowance_ != com.google.protobuf.Any.getDefaultInstance()) {
          getAllowanceBuilder().mergeFrom(value);
        } else {
          allowance_ = value;
        }
      } else {
        allowanceBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     */
    public Builder clearAllowance() {
      bitField0_ = (bitField0_ & ~0x00000001);
      allowance_ = null;
      if (allowanceBuilder_ != null) {
        allowanceBuilder_.dispose();
        allowanceBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     */
    public com.google.protobuf.Any.Builder getAllowanceBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getAllowanceFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     */
    public com.google.protobuf.AnyOrBuilder getAllowanceOrBuilder() {
      if (allowanceBuilder_ != null) {
        return allowanceBuilder_.getMessageOrBuilder();
      } else {
        return allowance_ == null ?
            com.google.protobuf.Any.getDefaultInstance() : allowance_;
      }
    }
    /**
     * <pre>
     * allowance can be any of basic and filtered fee allowance.
     * </pre>
     *
     * <code>.google.protobuf.Any allowance = 1 [json_name = "allowance", (.cosmos_proto.accepts_interface) = "FeeAllowanceI"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> 
        getAllowanceFieldBuilder() {
      if (allowanceBuilder_ == null) {
        allowanceBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>(
                getAllowance(),
                getParentForChildren(),
                isClean());
        allowance_ = null;
      }
      return allowanceBuilder_;
    }

    private com.google.protobuf.LazyStringList allowedMessages_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureAllowedMessagesIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        allowedMessages_ = new com.google.protobuf.LazyStringArrayList(allowedMessages_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @return A list containing the allowedMessages.
     */
    public com.google.protobuf.ProtocolStringList
        getAllowedMessagesList() {
      return allowedMessages_.getUnmodifiableView();
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @return The count of allowedMessages.
     */
    public int getAllowedMessagesCount() {
      return allowedMessages_.size();
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @param index The index of the element to return.
     * @return The allowedMessages at the given index.
     */
    public java.lang.String getAllowedMessages(int index) {
      return allowedMessages_.get(index);
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @param index The index of the value to return.
     * @return The bytes of the allowedMessages at the given index.
     */
    public com.google.protobuf.ByteString
        getAllowedMessagesBytes(int index) {
      return allowedMessages_.getByteString(index);
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @param index The index to set the value at.
     * @param value The allowedMessages to set.
     * @return This builder for chaining.
     */
    public Builder setAllowedMessages(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureAllowedMessagesIsMutable();
      allowedMessages_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @param value The allowedMessages to add.
     * @return This builder for chaining.
     */
    public Builder addAllowedMessages(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureAllowedMessagesIsMutable();
      allowedMessages_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @param values The allowedMessages to add.
     * @return This builder for chaining.
     */
    public Builder addAllAllowedMessages(
        java.lang.Iterable<java.lang.String> values) {
      ensureAllowedMessagesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, allowedMessages_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @return This builder for chaining.
     */
    public Builder clearAllowedMessages() {
      allowedMessages_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * allowed_messages are the messages for which the grantee has the access.
     * </pre>
     *
     * <code>repeated string allowed_messages = 2 [json_name = "allowedMessages"];</code>
     * @param value The bytes of the allowedMessages to add.
     * @return This builder for chaining.
     */
    public Builder addAllowedMessagesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensureAllowedMessagesIsMutable();
      allowedMessages_.add(value);
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


    // @@protoc_insertion_point(builder_scope:cosmos.feegrant.v1beta1.AllowedMsgAllowance)
  }

  // @@protoc_insertion_point(class_scope:cosmos.feegrant.v1beta1.AllowedMsgAllowance)
  private static final com.cosmos.feegrant.v1beta1.AllowedMsgAllowance DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cosmos.feegrant.v1beta1.AllowedMsgAllowance();
  }

  public static com.cosmos.feegrant.v1beta1.AllowedMsgAllowance getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AllowedMsgAllowance>
      PARSER = new com.google.protobuf.AbstractParser<AllowedMsgAllowance>() {
    @java.lang.Override
    public AllowedMsgAllowance parsePartialFrom(
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

  public static com.google.protobuf.Parser<AllowedMsgAllowance> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AllowedMsgAllowance> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cosmos.feegrant.v1beta1.AllowedMsgAllowance getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

