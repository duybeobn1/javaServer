package org.sample.park.service;

import org.sample.park.model.Test;
import org.sample.park.model.Capteurs;
import org.sample.park.model.ValeurCapteur;
import org.sample.park.repository.TestRepository;
import org.sample.park.repository.ValeurCapteurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommandResultService {

    private static final Logger logger = LoggerFactory.getLogger(CommandResultService.class);

    @Autowired
    private ValeurCapteurRepository valeurCapteurRepository;

    @Autowired
    private TestRepository testRepository;

    public void saveResult(UUID testId, UUID capteurId, Float valeur) {
        // Check if the Test entity exists, create if it doesn't
        Optional<Test> testOptional = testRepository.findById(testId);
        Test test;
        if (testOptional.isPresent()) {
            test = testOptional.get();
        } else {
            test = new Test();
            test.setId(testId);
            test.setTempsDebut(new Timestamp(System.currentTimeMillis()));
            test.setTempsFinTheorique(new Timestamp(System.currentTimeMillis() + 3600000)); // Example: 1 hour later
            test.setDescription(generateUniqueDescription("Automatically created test"));
            // Set default values for other non-nullable fields if needed
            testRepository.save(test);
            logger.info("Created new Test entity with ID: {}", testId);
        }

        ValeurCapteur valeurCapteur = new ValeurCapteur();
        valeurCapteur.setId(UUID.randomUUID());
        valeurCapteur.setTest(test);
        valeurCapteur.setCapteur(new Capteurs(capteurId));
        valeurCapteur.setValeur(valeur);
        valeurCapteur.setTemps(new Timestamp(System.currentTimeMillis()));

        valeurCapteurRepository.save(valeurCapteur);

        logger.info("Saved result to database: Test ID: {}, Capteur ID: {}, Valeur: {}", testId, capteurId, valeur);
    }

    public List<ValeurCapteur> getRecentResults() {
        return valeurCapteurRepository.findRecentResults();
    }

    private String generateUniqueDescription(String baseDescription) {
        String description = baseDescription;
        int counter = 1;
        while (testRepository.existsByDescription(description)) {
            description = baseDescription + " " + counter++;
        }
        return description;
    }
}
