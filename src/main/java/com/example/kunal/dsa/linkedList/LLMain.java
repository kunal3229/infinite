package com.example.kunal.dsa.linkedList;

public class LLMain {

    public static void main(String[] args) {

        LL list = new LL();

        list.addFirst(12);
        list.addFirst(34);
        list.addLast(45);
        list.addFirst(13);
        list.addLast(56);
        list.addIndex(67, 2);
        list.removeLast();
        list.removeFirst();
        list.display();
    }
}
