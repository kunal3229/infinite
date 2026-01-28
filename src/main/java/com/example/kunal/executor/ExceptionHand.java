package com.example.kunal.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHand {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String>  future = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong");
            }
            return "Success";
        })
                .exceptionally(ex -> {
                    System.out.println("Exception: " + ex.getMessage());
                    return "Default Value"; // Fallback value
                });
        System.out.println(future.get());

        // handle Both success and exception
        CompletableFuture<String> handleBoth = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong");
            }
            return "Success";
        })
                .handle((result, exception) -> {
                    if (exception != null) {
                        return "Error Occurred " + exception.getMessage();
                    }
                    return "Result: " + result;
                });
        System.out.println(handleBoth.get());

        //whenComplete - Side effect without modifying result:
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
                    return "Data";
                })
                .whenComplete((result, exception) -> {
                    if (exception != null) {
                        System.out.println("Failed: " + exception);
                    } else {
                        System.out.println("Succeeded with: " + result);
                    }
                    // Doesn't modify the result
                });
    }
}
