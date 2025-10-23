package com.example.kunal.basics.java8;

import java.util.Arrays;
import java.util.List;

public class StreamQuestions {
    public static void main(String[] args) {

        // Java 8 --> minimal code, functional programming, streams, lambda expressions

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        String sentence = "The quick brown fox jumps over the lazy dog";

        double count = numbers.stream().filter(n -> n % 2 == 0).count();
        char[] chars = sentence.toCharArray();
        sentence.chars().filter(c -> c == 'a').forEach(System.out::println);
    }
}

