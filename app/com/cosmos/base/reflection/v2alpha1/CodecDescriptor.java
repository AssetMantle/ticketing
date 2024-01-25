// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/base/reflection/v2alpha1/reflection.proto

package com.cosmos.base.reflection.v2alpha1;

/**
 * <pre>
 * CodecDescriptor describes the registered interfaces and provides metadata information on the types
 * </pre>
 *
 * Protobuf type {@code cosmos.base.reflection.v2alpha1.CodecDescriptor}
 */
public final class CodecDescriptor extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cosmos.base.reflection.v2alpha1.CodecDescriptor)
    CodecDescriptorOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CodecDescriptor.newBuilder() to construct.
  private CodecDescriptor(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CodecDescriptor() {
    interfaces_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CodecDescriptor();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_CodecDescriptor_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_CodecDescriptor_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.cosmos.base.reflection.v2alpha1.CodecDescriptor.class, com.cosmos.base.reflection.v2alpha1.CodecDescriptor.Builder.class);
  }

  public static final int INTERFACES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor> interfaces_;
  /**
   * <pre>
   * interfaces is a list of the registerted interfaces descriptors
   * </pre>
   *
   * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
   */
  @java.lang.Override
  public java.util.List<com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor> getInterfacesList() {
    return interfaces_;
  }
  /**
   * <pre>
   * interfaces is a list of the registerted interfaces descriptors
   * </pre>
   *
   * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.cosmos.base.reflection.v2alpha1.InterfaceDescriptorOrBuilder> 
      getInterfacesOrBuilderList() {
    return interfaces_;
  }
  /**
   * <pre>
   * interfaces is a list of the registerted interfaces descriptors
   * </pre>
   *
   * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
   */
  @java.lang.Override
  public int getInterfacesCount() {
    return interfaces_.size();
  }
  /**
   * <pre>
   * interfaces is a list of the registerted interfaces descriptors
   * </pre>
   *
   * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
   */
  @java.lang.Override
  public com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor getInterfaces(int index) {
    return interfaces_.get(index);
  }
  /**
   * <pre>
   * interfaces is a list of the registerted interfaces descriptors
   * </pre>
   *
   * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
   */
  @java.lang.Override
  public com.cosmos.base.reflection.v2alpha1.InterfaceDescriptorOrBuilder getInterfacesOrBuilder(
      int index) {
    return interfaces_.get(index);
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
    for (int i = 0; i < interfaces_.size(); i++) {
      output.writeMessage(1, interfaces_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < interfaces_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, interfaces_.get(i));
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
    if (!(obj instanceof com.cosmos.base.reflection.v2alpha1.CodecDescriptor)) {
      return super.equals(obj);
    }
    com.cosmos.base.reflection.v2alpha1.CodecDescriptor other = (com.cosmos.base.reflection.v2alpha1.CodecDescriptor) obj;

    if (!getInterfacesList()
        .equals(other.getInterfacesList())) return false;
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
    if (getInterfacesCount() > 0) {
      hash = (37 * hash) + INTERFACES_FIELD_NUMBER;
      hash = (53 * hash) + getInterfacesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor parseFrom(
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
  public static Builder newBuilder(com.cosmos.base.reflection.v2alpha1.CodecDescriptor prototype) {
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
   * CodecDescriptor describes the registered interfaces and provides metadata information on the types
   * </pre>
   *
   * Protobuf type {@code cosmos.base.reflection.v2alpha1.CodecDescriptor}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cosmos.base.reflection.v2alpha1.CodecDescriptor)
      com.cosmos.base.reflection.v2alpha1.CodecDescriptorOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_CodecDescriptor_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_CodecDescriptor_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.base.reflection.v2alpha1.CodecDescriptor.class, com.cosmos.base.reflection.v2alpha1.CodecDescriptor.Builder.class);
    }

    // Construct using com.cosmos.base.reflection.v2alpha1.CodecDescriptor.newBuilder()
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
      if (interfacesBuilder_ == null) {
        interfaces_ = java.util.Collections.emptyList();
      } else {
        interfaces_ = null;
        interfacesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.cosmos.base.reflection.v2alpha1.ReflectionProto.internal_static_cosmos_base_reflection_v2alpha1_CodecDescriptor_descriptor;
    }

    @java.lang.Override
    public com.cosmos.base.reflection.v2alpha1.CodecDescriptor getDefaultInstanceForType() {
      return com.cosmos.base.reflection.v2alpha1.CodecDescriptor.getDefaultInstance();
    }

    @java.lang.Override
    public com.cosmos.base.reflection.v2alpha1.CodecDescriptor build() {
      com.cosmos.base.reflection.v2alpha1.CodecDescriptor result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.cosmos.base.reflection.v2alpha1.CodecDescriptor buildPartial() {
      com.cosmos.base.reflection.v2alpha1.CodecDescriptor result = new com.cosmos.base.reflection.v2alpha1.CodecDescriptor(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.cosmos.base.reflection.v2alpha1.CodecDescriptor result) {
      if (interfacesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          interfaces_ = java.util.Collections.unmodifiableList(interfaces_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.interfaces_ = interfaces_;
      } else {
        result.interfaces_ = interfacesBuilder_.build();
      }
    }

    private void buildPartial0(com.cosmos.base.reflection.v2alpha1.CodecDescriptor result) {
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
      if (other instanceof com.cosmos.base.reflection.v2alpha1.CodecDescriptor) {
        return mergeFrom((com.cosmos.base.reflection.v2alpha1.CodecDescriptor)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.cosmos.base.reflection.v2alpha1.CodecDescriptor other) {
      if (other == com.cosmos.base.reflection.v2alpha1.CodecDescriptor.getDefaultInstance()) return this;
      if (interfacesBuilder_ == null) {
        if (!other.interfaces_.isEmpty()) {
          if (interfaces_.isEmpty()) {
            interfaces_ = other.interfaces_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureInterfacesIsMutable();
            interfaces_.addAll(other.interfaces_);
          }
          onChanged();
        }
      } else {
        if (!other.interfaces_.isEmpty()) {
          if (interfacesBuilder_.isEmpty()) {
            interfacesBuilder_.dispose();
            interfacesBuilder_ = null;
            interfaces_ = other.interfaces_;
            bitField0_ = (bitField0_ & ~0x00000001);
            interfacesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getInterfacesFieldBuilder() : null;
          } else {
            interfacesBuilder_.addAllMessages(other.interfaces_);
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
              com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor m =
                  input.readMessage(
                      com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.parser(),
                      extensionRegistry);
              if (interfacesBuilder_ == null) {
                ensureInterfacesIsMutable();
                interfaces_.add(m);
              } else {
                interfacesBuilder_.addMessage(m);
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

    private java.util.List<com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor> interfaces_ =
      java.util.Collections.emptyList();
    private void ensureInterfacesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        interfaces_ = new java.util.ArrayList<com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor>(interfaces_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptorOrBuilder> interfacesBuilder_;

    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public java.util.List<com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor> getInterfacesList() {
      if (interfacesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(interfaces_);
      } else {
        return interfacesBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public int getInterfacesCount() {
      if (interfacesBuilder_ == null) {
        return interfaces_.size();
      } else {
        return interfacesBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor getInterfaces(int index) {
      if (interfacesBuilder_ == null) {
        return interfaces_.get(index);
      } else {
        return interfacesBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder setInterfaces(
        int index, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor value) {
      if (interfacesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInterfacesIsMutable();
        interfaces_.set(index, value);
        onChanged();
      } else {
        interfacesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder setInterfaces(
        int index, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder builderForValue) {
      if (interfacesBuilder_ == null) {
        ensureInterfacesIsMutable();
        interfaces_.set(index, builderForValue.build());
        onChanged();
      } else {
        interfacesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder addInterfaces(com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor value) {
      if (interfacesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInterfacesIsMutable();
        interfaces_.add(value);
        onChanged();
      } else {
        interfacesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder addInterfaces(
        int index, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor value) {
      if (interfacesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInterfacesIsMutable();
        interfaces_.add(index, value);
        onChanged();
      } else {
        interfacesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder addInterfaces(
        com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder builderForValue) {
      if (interfacesBuilder_ == null) {
        ensureInterfacesIsMutable();
        interfaces_.add(builderForValue.build());
        onChanged();
      } else {
        interfacesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder addInterfaces(
        int index, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder builderForValue) {
      if (interfacesBuilder_ == null) {
        ensureInterfacesIsMutable();
        interfaces_.add(index, builderForValue.build());
        onChanged();
      } else {
        interfacesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder addAllInterfaces(
        java.lang.Iterable<? extends com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor> values) {
      if (interfacesBuilder_ == null) {
        ensureInterfacesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, interfaces_);
        onChanged();
      } else {
        interfacesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder clearInterfaces() {
      if (interfacesBuilder_ == null) {
        interfaces_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        interfacesBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public Builder removeInterfaces(int index) {
      if (interfacesBuilder_ == null) {
        ensureInterfacesIsMutable();
        interfaces_.remove(index);
        onChanged();
      } else {
        interfacesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder getInterfacesBuilder(
        int index) {
      return getInterfacesFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public com.cosmos.base.reflection.v2alpha1.InterfaceDescriptorOrBuilder getInterfacesOrBuilder(
        int index) {
      if (interfacesBuilder_ == null) {
        return interfaces_.get(index);  } else {
        return interfacesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public java.util.List<? extends com.cosmos.base.reflection.v2alpha1.InterfaceDescriptorOrBuilder> 
         getInterfacesOrBuilderList() {
      if (interfacesBuilder_ != null) {
        return interfacesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(interfaces_);
      }
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder addInterfacesBuilder() {
      return getInterfacesFieldBuilder().addBuilder(
          com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.getDefaultInstance());
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder addInterfacesBuilder(
        int index) {
      return getInterfacesFieldBuilder().addBuilder(
          index, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.getDefaultInstance());
    }
    /**
     * <pre>
     * interfaces is a list of the registerted interfaces descriptors
     * </pre>
     *
     * <code>repeated .cosmos.base.reflection.v2alpha1.InterfaceDescriptor interfaces = 1 [json_name = "interfaces"];</code>
     */
    public java.util.List<com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder> 
         getInterfacesBuilderList() {
      return getInterfacesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptorOrBuilder> 
        getInterfacesFieldBuilder() {
      if (interfacesBuilder_ == null) {
        interfacesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptor.Builder, com.cosmos.base.reflection.v2alpha1.InterfaceDescriptorOrBuilder>(
                interfaces_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        interfaces_ = null;
      }
      return interfacesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:cosmos.base.reflection.v2alpha1.CodecDescriptor)
  }

  // @@protoc_insertion_point(class_scope:cosmos.base.reflection.v2alpha1.CodecDescriptor)
  private static final com.cosmos.base.reflection.v2alpha1.CodecDescriptor DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.cosmos.base.reflection.v2alpha1.CodecDescriptor();
  }

  public static com.cosmos.base.reflection.v2alpha1.CodecDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CodecDescriptor>
      PARSER = new com.google.protobuf.AbstractParser<CodecDescriptor>() {
    @java.lang.Override
    public CodecDescriptor parsePartialFrom(
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

  public static com.google.protobuf.Parser<CodecDescriptor> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CodecDescriptor> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.cosmos.base.reflection.v2alpha1.CodecDescriptor getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
