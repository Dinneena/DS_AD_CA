package client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.adinneen.smokeLibrary.GameInfo;
import com.adinneen.smokeLibrary.GameRequest;
import com.adinneen.smokeLibrary.LibraryGrpc;
import com.adinneen.smokeLibrary.LibraryGrpc.LibraryBlockingStub;
import com.adinneen.smokeStore.GamesSummary;
import com.adinneen.smokeStore.ListingRequest;
import com.adinneen.smokeStore.StoreGrpc;
import com.adinneen.smokeStore.StoreGrpc.StoreBlockingStub;
import com.adinneen.smokeStore.StoreGrpc.StoreStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SmokeClient implements ActionListener {
	public static void main(String[] args) throws Exception {

		String host = "localhost";

		ManagedChannel libraryChannel = ManagedChannelBuilder.forAddress(host, 50051).usePlaintext().build();
		ManagedChannel storeChannel = ManagedChannelBuilder.forAddress(host, 50052).usePlaintext().build();

		LibraryBlockingStub stub = LibraryGrpc.newBlockingStub(libraryChannel);
		StoreStub storeStub = StoreGrpc.newStub(storeChannel);

		// adding in Unary RPC
		try {
			GameRequest request = GameRequest.newBuilder().setAccountName("Dark Souls").build();
			GameInfo reply = stub.getGameInfo(request);

			System.out.println(reply.getMessage());
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		} finally {
			libraryChannel.shutdown().awaitTermination(60, TimeUnit.SECONDS);
		}

		// adding in client-streaming
		CountDownLatch latch = new CountDownLatch(1);
		StreamObserver<GamesSummary> responseObserver = new StreamObserver<GamesSummary>() {

			@Override
			public void onNext(GamesSummary value) {
				// TODO Auto-generated method stub
				System.out.println("Final Response from server " + value.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				latch.countDown();
			}
		};

		// grpc library returns a StreamObserver to us
		StreamObserver<ListingRequest> requestObserver = storeStub.getSummary(responseObserver);
		ListingRequest storeRequest = ListingRequest.newBuilder().setGameList("Dark Souls, Crash Bandicoot, Sly Cooper")
				.build();

		requestObserver.onNext(storeRequest);
		requestObserver.onNext(storeRequest);
		requestObserver.onNext(storeRequest);

		System.out.println("Client has now sent its messages");
		requestObserver.onCompleted();
		Thread.sleep(5000);

		requestObserver.onCompleted();
//			try {
//				ListingRequest request = ListingRequest.newBuilder().setGameList("Dark Souls, Crash Bandicoot, Sly Cooper").build();
//				GamesSummary reply = storeStub.getSummary(request);
//
//			} catch (StatusRuntimeException e) {
//				e.printStackTrace();
//			} finally {
//				storeChannel.shutdown().awaitTermination(60, TimeUnit.SECONDS);
//			}

//		final CountDownLatch finishLatch = new CountDownLatch(1);
//		StreamObserver<GamesSummary> responseObserver = new StreamObserver<GamesSummary>() {
//			@Override
//			public void onNext(GamesSummary summary) {
//				System.out.println("On Next ");
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				finishLatch.countDown();
//			}
//
//			@Override
//			public void onCompleted() {
//				finishLatch.countDown();
//			}
//		};
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
