package org.sample.park.service;

import org.sample.park.model.Notifications;
import org.sample.park.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    public List<Notifications> getAllNotifications() {
        return notificationsRepository.findAll();
    }

    public Notifications createNotification(Notifications notification) {
        return notificationsRepository.save(notification);
    }
}
