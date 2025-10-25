package com.example.kunal.dsa.stackQueue;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack() {
        this.data = new int[DEFAULT_SIZE];
    }
    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item){
        if (isFull()) throw new IllegalStateException("Stack is full");
        data[++ptr] = item;
        return true;
    }

    public int pop(){
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data[ptr--];
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data[ptr];
    }

    public boolean isFull(){
        return ptr + 1 == data.length;
    }
    public boolean isEmpty(){
        return ptr == -1;
    }

}
