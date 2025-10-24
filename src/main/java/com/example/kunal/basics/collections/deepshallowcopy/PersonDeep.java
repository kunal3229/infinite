package com.example.kunal.basics.collections.deepshallowcopy;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PersonDeep implements Cloneable{
    String name;
    Address address;

    PersonDeep(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public PersonDeep clone() throws CloneNotSupportedException {
        PersonDeep personDeep = (PersonDeep) super.clone();
        personDeep.address = new Address(address.city);
        return  personDeep;
    }
}
