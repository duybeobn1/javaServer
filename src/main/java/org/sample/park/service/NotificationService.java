package org.sample.park.service;

import org.sample.park.model.Notifications;
import org.sample.park.model.Test;
import org.sample.park.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {

    @Autowired
    private NotificationsRepository notificationRepository;

    public List<Notifications> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notifications createNotification(Notifications notification) {
        return notificationRepository.save(notification);
    }

    public void createNotificationForTest(Test test, boolean success) {
        Notifications notification = new Notifications();
        notification.setId(UUID.randomUUID());
        notification.setTest(test);
        notification.setMessage(success ? "Test succeeded" : "Test failed");
        notificationRepository.save(notification);
    }
}
