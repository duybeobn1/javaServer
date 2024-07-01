package org.sample.park.service;

import org.sample.park.model.Test;
import org.sample.park.model.Capteurs;
import org.sample.park.model.ValeurCapteur;
import org.sample.park.repository.ValeurCapteurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class CommandResultService {

    private static final Logger logger = LoggerFactory.getLogger(CommandResultService.class);

    @Autowired
    private ValeurCapteurRepository valeurCapteurRepository;

    public void saveResult(UUID testId, UUID capteurId, Float valeur) {
        ValeurCapteur valeurCapteur = new ValeurCapteur();
        valeurCapteur.setId(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"));
        valeurCapteur.setTest(new Test(testId));
        valeurCapteur.setCapteur(new Capteurs(capteurId));
        valeurCapteur.setValeur(valeur);
        valeurCapteur.setTemps(new Timestamp(System.currentTimeMillis()));
        
        valeurCapteurRepository.save(valeurCapteur);
        
        logger.info("Saved result to database: Test ID: {}, Capteur ID: {}, Valeur: {}", testId, capteurId, valeur);
    }
}
