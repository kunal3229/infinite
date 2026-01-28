package com.example.kunal.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


public class ServiceAggregator {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<String> userService = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "UserService";
        });

        CompletableFuture<String> orderService = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "OrderService";
        });

        CompletableFuture<String> paymentService = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "PaymentService";
        });

        // Wait for all to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(userService, orderService, paymentService);

        // allOf returns Void, so we need to get results individually
        allFutures.thenRun(() -> {
            try {
                System.out.println(userService.get());
                System.out.println(orderService.get());
                System.out.println(paymentService.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        allFutures.get(); // Wait for completion
        // Total time: ~1500ms (longest task)
        System.out.println("Done");

        // Better way to collect al the results
        List<CompletableFuture<String>> futures = Arrays.asList(
                CompletableFuture.supplyAsync(() -> "Service 1"),
                CompletableFuture.supplyAsync(() -> "Service 2"),
                CompletableFuture.supplyAsync(() -> "Service 3")
        );

        CompletableFuture<List<String>> combined =  CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0]))
                .thenApply(v ->
                        futures.stream()
                                .map(CompletableFuture::join) // join is like get but unchecked
                                .collect(Collectors.toList())
                );
        List<String> combinedList = combined.get();
        System.out.println(combinedList);


    }

    static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
