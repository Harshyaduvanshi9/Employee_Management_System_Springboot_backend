package com.emp.empsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.emp.empsystem.Model.Department;
import com.emp.empsystem.Service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable String departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable String departmentId, @RequestBody Department updatedDepartment) {
        return departmentService.updateDepartment(departmentId, updatedDepartment);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable String departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}

