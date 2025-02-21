package com.example.employee;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan("clerk")
@Scope("prototype")
public class Clerk extends Employee {
    private Clerk() {
        setDesignation("Clerk");
    }

    public static Clerk createClerk() {
        return new Clerk();
    }
    
    
}

