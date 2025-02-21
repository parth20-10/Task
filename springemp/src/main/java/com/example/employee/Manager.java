package com.example.employee;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan("manager")
@Scope("prototype")
public class Manager extends Employee {


    private Manager() {
        setDesignation("Manager");
    }
    

    public static Manager createManager() {
        
        return new Manager();
    }
    

    
}

