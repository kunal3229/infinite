package com.example.kunal.systemdesign.solid.srp;

public interface UserRepo {

    void save(String email, String encryptedPassword);
}
