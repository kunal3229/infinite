package com.example.kunal.dsa.heap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        int key, value;
        Node prev, next;
        public Node (int k, int v) { this.key = k; this.value = v; }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertToTail(node);
        return node.value;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        } else if(map.size() == capacity){
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
        Node node = new Node(key, value);
        insertToTail(node);
        map.put(key, node);
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertToTail(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    public void printCache(){
        Node current = head.next;
        System.out.print("{");
        while (current != tail){
            System.out.print(current.key + "=" + current.value);
            current = current.next;
            if (current != tail) System.out.print(", ");
        }
        System.out.println("}");
    }
}
