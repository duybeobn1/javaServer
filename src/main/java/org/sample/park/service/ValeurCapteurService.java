package org.sample.park.service;

import org.sample.park.model.ValeurCapteur;
import org.sample.park.repository.ValeurCapteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValeurCapteurService {

    @Autowired
    private ValeurCapteurRepository valeurCapteurRepository;

    public List<ValeurCapteur> getAllValeurCapteurs() {
        return valeurCapteurRepository.findAll();
    }

    public ValeurCapteur createValeurCapteur(ValeurCapteur valeurCapteur) {
        return valeurCapteurRepository.save(valeurCapteur);
    }
}
