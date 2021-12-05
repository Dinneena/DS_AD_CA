package com.adinneen.smokeLibrary;

import java.util.concurrent.TimeUnit;

import com.adinneen.smokeLibrary.LibraryGrpc.LibraryBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class LibraryClient {
	public static void main(String[] args) throws Exception {
	String host = "localhost";
	int port = 50051;
	
	ManagedChannel channel = ManagedChannelBuilder
			.forAddress(host, port)
			.usePlaintext()
			.build();
	LibraryBlockingStub stub = LibraryGrpc.newBlockingStub(channel);
	
		try {
			GameRequest request = GameRequest.newBuilder().setAccountName("Account Name").build();
			GameInfo reply = stub.getGameInfo(request);
			
			System.out.println(reply.getMessage());
		}catch(StatusRuntimeException e) {
			e.printStackTrace();
		}finally {
			channel.shutdown().awaitTermination(60, TimeUnit.SECONDS);
		}
	}
}

