package com.example.kunal.basics.collections.failsafefastiterator;

import java.util.ArrayList;
import java.util.List;

public class FailFastIterator {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("kunal");
        list.add("ankit");
        list.add("sumit");

        for (String str : list){
            System.out.println(str);
            // modifying structure of list while iterating
            list.add("newName"); // This will cause ConcurrentModificationException
        }
    }
}
