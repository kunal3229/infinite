package com.example.kunal.systemdesign.solid.srp;

public class UserService {
    private final UserValidator validator;
    private final PasswordEncryptor encryptor;
    private final UserRepo repository;
    private final EmailNotifier notifier;

    public UserService(UserValidator v, PasswordEncryptor e, UserRepo r, EmailNotifier n) {
        this.validator = v;
        this.encryptor = e;
        this.repository = r;
        this.notifier = n;
    }

    public void registerUser(String email, String password) {
        validator.validate(email, password);
        String hashed = encryptor.encrypt(password);
        repository.save(email, hashed);
        notifier.sendWelcomeEmail(email);
    }
}
