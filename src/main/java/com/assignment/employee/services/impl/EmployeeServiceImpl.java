package com.assignment.employee.services.impl;

import com.assignment.employee.dto.Employee;
import com.assignment.employee.dto.EmployeeResponse;
import com.assignment.employee.dto.EmployeeUpdated;
import com.assignment.employee.model.EmployeeModel;
import com.assignment.employee.repository.EmployeeRepository;
import com.assignment.employee.services.EmployeeService;
import com.sun.jdi.VMCannotBeModifiedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.json.JsonObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse uploadEmployee(EmployeeModel oneEmployee){
        Random rand = new Random();
        int userId = Math.abs(rand.nextInt());
        oneEmployee.setUserId(Integer.toString(userId));
        employeeRepository.saveEmployees(oneEmployee);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setMessage("Employee created successfully");
        employeeResponse.setUserId(oneEmployee.getUserId());
        return employeeResponse;
    }

    @Override
    public Employee getEmployee(String userId){
        return employeeRepository.findByUserId(userId);
    }

    @Override
    public EmployeeUpdated updateEmployee(String userId, EmployeeModel oneEmployee){
            return employeeRepository.updateEmployee(userId, oneEmployee);
    }

    @Override
    public EmployeeUpdated deleteEmployee(String userId){
        employeeRepository.deleteByUserId(userId);
        EmployeeUpdated employeeUpdated = new EmployeeUpdated();
        employeeUpdated.setMessage("Employee deleted successfully");
        return employeeUpdated;
    }
}
