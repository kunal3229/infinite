package com.example.kunal.systemdesign.designpatterns.factorymethod;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//Problem
//Define an interface for creating objects, but let subclasses decide which class to instantiate.

//When to Use
//
//When exact type of object isn't known until runtime
//Creating objects based on conditions
//Payment gateways, notification services


// Factory
@Component
@RequiredArgsConstructor
public class PaymentProcessorFactory {

    private final ApplicationContext context;

    public PaymentProcessor getProcessor(String paymentType) {
        return switch (paymentType.toLowerCase()) {
            case "creditcard" -> context.getBean("creditCard", PaymentProcessor.class);
            case "paypal" -> context.getBean("paypal", PaymentProcessor.class);
            default -> throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        };
    }

}