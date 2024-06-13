package com.assignment.employee.repository;

import com.assignment.employee.dto.Employee;
import com.assignment.employee.dto.EmployeeResponse;
import com.assignment.employee.dto.EmployeeUpdated;
import com.assignment.employee.model.EmployeeModel;
import org.bson.json.JsonObject;

public interface EmployeeCustomRepository {
    void saveEmployees(EmployeeModel oneEmployee);
    public EmployeeUpdated updateEmployee(String userId, EmployeeModel oneEmployee);
}
