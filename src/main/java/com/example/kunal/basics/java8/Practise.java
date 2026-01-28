package com.example.kunal.basics.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practise {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        String sentence = "The quick brown fox jumps over the lazy dog";

        double count = numbers.stream().filter(n -> n % 2 == 0).count();
        char[] chars = sentence.toCharArray();
        sentence.chars().forEach(c -> System.out.print((char) c));

        // Collecting name by length
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));

        // Counting word occurances
        String text = "apple banana apple orange banana apple";
        System.out.println(Arrays.stream(text.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(nums.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));
    }
}
