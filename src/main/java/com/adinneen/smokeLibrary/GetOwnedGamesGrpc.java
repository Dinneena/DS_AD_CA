package com.adinneen.smokeLibrary;

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
 * Unary rpc
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smokeLibrary.proto")
public final class GetOwnedGamesGrpc {

  private GetOwnedGamesGrpc() {}

  public static final String SERVICE_NAME = "smokeLibrary.GetOwnedGames";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.GameRequest,
      com.adinneen.smokeLibrary.GamesOwned> getGetGamesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getGames",
      requestType = com.adinneen.smokeLibrary.GameRequest.class,
      responseType = com.adinneen.smokeLibrary.GamesOwned.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.GameRequest,
      com.adinneen.smokeLibrary.GamesOwned> getGetGamesMethod() {
    io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.GameRequest, com.adinneen.smokeLibrary.GamesOwned> getGetGamesMethod;
    if ((getGetGamesMethod = GetOwnedGamesGrpc.getGetGamesMethod) == null) {
      synchronized (GetOwnedGamesGrpc.class) {
        if ((getGetGamesMethod = GetOwnedGamesGrpc.getGetGamesMethod) == null) {
          GetOwnedGamesGrpc.getGetGamesMethod = getGetGamesMethod = 
              io.grpc.MethodDescriptor.<com.adinneen.smokeLibrary.GameRequest, com.adinneen.smokeLibrary.GamesOwned>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smokeLibrary.GetOwnedGames", "getGames"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeLibrary.GameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeLibrary.GamesOwned.getDefaultInstance()))
                  .setSchemaDescriptor(new GetOwnedGamesMethodDescriptorSupplier("getGames"))
                  .build();
          }
        }
     }
     return getGetGamesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetOwnedGamesStub newStub(io.grpc.Channel channel) {
    return new GetOwnedGamesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetOwnedGamesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GetOwnedGamesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GetOwnedGamesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GetOwnedGamesFutureStub(channel);
  }

  /**
   * <pre>
   * Unary rpc
   * </pre>
   */
  public static abstract class GetOwnedGamesImplBase implements io.grpc.BindableService {

    /**
     */
    public void getGames(com.adinneen.smokeLibrary.GameRequest request,
        io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesOwned> responseObserver) {
      asyncUnimplementedUnaryCall(getGetGamesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetGamesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.adinneen.smokeLibrary.GameRequest,
                com.adinneen.smokeLibrary.GamesOwned>(
                  this, METHODID_GET_GAMES)))
          .build();
    }
  }

  /**
   * <pre>
   * Unary rpc
   * </pre>
   */
  public static final class GetOwnedGamesStub extends io.grpc.stub.AbstractStub<GetOwnedGamesStub> {
    private GetOwnedGamesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetOwnedGamesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetOwnedGamesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetOwnedGamesStub(channel, callOptions);
    }

    /**
     */
    public void getGames(com.adinneen.smokeLibrary.GameRequest request,
        io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesOwned> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGamesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Unary rpc
   * </pre>
   */
  public static final class GetOwnedGamesBlockingStub extends io.grpc.stub.AbstractStub<GetOwnedGamesBlockingStub> {
    private GetOwnedGamesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetOwnedGamesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetOwnedGamesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetOwnedGamesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.adinneen.smokeLibrary.GamesOwned getGames(com.adinneen.smokeLibrary.GameRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGamesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Unary rpc
   * </pre>
   */
  public static final class GetOwnedGamesFutureStub extends io.grpc.stub.AbstractStub<GetOwnedGamesFutureStub> {
    private GetOwnedGamesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetOwnedGamesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetOwnedGamesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetOwnedGamesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.adinneen.smokeLibrary.GamesOwned> getGames(
        com.adinneen.smokeLibrary.GameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGamesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_GAMES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetOwnedGamesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetOwnedGamesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_GAMES:
          serviceImpl.getGames((com.adinneen.smokeLibrary.GameRequest) request,
              (io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesOwned>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GetOwnedGamesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetOwnedGamesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.adinneen.smokeLibrary.SmokeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetOwnedGames");
    }
  }

  private static final class GetOwnedGamesFileDescriptorSupplier
      extends GetOwnedGamesBaseDescriptorSupplier {
    GetOwnedGamesFileDescriptorSupplier() {}
  }

  private static final class GetOwnedGamesMethodDescriptorSupplier
      extends GetOwnedGamesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetOwnedGamesMethodDescriptorSupplier(String methodName) {
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
      synchronized (GetOwnedGamesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetOwnedGamesFileDescriptorSupplier())
              .addMethod(getGetGamesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
