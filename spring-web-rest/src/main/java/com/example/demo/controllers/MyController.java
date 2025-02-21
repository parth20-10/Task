package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping(path="/", produces="text/xml")
	public String acb() {
		return "<html><body><h1>Welcome to ....</h1></body></html>";
	}

	@GetMapping(path="/greet", produces="text/xml")
	public String greeter() {
		return "<h1>Welcome to Greeter....</h1>";
	}
	@PutMapping(path="/greet", produces="text/xml")
	public String greeter2() {
		return "<h1>Welcome to Greeter Put....</h1>";
	}
	@PostMapping(path="/greet", produces="text/xml")
	public String greeter3() {
		return "<h1>Welcome to Greeter Post....</h1>";
	}
	@DeleteMapping	(path="/greet", produces="text/xml")
	public String greeter4() {
		return "<h1>Welcome to Greeter Delete....</h1>";
	}
	@PatchMapping(path="/greet", produces="text/xml")
	public String greeter5() {
		return "<h1>Welcome to Greeter Patch....</h1>";
	}
}
