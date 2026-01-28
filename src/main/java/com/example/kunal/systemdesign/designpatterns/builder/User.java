package com.example.kunal.systemdesign.designpatterns.builder;

import lombok.ToString;

@ToString
public class User {

    private int id;
    private String name;
    private String password;
    private String email;
    private String address;

    private User(UserBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
        this.address = builder.address;
    }

    public static class UserBuilder{
        private int id;
        private String name;
        private String password;
        private String email;
        private String address;

        public UserBuilder id(int id){this.id = id; return this;}
        public UserBuilder name(String name){this.name = name; return this;}
        public UserBuilder password(String password){this.password = password; return this;}
        public UserBuilder email(String email){this.email = email; return this;}
        public UserBuilder address(String address){this.address = address; return this;}

        public User build(){
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user = new User.UserBuilder()
                        .id(1)
                        .name("Kunal")
                        .email("kual@gmail.com")
                        .password("password123").build();
        System.out.println(user);
    }
}
