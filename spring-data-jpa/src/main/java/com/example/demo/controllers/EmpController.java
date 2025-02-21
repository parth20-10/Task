package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entites.Employee;
import com.example.demo.service.EmpService;


@RestController
@RequestMapping("/employees")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return empService.getAllEmployees();
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee e) {
        return empService.addEmployee(e);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee e) {
        return empService.updateEmployee(id, e);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return empService.deleteEmployee(id);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id) {
        return empService.getEmployeeById(id);
    }

    @GetMapping("/role")
    public List<Employee> getEmployeeByDesignation(@RequestParam String desig) {
        return empService.getEmployeesByDesignation(desig);
    }

    @GetMapping("/custom")
    public List<Employee> getCustom(@RequestParam String desig) {
        return empService.getCustomEmployees(desig);
    }
}
