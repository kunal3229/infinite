package com.example.kunal.multithreading;

import lombok.Getter;

@Getter
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

}
