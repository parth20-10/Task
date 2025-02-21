package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.h2repository.H2StudentRepository;
import com.example.demo.postgresrepository.PostgresStudentRepository;

@Service
public class StudentService {

    private final H2StudentRepository h2Repository;
    private final PostgresStudentRepository postgresRepository;

    public StudentService(H2StudentRepository h2Repository, PostgresStudentRepository postgresRepository) {
        this.h2Repository = h2Repository;
        this.postgresRepository = postgresRepository;
    }

    // Save student in both databases
    public void saveStudent(Student student) {
    	System.out.println("------------");

        h2Repository.save(student);
    	System.out.println("------------");

        postgresRepository.save(student);
    	System.out.println("------------");

    }

    // Fetch students from both databases
    public Map<String, List<Student>> getAllStudents() {
    	System.out.println("------------");
        List<Student> h2Students = h2Repository.findAll();
        
        List<Student> postgresStudents = postgresRepository.findAll();

        Map<String, List<Student>> result = new HashMap<>();
        result.put("h2_students", h2Students);
        result.put("postgres_students", postgresStudents);

        return result;
    }
}
