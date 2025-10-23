package com.example.kunal.basics.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamQuestions {
    public static void main(String[] args) {

        // Java 8 --> minimal code, functional programming, streams, lambda expressions

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        String sentence = "The quick brown fox jumps over the lazy dog";

        double count = numbers.stream().filter(n -> n % 2 == 0).count();
        char[] chars = sentence.toCharArray();
        sentence.chars().filter(c -> c == 'a').forEach(System.out::println);

        // Example 1 : Collecting names by length
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));

        // Example 2 : Counting word occurrences
        String text = "apple banana apple orange banana apple";
        System.out.println(Arrays.stream(text.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        //Example 3 : Partitioning numbers into even and odd
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(nums.stream().collect(Collectors.partitioningBy(x -> x%2==0)));

        // Example 4 : Summing values in a map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 30);
        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println((Integer) items.values().stream().mapToInt(Integer::intValue).sum());

        // Example 5 : Creating a Map from Stream
        List<String> fruits = List.of("apple", "banana", "cherry");
        fruits.stream().collect(Collectors.toMap(String::toUpperCase, String::length))
                .forEach((k, v) -> System.out.println(k + ": " + v));

        // Example 6 :

    }
}

