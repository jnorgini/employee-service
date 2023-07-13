package com.norgini.employeemanager.service;

import com.norgini.employeemanager.exception.UserNotFoundException;
import com.norgini.employeemanager.model.Employee;
import com.norgini.employeemanager.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");

        when(repository.save(employee)).thenReturn(employee);

        Employee savedEmployee = service.addEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals(employee.getName(), savedEmployee.getName());

        verify(repository, times(1)).save(employee);
    }

    @Test
    public void testFindAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());

        when(repository.findAll()).thenReturn(employees);

        List<Employee> result = service.findAllEmployees();

        assertNotNull(result);
        assertEquals(employees.size(), result.size());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");

        when(repository.save(employee)).thenReturn(employee);

        Employee updatedEmployee = service.updateEmployee(employee);

        assertNotNull(updatedEmployee);
        assertEquals(employee.getName(), updatedEmployee.getName());

        verify(repository, times(1)).save(employee);
    }

    @Test
    public void testGetEmployeeByIdFound() {
        Long id = 1L;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("John Doe");

        when(repository.getEmployeeById(id)).thenReturn(Optional.of(employee));

        Employee result = service.getEmployeeById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());

        verify(repository, times(1)).getEmployeeById(id);
    }

    @Test
    public void testGetEmployeeByIdNotFound() {
        Long id = 1L;

        when(repository.getEmployeeById(id)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> service.getEmployeeById(id));

        verify(repository, times(1)).getEmployeeById(id);
    }


    @Test
    public void testDeleteEmployee() {
        Long id = 1L;

        service.deleteEmployee(id);

        verify(repository, times(1)).deleteEmployeeById(id);
    }
}
