package com.example.kunal.basics.collections.failsafefastiterator;

import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterator {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("kunal");
        list.add("ankit");
        list.add("sumit");

        for (String str : list){
            System.out.println(str);
            // modifying structure of list while iterating
            list.add("newName"); // This will NOT cause ConcurrentModificationException
        }
        System.out.println("Final List: " + list);
    }
}
