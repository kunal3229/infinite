package com.example.kunal.systemdesign.solid.srp;

import java.util.Locale;

public class PasswordEncryptor {

    public String encrypt(String password) {
        return password.toLowerCase(Locale.ROOT);
    }
}
