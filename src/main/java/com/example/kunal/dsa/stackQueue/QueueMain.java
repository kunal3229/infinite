package com.example.kunal.dsa.stackQueue;

public class QueueMain {

    public static void main(String[] args) {

        CustomQueue customQueue = new CustomQueue(4);
        customQueue.insert(5);
        customQueue.insert(8);
        customQueue.insert(88);

        customQueue.display();

        CircularQueue circularQueue = new CircularQueue(4);
        circularQueue.insert(12);
        circularQueue.insert(23);
        circularQueue.insert(11);
        circularQueue.insert(45);
        circularQueue.display();
    }
}
