package com.emp.empsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.empsystem.Exceptions.DepartmentNotFoundException;
import com.emp.empsystem.Model.Department;
import com.emp.empsystem.Repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {
        // Add your business logic here, if needed, before saving the department.
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(String departmentId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            return optionalDepartment.get();
        } else {
            // Handle the case when the department is not found, e.g., throw an exception
            // You can create a custom exception class for this purpose.
            throw new DepartmentNotFoundException("Department not found with ID: " + departmentId);
        }
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(String departmentId, Department updatedDepartment) {
        Department existingDepartment = getDepartmentById(departmentId);
        // Update the existingDepartment with the data from updatedDepartment
        existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());

        // Update any other fields as needed

        // Save the updated department
        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(String departmentId) {
        Department existingDepartment = getDepartmentById(departmentId);
        departmentRepository.delete(existingDepartment);
    }
}

