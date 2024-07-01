package org.sample.park.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import org.sample.park.CommandRequest;
import org.sample.park.CommandResponse;
import org.sample.park.CarParkServiceGrpc;
import org.sample.park.Empty;
import org.sample.park.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CarParkGrpcClient {

    private static final Logger logger = LoggerFactory.getLogger(CarParkGrpcClient.class);
    private final CarParkServiceGrpc.CarParkServiceBlockingStub blockingStub;
    private final CarParkServiceGrpc.CarParkServiceStub asyncStub;

    public CarParkGrpcClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.14", 50051)
                .usePlaintext()
                .build();
        blockingStub = CarParkServiceGrpc.newBlockingStub(channel);
        asyncStub = CarParkServiceGrpc.newStub(channel);
    }

    public String processCommand(String command) {
        CommandRequest request = CommandRequest.newBuilder()
                .setCommand(command)
                .build();
        logger.info("Sending CommandRequest to gRPC server with command: {}", command);
        try {
            CommandResponse response = blockingStub.processCommand(request);
            logger.info("Received response from gRPC server: {}", response.getResult());
            return response.getResult();
        } catch (StatusRuntimeException e) {
            logger.error("gRPC request failed: {}", e.getStatus(), e);
            return "gRPC request failed: " + e.getStatus();
        } catch (Exception e) {
            logger.error("Unexpected error during gRPC request", e);
            return "Unexpected error: " + e.getMessage();
        }
    }

    public void streamLogs() {
        asyncStub.streamLogs(Empty.getDefaultInstance(), new StreamObserver<LogMessage>() {
            @Override
            public void onNext(LogMessage logMessage) {
                logger.info("Received log message: {} at {}", logMessage.getMessage(), logMessage.getTimestamp());
                // Add logic to save to database here if needed
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Error receiving log message: ", t);
            }

            @Override
            public void onCompleted() {
                logger.info("Log message stream completed.");
            }
        });
    }

    public static void main(String[] args) {
        CarParkGrpcClient client = new CarParkGrpcClient();
        client.streamLogs(); // Start streaming logs

        // Example of processing a command
        String response = client.processCommand("read");
        System.out.println("Command response: " + response);

        // Keep the application running to receive log messages
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
