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


public class LibraryServer extends LibraryImplBase{
	static HashMap<String,List<String>> libraryMap;
	
	
	public static void main(String[] args) {
		int port = 50051;
		String serviceType = "_grpc._tcp.local.";
		String serviceName = "GrpcLibraryServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, serviceType, serviceName);
		
		LibraryServer libraryServer = new LibraryServer();
		libraryMap = new HashMap<String,List<String>>();
		
		//sample dataset to pull account information from during the gRPC calls
		String[] blackMesa = {"Black Mesa", "Last Played: 03 December", "State: Uninstalled"};
		String[] haloInfinate = {"Halo Infinate", "Last Played: 02 December", "State: Uninstalled"};
		String[] Phasmophobia = {"Phasmophobia", "Last Played: 31 October", "State: Installed"};
		String[] residentEvil2 = {"Resident Evil 2", "Last Played: 02 December", "State: Uninstalled"};
		String[] counterStrike = {"Counter Strike", "Last Played: 02 December", "State: Uninstalled"};
		
		libraryMap.put("Black Mesa", Arrays.asList(blackMesa));
		libraryMap.put("Halo Infinate", Arrays.asList(haloInfinate));
		libraryMap.put("Phasmophobia", Arrays.asList(Phasmophobia));
		libraryMap.put("Resident Evil 2", Arrays.asList(residentEvil2));
		libraryMap.put("Counter Strike", Arrays.asList(counterStrike));
	
		
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
	
	/*
	 *  ---Unary---
	*/
	
	public void getGameInfo(GameRequest request, StreamObserver<GameInfo> responseObserver) {
		System.out.println("The server has been called!");
		
		GameInfo reply = GameInfo
				.newBuilder()
				.setMessage("This is the game info for " + request.getAccountName() + ": " )
				.build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	

	/*
	 * ---Bidirectional Streaming---
	 */
	
	public StreamObserver<Game> getInstalledGames(final StreamObserver<Game> responseObserver){
		System.out.println("HERE");
		 System.out.println(responseObserver);
		return new StreamObserver<Game>() {
			@Override
			public void onNext(Game game) {
				System.out.println(game.getName());
				responseObserver.onNext(game);
//				ArrayList<Game> installRequests = getInstall(installRequest.getGame());
//				
//				//respond with all previous installs
//				for(Game prevInstallRequest : installRequests.toArray(new Game[0])) {
//					responseObserver.onNext(prevInstallRequest);
//				}
//				
//				//add install to list
//				installRequests.add(installRequest);
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
