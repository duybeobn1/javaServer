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
    private String message;

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Boolean getNotificationEmail() {
        return notificationEmail;
    }

    public void setNotificationEmail(Boolean notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getNotificationPush() {
        return notificationPush;
    }

    public void setNotificationPush(Boolean notificationPush) {
        this.notificationPush = notificationPush;
    }

    public String getTokenAndroid() {
        return tokenAndroid;
    }

    public void setTokenAndroid(String tokenAndroid) {
        this.tokenAndroid = tokenAndroid;
    }

    public String getTokenIos() {
        return tokenIos;
    }

    public void setTokenIos(String tokenIos) {
        this.tokenIos = tokenIos;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
