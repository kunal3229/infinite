package com.example.kunal.systemdesign.solid.ocp;

public class EmailNotifier implements Notifier{

    @Override
    public void send(String message) {
        System.out.println("Email sent with message: " + message);
    }
}
