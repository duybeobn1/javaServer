package org.sample.park.controller;

import org.sample.park.model.ValeurCapteur;
import org.sample.park.service.ValeurCapteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valeur-capteur")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.1.96:4200"})
public class ValeurCapteurController {

    @Autowired
    private ValeurCapteurService valeurCapteurService;

    @GetMapping
    public List<ValeurCapteur> getAllValeurCapteurs() {
        return valeurCapteurService.getAllValeurCapteurs();
    }

    @PostMapping
    public ValeurCapteur createValeurCapteur(@RequestBody ValeurCapteur valeurCapteur) {
        return valeurCapteurService.createValeurCapteur(valeurCapteur);
    }
}
