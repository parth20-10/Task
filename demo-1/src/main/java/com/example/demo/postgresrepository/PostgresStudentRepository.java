package com.example.demo.postgresrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface PostgresStudentRepository extends JpaRepository<Student, Long> {
}
