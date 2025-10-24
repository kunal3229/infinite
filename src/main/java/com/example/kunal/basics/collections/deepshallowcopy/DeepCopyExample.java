package com.example.kunal.basics.collections.deepshallowcopy;

public class DeepCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {

        PersonDeep person1 = new PersonDeep("Kunal", new Address("Pune"));
        PersonDeep person2 = (PersonDeep) person1.clone();

        person2.address.city = "HYD"; // change in copy object

        System.out.println(person1);
        System.out.println(person2);
    }
}
