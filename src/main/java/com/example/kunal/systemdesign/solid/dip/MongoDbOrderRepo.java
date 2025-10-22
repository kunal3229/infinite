package com.example.kunal.systemdesign.solid.dip;

public class MongoDbOrderRepo implements  OrderRepo {

    @Override
    public void saveOrder(String order) {
        System.out.println("Order " + order + " saved to MongoDB database.");
    }
}
