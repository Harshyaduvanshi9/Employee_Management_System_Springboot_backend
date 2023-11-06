package com.emp.empsystem.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emp.empsystem.Model.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {
   
}

