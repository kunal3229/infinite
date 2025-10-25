package com.example.kunal.springexamples;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final NotificationService notificationService;

    public OrderService(@Qualifier("smsNotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
