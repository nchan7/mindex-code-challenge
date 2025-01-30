package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

/**
 * Interface for the CompensationService.
 * Includes retrieving an employee's compensation
 */

public interface CompensationService {
    Compensation create(Compensation compensation);
    Compensation getCompensationByEmployeeId(String id);
}