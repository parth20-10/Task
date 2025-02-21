package com.example.demo.h2repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface H2StudentRepository extends JpaRepository<Student, Long> {
}
