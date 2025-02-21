package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.details.Address;
import com.example.details.GetDetails;
import com.example.handler.DatabaseConnectivityMongoDB;

public abstract class Employee implements java.io.Serializable {
    private int eID;
    private String name;
    private int age;
    private int salary;
    private String designation;
    private String department;
    @Autowired
    private Address address =new Address();    

    public Employee() {

        try  {
            
            if(CEO.ceo==false ) {
                
                CEO.createCEO();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        name = GetDetails.setName("");
        age = GetDetails.setAge(0, 21, 60);
        department =GetDetails.setDepartment();
        salary =GetDetails.setSalary();

    }



    public  void raiseSalary(){
        DatabaseConnectivityMongoDB.appraisal();
    };

    

    public int getSalary() {
        return salary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public int geteID() {
        return eID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getDepartment(){
        return department;
    }
    public Address getAddress(){
        return address;
    }   
}

