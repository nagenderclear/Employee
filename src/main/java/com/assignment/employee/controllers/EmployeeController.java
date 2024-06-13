package com.assignment.employee.controllers;


import com.assignment.employee.dto.Employee;
import com.assignment.employee.dto.EmployeeResponse;
import com.assignment.employee.dto.EmployeeUpdated;
import com.assignment.employee.model.EmployeeModel;
import com.assignment.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.json.JsonObject;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(path = "/employees")
    public EmployeeResponse uploadEmployee(
            @RequestBody EmployeeModel file){
            return employeeService.uploadEmployee(file);

    }

    @GetMapping(path = "/employees/{userId}")
    public Employee getEmployee(
            @PathVariable String userId){
            return  employeeService.getEmployee(userId);
    }

    @PutMapping(path = "/employees/{userId}")
    public EmployeeUpdated updateEmployee(
            @PathVariable String userId,
            @RequestBody EmployeeModel file){
            return employeeService.updateEmployee(userId, file);
    }

    @DeleteMapping(path = "/employees/{userId}")
    public EmployeeUpdated deleteEmployee(
            @PathVariable String userId){
        return  employeeService.deleteEmployee(userId);
    }

}
