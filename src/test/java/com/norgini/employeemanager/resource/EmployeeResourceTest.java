package com.norgini.employeemanager.resource;

import com.norgini.employeemanager.model.Employee;
import com.norgini.employeemanager.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeResourceTest {

    @Mock
    private EmployeeService service;

    @InjectMocks
    private EmployeeResource resource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());

        when(service.findAllEmployees()).thenReturn(employees);

        ResponseEntity<List<Employee>> response = resource.getAllEmployees();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees.size(), response.getBody().size());

        verify(service, times(1)).findAllEmployees();
    }

    @Test
    public void testFindEmployeeById() {
        Long id = 1L;
        Employee employee = new Employee();
        employee.setId(id);

        when(service.getEmployeeById(id)).thenReturn(employee);

        ResponseEntity<Employee> response = resource.findEmployeeById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(id, response.getBody().getId());

        verify(service, times(1)).getEmployeeById(id);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");

        when(service.addEmployee(employee)).thenReturn(employee);

        ResponseEntity<Employee> response = resource.addEmployee(employee);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(employee.getName(), response.getBody().getName());

        verify(service, times(1)).addEmployee(employee);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");

        when(service.updateEmployee(employee)).thenReturn(employee);

        ResponseEntity<Employee> response = resource.updateEmployee(employee);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee.getName(), response.getBody().getName());

        verify(service, times(1)).updateEmployee(employee);
    }

    @Test
    public void testDeleteEmployee() {
        Long id = 1L;

        ResponseEntity<?> response = resource.deleteEmployee(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(service, times(1)).deleteEmployee(id);
    }
}
