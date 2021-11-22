import java.util.concurrent.TimeUnit;

import grpc.newservice.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GUI {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        // Build a channel
        int port = 50051;
        String host = "localhost";

        ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        // code previous to this is generic - except that you may change port number

        // now build our message

        containsString cString = containsString.newBuilder().setFirstString("test1").build();

        // Create a stub, pass the channel to the stub
        // The stub is specific to our service

        newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);

        // Calling the server and receiving a response
        containsString response = bstub.getFirstString(cString);

        System.out.println(response.getFirstString());

        newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}