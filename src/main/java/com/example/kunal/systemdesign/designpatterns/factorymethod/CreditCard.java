package com.example.kunal.systemdesign.designpatterns.factorymethod;

import org.springframework.stereotype.Component;

@Component("creditCard")
public class CreditCard implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment");
    }
}
