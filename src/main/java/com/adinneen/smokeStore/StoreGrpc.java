package com.adinneen.smokeStore;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smokeStore.proto")
public final class StoreGrpc {

  private StoreGrpc() {}

  public static final String SERVICE_NAME = "smokeStore.Store";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.adinneen.smokeStore.ListingRequest,
      com.adinneen.smokeStore.GamesSummary> getGetSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSummary",
      requestType = com.adinneen.smokeStore.ListingRequest.class,
      responseType = com.adinneen.smokeStore.GamesSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.adinneen.smokeStore.ListingRequest,
      com.adinneen.smokeStore.GamesSummary> getGetSummaryMethod() {
    io.grpc.MethodDescriptor<com.adinneen.smokeStore.ListingRequest, com.adinneen.smokeStore.GamesSummary> getGetSummaryMethod;
    if ((getGetSummaryMethod = StoreGrpc.getGetSummaryMethod) == null) {
      synchronized (StoreGrpc.class) {
        if ((getGetSummaryMethod = StoreGrpc.getGetSummaryMethod) == null) {
          StoreGrpc.getGetSummaryMethod = getGetSummaryMethod = 
              io.grpc.MethodDescriptor.<com.adinneen.smokeStore.ListingRequest, com.adinneen.smokeStore.GamesSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smokeStore.Store", "getSummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeStore.ListingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeStore.GamesSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new StoreMethodDescriptorSupplier("getSummary"))
                  .build();
          }
        }
     }
     return getGetSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.adinneen.smokeStore.OwnedGamesRequest,
      com.adinneen.smokeStore.GamesOwned> getGetOwnedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOwned",
      requestType = com.adinneen.smokeStore.OwnedGamesRequest.class,
      responseType = com.adinneen.smokeStore.GamesOwned.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.adinneen.smokeStore.OwnedGamesRequest,
      com.adinneen.smokeStore.GamesOwned> getGetOwnedMethod() {
    io.grpc.MethodDescriptor<com.adinneen.smokeStore.OwnedGamesRequest, com.adinneen.smokeStore.GamesOwned> getGetOwnedMethod;
    if ((getGetOwnedMethod = StoreGrpc.getGetOwnedMethod) == null) {
      synchronized (StoreGrpc.class) {
        if ((getGetOwnedMethod = StoreGrpc.getGetOwnedMethod) == null) {
          StoreGrpc.getGetOwnedMethod = getGetOwnedMethod = 
              io.grpc.MethodDescriptor.<com.adinneen.smokeStore.OwnedGamesRequest, com.adinneen.smokeStore.GamesOwned>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smokeStore.Store", "getOwned"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeStore.OwnedGamesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeStore.GamesOwned.getDefaultInstance()))
                  .setSchemaDescriptor(new StoreMethodDescriptorSupplier("getOwned"))
                  .build();
          }
        }
     }
     return getGetOwnedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StoreStub newStub(io.grpc.Channel channel) {
    return new StoreStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StoreBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StoreBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StoreFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StoreFutureStub(channel);
  }

  /**
   */
  public static abstract class StoreImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Client-side streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.adinneen.smokeStore.ListingRequest> getSummary(
        io.grpc.stub.StreamObserver<com.adinneen.smokeStore.GamesSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetSummaryMethod(), responseObserver);
    }

    /**
     * <pre>
     *Server-side streaming
     * </pre>
     */
    public void getOwned(com.adinneen.smokeStore.OwnedGamesRequest request,
        io.grpc.stub.StreamObserver<com.adinneen.smokeStore.GamesOwned> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOwnedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetSummaryMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.adinneen.smokeStore.ListingRequest,
                com.adinneen.smokeStore.GamesSummary>(
                  this, METHODID_GET_SUMMARY)))
          .addMethod(
            getGetOwnedMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.adinneen.smokeStore.OwnedGamesRequest,
                com.adinneen.smokeStore.GamesOwned>(
                  this, METHODID_GET_OWNED)))
          .build();
    }
  }

  /**
   */
  public static final class StoreStub extends io.grpc.stub.AbstractStub<StoreStub> {
    private StoreStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StoreStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StoreStub(channel, callOptions);
    }

    /**
     * <pre>
     *Client-side streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.adinneen.smokeStore.ListingRequest> getSummary(
        io.grpc.stub.StreamObserver<com.adinneen.smokeStore.GamesSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetSummaryMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *Server-side streaming
     * </pre>
     */
    public void getOwned(com.adinneen.smokeStore.OwnedGamesRequest request,
        io.grpc.stub.StreamObserver<com.adinneen.smokeStore.GamesOwned> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetOwnedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StoreBlockingStub extends io.grpc.stub.AbstractStub<StoreBlockingStub> {
    private StoreBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StoreBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StoreBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server-side streaming
     * </pre>
     */
    public java.util.Iterator<com.adinneen.smokeStore.GamesOwned> getOwned(
        com.adinneen.smokeStore.OwnedGamesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetOwnedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StoreFutureStub extends io.grpc.stub.AbstractStub<StoreFutureStub> {
    private StoreFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StoreFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StoreFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_OWNED = 0;
  private static final int METHODID_GET_SUMMARY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StoreImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_OWNED:
          serviceImpl.getOwned((com.adinneen.smokeStore.OwnedGamesRequest) request,
              (io.grpc.stub.StreamObserver<com.adinneen.smokeStore.GamesOwned>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SUMMARY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getSummary(
              (io.grpc.stub.StreamObserver<com.adinneen.smokeStore.GamesSummary>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.adinneen.smokeStore.SmokeStoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Store");
    }
  }

  private static final class StoreFileDescriptorSupplier
      extends StoreBaseDescriptorSupplier {
    StoreFileDescriptorSupplier() {}
  }

  private static final class StoreMethodDescriptorSupplier
      extends StoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StoreMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StoreFileDescriptorSupplier())
              .addMethod(getGetSummaryMethod())
              .addMethod(getGetOwnedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
