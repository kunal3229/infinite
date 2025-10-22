package com.example.kunal.systemdesign.solid.dip;

public class OrderService {
    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void placeOrder(String order) {
        // Business logic for placing an order
        orderRepo.saveOrder(order);
    }
}
