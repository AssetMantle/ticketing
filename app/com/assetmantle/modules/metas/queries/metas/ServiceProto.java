// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: metas/queries/metas/service.proto

package com.assetmantle.modules.metas.queries.metas;

public final class ServiceProto {
  private ServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!metas/queries/metas/service.proto\022\'ass" +
      "etmantle.modules.metas.queries.metas\032\034go" +
      "ogle/api/annotations.proto\032\'metas/querie" +
      "s/metas/query_request.proto\032(metas/queri" +
      "es/metas/query_response.proto2\246\001\n\005Query\022" +
      "\234\001\n\006Handle\0225.assetmantle.modules.metas.q" +
      "ueries.metas.QueryRequest\0326.assetmantle." +
      "modules.metas.queries.metas.QueryRespons" +
      "e\"#\202\323\344\223\002\035\022\033/mantle/metas/v1beta1/metasB\263" +
      "\002\n+com.assetmantle.modules.metas.queries" +
      ".metasB\014ServiceProtoP\001Z4github.com/Asset" +
      "Mantle/modules/x/metas/queries/metas\242\002\005A" +
      "MMQM\252\002\'Assetmantle.Modules.Metas.Queries" +
      ".Metas\312\002\'Assetmantle\\Modules\\Metas\\Queri" +
      "es\\Metas\342\0023Assetmantle\\Modules\\Metas\\Que" +
      "ries\\Metas\\GPBMetadata\352\002+Assetmantle::Mo" +
      "dules::Metas::Queries::Metasb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.assetmantle.modules.metas.queries.metas.QueryRequestProto.getDescriptor(),
          com.assetmantle.modules.metas.queries.metas.QueryResponseProto.getDescriptor(),
        });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.assetmantle.modules.metas.queries.metas.QueryRequestProto.getDescriptor();
    com.assetmantle.modules.metas.queries.metas.QueryResponseProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
