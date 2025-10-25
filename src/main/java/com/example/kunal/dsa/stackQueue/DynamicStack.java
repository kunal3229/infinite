package com.example.kunal.dsa.stackQueue;

public class DynamicStack extends CustomStack{

    public  DynamicStack(int size) {
        super(size);
    }
    public  DynamicStack() {
        super();
    }

    @Override
    public boolean push(int item){
        if (this.isFull()){
            // double the array size
            int[] temp = new int[data.length*2];
            //copy all previous items in new
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        return super.push(item);
    }
}
