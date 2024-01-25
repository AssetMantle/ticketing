// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ibc/core/client/v1/tx.proto

package com.ibc.core.client.v1;

/**
 * <pre>
 * MsgSubmitMisbehaviourResponse defines the Msg/SubmitMisbehaviour response
 * type.
 * </pre>
 *
 * Protobuf type {@code ibc.core.client.v1.MsgSubmitMisbehaviourResponse}
 */
public final class MsgSubmitMisbehaviourResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ibc.core.client.v1.MsgSubmitMisbehaviourResponse)
    MsgSubmitMisbehaviourResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MsgSubmitMisbehaviourResponse.newBuilder() to construct.
  private MsgSubmitMisbehaviourResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MsgSubmitMisbehaviourResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MsgSubmitMisbehaviourResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ibc.core.client.v1.TxProto.internal_static_ibc_core_client_v1_MsgSubmitMisbehaviourResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ibc.core.client.v1.TxProto.internal_static_ibc_core_client_v1_MsgSubmitMisbehaviourResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse.class, com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse.Builder.class);
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
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse)) {
      return super.equals(obj);
    }
    com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse other = (com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse) obj;

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
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse parseFrom(
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
  public static Builder newBuilder(com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse prototype) {
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
   * MsgSubmitMisbehaviourResponse defines the Msg/SubmitMisbehaviour response
   * type.
   * </pre>
   *
   * Protobuf type {@code ibc.core.client.v1.MsgSubmitMisbehaviourResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ibc.core.client.v1.MsgSubmitMisbehaviourResponse)
      com.ibc.core.client.v1.MsgSubmitMisbehaviourResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ibc.core.client.v1.TxProto.internal_static_ibc_core_client_v1_MsgSubmitMisbehaviourResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ibc.core.client.v1.TxProto.internal_static_ibc_core_client_v1_MsgSubmitMisbehaviourResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse.class, com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse.Builder.class);
    }

    // Construct using com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ibc.core.client.v1.TxProto.internal_static_ibc_core_client_v1_MsgSubmitMisbehaviourResponse_descriptor;
    }

    @java.lang.Override
    public com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse getDefaultInstanceForType() {
      return com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse build() {
      com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse buildPartial() {
      com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse result = new com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse(this);
      onBuilt();
      return result;
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
      if (other instanceof com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse) {
        return mergeFrom((com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse other) {
      if (other == com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse.getDefaultInstance()) return this;
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


    // @@protoc_insertion_point(builder_scope:ibc.core.client.v1.MsgSubmitMisbehaviourResponse)
  }

  // @@protoc_insertion_point(class_scope:ibc.core.client.v1.MsgSubmitMisbehaviourResponse)
  private static final com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse();
  }

  public static com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MsgSubmitMisbehaviourResponse>
      PARSER = new com.google.protobuf.AbstractParser<MsgSubmitMisbehaviourResponse>() {
    @java.lang.Override
    public MsgSubmitMisbehaviourResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<MsgSubmitMisbehaviourResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MsgSubmitMisbehaviourResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ibc.core.client.v1.MsgSubmitMisbehaviourResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

