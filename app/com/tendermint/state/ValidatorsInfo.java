// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/state/types.proto

package com.tendermint.state;

/**
 * <pre>
 * ValidatorsInfo represents the latest validator set, or the last height it changed
 * </pre>
 *
 * Protobuf type {@code tendermint.state.ValidatorsInfo}
 */
public final class ValidatorsInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tendermint.state.ValidatorsInfo)
    ValidatorsInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ValidatorsInfo.newBuilder() to construct.
  private ValidatorsInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ValidatorsInfo() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ValidatorsInfo();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tendermint.state.TypesProto.internal_static_tendermint_state_ValidatorsInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tendermint.state.TypesProto.internal_static_tendermint_state_ValidatorsInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tendermint.state.ValidatorsInfo.class, com.tendermint.state.ValidatorsInfo.Builder.class);
  }

  public static final int VALIDATOR_SET_FIELD_NUMBER = 1;
  private com.tendermint.types.ValidatorSet validatorSet_;
  /**
   * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
   * @return Whether the validatorSet field is set.
   */
  @java.lang.Override
  public boolean hasValidatorSet() {
    return validatorSet_ != null;
  }
  /**
   * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
   * @return The validatorSet.
   */
  @java.lang.Override
  public com.tendermint.types.ValidatorSet getValidatorSet() {
    return validatorSet_ == null ? com.tendermint.types.ValidatorSet.getDefaultInstance() : validatorSet_;
  }
  /**
   * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
   */
  @java.lang.Override
  public com.tendermint.types.ValidatorSetOrBuilder getValidatorSetOrBuilder() {
    return validatorSet_ == null ? com.tendermint.types.ValidatorSet.getDefaultInstance() : validatorSet_;
  }

  public static final int LAST_HEIGHT_CHANGED_FIELD_NUMBER = 2;
  private long lastHeightChanged_ = 0L;
  /**
   * <code>int64 last_height_changed = 2 [json_name = "lastHeightChanged"];</code>
   * @return The lastHeightChanged.
   */
  @java.lang.Override
  public long getLastHeightChanged() {
    return lastHeightChanged_;
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
    if (validatorSet_ != null) {
      output.writeMessage(1, getValidatorSet());
    }
    if (lastHeightChanged_ != 0L) {
      output.writeInt64(2, lastHeightChanged_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (validatorSet_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getValidatorSet());
    }
    if (lastHeightChanged_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, lastHeightChanged_);
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
    if (!(obj instanceof com.tendermint.state.ValidatorsInfo)) {
      return super.equals(obj);
    }
    com.tendermint.state.ValidatorsInfo other = (com.tendermint.state.ValidatorsInfo) obj;

    if (hasValidatorSet() != other.hasValidatorSet()) return false;
    if (hasValidatorSet()) {
      if (!getValidatorSet()
          .equals(other.getValidatorSet())) return false;
    }
    if (getLastHeightChanged()
        != other.getLastHeightChanged()) return false;
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
    if (hasValidatorSet()) {
      hash = (37 * hash) + VALIDATOR_SET_FIELD_NUMBER;
      hash = (53 * hash) + getValidatorSet().hashCode();
    }
    hash = (37 * hash) + LAST_HEIGHT_CHANGED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastHeightChanged());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tendermint.state.ValidatorsInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tendermint.state.ValidatorsInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tendermint.state.ValidatorsInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tendermint.state.ValidatorsInfo parseFrom(
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
  public static Builder newBuilder(com.tendermint.state.ValidatorsInfo prototype) {
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
   * ValidatorsInfo represents the latest validator set, or the last height it changed
   * </pre>
   *
   * Protobuf type {@code tendermint.state.ValidatorsInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tendermint.state.ValidatorsInfo)
      com.tendermint.state.ValidatorsInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tendermint.state.TypesProto.internal_static_tendermint_state_ValidatorsInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tendermint.state.TypesProto.internal_static_tendermint_state_ValidatorsInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tendermint.state.ValidatorsInfo.class, com.tendermint.state.ValidatorsInfo.Builder.class);
    }

    // Construct using com.tendermint.state.ValidatorsInfo.newBuilder()
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
      validatorSet_ = null;
      if (validatorSetBuilder_ != null) {
        validatorSetBuilder_.dispose();
        validatorSetBuilder_ = null;
      }
      lastHeightChanged_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tendermint.state.TypesProto.internal_static_tendermint_state_ValidatorsInfo_descriptor;
    }

    @java.lang.Override
    public com.tendermint.state.ValidatorsInfo getDefaultInstanceForType() {
      return com.tendermint.state.ValidatorsInfo.getDefaultInstance();
    }

    @java.lang.Override
    public com.tendermint.state.ValidatorsInfo build() {
      com.tendermint.state.ValidatorsInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tendermint.state.ValidatorsInfo buildPartial() {
      com.tendermint.state.ValidatorsInfo result = new com.tendermint.state.ValidatorsInfo(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tendermint.state.ValidatorsInfo result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.validatorSet_ = validatorSetBuilder_ == null
            ? validatorSet_
            : validatorSetBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.lastHeightChanged_ = lastHeightChanged_;
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
      if (other instanceof com.tendermint.state.ValidatorsInfo) {
        return mergeFrom((com.tendermint.state.ValidatorsInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tendermint.state.ValidatorsInfo other) {
      if (other == com.tendermint.state.ValidatorsInfo.getDefaultInstance()) return this;
      if (other.hasValidatorSet()) {
        mergeValidatorSet(other.getValidatorSet());
      }
      if (other.getLastHeightChanged() != 0L) {
        setLastHeightChanged(other.getLastHeightChanged());
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
                  getValidatorSetFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              lastHeightChanged_ = input.readInt64();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
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

    private com.tendermint.types.ValidatorSet validatorSet_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tendermint.types.ValidatorSet, com.tendermint.types.ValidatorSet.Builder, com.tendermint.types.ValidatorSetOrBuilder> validatorSetBuilder_;
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     * @return Whether the validatorSet field is set.
     */
    public boolean hasValidatorSet() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     * @return The validatorSet.
     */
    public com.tendermint.types.ValidatorSet getValidatorSet() {
      if (validatorSetBuilder_ == null) {
        return validatorSet_ == null ? com.tendermint.types.ValidatorSet.getDefaultInstance() : validatorSet_;
      } else {
        return validatorSetBuilder_.getMessage();
      }
    }
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     */
    public Builder setValidatorSet(com.tendermint.types.ValidatorSet value) {
      if (validatorSetBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        validatorSet_ = value;
      } else {
        validatorSetBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     */
    public Builder setValidatorSet(
        com.tendermint.types.ValidatorSet.Builder builderForValue) {
      if (validatorSetBuilder_ == null) {
        validatorSet_ = builderForValue.build();
      } else {
        validatorSetBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     */
    public Builder mergeValidatorSet(com.tendermint.types.ValidatorSet value) {
      if (validatorSetBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          validatorSet_ != null &&
          validatorSet_ != com.tendermint.types.ValidatorSet.getDefaultInstance()) {
          getValidatorSetBuilder().mergeFrom(value);
        } else {
          validatorSet_ = value;
        }
      } else {
        validatorSetBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     */
    public Builder clearValidatorSet() {
      bitField0_ = (bitField0_ & ~0x00000001);
      validatorSet_ = null;
      if (validatorSetBuilder_ != null) {
        validatorSetBuilder_.dispose();
        validatorSetBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     */
    public com.tendermint.types.ValidatorSet.Builder getValidatorSetBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getValidatorSetFieldBuilder().getBuilder();
    }
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     */
    public com.tendermint.types.ValidatorSetOrBuilder getValidatorSetOrBuilder() {
      if (validatorSetBuilder_ != null) {
        return validatorSetBuilder_.getMessageOrBuilder();
      } else {
        return validatorSet_ == null ?
            com.tendermint.types.ValidatorSet.getDefaultInstance() : validatorSet_;
      }
    }
    /**
     * <code>.tendermint.types.ValidatorSet validator_set = 1 [json_name = "validatorSet"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tendermint.types.ValidatorSet, com.tendermint.types.ValidatorSet.Builder, com.tendermint.types.ValidatorSetOrBuilder> 
        getValidatorSetFieldBuilder() {
      if (validatorSetBuilder_ == null) {
        validatorSetBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tendermint.types.ValidatorSet, com.tendermint.types.ValidatorSet.Builder, com.tendermint.types.ValidatorSetOrBuilder>(
                getValidatorSet(),
                getParentForChildren(),
                isClean());
        validatorSet_ = null;
      }
      return validatorSetBuilder_;
    }

    private long lastHeightChanged_ ;
    /**
     * <code>int64 last_height_changed = 2 [json_name = "lastHeightChanged"];</code>
     * @return The lastHeightChanged.
     */
    @java.lang.Override
    public long getLastHeightChanged() {
      return lastHeightChanged_;
    }
    /**
     * <code>int64 last_height_changed = 2 [json_name = "lastHeightChanged"];</code>
     * @param value The lastHeightChanged to set.
     * @return This builder for chaining.
     */
    public Builder setLastHeightChanged(long value) {

      lastHeightChanged_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int64 last_height_changed = 2 [json_name = "lastHeightChanged"];</code>
     * @return This builder for chaining.
     */
    public Builder clearLastHeightChanged() {
      bitField0_ = (bitField0_ & ~0x00000002);
      lastHeightChanged_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:tendermint.state.ValidatorsInfo)
  }

  // @@protoc_insertion_point(class_scope:tendermint.state.ValidatorsInfo)
  private static final com.tendermint.state.ValidatorsInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tendermint.state.ValidatorsInfo();
  }

  public static com.tendermint.state.ValidatorsInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ValidatorsInfo>
      PARSER = new com.google.protobuf.AbstractParser<ValidatorsInfo>() {
    @java.lang.Override
    public ValidatorsInfo parsePartialFrom(
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

  public static com.google.protobuf.Parser<ValidatorsInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ValidatorsInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tendermint.state.ValidatorsInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

