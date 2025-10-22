package com.example.kunal.systemdesign.solid.ocp;

public class SMSNotifier implements Notifier{

    @Override
    public void send(String message) {
        System.out.println("SMS sent with message: " + message);
    }
}
