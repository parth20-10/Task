package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {

	private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
   @RequestMapping("/")public String hello() {
	   
	   return "Hello";
   }
    
    @PostMapping("/students")
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student saved in both databases!";
    }

    // GET API to fetch students from both H2 and PostgreSQL
    @GetMapping("/students")
    public Map<String, List<Student>> getAllStudents() {
    	System.out.println(".................");
        return studentService.getAllStudents();
    }
    
}
