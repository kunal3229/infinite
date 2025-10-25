package com.example.kunal.springexamples;

import org.springframework.stereotype.Component;

@Component("smsNotificationService")
public class SMSNotificationService implements  NotificationService {

    @Override
    public void notifyUser(String userId, String message) {
        System.out.println("Sending SMS to user " + userId + " with message: " + message);
    }
}
