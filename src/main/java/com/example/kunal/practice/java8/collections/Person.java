package com.example.kunal.practice.java8.collections;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person implements Cloneable{

    private String name;
    private Address address;

    Person(String name, Address address){
        this.name = name;
        this.address = address;
    }

    // Shallow Copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
