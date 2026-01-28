package com.example.kunal.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEx {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<Integer> future = executorService.submit(() -> {
            Thread.sleep(1000);
            return 1;
        });

        System.out.println("Task submitted, doing other work...");

        try {
            // this blocks until result is available
            Integer result = future.get();
            System.out.println("Task submitted, result is " + result);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        executorService.shutdown();

    }
}
