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
 * <pre>
 *Client-side streaming
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smokeStore.proto")
public final class GetStoreListingsGrpc {

  private GetStoreListingsGrpc() {}

  public static final String SERVICE_NAME = "smokeStore.GetStoreListings";

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
    if ((getGetSummaryMethod = GetStoreListingsGrpc.getGetSummaryMethod) == null) {
      synchronized (GetStoreListingsGrpc.class) {
        if ((getGetSummaryMethod = GetStoreListingsGrpc.getGetSummaryMethod) == null) {
          GetStoreListingsGrpc.getGetSummaryMethod = getGetSummaryMethod = 
              io.grpc.MethodDescriptor.<com.adinneen.smokeStore.ListingRequest, com.adinneen.smokeStore.GamesSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smokeStore.GetStoreListings", "getSummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeStore.ListingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeStore.GamesSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new GetStoreListingsMethodDescriptorSupplier("getSummary"))
                  .build();
          }
        }
     }
     return getGetSummaryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetStoreListingsStub newStub(io.grpc.Channel channel) {
    return new GetStoreListingsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetStoreListingsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GetStoreListingsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GetStoreListingsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GetStoreListingsFutureStub(channel);
  }

  /**
   * <pre>
   *Client-side streaming
   * </pre>
   */
  public static abstract class GetStoreListingsImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.adinneen.smokeStore.ListingRequest> getSummary(
        io.grpc.stub.StreamObserver<com.adinneen.smokeStore.GamesSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetSummaryMethod(), responseObserver);
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
          .build();
    }
  }

  /**
   * <pre>
   *Client-side streaming
   * </pre>
   */
  public static final class GetStoreListingsStub extends io.grpc.stub.AbstractStub<GetStoreListingsStub> {
    private GetStoreListingsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetStoreListingsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetStoreListingsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetStoreListingsStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.adinneen.smokeStore.ListingRequest> getSummary(
        io.grpc.stub.StreamObserver<com.adinneen.smokeStore.GamesSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetSummaryMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Client-side streaming
   * </pre>
   */
  public static final class GetStoreListingsBlockingStub extends io.grpc.stub.AbstractStub<GetStoreListingsBlockingStub> {
    private GetStoreListingsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetStoreListingsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetStoreListingsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetStoreListingsBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   *Client-side streaming
   * </pre>
   */
  public static final class GetStoreListingsFutureStub extends io.grpc.stub.AbstractStub<GetStoreListingsFutureStub> {
    private GetStoreListingsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetStoreListingsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetStoreListingsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetStoreListingsFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_SUMMARY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetStoreListingsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetStoreListingsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
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

  private static abstract class GetStoreListingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetStoreListingsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.adinneen.smokeStore.SmokeStoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetStoreListings");
    }
  }

  private static final class GetStoreListingsFileDescriptorSupplier
      extends GetStoreListingsBaseDescriptorSupplier {
    GetStoreListingsFileDescriptorSupplier() {}
  }

  private static final class GetStoreListingsMethodDescriptorSupplier
      extends GetStoreListingsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetStoreListingsMethodDescriptorSupplier(String methodName) {
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
      synchronized (GetStoreListingsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetStoreListingsFileDescriptorSupplier())
              .addMethod(getGetSummaryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
