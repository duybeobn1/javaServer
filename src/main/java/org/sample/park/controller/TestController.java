package org.sample.park.controller;

import org.sample.park.client.CarParkGrpcClient;
import org.sample.park.service.CommandResultService;
import org.sample.park.model.TestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/tests")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.1.96:4200"})
public class TestController {

    @Autowired
    private CarParkGrpcClient carParkGrpcClient;

    @Autowired
    private CommandResultService commandResultService;

    @PostMapping
    public Map<String, String> createTest(@RequestBody Map<String, String> command) {
        String cmd = command.get("command");
        String result = carParkGrpcClient.processCommand(cmd);

        // For start/stop/read commands, simply return the result as JSON
        if (cmd.equals("start") || cmd.equals("stop") || cmd.equals("read")) {
            return Map.of("result", result);
        }

        // Assume result is a comma-separated string of testId, capteurId, and valeur
        String[] parts = result.split(",");
        if (parts.length != 3) {
            return Map.of("error", "Invalid result format: " + result);
        }

        UUID testId;
        UUID capteurId;
        Float valeur;

        try {
            testId = UUID.fromString(parts[0].trim());
            capteurId = UUID.fromString(parts[1].trim());
            valeur = Float.parseFloat(parts[2].trim());
        } catch (IllegalArgumentException e) {
            return Map.of("error", "Error parsing result: " + result);
        }

        commandResultService.saveResult(testId, capteurId, valeur);
        return Map.of("result", "Test result saved: " + result);
    }
}
