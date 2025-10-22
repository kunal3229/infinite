package com.example.kunal.basics.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {

        // static method reference
        List<String>  numbers = List.of("1", "2", "3", "4", "5");
        List<Integer> list = numbers.stream().map(Integer::parseInt).toList();
        System.out.println(list);

        // Instance method reference
        List<String> words = List.of("apple", "banana", "cherry");
        words.forEach(System.out::println);

        // Instance method reference of a particular object
        List<String> fruits = List.of("apple", "banana", "cherry");
        fruits.stream().map(String::toUpperCase).forEach(System.out::println);

        // Constructor method reference
        Supplier<List<String>> supplierNormal = () -> new ArrayList<String>();
        Supplier<List<String>> supplierMethodRef = ArrayList::new;
        List<String> myList1 = supplierNormal.get();
        myList1.add("Hello");
        List<String> myList2 = supplierMethodRef.get();
        myList2.add("World");
        System.out.println(myList1);
        System.out.println(myList2);

    }
}
