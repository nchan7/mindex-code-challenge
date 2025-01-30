package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

/**
 * Interface for the ReportingStructureService.
 * Includes retrieving an employee's reporting structure
 */

public interface ReportingStructureService {
    ReportingStructure getReportsByEmployee(String id);
}
