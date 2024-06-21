package org.sample.park.controller;

import org.sample.park.client.CarParkGrpcClient;
import org.sample.park.service.CommandResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private CarParkGrpcClient carParkGrpcClient;

    @Autowired
    private CommandResultService commandResultService;

    @PostMapping
    public String createTest(@RequestBody Map<String, String> command) {
        String cmd = command.get("command");
        String result = carParkGrpcClient.processCommand(cmd);

        // Assume result is a comma-separated string of testId, capteurId, and valeur
        String[] parts = result.split(",");
        if (parts.length != 3) {
            return "Invalid result format: " + result;
        }

        UUID testId;
        UUID capteurId;
        Float valeur;

        try {
            testId = UUID.fromString(parts[0].trim());
            capteurId = UUID.fromString(parts[1].trim());
            valeur = Float.parseFloat(parts[2].trim());
        } catch (IllegalArgumentException e) {
            return "Error parsing result: " + result;
        }

        commandResultService.saveResult(testId, capteurId, valeur);
        return "Test result saved: " + result;
    }
}
