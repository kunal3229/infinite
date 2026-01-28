package com.example.kunal.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorBasics {

    public static void main(String[] args) {

        // Fixed Thread Pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        for(int i = 0; i<= 6; i++){
            final int taskId = i;
            fixedThreadPool.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {e.printStackTrace();}
            });
        }
        fixedThreadPool.shutdown();

        // Cached Thread Pool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 10; i<= 20; i++){
            final int taskId = i;
            cachedThreadPool.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));
        }
        cachedThreadPool.shutdown();

        // Single Threaded Pool
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for(int i = 10; i<= 30; i++){
            final int taskId = i;
            singleThreadPool.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));
        }
        singleThreadPool.shutdown();

        // Scheduled Thread Pool
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        // Run every day
        scheduler.schedule(() -> {
            System.out.println("Scheduled task executed by " + Thread.currentThread().getName());
        }, 1, TimeUnit.DAYS);

        // Run every 2 seconds after initial 1 second delay
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled task executed by " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

    }
}
