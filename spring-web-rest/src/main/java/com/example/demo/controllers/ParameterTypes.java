package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

import com.example.demo.models.Person;

@RestController
public class ParameterTypes {


	//Query Parameter
	@GetMapping(path="/query", produces="text/plain")
	public String queryParaDemo(@RequestParam String name ,@RequestParam int age) {
		System.out.println( "Hello " + name + " you are " + age + " years old"
		);
		return "Welcome " + name + " you are " + age + " years old";
	}

	//Path Parameter
	@GetMapping(path="/path/{name}/{age}" )
	public String pathParaDemo(@PathVariable String name ,@PathVariable int age) {
		System.out.println( "Hello " + name + " you are " + age + " years old"
		);
		return "Welcome " + name + " you are " + age + " years old";
	}
	
	//body Parameter
	@GetMapping(path="/body")
	public String bodyParaDemo(@RequestBody Person p){
		System.out.println( "Hello " + p.getName() + " you are " + p.getAge() + " years old"
		);
		return " Hello " + p.getName() + " you are " + p.getAge() + " years old";
	}
	
	@GetMapping(path="/persons", produces="application/xml")
	public List<Person> getPersons(){
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("John", 25));
		persons.add(new Person("Jane", 30));
		persons.add(new Person("Doe", 35));
		return persons;
	}


}
