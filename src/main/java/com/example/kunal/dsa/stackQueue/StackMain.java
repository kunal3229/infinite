package com.example.kunal.dsa.stackQueue;

public class StackMain {

    public static void main(String[] args) {

        CustomStack customStack = new CustomStack(2);
        customStack.push(112);
        customStack.push(12);

        DynamicStack dynamicStack = new DynamicStack(3);
        dynamicStack.push(12);
        dynamicStack.push(340);
        dynamicStack.push(23);
        dynamicStack.push(5);

        System.out.println(customStack.pop());
    }
}
