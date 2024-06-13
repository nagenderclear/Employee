package com.assignment.employee.repository;

import com.assignment.employee.dto.Employee;
import com.assignment.employee.model.EmployeeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeModel, String>, EmployeeCustomRepository {
    public Employee findByUserId(String userId);
    public void deleteByUserId(String userId);
}
