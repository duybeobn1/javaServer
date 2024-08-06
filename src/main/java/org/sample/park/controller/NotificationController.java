package org.sample.park.controller;

import org.sample.park.model.Notifications;
import org.sample.park.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.1.96:4200"})
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notifications> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @PostMapping
    public Notifications createNotification(@RequestBody Notifications notification) {
        return notificationService.createNotification(notification);
    }
}
