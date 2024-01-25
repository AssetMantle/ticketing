// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/applications/interchain_accounts/v1/packet.proto

package com.ibc.applications.interchain_accounts.v1;

/**
 * <pre>
 * InterchainAccountPacketData is comprised of a raw transaction, type of transaction and optional memo field.
 * </pre>
 *
 * Protobuf type {@code ibc.applications.interchain_accounts.v1.InterchainAccountPacketData}
 */
public final class InterchainAccountPacketData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ibc.applications.interchain_accounts.v1.InterchainAccountPacketData)
    InterchainAccountPacketDataOrBuilder {
private static final long serialVersionUID = 0L;
  // Use InterchainAccountPacketData.newBuilder() to construct.
  private InterchainAccountPacketData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private InterchainAccountPacketData() {
    type_ = 0;
    data_ = com.google.protobuf.ByteString.EMPTY;
    memo_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new InterchainAccountPacketData();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ibc.applications.interchain_accounts.v1.PacketProto.internal_static_ibc_applications_interchain_accounts_v1_InterchainAccountPacketData_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ibc.applications.interchain_accounts.v1.PacketProto.internal_static_ibc_applications_interchain_accounts_v1_InterchainAccountPacketData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData.class, com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData.Builder.class);
  }

  public static final int TYPE_FIELD_NUMBER = 1;
  private int type_ = 0;
  /**
   * <code>.ibc.applications.interchain_accounts.v1.Type type = 1 [json_name = "type"];</code>
   * @return The enum numeric value on the wire for type.
   */
  @java.lang.Override public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.ibc.applications.interchain_accounts.v1.Type type = 1 [json_name = "type"];</code>
   * @return The type.
   */
  @java.lang.Override public com.ibc.applications.interchain_accounts.v1.Type getType() {
    com.ibc.applications.interchain_accounts.v1.Type result = com.ibc.applications.interchain_accounts.v1.Type.forNumber(type_);
    return result == null ? com.ibc.applications.interchain_accounts.v1.Type.UNRECOGNIZED : result;
  }

  public static final int DATA_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes data = 2 [json_name = "data"];</code>
   * @return The data.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getData() {
    return data_;
  }

  public static final int MEMO_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object memo_ = "";
  /**
   * <code>string memo = 3 [json_name = "memo"];</code>
   * @return The memo.
   */
  @java.lang.Override
  public java.lang.String getMemo() {
    java.lang.Object ref = memo_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      memo_ = s;
      return s;
    }
  }
  /**
   * <code>string memo = 3 [json_name = "memo"];</code>
   * @return The bytes for memo.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMemoBytes() {
    java.lang.Object ref = memo_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      memo_ = b;
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
    if (type_ != com.ibc.applications.interchain_accounts.v1.Type.TYPE_UNSPECIFIED.getNumber()) {
      output.writeEnum(1, type_);
    }
    if (!data_.isEmpty()) {
      output.writeBytes(2, data_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(memo_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, memo_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (type_ != com.ibc.applications.interchain_accounts.v1.Type.TYPE_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, type_);
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, data_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(memo_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, memo_);
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
    if (!(obj instanceof com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData)) {
      return super.equals(obj);
    }
    com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData other = (com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData) obj;

    if (type_ != other.type_) return false;
    if (!getData()
        .equals(other.getData())) return false;
    if (!getMemo()
        .equals(other.getMemo())) return false;
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
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    hash = (37 * hash) + MEMO_FIELD_NUMBER;
    hash = (53 * hash) + getMemo().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData parseFrom(
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
  public static Builder newBuilder(com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData prototype) {
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
   * InterchainAccountPacketData is comprised of a raw transaction, type of transaction and optional memo field.
   * </pre>
   *
   * Protobuf type {@code ibc.applications.interchain_accounts.v1.InterchainAccountPacketData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ibc.applications.interchain_accounts.v1.InterchainAccountPacketData)
      com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ibc.applications.interchain_accounts.v1.PacketProto.internal_static_ibc_applications_interchain_accounts_v1_InterchainAccountPacketData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ibc.applications.interchain_accounts.v1.PacketProto.internal_static_ibc_applications_interchain_accounts_v1_InterchainAccountPacketData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData.class, com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData.Builder.class);
    }

    // Construct using com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData.newBuilder()
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
      type_ = 0;
      data_ = com.google.protobuf.ByteString.EMPTY;
      memo_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ibc.applications.interchain_accounts.v1.PacketProto.internal_static_ibc_applications_interchain_accounts_v1_InterchainAccountPacketData_descriptor;
    }

    @java.lang.Override
    public com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData getDefaultInstanceForType() {
      return com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData.getDefaultInstance();
    }

    @java.lang.Override
    public com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData build() {
      com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData buildPartial() {
      com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData result = new com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.type_ = type_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.data_ = data_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.memo_ = memo_;
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
      if (other instanceof com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData) {
        return mergeFrom((com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData other) {
      if (other == com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData.getDefaultInstance()) return this;
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
        setData(other.getData());
      }
      if (!other.getMemo().isEmpty()) {
        memo_ = other.memo_;
        bitField0_ |= 0x00000004;
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
            case 8: {
              type_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              data_ = input.readBytes();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              memo_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
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

    private int type_ = 0;
    /**
     * <code>.ibc.applications.interchain_accounts.v1.Type type = 1 [json_name = "type"];</code>
     * @return The enum numeric value on the wire for type.
     */
    @java.lang.Override public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.ibc.applications.interchain_accounts.v1.Type type = 1 [json_name = "type"];</code>
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(int value) {
      type_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.ibc.applications.interchain_accounts.v1.Type type = 1 [json_name = "type"];</code>
     * @return The type.
     */
    @java.lang.Override
    public com.ibc.applications.interchain_accounts.v1.Type getType() {
      com.ibc.applications.interchain_accounts.v1.Type result = com.ibc.applications.interchain_accounts.v1.Type.forNumber(type_);
      return result == null ? com.ibc.applications.interchain_accounts.v1.Type.UNRECOGNIZED : result;
    }
    /**
     * <code>.ibc.applications.interchain_accounts.v1.Type type = 1 [json_name = "type"];</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(com.ibc.applications.interchain_accounts.v1.Type value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.ibc.applications.interchain_accounts.v1.Type type = 1 [json_name = "type"];</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes data = 2 [json_name = "data"];</code>
     * @return The data.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getData() {
      return data_;
    }
    /**
     * <code>bytes data = 2 [json_name = "data"];</code>
     * @param value The data to set.
     * @return This builder for chaining.
     */
    public Builder setData(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      data_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bytes data = 2 [json_name = "data"];</code>
     * @return This builder for chaining.
     */
    public Builder clearData() {
      bitField0_ = (bitField0_ & ~0x00000002);
      data_ = getDefaultInstance().getData();
      onChanged();
      return this;
    }

    private java.lang.Object memo_ = "";
    /**
     * <code>string memo = 3 [json_name = "memo"];</code>
     * @return The memo.
     */
    public java.lang.String getMemo() {
      java.lang.Object ref = memo_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        memo_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string memo = 3 [json_name = "memo"];</code>
     * @return The bytes for memo.
     */
    public com.google.protobuf.ByteString
        getMemoBytes() {
      java.lang.Object ref = memo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        memo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string memo = 3 [json_name = "memo"];</code>
     * @param value The memo to set.
     * @return This builder for chaining.
     */
    public Builder setMemo(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      memo_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string memo = 3 [json_name = "memo"];</code>
     * @return This builder for chaining.
     */
    public Builder clearMemo() {
      memo_ = getDefaultInstance().getMemo();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string memo = 3 [json_name = "memo"];</code>
     * @param value The bytes for memo to set.
     * @return This builder for chaining.
     */
    public Builder setMemoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      memo_ = value;
      bitField0_ |= 0x00000004;
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


    // @@protoc_insertion_point(builder_scope:ibc.applications.interchain_accounts.v1.InterchainAccountPacketData)
  }

  // @@protoc_insertion_point(class_scope:ibc.applications.interchain_accounts.v1.InterchainAccountPacketData)
  private static final com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData();
  }

  public static com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<InterchainAccountPacketData>
      PARSER = new com.google.protobuf.AbstractParser<InterchainAccountPacketData>() {
    @java.lang.Override
    public InterchainAccountPacketData parsePartialFrom(
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

  public static com.google.protobuf.Parser<InterchainAccountPacketData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<InterchainAccountPacketData> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ibc.applications.interchain_accounts.v1.InterchainAccountPacketData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

