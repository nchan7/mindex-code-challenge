package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Controller for ReportingStructure.
 * Uses the ReportingStructureService to provide appropriate responses for the defined API endpoint.
 */

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    /**
     * Reads an employee's reporting structure given an employee id.
     *
     * @param id the employee id.
     * @return The number of reports (direct and indirect) for an employee.
     */

    // Considered creating this endpoint within employee (i.e. employee/reportingStructure/{id})
    // For the sake of this exercise chose to create a separate ReportingStructureController for readability and clarity
    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure getReportsByEmployee(@PathVariable String id) {
        LOG.debug("Received reporting structure create request for employee id [{}]", id);

        return reportingStructureService.getReportsByEmployee(id);
    }
}
