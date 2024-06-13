package com.assignment.employee.services;

import com.assignment.employee.dto.Employee;
import com.assignment.employee.dto.EmployeeResponse;
import com.assignment.employee.dto.EmployeeUpdated;
import com.assignment.employee.model.EmployeeModel;
import org.bson.json.JsonObject;

public interface EmployeeService {
    EmployeeResponse uploadEmployee(EmployeeModel file);
    Employee getEmployee(String userId);
    EmployeeUpdated updateEmployee(String userId, EmployeeModel file);
    EmployeeUpdated deleteEmployee(String userId);
}
