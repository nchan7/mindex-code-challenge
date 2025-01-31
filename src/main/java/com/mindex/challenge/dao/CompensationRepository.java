package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The Compensation Repository Interface.
 * Created this repository to fetch compensation data for a specific employee using the persistence layer
 */
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {

    /**
     * Finds a compensation based on the given employee id
     *
     * @param employeeId the employee id
     */
    Compensation findByEmployeeId(String employeeId);
}
