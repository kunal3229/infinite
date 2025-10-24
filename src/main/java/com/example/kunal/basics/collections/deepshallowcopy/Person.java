package com.example.kunal.basics.collections.deepshallowcopy;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Person implements Cloneable{

    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // shallow copy
    @Override
    public Object clone() throws  CloneNotSupportedException {
        return super.clone();
    }

}
