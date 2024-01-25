// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tendermint/abci/types.proto

package com.tendermint.abci;

/**
 * Protobuf type {@code tendermint.abci.ResponseInfo}
 */
public final class ResponseInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tendermint.abci.ResponseInfo)
    ResponseInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ResponseInfo.newBuilder() to construct.
  private ResponseInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ResponseInfo() {
    data_ = "";
    version_ = "";
    lastBlockAppHash_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ResponseInfo();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tendermint.abci.TypesProto.internal_static_tendermint_abci_ResponseInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tendermint.abci.TypesProto.internal_static_tendermint_abci_ResponseInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tendermint.abci.ResponseInfo.class, com.tendermint.abci.ResponseInfo.Builder.class);
  }

  public static final int DATA_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object data_ = "";
  /**
   * <code>string data = 1 [json_name = "data"];</code>
   * @return The data.
   */
  @java.lang.Override
  public java.lang.String getData() {
    java.lang.Object ref = data_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      data_ = s;
      return s;
    }
  }
  /**
   * <code>string data = 1 [json_name = "data"];</code>
   * @return The bytes for data.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDataBytes() {
    java.lang.Object ref = data_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      data_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VERSION_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object version_ = "";
  /**
   * <code>string version = 2 [json_name = "version"];</code>
   * @return The version.
   */
  @java.lang.Override
  public java.lang.String getVersion() {
    java.lang.Object ref = version_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      version_ = s;
      return s;
    }
  }
  /**
   * <code>string version = 2 [json_name = "version"];</code>
   * @return The bytes for version.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getVersionBytes() {
    java.lang.Object ref = version_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      version_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int APP_VERSION_FIELD_NUMBER = 3;
  private long appVersion_ = 0L;
  /**
   * <code>uint64 app_version = 3 [json_name = "appVersion"];</code>
   * @return The appVersion.
   */
  @java.lang.Override
  public long getAppVersion() {
    return appVersion_;
  }

  public static final int LAST_BLOCK_HEIGHT_FIELD_NUMBER = 4;
  private long lastBlockHeight_ = 0L;
  /**
   * <code>int64 last_block_height = 4 [json_name = "lastBlockHeight"];</code>
   * @return The lastBlockHeight.
   */
  @java.lang.Override
  public long getLastBlockHeight() {
    return lastBlockHeight_;
  }

  public static final int LAST_BLOCK_APP_HASH_FIELD_NUMBER = 5;
  private com.google.protobuf.ByteString lastBlockAppHash_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes last_block_app_hash = 5 [json_name = "lastBlockAppHash"];</code>
   * @return The lastBlockAppHash.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getLastBlockAppHash() {
    return lastBlockAppHash_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(data_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, data_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(version_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, version_);
    }
    if (appVersion_ != 0L) {
      output.writeUInt64(3, appVersion_);
    }
    if (lastBlockHeight_ != 0L) {
      output.writeInt64(4, lastBlockHeight_);
    }
    if (!lastBlockAppHash_.isEmpty()) {
      output.writeBytes(5, lastBlockAppHash_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(data_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, data_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(version_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, version_);
    }
    if (appVersion_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, appVersion_);
    }
    if (lastBlockHeight_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, lastBlockHeight_);
    }
    if (!lastBlockAppHash_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(5, lastBlockAppHash_);
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
    if (!(obj instanceof com.tendermint.abci.ResponseInfo)) {
      return super.equals(obj);
    }
    com.tendermint.abci.ResponseInfo other = (com.tendermint.abci.ResponseInfo) obj;

    if (!getData()
        .equals(other.getData())) return false;
    if (!getVersion()
        .equals(other.getVersion())) return false;
    if (getAppVersion()
        != other.getAppVersion()) return false;
    if (getLastBlockHeight()
        != other.getLastBlockHeight()) return false;
    if (!getLastBlockAppHash()
        .equals(other.getLastBlockAppHash())) return false;
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
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + getVersion().hashCode();
    hash = (37 * hash) + APP_VERSION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getAppVersion());
    hash = (37 * hash) + LAST_BLOCK_HEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastBlockHeight());
    hash = (37 * hash) + LAST_BLOCK_APP_HASH_FIELD_NUMBER;
    hash = (53 * hash) + getLastBlockAppHash().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tendermint.abci.ResponseInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tendermint.abci.ResponseInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tendermint.abci.ResponseInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tendermint.abci.ResponseInfo parseFrom(
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
  public static Builder newBuilder(com.tendermint.abci.ResponseInfo prototype) {
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
   * Protobuf type {@code tendermint.abci.ResponseInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tendermint.abci.ResponseInfo)
      com.tendermint.abci.ResponseInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tendermint.abci.TypesProto.internal_static_tendermint_abci_ResponseInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tendermint.abci.TypesProto.internal_static_tendermint_abci_ResponseInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tendermint.abci.ResponseInfo.class, com.tendermint.abci.ResponseInfo.Builder.class);
    }

    // Construct using com.tendermint.abci.ResponseInfo.newBuilder()
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
      data_ = "";
      version_ = "";
      appVersion_ = 0L;
      lastBlockHeight_ = 0L;
      lastBlockAppHash_ = com.google.protobuf.ByteString.EMPTY;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tendermint.abci.TypesProto.internal_static_tendermint_abci_ResponseInfo_descriptor;
    }

    @java.lang.Override
    public com.tendermint.abci.ResponseInfo getDefaultInstanceForType() {
      return com.tendermint.abci.ResponseInfo.getDefaultInstance();
    }

    @java.lang.Override
    public com.tendermint.abci.ResponseInfo build() {
      com.tendermint.abci.ResponseInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tendermint.abci.ResponseInfo buildPartial() {
      com.tendermint.abci.ResponseInfo result = new com.tendermint.abci.ResponseInfo(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tendermint.abci.ResponseInfo result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.data_ = data_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.version_ = version_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.appVersion_ = appVersion_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.lastBlockHeight_ = lastBlockHeight_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.lastBlockAppHash_ = lastBlockAppHash_;
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
      if (other instanceof com.tendermint.abci.ResponseInfo) {
        return mergeFrom((com.tendermint.abci.ResponseInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tendermint.abci.ResponseInfo other) {
      if (other == com.tendermint.abci.ResponseInfo.getDefaultInstance()) return this;
      if (!other.getData().isEmpty()) {
        data_ = other.data_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getVersion().isEmpty()) {
        version_ = other.version_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.getAppVersion() != 0L) {
        setAppVersion(other.getAppVersion());
      }
      if (other.getLastBlockHeight() != 0L) {
        setLastBlockHeight(other.getLastBlockHeight());
      }
      if (other.getLastBlockAppHash() != com.google.protobuf.ByteString.EMPTY) {
        setLastBlockAppHash(other.getLastBlockAppHash());
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
              data_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              version_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 24: {
              appVersion_ = input.readUInt64();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 32: {
              lastBlockHeight_ = input.readInt64();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            case 42: {
              lastBlockAppHash_ = input.readBytes();
              bitField0_ |= 0x00000010;
              break;
            } // case 42
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

    private java.lang.Object data_ = "";
    /**
     * <code>string data = 1 [json_name = "data"];</code>
     * @return The data.
     */
    public java.lang.String getData() {
      java.lang.Object ref = data_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        data_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string data = 1 [json_name = "data"];</code>
     * @return The bytes for data.
     */
    public com.google.protobuf.ByteString
        getDataBytes() {
      java.lang.Object ref = data_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        data_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string data = 1 [json_name = "data"];</code>
     * @param value The data to set.
     * @return This builder for chaining.
     */
    public Builder setData(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      data_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string data = 1 [json_name = "data"];</code>
     * @return This builder for chaining.
     */
    public Builder clearData() {
      data_ = getDefaultInstance().getData();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string data = 1 [json_name = "data"];</code>
     * @param value The bytes for data to set.
     * @return This builder for chaining.
     */
    public Builder setDataBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      data_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object version_ = "";
    /**
     * <code>string version = 2 [json_name = "version"];</code>
     * @return The version.
     */
    public java.lang.String getVersion() {
      java.lang.Object ref = version_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        version_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string version = 2 [json_name = "version"];</code>
     * @return The bytes for version.
     */
    public com.google.protobuf.ByteString
        getVersionBytes() {
      java.lang.Object ref = version_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        version_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string version = 2 [json_name = "version"];</code>
     * @param value The version to set.
     * @return This builder for chaining.
     */
    public Builder setVersion(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      version_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string version = 2 [json_name = "version"];</code>
     * @return This builder for chaining.
     */
    public Builder clearVersion() {
      version_ = getDefaultInstance().getVersion();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string version = 2 [json_name = "version"];</code>
     * @param value The bytes for version to set.
     * @return This builder for chaining.
     */
    public Builder setVersionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      version_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private long appVersion_ ;
    /**
     * <code>uint64 app_version = 3 [json_name = "appVersion"];</code>
     * @return The appVersion.
     */
    @java.lang.Override
    public long getAppVersion() {
      return appVersion_;
    }
    /**
     * <code>uint64 app_version = 3 [json_name = "appVersion"];</code>
     * @param value The appVersion to set.
     * @return This builder for chaining.
     */
    public Builder setAppVersion(long value) {

      appVersion_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 app_version = 3 [json_name = "appVersion"];</code>
     * @return This builder for chaining.
     */
    public Builder clearAppVersion() {
      bitField0_ = (bitField0_ & ~0x00000004);
      appVersion_ = 0L;
      onChanged();
      return this;
    }

    private long lastBlockHeight_ ;
    /**
     * <code>int64 last_block_height = 4 [json_name = "lastBlockHeight"];</code>
     * @return The lastBlockHeight.
     */
    @java.lang.Override
    public long getLastBlockHeight() {
      return lastBlockHeight_;
    }
    /**
     * <code>int64 last_block_height = 4 [json_name = "lastBlockHeight"];</code>
     * @param value The lastBlockHeight to set.
     * @return This builder for chaining.
     */
    public Builder setLastBlockHeight(long value) {

      lastBlockHeight_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>int64 last_block_height = 4 [json_name = "lastBlockHeight"];</code>
     * @return This builder for chaining.
     */
    public Builder clearLastBlockHeight() {
      bitField0_ = (bitField0_ & ~0x00000008);
      lastBlockHeight_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString lastBlockAppHash_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes last_block_app_hash = 5 [json_name = "lastBlockAppHash"];</code>
     * @return The lastBlockAppHash.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getLastBlockAppHash() {
      return lastBlockAppHash_;
    }
    /**
     * <code>bytes last_block_app_hash = 5 [json_name = "lastBlockAppHash"];</code>
     * @param value The lastBlockAppHash to set.
     * @return This builder for chaining.
     */
    public Builder setLastBlockAppHash(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      lastBlockAppHash_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>bytes last_block_app_hash = 5 [json_name = "lastBlockAppHash"];</code>
     * @return This builder for chaining.
     */
    public Builder clearLastBlockAppHash() {
      bitField0_ = (bitField0_ & ~0x00000010);
      lastBlockAppHash_ = getDefaultInstance().getLastBlockAppHash();
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


    // @@protoc_insertion_point(builder_scope:tendermint.abci.ResponseInfo)
  }

  // @@protoc_insertion_point(class_scope:tendermint.abci.ResponseInfo)
  private static final com.tendermint.abci.ResponseInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tendermint.abci.ResponseInfo();
  }

  public static com.tendermint.abci.ResponseInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ResponseInfo>
      PARSER = new com.google.protobuf.AbstractParser<ResponseInfo>() {
    @java.lang.Override
    public ResponseInfo parsePartialFrom(
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

  public static com.google.protobuf.Parser<ResponseInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ResponseInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tendermint.abci.ResponseInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
