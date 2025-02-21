package com.example.demo.users;

public class User {
    private String customerId;
    private String name;
    private String password;

    public User(String customerId, String name, String password) {
        this.customerId = customerId;
        this.name = name;
        this.password = password;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getPassword() { return password; }
}
