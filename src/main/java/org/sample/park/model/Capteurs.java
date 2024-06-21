package org.sample.park.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Capteurs {

    @Id
    private UUID id;
    private String nom;

    // Default constructor
    public Capteurs() {
    }

    // Constructor with UUID
    public Capteurs(UUID id) {
        this.id = id;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
