package com.example.kunal.springexamples;

import org.springframework.stereotype.Component;

@Component("emailNotificationService")
public class EmailNotificationService implements  NotificationService {

    @Override
    public void notifyUser(String userId, String message) {
        System.out.println("Sending email to user " + userId + " with message: " + message);
    }
}
