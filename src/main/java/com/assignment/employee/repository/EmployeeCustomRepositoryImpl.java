package com.assignment.employee.repository;

import com.assignment.employee.dto.EmployeeResponse;
import com.assignment.employee.dto.EmployeeUpdated;
import com.assignment.employee.model.EmployeeModel;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.UpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Queue;

@RequiredArgsConstructor
@Repository
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {
    private final MongoTemplate mongoTemplate;
    @Override
    public void saveEmployees(EmployeeModel oneEmployee){
        mongoTemplate.save(oneEmployee);
    }

    @Override
    public EmployeeUpdated updateEmployee(String userId, EmployeeModel oneEmployee){
        Query query = new Query(Criteria.where("userId").is(userId));

        Update update = new Update()
                .set("name", oneEmployee.getName())
                .set("email", oneEmployee.getEmail())
                .set("department", oneEmployee.getDepartment())
                .set("designation", oneEmployee.getDesignation());

        mongoTemplate.findAndModify(query, update, EmployeeModel.class);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, EmployeeModel.class);
        if(updateResult.getMatchedCount()>0) {
            EmployeeUpdated employeeUpdated = new EmployeeUpdated();
            employeeUpdated.setMessage("Employee updated successfully");
            return employeeUpdated;
        }
        else{
            EmployeeUpdated employeeUpdated = new EmployeeUpdated();
            employeeUpdated.setMessage("Employee not found by the given ID");
            return employeeUpdated;
        }
    }

}


