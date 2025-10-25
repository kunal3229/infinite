package com.example.kunal.multithreading;

public class Priority extends Thread{
    Priority(String name) {
        super(name);
    }

    @Override
    public void run() {

        for (int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName() + " -Priority: " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Priority p1 = new Priority("High Priority Thread");
        p1.setPriority(Thread.MAX_PRIORITY);
        p1.start();

        Priority p2 = new Priority("Medium Priority Thread");
        p2.setPriority(Thread.NORM_PRIORITY);
        p2.start();

        Priority p3 = new Priority("Low Priority Thread");
        p3.setPriority(Thread.MIN_PRIORITY);
        p3.start();
    }
}
