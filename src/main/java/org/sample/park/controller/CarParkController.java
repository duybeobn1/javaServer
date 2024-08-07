package org.sample.park.controller;

import org.sample.park.client.CarParkGrpcClient;
import org.sample.park.service.CommandResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/park")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.1.96:4200"})

public class CarParkController {

    private static final Logger logger = LoggerFactory.getLogger(CarParkController.class);

    @Autowired
    private CarParkGrpcClient carParkGrpcClient;

    @Autowired
    private CommandResultService commandResultService;

    @PostMapping("/test")
    public String testEndpoint(@RequestBody Map<String, String> command) {
        String cmd = command.get("command");
        logger.info("Received command: {}", cmd);
        
        String result = carParkGrpcClient.processCommand(cmd);
        logger.info("Received result from gRPC server: {}", result);

        // Assume result is a comma-separated string of testId, capteurId, and valeur
        String[] parts = result.split(",");
        if (parts.length != 3) {
            logger.error("Invalid result format: {}", result);
            return "Invalid result format: " + result;
        }

        UUID testId;
        UUID capteurId;
        Float valeur;

        try {
            logger.info("Parsing testId: {}", parts[0].trim());
            testId = UUID.fromString(parts[0].trim());
            logger.info("Parsing capteurId: {}", parts[1].trim());
            capteurId = UUID.fromString(parts[1].trim());
            logger.info("Parsing valeur: {}", parts[2].trim());
            valeur = Float.parseFloat(parts[2].trim());
        } catch (IllegalArgumentException e) {
            logger.error("Error parsing result: {}", result, e);
            return "Error parsing result: " + result;
        }

        commandResultService.saveResult(testId, capteurId, valeur);
        logger.info("Test result saved: {}", result);
        return "Test result saved: " + result;
    }
}
