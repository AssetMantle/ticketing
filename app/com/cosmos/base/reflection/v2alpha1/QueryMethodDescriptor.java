// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/base/reflection/v2alpha1/reflection.proto

package com.cosmos.base.reflection.v2alpha1;

/**
 * <pre>
 * QueryMethodDescriptor describes a queryable method of a query service
 * no other info is provided beside method name and tendermint queryable path
 * because it would be redundant with the grpc reflection service
 * </pre>
 *
 * Protobuf type {@code cosmos.base.reflection.v2alpha1.QueryMethodDescriptor}
 */
public final class QueryMethodDescriptor extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cosmos.base.reflection.v2alpha1.QueryMethodDescriptor)
    QueryMethodDescriptorOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QueryMethodDescriptor.newBuilder() to construct.
  private QueryMethodDescriptor(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QueryMethodDescriptor() {
    name_ = "";
    fullQueryPath_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new QueryMethodDescriptor();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_QueryMethodDescriptor_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_QueryMethodDescriptor_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor.class, com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object name_ = "";
  /**
   * <pre>
   * name is the protobuf name (not fullname) of the method
   * </pre>
   *
   * <code>string name = 1 [json_name = "name"];</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * name is the protobuf name (not fullname) of the method
   * </pre>
   *
   * <code>string name = 1 [json_name = "name"];</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FULL_QUERY_PATH_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object fullQueryPath_ = "";
  /**
   * <pre>
   * full_query_path is the path that can be used to query
   * this method via tendermint abci.Query
   * </pre>
   *
   * <code>string full_query_path = 2 [json_name = "fullQueryPath"];</code>
   * @return The fullQueryPath.
   */
  @java.lang.Override
  public java.lang.String getFullQueryPath() {
    java.lang.Object ref = fullQueryPath_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fullQueryPath_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * full_query_path is the path that can be used to query
   * this method via tendermint abci.Query
   * </pre>
   *
   * <code>string full_query_path = 2 [json_name = "fullQueryPath"];</code>
   * @return The bytes for fullQueryPath.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFullQueryPathBytes() {
    java.lang.Object ref = fullQueryPath_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      fullQueryPath_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fullQueryPath_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, fullQueryPath_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fullQueryPath_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, fullQueryPath_);
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
    if (!(obj instanceof com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor)) {
      return super.equals(obj);
    }
    com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor other = (com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (!getFullQueryPath()
        .equals(other.getFullQueryPath())) return false;
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
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + FULL_QUERY_PATH_FIELD_NUMBER;
    hash = (53 * hash) + getFullQueryPath().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor parseFrom(
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
  public static Builder newBuilder(com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor prototype) {
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
   * QueryMethodDescriptor describes a queryable method of a query service
   * no other info is provided beside method name and tendermint queryable path
   * because it would be redundant with the grpc reflection service
   * </pre>
   *
   * Protobuf type {@code cosmos.base.reflection.v2alpha1.QueryMethodDescriptor}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cosmos.base.reflection.v2alpha1.QueryMethodDescriptor)
      com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptorOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_QueryMethodDescriptor_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_QueryMethodDescriptor_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor.class, com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor.Builder.class);
    }

    // Construct using com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor.newBuilder()
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
      name_ = "";
      fullQueryPath_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_QueryMethodDescriptor_descriptor;
    }

    @java.lang.Override
    public com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor getDefaultInstanceForType() {
      return com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor.getDefaultInstance();
    }

    @java.lang.Override
    public com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor build() {
      com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor buildPartial() {
      com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor result = new com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.name_ = name_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.fullQueryPath_ = fullQueryPath_;
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
      if (other instanceof com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor) {
        return mergeFrom((com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor other) {
      if (other == com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getFullQueryPath().isEmpty()) {
        fullQueryPath_ = other.fullQueryPath_;
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
              name_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              fullQueryPath_ = input.readStringRequireUtf8();
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

    private java.lang.Object name_ = "";
    /**
     * <pre>
     * name is the protobuf name (not fullname) of the method
     * </pre>
     *
     * <code>string name = 1 [json_name = "name"];</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * name is the protobuf name (not fullname) of the method
     * </pre>
     *
     * <code>string name = 1 [json_name = "name"];</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * name is the protobuf name (not fullname) of the method
     * </pre>
     *
     * <code>string name = 1 [json_name = "name"];</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * name is the protobuf name (not fullname) of the method
     * </pre>
     *
     * <code>string name = 1 [json_name = "name"];</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * name is the protobuf name (not fullname) of the method
     * </pre>
     *
     * <code>string name = 1 [json_name = "name"];</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object fullQueryPath_ = "";
    /**
     * <pre>
     * full_query_path is the path that can be used to query
     * this method via tendermint abci.Query
     * </pre>
     *
     * <code>string full_query_path = 2 [json_name = "fullQueryPath"];</code>
     * @return The fullQueryPath.
     */
    public java.lang.String getFullQueryPath() {
      java.lang.Object ref = fullQueryPath_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fullQueryPath_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * full_query_path is the path that can be used to query
     * this method via tendermint abci.Query
     * </pre>
     *
     * <code>string full_query_path = 2 [json_name = "fullQueryPath"];</code>
     * @return The bytes for fullQueryPath.
     */
    public com.google.protobuf.ByteString
        getFullQueryPathBytes() {
      java.lang.Object ref = fullQueryPath_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        fullQueryPath_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * full_query_path is the path that can be used to query
     * this method via tendermint abci.Query
     * </pre>
     *
     * <code>string full_query_path = 2 [json_name = "fullQueryPath"];</code>
     * @param value The fullQueryPath to set.
     * @return This builder for chaining.
     */
    public Builder setFullQueryPath(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      fullQueryPath_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * full_query_path is the path that can be used to query
     * this method via tendermint abci.Query
     * </pre>
     *
     * <code>string full_query_path = 2 [json_name = "fullQueryPath"];</code>
     * @return This builder for chaining.
     */
    public Builder clearFullQueryPath() {
      fullQueryPath_ = getDefaultInstance().getFullQueryPath();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * full_query_path is the path that can be used to query
     * this method via tendermint abci.Query
     * </pre>
     *
     * <code>string full_query_path = 2 [json_name = "fullQueryPath"];</code>
     * @param value The bytes for fullQueryPath to set.
     * @return This builder for chaining.
     */
    public Builder setFullQueryPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      fullQueryPath_ = value;
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


    // @@protoc_insertion_point(builder_scope:cosmos.base.reflection.v2alpha1.QueryMethodDescriptor)
  }

  // @@protoc_insertion_point(class_scope:cosmos.base.reflection.v2alpha1.QueryMethodDescriptor)
  private static final com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor();
  }

  public static com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QueryMethodDescriptor>
      PARSER = new com.google.protobuf.AbstractParser<QueryMethodDescriptor>() {
    @java.lang.Override
    public QueryMethodDescriptor parsePartialFrom(
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

  public static com.google.protobuf.Parser<QueryMethodDescriptor> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QueryMethodDescriptor> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cosmos.base.reflection.v2alpha1.QueryMethodDescriptor getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
