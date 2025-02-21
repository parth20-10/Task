package com.example.employee;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan("programmer")
@Scope("prototype")
public class Programmer extends Employee {
    private Programmer() {
        setDesignation("Programmer");
    }
    public static Programmer createProgrammer() {
        return new Programmer();
    }
   

    
}

