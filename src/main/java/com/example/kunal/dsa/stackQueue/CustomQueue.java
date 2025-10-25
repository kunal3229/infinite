package com.example.kunal.dsa.stackQueue;

public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    CustomQueue() {
        this.data = new int[DEFAULT_SIZE];
    }
    CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item){
        if (isFull()) throw new IllegalStateException("Queue is full");
        data[end++] = item;
        return true;
    }

    public int remove(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        int removed = data[0];
        //shift all items to left by one
        for (int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return data[0];
    }

    public boolean isFull(){
        return end == data.length;
    }
    public boolean isEmpty(){
        return end == 0;
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("END");
    }
}
