package com.assignment.employee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@NoArgsConstructor
@Component
public class EmployeeResponse {
//    @JsonProperty(value = "id")
    private String message;
    private String userId;
}
