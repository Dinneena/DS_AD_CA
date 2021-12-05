package com.adinneen.smokeStore;

import java.util.concurrent.TimeUnit;

import com.adinneen.smokeStore.StoreGrpc.StoreBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class StoreClient {
	public static void main(String[] args) throws Exception {
	String host = "localhost";
	int port = 50051;
	
	ManagedChannel channel = ManagedChannelBuilder
			.forAddress(host, port)
			.usePlaintext()
			.build();
	StoreBlockingStub stub = StoreGrpc.newBlockingStub(channel);
	
		try {
			ListingRequest request = ListingRequest.newBuilder().setGameList("Dark Souls, Crash Bandicoot, Sly Cooper").build();
			
		}catch(StatusRuntimeException e) {
			e.printStackTrace();
		}finally {
			channel.shutdown().awaitTermination(60, TimeUnit.SECONDS);
		}
	}
}
