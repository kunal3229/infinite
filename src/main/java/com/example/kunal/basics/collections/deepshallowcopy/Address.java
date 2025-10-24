package com.example.kunal.basics.collections.deepshallowcopy;

import lombok.ToString;

@ToString
public class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}
