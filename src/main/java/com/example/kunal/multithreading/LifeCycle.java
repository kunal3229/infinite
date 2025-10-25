package com.example.kunal.multithreading;

public class LifeCycle extends Thread {

    public static void main(String[] args) throws InterruptedException {
        LifeCycle t = new LifeCycle();
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(100);
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());
    }

    @Override
    public void run() {
        System.out.println("dlsakn");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}