package com.example.kunal.systemdesign.solid.srp;

public class UserValidator {

    public void validate(String email, String password) {
        if (!email.contains("@") || password.length() < 8) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
