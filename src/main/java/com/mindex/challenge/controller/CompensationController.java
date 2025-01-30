package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A Controller for Compensation.
 * Uses the CompensationService to provide appropriate responses for the defined API endpoints.
 */

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    /**
     * Creates a compensation given a compensation payload.
     *
     * @param compensation the compensation payload from the request.
     * @return The newly created compensation for an employee.
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received employee create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    /**
     * Reads a compensation given an employee id.
     *
     * @param id the employee id.
     * @return The employee.
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation read request for id [{}]", id);

        return compensationService.getCompensationByEmployeeId(id);
    }
}