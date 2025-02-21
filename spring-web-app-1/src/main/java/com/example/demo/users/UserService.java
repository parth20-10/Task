package com.example.demo.users;

import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class UserService {
    private final HashMap<String, User> userMap = new HashMap<>();

    public boolean registerUser(String customerId, String name, String password, String confirmPassword) {
        if (!password.equals(confirmPassword) || userMap.containsKey(customerId)) {
            return false;
        }
        userMap.put(customerId, new User(customerId, name, password));
        return true;
    }

    public User validateUser(String customerId, String password) {
        User user = userMap.get(customerId);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }
}