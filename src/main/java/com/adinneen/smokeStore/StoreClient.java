package com.adinneen.smokeStore;

import com.adinneen.smokeStore.GetOwnedGamesGrpc.GetOwnedGamesBlockingStub;
import com.adinneen.smokeStore.GetStoreListingsGrpc.GetStoreListingsBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class StoreClient {
	String host = "localhost";
	int port = 50051;
	
	ManagedChannel channel = ManagedChannelBuilder
			.forAddress(host, port)
			.usePlaintext()
			.build();
}
