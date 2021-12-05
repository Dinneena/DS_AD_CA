package com.adinneen.smokeStore;

import com.adinneen.smokeStore.StoreGrpc.StoreImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class StoreServer extends StoreImplBase {
	public static void main(String[] args) {
		int port = 50052;
		StoreServer storeServer = new StoreServer();

		try {
			Server server = ServerBuilder.forPort(port).addService(storeServer).build().start();
			System.out.println("Store Server Started!");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public StreamObserver<ListingRequest> getSummary(StreamObserver<GamesSummary> responseObserver) {
		return new StreamObserver<ListingRequest>() {

			@Override
			public void onNext(ListingRequest value) {
				// TODO Auto-generated method stub
				System.out.println("Value " + value.getGameList());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				GamesSummary.Builder response = GamesSummary.newBuilder();
				response.setMessage("test");
				responseObserver.onNext(response.build());
				responseObserver.onCompleted();
			}

		};
	}

}
