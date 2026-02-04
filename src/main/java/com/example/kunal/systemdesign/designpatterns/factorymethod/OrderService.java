package com.example.kunal.systemdesign.designpatterns.factorymethod;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final PaymentProcessorFactory paymentProcessorFactory;

    public void checkOut(Long amount, String paymentType){
        PaymentProcessor paymentProcessor = paymentProcessorFactory.getProcessor(paymentType);
        paymentProcessor.processPayment(amount);
    }


}
