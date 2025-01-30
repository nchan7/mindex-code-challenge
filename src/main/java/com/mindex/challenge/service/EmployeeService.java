package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;

/**
 * Interface for the EmployeeService.
 * Includes creating an employee, retrieving an employee, and updating an employee's information
 */

public interface EmployeeService {
    Employee create(Employee employee);
    Employee read(String id);
    Employee update(Employee employee);
}
