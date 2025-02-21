package com.example.demo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
//@Table(name = "emp")
public class Employee {
	@Id
	private int eid;
	private String name;
	private int age;
	private int Salary;
//	@Column(name="ROLE")
	private String designation;
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
