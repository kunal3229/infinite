package com.example.kunal.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FileProcessor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<String> files = Arrays.asList("text1.txt", "text2.txt", "text3.txt", "text4.txt");

        List<Future<Integer>> futures = new ArrayList<>();

        for(String file : files){
            Callable<Integer> task = () -> {
                System.out.println("Processing file: " + file);
                Thread.sleep(1000);
                return file.length();
            };
            futures.add(executorService.submit(task));
        }

        //Collect Results
        int total = 0;
        for (Future<Integer> future : futures) {
            try {
                total += future.get();
            } catch (ExecutionException | InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Total files processed: " + total);
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Force shutdown if tasks don't finish

                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Executor did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
