// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smokeStore.proto

package com.adinneen.smokeStore;

public final class SmokeStoreProto {
  private SmokeStoreProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smokeStore_ListingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smokeStore_ListingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smokeStore_GamesSummary_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smokeStore_GamesSummary_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smokeStore_OwnedGamesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smokeStore_OwnedGamesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smokeStore_GamesOwned_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smokeStore_GamesOwned_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020smokeStore.proto\022\nsmokeStore\"%\n\016Listin" +
      "gRequest\022\023\n\013accountName\030\001 \001(\t\"\037\n\014GamesSu" +
      "mmary\022\017\n\007message\030\001 \001(\t\"(\n\021OwnedGamesRequ" +
      "est\022\023\n\013accountName\030\001 \001(\t\"\035\n\nGamesOwned\022\017" +
      "\n\007message\030\001 \001(\t2Z\n\020GetStoreListings\022F\n\ng" +
      "etSummary\022\032.smokeStore.ListingRequest\032\030." +
      "smokeStore.GamesSummary\"\000(\0012V\n\rGetOwnedG" +
      "ames\022E\n\010getOwned\022\035.smokeStore.OwnedGames" +
      "Request\032\026.smokeStore.GamesOwned\"\0000\001B,\n\027c" +
      "om.adinneen.smokeStoreB\017SmokeStoreProtoP" +
      "\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_smokeStore_ListingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smokeStore_ListingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smokeStore_ListingRequest_descriptor,
        new java.lang.String[] { "AccountName", });
    internal_static_smokeStore_GamesSummary_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_smokeStore_GamesSummary_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smokeStore_GamesSummary_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_smokeStore_OwnedGamesRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_smokeStore_OwnedGamesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smokeStore_OwnedGamesRequest_descriptor,
        new java.lang.String[] { "AccountName", });
    internal_static_smokeStore_GamesOwned_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_smokeStore_GamesOwned_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smokeStore_GamesOwned_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
