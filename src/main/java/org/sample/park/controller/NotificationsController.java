package org.sample.park.controller;

import org.sample.park.model.Notifications;
import org.sample.park.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.1.96:4200"})

public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @GetMapping
    public List<Notifications> getAllNotifications() {
        return notificationsService.getAllNotifications();
    }

    @PostMapping
    public Notifications createNotification(@RequestBody Notifications notification) {
        return notificationsService.createNotification(notification);
    }
}
