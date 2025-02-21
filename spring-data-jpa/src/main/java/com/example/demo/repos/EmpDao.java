package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entites.Employee;

public interface EmpDao extends JpaRepository	<Employee ,Integer> {
	
	public List <Employee> getByDesignation(String desig);
	public List <Employee> getByAgeGreaterThan(int age);
	public List <Employee> getByAgeLessThan(int age);
	
//	@Query("FROM Employee  where designation=?3 order by age desc")
//	public List<Employee> myCustomQuery(int age, int salary ,String desig);
	
	@Query("FROM Employee  where designation=?1 order by age desc")
	public List<Employee> myCustomQuery(String desig);

}
