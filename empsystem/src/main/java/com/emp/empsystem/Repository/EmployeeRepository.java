package com.emp.empsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.empsystem.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   
}

