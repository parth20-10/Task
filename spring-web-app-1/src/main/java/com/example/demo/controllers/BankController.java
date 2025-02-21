package com.example.demo.controllers;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.users.User;
import com.example.demo.users.UserService;

@Controller
public class BankController {
    private final UserService userService;
    public BankController(UserService userService) {
        this.userService = userService;
    }


    
    
    @RequestMapping("netbanking")
    public String netbanking() {
        return "netbanking";  
    }

    @PostMapping("/login")
    public String login(@RequestParam String customerId, @RequestParam String password, Model model, HttpSession session) {
        User user = userService.validateUser(customerId, password);
        if (user != null) {
            session.setAttribute("user", user);
            model.addAttribute("name", user.getName());
            return "welcome";  
        }
        model.addAttribute("error", "Invalid Customer ID or Password");
        return "netbanking";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; 
    }

    @PostMapping("/register")
    public String register(@RequestParam String customerId, @RequestParam String name,
                           @RequestParam String password, @RequestParam String confirmPassword,
                           Model model) {
        if (userService.registerUser(customerId, name, password, confirmPassword)) {
            return "redirect:/netbanking";
        }
        model.addAttribute("error", "Registration Failed. Check Details.");
        return "signup";
    }
}
