package org.sample.park.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Test {

    @Id
    private UUID id;
    private Timestamp tempsDebut;
    private Timestamp tempsFinTheorique;
    private Timestamp tempsFin;
    private String etatTest;
    private String nomTesteur;
    private String commentaires;
    @Column(unique = true)
    private String description;

    // Default constructor
    public Test() {
    }

    // Constructor with UUID
    public Test(UUID id) {
        this.id = id;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getTempsDebut() {
        return tempsDebut;
    }

    public void setTempsDebut(Timestamp tempsDebut) {
        this.tempsDebut = tempsDebut;
    }

    public Timestamp getTempsFinTheorique() {
        return tempsFinTheorique;
    }

    public void setTempsFinTheorique(Timestamp tempsFinTheorique) {
        this.tempsFinTheorique = tempsFinTheorique;
    }

    public Timestamp getTempsFin() {
        return tempsFin;
    }

    public void setTempsFin(Timestamp tempsFin) {
        this.tempsFin = tempsFin;
    }

    public String getEtatTest() {
        return etatTest;
    }

    public void setEtatTest(String etatTest) {
        this.etatTest = etatTest;
    }

    public String getNomTesteur() {
        return nomTesteur;
    }

    public void setNomTesteur(String nomTesteur) {
        this.nomTesteur = nomTesteur;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
