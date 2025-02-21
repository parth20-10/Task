package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Employee;
import com.example.demo.repos.EmpDao;

@Service
public class EmpService {

    @Autowired
    private EmpDao dao;

    public Iterable<Employee> getAllEmployees() {
        return dao.findAll();
    }

    public String addEmployee(Employee e) {
        if (dao.existsById(e.getEid())) {
            return "Sorry, Employee with ID already exists.";
        }
        dao.save(e);
        return "Employee Added Successfully.";
    }

    public String updateEmployee(int id, Employee e) {
        if (!dao.existsById(id)) {
            return "Sorry, Employee does not exist.";
        }
        dao.save(e);
        return "Employee Updated Successfully.";
    }

    public String deleteEmployee(int id) {
        if (!dao.existsById(id)) {
            return "Sorry, Employee does not exist.";
        }
        dao.deleteById(id);
        return "Employee Deleted Successfully.";
    }

    public Optional<Employee> getEmployeeById(int id) {
        return dao.findById(id);
    }

    public List<Employee> getEmployeesByDesignation(String desig) {
        return dao.getByDesignation(desig);
    }

    public List<Employee> getCustomEmployees(String desig) {
        return dao.myCustomQuery(desig);
    }
}
