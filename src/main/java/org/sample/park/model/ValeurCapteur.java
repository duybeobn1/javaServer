package org.sample.park.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class ValeurCapteur {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
    @ManyToOne
    @JoinColumn(name = "capteur_id", nullable = false)
    private Capteurs capteur;
    private Float valeur;
    private Timestamp temps;

    // Getters and Setters

    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return Test return the test
     */
    public Test getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * @return Capteurs return the capteur
     */
    public Capteurs getCapteur() {
        return capteur;
    }

    /**
     * @param capteur the capteur to set
     */
    public void setCapteur(Capteurs capteur) {
        this.capteur = capteur;
    }

    /**
     * @return Float return the valeur
     */
    public Float getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    /**
     * @return Timestamp return the temps
     */
    public Timestamp getTemps() {
        return temps;
    }

    /**
     * @param temps the temps to set
     */
    public void setTemps(Timestamp temps) {
        this.temps = temps;
    }

}
