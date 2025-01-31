package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

/**
 * Interface for the CompensationService.
 * Includes retrieving an employee's compensation
 */

// A next step could be to include an update endpoint to allow a user to update a compensation
public interface CompensationService {
    Compensation create(Compensation compensation);
    Compensation getCompensationByEmployeeId(String id);
}