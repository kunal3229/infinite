package com.example.kunal.executor;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class CompletableFutureEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Supply Async -> returns a value
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Result from async task");

        // Run Async -> doesn't return a value
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Result from runAsync");
        });

        // Completed Future -> Already done
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Already done");

        // With Custom Executor
        ExecutorService customExecutor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> executeFuture = CompletableFuture.supplyAsync(() -> {
            return "Using Custom Executor";
        },  customExecutor);

        // Chaining Operations
        // thenApply - transforms result (returns new value)
        // thenAccept - consumes result (returns void)
        // thenRun - just runs after completion (doesn't use result)
        CompletableFuture<Void> chainFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1: Fetch User Data");
            return "User123";
        })
                .thenApply(userId -> {
                    System.out.println("Step 2: Fetch Orders for " + userId);
                    return Arrays.asList("Order 1",  "Order 2", "Order 3");
                })
                .thenApply(orders -> {
                    System.out.println("Calculate Total: ");
                    return orders.size()*100;
                })
                .thenAccept( total -> {
                    System.out.println("Total Amount: $"+total);
                });

        System.out.println(chainFuture.get());


        // Combining Futures
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });

        // Both run in parallel, then combine results
        CompletableFuture<Integer> combined = future1.thenCombine(future2, (result1, result2) -> {
            return result1 + result2;
        });

        System.out.println("Sum: " + combined.get()); // Output: 30
        // Total time: ~1 second (not 2, because parallel)





    }
}
