package com.example.kunal.basics.java8;

import java.util.function.*;

public class FI {

    public static void main(String[] args) {

        Calculator add = (a, b) -> a+b;
        Calculator sub = (a, b) -> a-b;
        System.out.println(add.calculate(5,6));
        System.out.println(sub.calculate(6,2));

        Function<Integer, Integer> doubleIt = (a) -> a+a;
        Function<Integer, Integer> square = (a) -> a*a;
        Function<Integer, Integer> doubleThenSquare = doubleIt.andThen(square);
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a*b;
        System.out.println(doubleIt.apply(5));
        System.out.println(multiply.apply(5, 5));
        System.out.println(doubleThenSquare.apply(5));

        Predicate<Integer> isEven = (a) -> a%2 == 0;
        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        Predicate<String> startWithA = s -> s.startsWith("A");
        Predicate<String> endWithX = s -> s.endsWith("X");
        Predicate<String> combined = startWithA.and(endWithX);
        System.out.println(isEven.test(4));
        System.out.println(isGreater.test(5, 3));
        System.out.println(combined.test("AX"));

        Consumer<Integer> print = System.out::println;
        BiConsumer<Integer, Integer> printSum = (a, b) -> System.out.println(a + b);
        print.accept(10);
        printSum.accept(5, 10);

        Supplier<Double> randomValue = Math::random;
        System.out.println(randomValue.get());

    }
}
