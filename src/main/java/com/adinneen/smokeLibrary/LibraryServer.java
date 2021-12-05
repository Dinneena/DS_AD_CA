package com.adinneen.smokeLibrary;


import com.adinneen.smokeLibrary.LibraryGrpc.LibraryImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LibraryServer extends LibraryImplBase{
	public static void main(String[] args) {
		int port = 50051;
		LibraryServer libraryServer = new LibraryServer();
		
		try {
			Server server = ServerBuilder
					.forPort(port)
					.addService(libraryServer)
					.build()
					.start();
			System.out.println("Library Server Started!");
			server.awaitTermination();
		}catch(Exception e) {
		 System.out.println(e);
		}
	}
	public void getGameInfo(GameRequest request, StreamObserver<GameInfo> responseObserver) {
		System.out.println("The server has been called!");
		
		GameInfo reply = GameInfo
				.newBuilder()
				.setMessage("This is the game info for " + request.getAccountName() + ": " )
				.build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}
