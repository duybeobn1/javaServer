package org.sample.park.model;

import java.util.UUID;

public class TestResult {
    private UUID testId;
    private UUID capteurId;
    private float valeur;

    // Constructor, getters and setters

    public TestResult(UUID testId, UUID capteurId, float valeur) {
        this.testId = testId;
        this.capteurId = capteurId;
        this.valeur = valeur;
    }

    public UUID getTestId() {
        return testId;
    }

    public void setTestId(UUID testId) {
        this.testId = testId;
    }

    public UUID getCapteurId() {
        return capteurId;
    }

    public void setCapteurId(UUID capteurId) {
        this.capteurId = capteurId;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }
}
