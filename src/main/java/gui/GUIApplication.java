package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.jmdns.ServiceInfo;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.adinneen.smokeLibrary.Game;
import com.adinneen.smokeLibrary.GameRequest;
import com.adinneen.smokeLibrary.LibraryGrpc;
import com.adinneen.smokeLibrary.LibraryGrpc.LibraryBlockingStub;
import com.adinneen.smokeLibrary.LibraryGrpc.LibraryStub;
import com.adinneen.smokeStore.GamesSummary;
import com.adinneen.smokeStore.StoreGame;
import com.adinneen.smokeStore.StoreGameRequest;
import com.adinneen.smokeStore.StoreGrpc;
import com.adinneen.smokeStore.StoreGrpc.StoreBlockingStub;
import com.adinneen.smokeStore.StoreGrpc.StoreStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GUIApplication {

	private static StoreStub storeStub;
	private static LibraryStub libraryStub;
	private static StoreBlockingStub storeBlockingStub;
	private static LibraryBlockingStub libraryBlockingStub;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			// overide the run method of runnable
			public void run() {
				try {
					GUIApplication window = new GUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIApplication() {

		ServiceInfo libraryServiceInfo;
		ServiceInfo storeServiceInfo;
//		String serviceType = "_grpc._tcp.local.";
//		String serviceTypeStore = "_http._tcp.local.";
//		libraryServiceInfo = SimpleServiceDiscovery.run(serviceType);
//		storeServiceInfo = SimpleServiceDiscovery.run(serviceTypeStore);
//		int port = libraryServiceInfo.getPort();
//		int port2 = storeServiceInfo.getPort();
		int port = 50051;
		int port2 = 50052;
		String host = "localhost";

		ManagedChannel libraryChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		ManagedChannel storeChannel = ManagedChannelBuilder.forAddress(host, port2).usePlaintext().build();

		// stubs -- generate from proto
		libraryBlockingStub = LibraryGrpc.newBlockingStub(libraryChannel);
		libraryStub = LibraryGrpc.newStub(libraryChannel);
		storeStub = StoreGrpc.newStub(storeChannel);
		storeBlockingStub = StoreGrpc.newBlockingStub(storeChannel);

		initialize();
	}

	private String formatGame(Game game) {
		String gameMessage = "";
		gameMessage += "Title: " + game.getName() + "\n";
		gameMessage += "Description: " + game.getDesc() + "\n";
		gameMessage += "Installed: " + game.getName() + "\n\n";
		return gameMessage;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		frame.getContentPane().setLayout(bl);

		// Create JPanel
		JPanel unaryPanel = new JPanel();
		unaryPanel.setBackground(new Color(125, 152, 161));

		JPanel serverStreamPanel = new JPanel();
		serverStreamPanel.setBackground(new Color(94, 101, 114));

		JPanel clientStreamPanel = new JPanel();
		clientStreamPanel.setBackground(new Color(169, 180, 194));

		JPanel bidirectionalPanel = new JPanel();
		bidirectionalPanel.setBackground(new Color(238, 241, 239));

		frame.getContentPane().add(unaryPanel);
		frame.getContentPane().add(serverStreamPanel);
		frame.getContentPane().add(clientStreamPanel);
		frame.getContentPane().add(bidirectionalPanel);

		/*
		 * ------ Unary -----
		 */

		JLabel unaryPanelLabel = new JLabel(" Game Name ");
		unaryPanel.add(unaryPanelLabel);

		JTextField unaryTextField = new JTextField();
		unaryPanel.add(unaryTextField);
		unaryTextField.setColumns(10);

		JTextArea unaryResponse = new JTextArea(10, 40);
		unaryResponse.setLineWrap(true);
		unaryResponse.setWrapStyleWord(true);
		unaryResponse.setEditable(false);

		JButton unaryButton = new JButton("Send unary command");
		unaryButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String gameRequest = unaryTextField.getText();
				GameRequest request = GameRequest.newBuilder().setName(gameRequest).build();
				Game response = libraryBlockingStub.getGameInfo(request);
				if (response.getName().equals("Error")) {
					unaryResponse.setText("No data for " + gameRequest);
				} else {
					unaryResponse.setText(formatGame(response));
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(unaryResponse);
		unaryPanel.add(scrollPane);

		unaryPanel.add(unaryButton);

		/*
		 * ------ Client-side streaming -----
		 */

		JLabel clientStreamPanelLabel = new JLabel(" Game List: ");
		clientStreamPanel.add(clientStreamPanelLabel);
		frame.getContentPane().add(clientStreamPanel);

		JTextField clientStreamTextField = new JTextField();
		clientStreamPanel.add(clientStreamTextField);
		clientStreamTextField.setColumns(10);

		JTextArea clientStreamResponse = new JTextArea(10, 40);
		clientStreamResponse.setLineWrap(true);
		clientStreamResponse.setWrapStyleWord(true);

		JButton clientStreamButton = new JButton("Send Client-Side Stream Command");
		clientStreamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String listingsInput = clientStreamTextField.getText();
				String[] listings = listingsInput.split(",");
				StreamObserver<GamesSummary> responseObserver = new StreamObserver<GamesSummary>() {

					@Override
					public void onNext(GamesSummary value) {
						System.out.println("Final Response from server " + value.getSummary());
						clientStreamResponse.setText(value.getSummary());
					}

					@Override
					public void onError(Throwable t) {
					}

					@Override
					public void onCompleted() {
					}
				};

				StreamObserver<StoreGameRequest> requestObserver = storeStub.getSummary(responseObserver);

				for (String listing : listings) {
					StoreGameRequest storeRequest = StoreGameRequest.newBuilder().setName(listing.trim()).build();
					requestObserver.onNext(storeRequest);
				}

//				System.out.println("Client has now sent its messages");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				requestObserver.onCompleted();
			}
		});

		JScrollPane serverSideScrollPane = new JScrollPane(clientStreamResponse);
		clientStreamPanel.add(serverSideScrollPane);
		clientStreamPanel.add(clientStreamButton);

		/*
		 * ------ Server-side streaming -----
		 */
		JLabel serverStreamPanelLabel = new JLabel("Game List: ");
		serverStreamPanel.add(serverStreamPanelLabel);
		frame.getContentPane().add(serverStreamPanel);
		JTextField serverStreamTextField = new JTextField();
		serverStreamPanel.add(serverStreamTextField);
		serverStreamTextField.setColumns(10);
		JButton serverStreamButton = new JButton("Send Server-Side Stream Command");

		JTextArea serverStreamResponse = new JTextArea(10, 40);
		serverStreamResponse.setLineWrap(true);
		serverStreamResponse.setWrapStyleWord(true);

		serverStreamButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String requestInput = serverStreamTextField.getText();
				StoreGameRequest request = StoreGameRequest.newBuilder().setName(requestInput).build();
				serverStreamResponse.setText("");

				Iterator<StoreGame> response = storeBlockingStub.getOwned(request);
				if (!response.hasNext()) {
					serverStreamResponse.setText("None of the requested games were owned");
				}
				while (response.hasNext()) {
					StoreGame game = response.next();
					serverStreamResponse.append(game.getName() + " : owned");
					serverStreamResponse.append("\n");
				}
			}
		});

		JScrollPane serverStreamScrollPane = new JScrollPane(serverStreamResponse);
		serverStreamPanel.add(serverStreamScrollPane);
		serverStreamPanel.add(serverStreamButton);

		/*
		 * ------ Bidirectional Streaming -----
		 */

		JLabel bidirectionalPanelLabel = new JLabel(" List of Games: ");
		bidirectionalPanel.add(bidirectionalPanelLabel);

		JTextField bidirectionalTextField = new JTextField();
		bidirectionalPanel.add(bidirectionalTextField);
		bidirectionalTextField.setColumns(10);

		JTextArea bidirectionalResponse = new JTextArea(10, 40);
		bidirectionalResponse.setLineWrap(true);
		bidirectionalResponse.setWrapStyleWord(true);
		bidirectionalResponse.setEditable(false);

		JButton bidirectionalButton = new JButton("Send bidirectional Stream command");
		bidirectionalButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				bidirectionalResponse.setText("");
				String gamesInput = bidirectionalTextField.getText();
				String[] games = gamesInput.split(",");
				StreamObserver<Game> responseObserver = new StreamObserver<Game>() {

					@Override
					public void onNext(Game value) {
						System.out.println("Final Response from server " + value.getName());

						bidirectionalResponse.append(value.getName() + "\n");
					}

					@Override
					public void onError(Throwable t) {
					}

					@Override
					public void onCompleted() {
					}
				};
				System.out.println("Response Observer " + responseObserver.toString());
				StreamObserver<GameRequest> requestObserver = libraryStub.getInstalledGames(responseObserver);

				for (String game : games) {
					GameRequest gameRequest = GameRequest.newBuilder().setName(game.trim()).build();
					requestObserver.onNext(gameRequest);
				}

//				System.out.println("Client has now sent its messages");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				requestObserver.onCompleted();
			}
		});

		JScrollPane bidirectionalScrollPane = new JScrollPane(bidirectionalResponse);
		bidirectionalPanel.add(bidirectionalScrollPane);

		bidirectionalPanel.add(bidirectionalButton);
	}
}
