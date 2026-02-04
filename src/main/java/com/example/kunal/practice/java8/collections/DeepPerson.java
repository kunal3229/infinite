package com.example.kunal.practice.java8.collections;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DeepPerson implements Cloneable{

    String name;
    Address address;

    DeepPerson(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Deep Copy
    @Override
    public DeepPerson clone() throws CloneNotSupportedException {
        DeepPerson person = (DeepPerson) super.clone();
        person.address = new Address(address.city);
        return person;
    }
}
