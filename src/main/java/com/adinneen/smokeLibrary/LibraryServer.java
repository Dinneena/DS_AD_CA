package com.adinneen.smokeLibrary;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;

import com.adinneen.smokeLibrary.LibraryGrpc.LibraryImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import jdk.jfr.internal.Logger;

public class LibraryServer extends LibraryImplBase {
	static HashMap<String, List<String>> libraryMap;

	public static void main(String[] args) {
		int port = 50051;
		String serviceType = "_grpc._tcp.local.";
		String serviceName = "GrpcLibraryServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, serviceType, serviceName);

		LibraryServer libraryServer = new LibraryServer();
		libraryMap = new HashMap<String, List<String>>();

		// sample dataset to pull account information from during the gRPC calls
		String[] blackMesa = { "Black Mesa", "Last Played: 03 December", "false" };
		String[] haloInfinate = { "Halo Infinate", "Last Played: 02 December", "false" };
		String[] Phasmophobia = { "Phasmophobia", "Last Played: 31 October", "true" };
		String[] residentEvil2 = { "Resident Evil 2", "Last Played: 02 December", "true" };
		String[] counterStrike = { "Counter Strike", "Last Played: 02 December", "false" };

		libraryMap.put("Black Mesa", Arrays.asList(blackMesa));
		libraryMap.put("Halo Infinate", Arrays.asList(haloInfinate));
		libraryMap.put("Phasmophobia", Arrays.asList(Phasmophobia));
		libraryMap.put("Resident Evil 2", Arrays.asList(residentEvil2));
		libraryMap.put("Counter Strike", Arrays.asList(counterStrike));

		try {
			Server server = ServerBuilder.forPort(port).addService(libraryServer).build().start();
			System.out.println("Library Server Started!");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * ---Unary---
	 */

	public void getGameInfo(GameRequest request, StreamObserver<Game> responseObserver) {
		System.out.println("The server has been called!");
		List<String> responses = libraryMap.get(request.getName());
		if (responses != null) {
			Game reply = Game.newBuilder().setName(responses.get(0)).setDesc(responses.get(1))
					.setInstalled(Boolean.parseBoolean(responses.get(2))).build();
			responseObserver.onNext(reply);
		} else {
			Game reply = Game.newBuilder().setName("Error").setDesc("Error").setInstalled(false).build();
			responseObserver.onNext(reply);
		}
		responseObserver.onCompleted();

	}

	/*
	 * ---Bidirectional Streaming---
	 */

	public StreamObserver<GameRequest> getInstalledGames(final StreamObserver<Game> responseObserver) {

		return new StreamObserver<GameRequest>() {
			@Override
			public void onNext(GameRequest game) {
				System.out.println(game.getName());

				List<String> responses = libraryMap.get(game.getName());
				if (responses != null) {
					Game reply = Game.newBuilder().setName(responses.toString()).build();
					responseObserver.onNext(reply);
				} else {
					Game reply = Game.newBuilder().setName(game.getName() + " is not currently in your Library.")
							.build();
					responseObserver.onNext(reply);
				}

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				responseObserver.onCompleted();
			}
		};

	}

}
