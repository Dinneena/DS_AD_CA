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
 * Bi-directional Streaming
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smokeLibrary.proto")
public final class GetInstalledGamesGrpc {

  private GetInstalledGamesGrpc() {}

  public static final String SERVICE_NAME = "smokeLibrary.GetInstalledGames";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.InstalledRequest,
      com.adinneen.smokeLibrary.GamesInstalled> getGetInstallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getInstall",
      requestType = com.adinneen.smokeLibrary.InstalledRequest.class,
      responseType = com.adinneen.smokeLibrary.GamesInstalled.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.InstalledRequest,
      com.adinneen.smokeLibrary.GamesInstalled> getGetInstallMethod() {
    io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.InstalledRequest, com.adinneen.smokeLibrary.GamesInstalled> getGetInstallMethod;
    if ((getGetInstallMethod = GetInstalledGamesGrpc.getGetInstallMethod) == null) {
      synchronized (GetInstalledGamesGrpc.class) {
        if ((getGetInstallMethod = GetInstalledGamesGrpc.getGetInstallMethod) == null) {
          GetInstalledGamesGrpc.getGetInstallMethod = getGetInstallMethod = 
              io.grpc.MethodDescriptor.<com.adinneen.smokeLibrary.InstalledRequest, com.adinneen.smokeLibrary.GamesInstalled>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smokeLibrary.GetInstalledGames", "getInstall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeLibrary.InstalledRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeLibrary.GamesInstalled.getDefaultInstance()))
                  .setSchemaDescriptor(new GetInstalledGamesMethodDescriptorSupplier("getInstall"))
                  .build();
          }
        }
     }
     return getGetInstallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GetInstalledGamesStub newStub(io.grpc.Channel channel) {
    return new GetInstalledGamesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GetInstalledGamesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GetInstalledGamesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GetInstalledGamesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GetInstalledGamesFutureStub(channel);
  }

  /**
   * <pre>
   * Bi-directional Streaming
   * </pre>
   */
  public static abstract class GetInstalledGamesImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.InstalledRequest> getInstall(
        io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesInstalled> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetInstallMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetInstallMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.adinneen.smokeLibrary.InstalledRequest,
                com.adinneen.smokeLibrary.GamesInstalled>(
                  this, METHODID_GET_INSTALL)))
          .build();
    }
  }

  /**
   * <pre>
   * Bi-directional Streaming
   * </pre>
   */
  public static final class GetInstalledGamesStub extends io.grpc.stub.AbstractStub<GetInstalledGamesStub> {
    private GetInstalledGamesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetInstalledGamesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetInstalledGamesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetInstalledGamesStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.InstalledRequest> getInstall(
        io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesInstalled> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetInstallMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Bi-directional Streaming
   * </pre>
   */
  public static final class GetInstalledGamesBlockingStub extends io.grpc.stub.AbstractStub<GetInstalledGamesBlockingStub> {
    private GetInstalledGamesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetInstalledGamesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetInstalledGamesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetInstalledGamesBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Bi-directional Streaming
   * </pre>
   */
  public static final class GetInstalledGamesFutureStub extends io.grpc.stub.AbstractStub<GetInstalledGamesFutureStub> {
    private GetInstalledGamesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GetInstalledGamesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GetInstalledGamesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GetInstalledGamesFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_INSTALL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GetInstalledGamesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GetInstalledGamesImplBase serviceImpl, int methodId) {
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
        case METHODID_GET_INSTALL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getInstall(
              (io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesInstalled>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GetInstalledGamesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GetInstalledGamesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.adinneen.smokeLibrary.SmokeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GetInstalledGames");
    }
  }

  private static final class GetInstalledGamesFileDescriptorSupplier
      extends GetInstalledGamesBaseDescriptorSupplier {
    GetInstalledGamesFileDescriptorSupplier() {}
  }

  private static final class GetInstalledGamesMethodDescriptorSupplier
      extends GetInstalledGamesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GetInstalledGamesMethodDescriptorSupplier(String methodName) {
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
      synchronized (GetInstalledGamesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GetInstalledGamesFileDescriptorSupplier())
              .addMethod(getGetInstallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
