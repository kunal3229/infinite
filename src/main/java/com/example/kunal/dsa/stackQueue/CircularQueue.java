package com.example.kunal.dsa.stackQueue;

public class CircularQueue extends CustomQueue{
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }
    public boolean isFull() {
        return size == data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean insert(int item) {
        if (isFull()) return false;

        data[end++] = item;
        end = end%data.length;
        size++;
        return true;
    }
    public int remove() {
        if (isEmpty()) throw new IllegalStateException("Queue is Empty");

        int removed = data[front++];

        front = front% data.length;
        size--;
        return removed;
    }
    public int front() {
        if (isEmpty()) throw new IllegalStateException("Queue is Empty");
        return data[front];
    }
    public void display(){
        int i = front;
        do {
            System.out.print(data[i]+" ");
            i++;
            i%= data.length;
        }
        while (i != end);
        System.out.println("END");
    }
}
