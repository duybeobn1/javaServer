package org.sample.park.model;

import java.util.UUID;

public class TestResult {
    private UUID testId;
    private UUID capteurId;
    private Float valeur;

    public TestResult(UUID testId, UUID capteurId, Float valeur) {
        this.testId = testId;
        this.capteurId = capteurId;
        this.valeur = valeur;
    }

    public UUID getTestId() {
        return testId;
    }

    public UUID getCapteurId() {
        return capteurId;
    }

    public Float getValeur() {
        return valeur;
    }
}
