package com.emp.empsystem.Testing;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.empsystem.Model.Employee;
import com.emp.empsystem.Repository.EmployeeRepository;
import com.emp.empsystem.Service.EmployeeService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeById() {
        
        Employee sampleEmployee = new Employee();
        sampleEmployee.setId(1L);
        sampleEmployee.setFirstName("Harsh Kumar");
        sampleEmployee.setLastName("Yaduvanshi");

        
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(sampleEmployee));

        
        Employee foundEmployee = employeeService.getEmployeeById(1L);

       
        assertThat(foundEmployee.getFirstName()).isEqualTo("John");
        assertThat(foundEmployee.getLastName()).isEqualTo("Doe");
    }

    
}

