package com.mindex.challenge.dao;

import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The Employee Repository Interface.
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    /**
     * Finds an employee based on the given employee id
     *
     * @param employeeId the employee id
     */
    Employee findByEmployeeId(String employeeId);
}
