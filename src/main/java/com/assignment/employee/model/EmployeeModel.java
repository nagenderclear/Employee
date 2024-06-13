package com.assignment.employee.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class EmployeeModel {
    private String userId;
    private String name;
    private String email;
    private String department;
    private String designation;
    private String joinDate;

}
