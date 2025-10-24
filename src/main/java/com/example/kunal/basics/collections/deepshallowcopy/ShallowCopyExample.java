package com.example.kunal.basics.collections.deepshallowcopy;

public class ShallowCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("Kunal", new Address("Pune"));
        Person person2 = (Person) person1.clone();
        person2.address.city = "HYD"; // change in copy object

        System.out.println(person1);
        System.out.println(person2);
    }
}
