// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/staking/v1beta1/staking.proto

package com.cosmos.staking.v1beta1;

/**
 * <pre>
 * DVPairs defines an array of DVPair objects.
 * </pre>
 *
 * Protobuf type {@code cosmos.staking.v1beta1.DVPairs}
 */
public final class DVPairs extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cosmos.staking.v1beta1.DVPairs)
    DVPairsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DVPairs.newBuilder() to construct.
  private DVPairs(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DVPairs() {
    pairs_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DVPairs();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cosmos.staking.v1beta1.StakingProto.internal_static_cosmos_staking_v1beta1_DVPairs_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cosmos.staking.v1beta1.StakingProto.internal_static_cosmos_staking_v1beta1_DVPairs_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cosmos.staking.v1beta1.DVPairs.class, com.cosmos.staking.v1beta1.DVPairs.Builder.class);
  }

  public static final int PAIRS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.cosmos.staking.v1beta1.DVPair> pairs_;
  /**
   * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
   */
  @java.lang.Override
  public java.util.List<com.cosmos.staking.v1beta1.DVPair> getPairsList() {
    return pairs_;
  }
  /**
   * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.cosmos.staking.v1beta1.DVPairOrBuilder> 
      getPairsOrBuilderList() {
    return pairs_;
  }
  /**
   * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
   */
  @java.lang.Override
  public int getPairsCount() {
    return pairs_.size();
  }
  /**
   * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
   */
  @java.lang.Override
  public com.cosmos.staking.v1beta1.DVPair getPairs(int index) {
    return pairs_.get(index);
  }
  /**
   * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
   */
  @java.lang.Override
  public com.cosmos.staking.v1beta1.DVPairOrBuilder getPairsOrBuilder(
      int index) {
    return pairs_.get(index);
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
    for (int i = 0; i < pairs_.size(); i++) {
      output.writeMessage(1, pairs_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < pairs_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, pairs_.get(i));
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
    if (!(obj instanceof com.cosmos.staking.v1beta1.DVPairs)) {
      return super.equals(obj);
    }
    com.cosmos.staking.v1beta1.DVPairs other = (com.cosmos.staking.v1beta1.DVPairs) obj;

    if (!getPairsList()
        .equals(other.getPairsList())) return false;
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
    if (getPairsCount() > 0) {
      hash = (37 * hash) + PAIRS_FIELD_NUMBER;
      hash = (53 * hash) + getPairsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.staking.v1beta1.DVPairs parseFrom(
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
  public static Builder newBuilder(com.cosmos.staking.v1beta1.DVPairs prototype) {
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
   * DVPairs defines an array of DVPair objects.
   * </pre>
   *
   * Protobuf type {@code cosmos.staking.v1beta1.DVPairs}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cosmos.staking.v1beta1.DVPairs)
      com.cosmos.staking.v1beta1.DVPairsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.staking.v1beta1.StakingProto.internal_static_cosmos_staking_v1beta1_DVPairs_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.staking.v1beta1.StakingProto.internal_static_cosmos_staking_v1beta1_DVPairs_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.staking.v1beta1.DVPairs.class, com.cosmos.staking.v1beta1.DVPairs.Builder.class);
    }

    // Construct using com.cosmos.staking.v1beta1.DVPairs.newBuilder()
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
      if (pairsBuilder_ == null) {
        pairs_ = java.util.Collections.emptyList();
      } else {
        pairs_ = null;
        pairsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cosmos.staking.v1beta1.StakingProto.internal_static_cosmos_staking_v1beta1_DVPairs_descriptor;
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.DVPairs getDefaultInstanceForType() {
      return com.cosmos.staking.v1beta1.DVPairs.getDefaultInstance();
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.DVPairs build() {
      com.cosmos.staking.v1beta1.DVPairs result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cosmos.staking.v1beta1.DVPairs buildPartial() {
      com.cosmos.staking.v1beta1.DVPairs result = new com.cosmos.staking.v1beta1.DVPairs(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.cosmos.staking.v1beta1.DVPairs result) {
      if (pairsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          pairs_ = java.util.Collections.unmodifiableList(pairs_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.pairs_ = pairs_;
      } else {
        result.pairs_ = pairsBuilder_.build();
      }
    }

    private void buildPartial0(com.cosmos.staking.v1beta1.DVPairs result) {
      int from_bitField0_ = bitField0_;
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
      if (other instanceof com.cosmos.staking.v1beta1.DVPairs) {
        return mergeFrom((com.cosmos.staking.v1beta1.DVPairs)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cosmos.staking.v1beta1.DVPairs other) {
      if (other == com.cosmos.staking.v1beta1.DVPairs.getDefaultInstance()) return this;
      if (pairsBuilder_ == null) {
        if (!other.pairs_.isEmpty()) {
          if (pairs_.isEmpty()) {
            pairs_ = other.pairs_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePairsIsMutable();
            pairs_.addAll(other.pairs_);
          }
          onChanged();
        }
      } else {
        if (!other.pairs_.isEmpty()) {
          if (pairsBuilder_.isEmpty()) {
            pairsBuilder_.dispose();
            pairsBuilder_ = null;
            pairs_ = other.pairs_;
            bitField0_ = (bitField0_ & ~0x00000001);
            pairsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPairsFieldBuilder() : null;
          } else {
            pairsBuilder_.addAllMessages(other.pairs_);
          }
        }
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
              com.cosmos.staking.v1beta1.DVPair m =
                  input.readMessage(
                      com.cosmos.staking.v1beta1.DVPair.parser(),
                      extensionRegistry);
              if (pairsBuilder_ == null) {
                ensurePairsIsMutable();
                pairs_.add(m);
              } else {
                pairsBuilder_.addMessage(m);
              }
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

    private java.util.List<com.cosmos.staking.v1beta1.DVPair> pairs_ =
      java.util.Collections.emptyList();
    private void ensurePairsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        pairs_ = new java.util.ArrayList<com.cosmos.staking.v1beta1.DVPair>(pairs_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.cosmos.staking.v1beta1.DVPair, com.cosmos.staking.v1beta1.DVPair.Builder, com.cosmos.staking.v1beta1.DVPairOrBuilder> pairsBuilder_;

    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public java.util.List<com.cosmos.staking.v1beta1.DVPair> getPairsList() {
      if (pairsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(pairs_);
      } else {
        return pairsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public int getPairsCount() {
      if (pairsBuilder_ == null) {
        return pairs_.size();
      } else {
        return pairsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public com.cosmos.staking.v1beta1.DVPair getPairs(int index) {
      if (pairsBuilder_ == null) {
        return pairs_.get(index);
      } else {
        return pairsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder setPairs(
        int index, com.cosmos.staking.v1beta1.DVPair value) {
      if (pairsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePairsIsMutable();
        pairs_.set(index, value);
        onChanged();
      } else {
        pairsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder setPairs(
        int index, com.cosmos.staking.v1beta1.DVPair.Builder builderForValue) {
      if (pairsBuilder_ == null) {
        ensurePairsIsMutable();
        pairs_.set(index, builderForValue.build());
        onChanged();
      } else {
        pairsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder addPairs(com.cosmos.staking.v1beta1.DVPair value) {
      if (pairsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePairsIsMutable();
        pairs_.add(value);
        onChanged();
      } else {
        pairsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder addPairs(
        int index, com.cosmos.staking.v1beta1.DVPair value) {
      if (pairsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePairsIsMutable();
        pairs_.add(index, value);
        onChanged();
      } else {
        pairsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder addPairs(
        com.cosmos.staking.v1beta1.DVPair.Builder builderForValue) {
      if (pairsBuilder_ == null) {
        ensurePairsIsMutable();
        pairs_.add(builderForValue.build());
        onChanged();
      } else {
        pairsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder addPairs(
        int index, com.cosmos.staking.v1beta1.DVPair.Builder builderForValue) {
      if (pairsBuilder_ == null) {
        ensurePairsIsMutable();
        pairs_.add(index, builderForValue.build());
        onChanged();
      } else {
        pairsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder addAllPairs(
        java.lang.Iterable<? extends com.cosmos.staking.v1beta1.DVPair> values) {
      if (pairsBuilder_ == null) {
        ensurePairsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, pairs_);
        onChanged();
      } else {
        pairsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder clearPairs() {
      if (pairsBuilder_ == null) {
        pairs_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        pairsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public Builder removePairs(int index) {
      if (pairsBuilder_ == null) {
        ensurePairsIsMutable();
        pairs_.remove(index);
        onChanged();
      } else {
        pairsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public com.cosmos.staking.v1beta1.DVPair.Builder getPairsBuilder(
        int index) {
      return getPairsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public com.cosmos.staking.v1beta1.DVPairOrBuilder getPairsOrBuilder(
        int index) {
      if (pairsBuilder_ == null) {
        return pairs_.get(index);  } else {
        return pairsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public java.util.List<? extends com.cosmos.staking.v1beta1.DVPairOrBuilder> 
         getPairsOrBuilderList() {
      if (pairsBuilder_ != null) {
        return pairsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(pairs_);
      }
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public com.cosmos.staking.v1beta1.DVPair.Builder addPairsBuilder() {
      return getPairsFieldBuilder().addBuilder(
          com.cosmos.staking.v1beta1.DVPair.getDefaultInstance());
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public com.cosmos.staking.v1beta1.DVPair.Builder addPairsBuilder(
        int index) {
      return getPairsFieldBuilder().addBuilder(
          index, com.cosmos.staking.v1beta1.DVPair.getDefaultInstance());
    }
    /**
     * <code>repeated .cosmos.staking.v1beta1.DVPair pairs = 1 [json_name = "pairs", (.gogoproto.nullable) = false];</code>
     */
    public java.util.List<com.cosmos.staking.v1beta1.DVPair.Builder> 
         getPairsBuilderList() {
      return getPairsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.cosmos.staking.v1beta1.DVPair, com.cosmos.staking.v1beta1.DVPair.Builder, com.cosmos.staking.v1beta1.DVPairOrBuilder> 
        getPairsFieldBuilder() {
      if (pairsBuilder_ == null) {
        pairsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.cosmos.staking.v1beta1.DVPair, com.cosmos.staking.v1beta1.DVPair.Builder, com.cosmos.staking.v1beta1.DVPairOrBuilder>(
                pairs_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        pairs_ = null;
      }
      return pairsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:cosmos.staking.v1beta1.DVPairs)
  }

  // @@protoc_insertion_point(class_scope:cosmos.staking.v1beta1.DVPairs)
  private static final com.cosmos.staking.v1beta1.DVPairs DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cosmos.staking.v1beta1.DVPairs();
  }

  public static com.cosmos.staking.v1beta1.DVPairs getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DVPairs>
      PARSER = new com.google.protobuf.AbstractParser<DVPairs>() {
    @java.lang.Override
    public DVPairs parsePartialFrom(
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

  public static com.google.protobuf.Parser<DVPairs> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DVPairs> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cosmos.staking.v1beta1.DVPairs getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
