package com.norgini.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norgini.employeemanager.exception.UserNotFoundException;
import com.norgini.employeemanager.model.Employee;
import com.norgini.employeemanager.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return repository.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee getEmployeeById(Long id) {
		return repository.getEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}

	public void deleteEmployee(Long id) {
		repository.deleteEmployeeById(id);
	}
}