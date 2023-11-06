package com.emp.empsystem.Testing;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.empsystem.Model.Department;
import com.emp.empsystem.Repository.DepartmentRepository;
import com.emp.empsystem.Service.DepartmentService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DepartmentServiceTest {
    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void testGetDepartmentById() {

       
        Department sampleDepartment = new Department();
        sampleDepartment.setDepartmentId("IT");
        sampleDepartment.setDepartmentName("Information Technology");

   
        Mockito.when(departmentRepository.findById("IT")).thenReturn(Optional.of(sampleDepartment));

      
        Department foundDepartment = departmentService.getDepartmentById("IT");

       
        assertThat(foundDepartment.getDepartmentName()).isEqualTo("Information Technology");
    }

    
}

