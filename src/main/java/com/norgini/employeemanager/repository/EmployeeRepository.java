package com.norgini.employeemanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.norgini.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Optional<Employee> getEmployeeById(Long id);
	
	 void deleteEmployeeById(Long id);

}
