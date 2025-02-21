package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.service.EmpService;

@WebMvcTest(controllers=EmpController.class)
public class EmpControllersTest {
	
	@MockitoBean
	private EmpService empService;
	
	@Autowired 
	private MockMvc mockMvc ;
	
	@Test
	public void testGetEmployee() {
		try {
		mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(MockMvcResultMatchers.status().is(200));
		}
		catch (Exception e) {
			
		}
	}

	@Test 
	public void testGetEmployeeBelongingToRole() {
		try {
		mockMvc.perform(MockMvcRequestBuilders.get("/employees/role?desig=Manager")).andExpect(MockMvcResultMatchers.status().is(200));
		}
		catch (Exception e) {
			
		}
	}
}
