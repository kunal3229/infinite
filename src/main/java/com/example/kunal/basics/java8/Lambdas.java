package com.example.kunal.basics.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Lambdas {
    public static void main(String[] args) {

        Runnable runnable = System.out::println;
        new Thread(runnable).start();

        MyLambda lambda = System.out::println;
        lambda.display("kunal");

        Consumer<String> p = s -> System.out.println(s.length());
        p.accept("hello");

        Comparator<Integer> cmp = Integer::compare;
        List<Integer> l = Arrays.asList(3,1,2);
        l.sort(cmp);
    }
}
