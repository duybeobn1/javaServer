package org.sample.park.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.sample.park.CarParkServiceGrpc;
import org.sample.park.CommandRequest;
import org.sample.park.CommandResponse;
import org.springframework.stereotype.Service;

@Service
public class CarParkGrpcClient {

    private final CarParkServiceGrpc.CarParkServiceBlockingStub blockingStub;

    public CarParkGrpcClient() {
        // The address should be configurable, so it can be different for dev and prod environments
        String serverAddress = System.getenv("PYTHON_SERVER_ADDRESS"); // Fetch the server address from environment variables

        // Hardcoded port
        int serverPort = 50051;

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();
        blockingStub = CarParkServiceGrpc.newBlockingStub(channel);
    }

    public String processCommand(String command) {
        CommandRequest request = CommandRequest.newBuilder()
                .setCommand(command)
                .build();
        try {
            CommandResponse response = blockingStub.processCommand(request);
            return response.getResult();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
