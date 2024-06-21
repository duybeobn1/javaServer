package org.sample.park.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Notifications {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
    private Boolean notificationEmail;
    private String email;
    private Boolean notificationPush;
    private String tokenAndroid;
    private String tokenIos;

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
     * @return Boolean return the notificationEmail
     */
    public Boolean isNotificationEmail() {
        return notificationEmail;
    }

    /**
     * @param notificationEmail the notificationEmail to set
     */
    public void setNotificationEmail(Boolean notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Boolean return the notificationPush
     */
    public Boolean isNotificationPush() {
        return notificationPush;
    }

    /**
     * @param notificationPush the notificationPush to set
     */
    public void setNotificationPush(Boolean notificationPush) {
        this.notificationPush = notificationPush;
    }

    /**
     * @return String return the tokenAndroid
     */
    public String getTokenAndroid() {
        return tokenAndroid;
    }

    /**
     * @param tokenAndroid the tokenAndroid to set
     */
    public void setTokenAndroid(String tokenAndroid) {
        this.tokenAndroid = tokenAndroid;
    }

    /**
     * @return String return the tokenIos
     */
    public String getTokenIos() {
        return tokenIos;
    }

    /**
     * @param tokenIos the tokenIos to set
     */
    public void setTokenIos(String tokenIos) {
        this.tokenIos = tokenIos;
    }

}
