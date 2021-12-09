package com.adinneen.smokeStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.adinneen.smokeLibrary.SimpleServiceRegistration;
import com.adinneen.smokeStore.StoreGrpc.StoreImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class StoreServer extends StoreImplBase {
	static HashMap storeMap;
	
	public static void main(String[] args) {
		int port = 50052;
		String serviceType = "_grpc._tcp.local.";
		String serviceName = "GrpcLibraryServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, serviceType, serviceName);
		
		StoreServer storeServer = new StoreServer();

		storeMap = new HashMap<String,ArrayList<String>>();

		//sample dataset to pull account information from during the gRPC calls
		String[] darkSouls = {"Dark Souls", "Dark Souls continues to push the boundaries with the latest in the genre-defining series.", "Price: €79.99", "Unowned"};
		String[] Bioshock = {"Bioshock", "BioShock is a shooter unlike any you've ever played, loaded with weapons and tactics never seen.", "Price: €59.99", "Unowned"};
		String[] bioshockInfinate = {"Bioshock Infinate", "Indebted to the wrong people, with his life on the line, Booker DeWitt has only one opportunity to wipe his slate clean.", "Price: €69.99"};
		String[] dishonored = {"Dishonored", "Dishonored is an immersive first-person action game that casts you as a supernatural assassin driven by revenge.", "Price: €79.99", "Unowned"};
		String[] prey = {"Prey", "In Prey, you awaken aboard Talos I, a space station orbiting the moon in the year 2032.", "Price: €49.99", "Unowned"};
		String[] left4Dead2 = {"Left 4 Dead 2", "Set in the zombie apocalypse, Left 4 Dead 2 (L4D2) is the highly anticipated sequel to the award-winning Left 4 Dead.", "Price: €15.99", "Unowned"};
		String[] eldenRing = {"Elden Ring", "Rise, Tarnished, and be guided by grace to brandish the power of the Elden Ring", "Price: €79.99", "Unowned"};
		String[] monsterHunterWorld = {"Monster Hunter World", "Welcome to a new world!", "Price: €59.99", "Unowned"};
		String[] Phasmophobia = {"Phasmophobia", "Phasmophobia is a 4 player online co-op psychological horror", "Price: €59.99", "Owned"};
		String[] residentEvil2 = {"Resident Evil 2","A deadly virus engulfs the residents of Raccoon City in September of 1998", "Price: €59.99", "Owned" };
		String[] counterStrike = {"Counter Strike","CS: GO expands upon the team-based action gameplay that it pioneered when it was launched 19 years ago.", "Price: Free", "Owned" };
		
		storeMap.put("Dark Souls", Arrays.asList(darkSouls));
		storeMap.put("Bioshocks", Arrays.asList(Bioshock));
		storeMap.put("Bioshock Infinate", Arrays.asList(bioshockInfinate));
		storeMap.put("Dishonored", Arrays.asList(dishonored));
		storeMap.put("Prey", Arrays.asList(prey));
		storeMap.put("Left 4 Dead 2", Arrays.asList(left4Dead2));
		storeMap.put("Elden Ring", Arrays.asList(eldenRing));
		storeMap.put("Monster Hunter World", Arrays.asList(monsterHunterWorld));
		storeMap.put("Phasmophobia", Arrays.asList(Phasmophobia));
		storeMap.put("Resident Evil 2", Arrays.asList(residentEvil2));
		storeMap.put("Counter Strike", Arrays.asList(counterStrike));
		
		
		try {
			Server server = ServerBuilder.forPort(port).addService(storeServer).build().start();
			System.out.println("Store Server Started!");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 *  ---Client-side streaming---
	*/
	
	@Override
	public StreamObserver<ListingRequest> getSummary(StreamObserver<GamesSummary> responseObserver) {
		System.out.println("On Server; Inside Streaming Method");
		ArrayList<String> responses = new ArrayList<>();
		return new StreamObserver<ListingRequest>() {

			@Override
			public void onNext(ListingRequest value) {
				// TODO Auto-generated method stub
				responses.add((String) storeMap.get(value.getGameList()));
				System.out.println("Value message received from client: " + value.getGameList());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				GamesSummary.Builder response = GamesSummary.newBuilder();
				response.setMessage(responses.toString());
				responseObserver.onNext(response.build());
				responseObserver.onCompleted();
			}

		};
	}
	
	/*
	 *  ---Server-side streaming---
	*/
	
	@Override
	public void getOwned(OwnedGamesRequest request, StreamObserver<GamesOwned> responseObserver) {
		//find out what was sent by the client
		String accountName = request.getAccountName();
		System.out.println("Account Name is: "+accountName);
		
		//build response
		GamesOwned.Builder response = GamesOwned.newBuilder();
		response.setMessage("Our first response is: "+accountName);
		
		//send out message
		responseObserver.onNext(response.build());
		
		response.setMessage("Our Second response is: ");
		responseObserver.onNext(response.build());
		
		response.setMessage("Our Third response is: ");
		responseObserver.onNext(response.build());
		
		responseObserver.onCompleted();	
		
	}

}
