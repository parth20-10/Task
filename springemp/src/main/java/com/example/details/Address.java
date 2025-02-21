package com.example.details;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("address")
@Scope("prototype")
public class Address {
	@Value("Pune")
	public String city;
	@Value("MH")
	public String state;
	@Value("411000")
	public int pin;
	
	@Override
	public String toString() {
		return "Address :  city : " + city + " state : "+state+" pin"+pin;
	}
}
