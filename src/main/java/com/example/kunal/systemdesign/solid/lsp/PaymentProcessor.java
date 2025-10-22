package com.example.kunal.systemdesign.solid.lsp;

public class PaymentProcessor {

    public void processPayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}
