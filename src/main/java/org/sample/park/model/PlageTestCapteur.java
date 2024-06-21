package org.sample.park.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class PlageTestCapteur {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
    @ManyToOne
    @JoinColumn(name = "capteur_id", nullable = false)
    private Capteurs capteur;
    private Long limiteSuperieure;
    private Long limiteInferieure;

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
     * @return Long return the limiteSuperieure
     */
    public Long getLimiteSuperieure() {
        return limiteSuperieure;
    }

    /**
     * @param limiteSuperieure the limiteSuperieure to set
     */
    public void setLimiteSuperieure(Long limiteSuperieure) {
        this.limiteSuperieure = limiteSuperieure;
    }

    /**
     * @return Long return the limiteInferieure
     */
    public Long getLimiteInferieure() {
        return limiteInferieure;
    }

    /**
     * @param limiteInferieure the limiteInferieure to set
     */
    public void setLimiteInferieure(Long limiteInferieure) {
        this.limiteInferieure = limiteInferieure;
    }

}
