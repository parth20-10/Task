package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;

@RestController
public class StudentController {
	List<Student> students = new ArrayList<Student>();

	@GetMapping("/")
	public String home() {
		return "Welocme to my website";
	}
	
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/student/{rollno}")
    public String getStudentByRollno(@PathVariable int rollno) {
        return students.stream().filter(student -> student.getRollno() == rollno).findFirst().toString();
    }

    @GetMapping(path="/students/school",produces ="text/plain")
    public List<Student> getStudentBySchool(@RequestParam String school) {
        return students.stream().filter(student -> student.getSchool().equals(school)).toList();
    }

    @GetMapping("students/result")
    public List<Student> getStudentByResult(@RequestParam boolean pass) {
        if(pass==true) {
            return students.stream().filter(student -> student.getPrecentage() > 35).toList();
        } else {
            return students.stream().filter(student -> student.getPrecentage() <= 35).toList();
        }
    }

    @GetMapping("students/strength")
    public int getStudentStrength(@RequestParam String school){
        return (int) students.stream().filter(student -> student.getSchool().equals(school)).count();
    }
    @GetMapping("students/toppers")
    public List<Student> getToppers(){
        return students.stream().sorted((s1, s2) -> Double.compare(s2.getPrecentage(), s1.getPrecentage())).limit(5).toList(); 
    }

    @GetMapping("students/topper")
    public Student getTopper(@RequestParam int standard){
        return students.stream().filter(student -> student.getStandard() == standard).max((s1, s2) -> Double.compare(s1.getPrecentage(), s2.getPrecentage())).get();
    }

    @GetMapping(path="/persons", produces="application/xml")
	public List<Student> getPersons(){
        System.out.println("In getPersons");
        students.add(new Student(1, 2,"Raj", "DSP",90));
        students.add(new Student(2, 3,"Raja", "DSP",90));
        students.add(new Student(3, 4,"Raju", "KVP",30));
        students.add(new Student(4, 2,"Rajesh", "KVP",60));
        students.add(new Student(5, 3,"Rajeev", "SMBA",7));
        students.add(new Student(6, 2,"Rajendra", "SMBA",80));  
        students.add(new Student(7, 3,"Rajeshwari", "DSP",50));
        students.add(new Student(8, 4,"Rajkumar", "DSP",70));
        return students;
	}

	@GetMapping(path="/body")
	public String bodyParaDemo(@RequestBody Student s){
		return "Hello "+s.getName();
	}

}
