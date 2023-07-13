package com.norgini.employeemanager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

	@Test
	public void testGettersAndSetters() {
		Employee employee = new Employee();
		Employee employee2 = new Employee(1L, "John Doe", "johndoe@example.com", "Software Engineer", "1234567890",
				"https://example.com/image.jpg", "EMP001");

		// Set values using setter methods
		employee.setId(1L);
		employee.setName("John Doe");
		employee.setEmail("johndoe@example.com");
		employee.setJobTitle("Software Engineer");
		employee.setPhone("1234567890");
		employee.setImageUrl("https://example.com/image.jpg");
		employee.setEmployeeCode("EMP001");

		// Verify values using getter methods
		assertEquals(1L, employee.getId());
		assertEquals("John Doe", employee.getName());
		assertEquals("johndoe@example.com", employee.getEmail());
		assertEquals("Software Engineer", employee.getJobTitle());
		assertEquals("1234567890", employee.getPhone());
		assertEquals("https://example.com/image.jpg", employee.getImageUrl());
		assertEquals("EMP001", employee.getEmployeeCode());
	}

	@Test
	public void testToString() {
		Employee employee = new Employee();
		assertNotNull(employee.toString());
	}

}
