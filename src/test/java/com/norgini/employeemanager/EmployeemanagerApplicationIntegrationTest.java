package com.norgini.employeemanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeemanagerApplicationIntegrationTest {

    @Test
    public void testApplicationStarts() {
        EmployeemanagerApplication.main(new String[]{});
        // O teste será aprovado se a aplicação for iniciada sem lançar exceções
    }
}
