package com.assignment.employee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@NoArgsConstructor
@Component
public class EmployeeUpdated {
    private String message;
}
