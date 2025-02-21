package com.example.demo.models;

public class Student {
	public int rollno;
	public String name;
	public String school;
	public int precentage;
	public int standard;

	
	
	public Student(int rollno, int standard, String name, String school, int precentage) {
		super();
		this.rollno = rollno;
		this.standard = standard;
		this.name = name;
		this.school = school;
		this.precentage = precentage;
	}
	public Student() {
		super();
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getPrecentage() {
		return precentage;
	}
	public void setPrecentage(int precentage) {
		this.precentage = precentage;
	}
	
}
