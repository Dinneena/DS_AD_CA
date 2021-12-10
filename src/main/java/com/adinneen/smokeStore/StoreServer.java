package com.adinneen.smokeStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.adinneen.smokeStore.StoreGrpc.StoreImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class StoreServer extends StoreImplBase {
	static HashMap<String, List<String>> storeMap;

	public static void main(String[] args) {
		int port2 = 50052;
		String serviceType = "_http._tcp.local.";
		String serviceName = "GrpcLibraryServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port2, serviceType, serviceName);

		StoreServer storeServer = new StoreServer();

		storeMap = new HashMap<String, List<String>>();

		// sample dataset to pull account information from during the gRPC calls
		String[] darkSouls = { "Dark Souls",
				"Dark Souls continues to push the boundaries with the latest in the genre-defining series.", "false" };
		String[] Bioshock = { "Bioshock",
				"BioShock is a shooter unlike any you've ever played, loaded with weapons and tactics never seen.",
				"true" };
		String[] bioshockInfinite = { "Bioshock Infinite",
				"Indebted to the wrong people, with his life on the line, Booker DeWitt has only one opportunity to wipe his slate clean.", "false" };
		String[] dishonored = { "Dishonored",
				"Dishonored is an immersive first-person action StoreGame that casts you as a supernatural assassin driven by revenge.",
				"true" };
		String[] prey = { "Prey",
				"In Prey, you awaken aboard Talos I, a space station orbiting the moon in the year 2032.", "true" };
		String[] left4Dead2 = { "Left 4 Dead 2",
				"Set in the zombie apocalypse, Left 4 Dead 2 (L4D2) is the highly anticipated sequel to the award-winning Left 4 Dead.",
				"true" };
		String[] eldenRing = { "Elden Ring",
				"Rise, Tarnished, and be guided by grace to brandish the power of the Elden Ring", "true" };
		String[] monsterHunterWorld = { "Monster Hunter World", "Welcome to a new world!", "true" };
		String[] Phasmophobia = { "Phasmophobia", "Phasmophobia is a 4 player online co-op psychological horror",
				"true" };
		String[] residentEvil2 = { "Resident Evil 2",
				"A deadly virus engulfs the residents of Raccoon City in September of 1998", "true" };
		String[] counterStrike = { "Counter Strike",
				"CS: GO expands upon the team-based action StoreGameplay that it pioneered when it was launched 19 years ago.",
				"true" };

		storeMap.put("dark souls", Arrays.asList(darkSouls));
		storeMap.put("bioshock", Arrays.asList(Bioshock));
		storeMap.put("bioshock infinite", Arrays.asList(bioshockInfinite));
		storeMap.put("dishonored", Arrays.asList(dishonored));
		storeMap.put("prey", Arrays.asList(prey));
		storeMap.put("left 4 dead 2", Arrays.asList(left4Dead2));
		storeMap.put("elden ring", Arrays.asList(eldenRing));
		storeMap.put("monster hunter world", Arrays.asList(monsterHunterWorld));
		storeMap.put("phasmophobia", Arrays.asList(Phasmophobia));
		storeMap.put("resident evil 2", Arrays.asList(residentEvil2));
		storeMap.put("counter strike", Arrays.asList(counterStrike));

		try {
			Server server = ServerBuilder.forPort(port2).addService(storeServer).build().start();
			System.out.println("Store Server Started!");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * ---Client-side streaming---
	 */

	@Override
	public StreamObserver<StoreGameRequest> getSummary(StreamObserver<GamesSummary> responseObserver) {
		System.out.println("On Server; Inside Streaming Method");
		return new StreamObserver<StoreGameRequest>() {
			String gamesStr = "";

			@Override
			public void onNext(StoreGameRequest value) {
				if (storeMap.get(value.getName().toLowerCase()) != null) {
					gamesStr += storeMap.get(value.getName().toLowerCase()).get(0) + " : "
							+ storeMap.get(value.getName().toLowerCase()).get(1) + "\n";
				} else {
					gamesStr += value.getName() + " does not exist" + "\n";
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				GamesSummary.Builder response = GamesSummary.newBuilder();
				response.setSummary(gamesStr);
				responseObserver.onNext(response.build());
				responseObserver.onCompleted();
			}

		};
	}

	/*
	 * ---Server-side streaming---
	 */

	@Override
	public void getOwned(StoreGameRequest request, StreamObserver<StoreGame> responseObserver) {
		String[] listings = request.getName().split(",");
		for (String game : listings) {
			List<String> summary = storeMap.get(game.trim().toLowerCase());
			if(summary != null) {
				String owned = summary.get(2);
				if (Boolean.parseBoolean(owned)) {
					System.out.println(owned + " OWNED");
					StoreGame.Builder response = StoreGame.newBuilder();
					response.setName(summary.get(0));
					responseObserver.onNext(response.build());
				}
			}
		}
		responseObserver.onCompleted();
	}

}
