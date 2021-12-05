package com.adinneen.smokeLibrary;

import com.adinneen.smokeLibrary.GetInstalledGamesGrpc.GetInstalledGamesImplBase;
import com.adinneen.smokeLibrary.GetOwnedGamesGrpc.GetOwnedGamesImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LibraryServer extends GetOwnedGamesImplBase{
	public static void main(String[] args) {
		int port = 50051;
		LibraryServer libraryServer = new LibraryServer();
		
		try {
			Server server = ServerBuilder
					.forPort(port)
					.addService(libraryServer)
					.build()
					.start();
			server.awaitTermination();
		}catch(Exception e) {
		 System.out.println(e);
		}
	}
	@Override
	public void getGames(GameRequest request, StreamObserver<GamesOwned> responseObserver) {
		System.out.println("The server has been called!");
		
		GamesOwned reply = GamesOwned
				.newBuilder()
				.setMessage("These are the games owned by " + request.getAccountName() + ": " )
				.build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}
