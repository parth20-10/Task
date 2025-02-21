package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyControllers {
    
    @GetMapping("/")
    public String getFirstPage() {
        return "home.html"; 
    }

    @GetMapping("/signIn")
    public String getSignIn() {
        return "login.html";
    }

    @RequestMapping("/verify") 
    public String getVerify(String user, String password, HttpSession session) {
        session.setAttribute("user", user);

        if (user.equals(password)) {
            return "welcome.jsp"; 
        } else {
            return "failure.jsp";
        }
    }

	@RequestMapping("/verifymv")
	public ModelAndView verifyUserMv(String user ,String pwd){
		ModelAndView mv = new ModelAndView();
		if(user.equals(pwd)){
			mv.addObject("uname",user);
			mv.setViewName("welcome.jsp");}
		else{
			mv.setViewName("failure.jsp");
		}
		return mv;
	}
}
