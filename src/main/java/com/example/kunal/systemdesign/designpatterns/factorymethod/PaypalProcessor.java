package com.example.kunal.systemdesign.designpatterns.factorymethod;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PaypalProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Pay pal amount");
    }
}
