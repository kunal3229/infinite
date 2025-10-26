package com.example.kunal.dsa.heap;

public class LRUMain {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3); // removes key 2
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4); // removes key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
        cache.printCache(); // {3=3, 4=4}
    }
}
