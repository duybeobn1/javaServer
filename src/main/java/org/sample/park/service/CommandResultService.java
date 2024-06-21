package org.sample.park.service;

import org.sample.park.model.Capteurs;
import org.sample.park.model.Test;
import org.sample.park.model.ValeurCapteur;
import org.sample.park.repository.ValeurCapteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class CommandResultService {

    @Autowired
    private ValeurCapteurRepository valeurCapteurRepository;

    public void saveResult(UUID testId, UUID capteurId, Float valeur) {
        ValeurCapteur valeurCapteur = new ValeurCapteur();
        valeurCapteur.setId(UUID.randomUUID());
        valeurCapteur.setTest(new Test(testId));
        valeurCapteur.setCapteur(new Capteurs(capteurId));
        valeurCapteur.setValeur(valeur);
        valeurCapteur.setTemps(new Timestamp(System.currentTimeMillis()));
        valeurCapteurRepository.save(valeurCapteur);
    }
}
