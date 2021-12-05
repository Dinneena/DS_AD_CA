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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smokeLibrary.proto")
public final class LibraryGrpc {

  private LibraryGrpc() {}

  public static final String SERVICE_NAME = "smokeLibrary.Library";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.GameRequest,
      com.adinneen.smokeLibrary.GameInfo> getGetGameInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getGameInfo",
      requestType = com.adinneen.smokeLibrary.GameRequest.class,
      responseType = com.adinneen.smokeLibrary.GameInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.GameRequest,
      com.adinneen.smokeLibrary.GameInfo> getGetGameInfoMethod() {
    io.grpc.MethodDescriptor<com.adinneen.smokeLibrary.GameRequest, com.adinneen.smokeLibrary.GameInfo> getGetGameInfoMethod;
    if ((getGetGameInfoMethod = LibraryGrpc.getGetGameInfoMethod) == null) {
      synchronized (LibraryGrpc.class) {
        if ((getGetGameInfoMethod = LibraryGrpc.getGetGameInfoMethod) == null) {
          LibraryGrpc.getGetGameInfoMethod = getGetGameInfoMethod = 
              io.grpc.MethodDescriptor.<com.adinneen.smokeLibrary.GameRequest, com.adinneen.smokeLibrary.GameInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smokeLibrary.Library", "getGameInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeLibrary.GameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeLibrary.GameInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new LibraryMethodDescriptorSupplier("getGameInfo"))
                  .build();
          }
        }
     }
     return getGetGameInfoMethod;
  }

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
    if ((getGetInstallMethod = LibraryGrpc.getGetInstallMethod) == null) {
      synchronized (LibraryGrpc.class) {
        if ((getGetInstallMethod = LibraryGrpc.getGetInstallMethod) == null) {
          LibraryGrpc.getGetInstallMethod = getGetInstallMethod = 
              io.grpc.MethodDescriptor.<com.adinneen.smokeLibrary.InstalledRequest, com.adinneen.smokeLibrary.GamesInstalled>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smokeLibrary.Library", "getInstall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeLibrary.InstalledRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.adinneen.smokeLibrary.GamesInstalled.getDefaultInstance()))
                  .setSchemaDescriptor(new LibraryMethodDescriptorSupplier("getInstall"))
                  .build();
          }
        }
     }
     return getGetInstallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LibraryStub newStub(io.grpc.Channel channel) {
    return new LibraryStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LibraryBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LibraryBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LibraryFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LibraryFutureStub(channel);
  }

  /**
   */
  public static abstract class LibraryImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary rpc
     * </pre>
     */
    public void getGameInfo(com.adinneen.smokeLibrary.GameRequest request,
        io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GameInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetGameInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     *Bidirectional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.InstalledRequest> getInstall(
        io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesInstalled> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetInstallMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetGameInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.adinneen.smokeLibrary.GameRequest,
                com.adinneen.smokeLibrary.GameInfo>(
                  this, METHODID_GET_GAME_INFO)))
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
   */
  public static final class LibraryStub extends io.grpc.stub.AbstractStub<LibraryStub> {
    private LibraryStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LibraryStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LibraryStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary rpc
     * </pre>
     */
    public void getGameInfo(com.adinneen.smokeLibrary.GameRequest request,
        io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GameInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGameInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Bidirectional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.InstalledRequest> getInstall(
        io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesInstalled> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetInstallMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LibraryBlockingStub extends io.grpc.stub.AbstractStub<LibraryBlockingStub> {
    private LibraryBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LibraryBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LibraryBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary rpc
     * </pre>
     */
    public com.adinneen.smokeLibrary.GameInfo getGameInfo(com.adinneen.smokeLibrary.GameRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGameInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LibraryFutureStub extends io.grpc.stub.AbstractStub<LibraryFutureStub> {
    private LibraryFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LibraryFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LibraryFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary rpc
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.adinneen.smokeLibrary.GameInfo> getGameInfo(
        com.adinneen.smokeLibrary.GameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGameInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_GAME_INFO = 0;
  private static final int METHODID_GET_INSTALL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LibraryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LibraryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_GAME_INFO:
          serviceImpl.getGameInfo((com.adinneen.smokeLibrary.GameRequest) request,
              (io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GameInfo>) responseObserver);
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
        case METHODID_GET_INSTALL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getInstall(
              (io.grpc.stub.StreamObserver<com.adinneen.smokeLibrary.GamesInstalled>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LibraryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LibraryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.adinneen.smokeLibrary.SmokeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Library");
    }
  }

  private static final class LibraryFileDescriptorSupplier
      extends LibraryBaseDescriptorSupplier {
    LibraryFileDescriptorSupplier() {}
  }

  private static final class LibraryMethodDescriptorSupplier
      extends LibraryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LibraryMethodDescriptorSupplier(String methodName) {
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
      synchronized (LibraryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LibraryFileDescriptorSupplier())
              .addMethod(getGetGameInfoMethod())
              .addMethod(getGetInstallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
