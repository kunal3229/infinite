package com.example.kunal.systemdesign.solid.ocp;

import java.util.List;

public class NotifierService {

    private final List<Notifier> notifiers;

    public NotifierService(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void notifyAll(String message) {
        for (Notifier notifier : notifiers) {
            notifier.send(message);
        }
    }
}
