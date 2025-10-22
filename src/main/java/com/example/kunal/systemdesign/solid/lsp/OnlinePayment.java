package com.example.kunal.systemdesign.solid.lsp;

public class OnlinePayment implements  Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Online Payment");
    }
}
