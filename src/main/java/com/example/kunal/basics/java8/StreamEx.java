package com.example.kunal.basics.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {

        // Stream Creation
        // From Collections
        List<String> list = Arrays.asList("EA", "Sports", "HYD");

        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
        // From Arrays
        String[] arr = {"A", "B", "C"};
        Stream<String> arrayStream = Arrays.stream(arr);
        // From Values
        Stream<String> valueStream = Stream.of("X", "Y", "Z");
        // Infinite Stream
        Stream<Integer> infiniteStream = Stream.iterate(1, n -> n + 1);

        // Stream Intermediate Operations
        List<String> words = List.of("apple", "banana", "cherry");
        List<List<Integer>> nestedList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        words.stream().filter(s -> s.length() > 5).forEach(System.out::println);
        words.stream().map(String::toUpperCase).forEach(System.out::println);
        nestedList.stream().flatMap(List::stream).forEach(System.out::println);
        words.stream().sorted().forEach(System.out::println);
        words.stream().distinct().forEach(System.out::println);
        infiniteStream.limit(5).forEach(System.out::println);
        words.stream().peek(System.out::println).forEach(System.out::println);

        // Stream Terminal Operations
        List<String> res = words.stream().filter(s -> s.length() > 5).toList();
        res.forEach(System.out::println);
        int sum = Stream.of(1,2,4,5).reduce(0, Integer::sum);
        long count = words.stream().filter(s -> s.length() > 5).count();
        boolean anyMatch = words.stream().anyMatch(s -> s.startsWith("a"));
        boolean allMatch = words.stream().allMatch(s -> s.startsWith("a"));

        // Parallel Streams
        long start = System.currentTimeMillis();
        List<Integer> bigList = Stream.iterate(1, n -> n + 1).limit(20000).toList();
        List<Long> factorialStream = bigList.stream().map(StreamEx::factorial).toList();
        long end = System.currentTimeMillis();
        System.out.println("Time taken in sequential stream: " + (end - start) + " ms");

        long pStart = System.currentTimeMillis();
        List<Long> parallelFactorialStream = bigList.parallelStream().map(StreamEx::factorial).toList();
        long pEnd = System.currentTimeMillis();
        System.out.println("Time taken in parallel stream: " + (pEnd - pStart) + " ms");

        // Cumulative output
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        AtomicInteger cumulativeSum = new AtomicInteger(0);
        List<Integer> cumulativeList = numbers.stream()
                .map(cumulativeSum::addAndGet)
                .toList();
        System.out.println("Cumulative Sum List: " + cumulativeList);
    }

    private static Long factorial(Integer n) {
        if (n == 0 || n == 1) return 1L;
        return n * factorial(n - 1);
    }
}
