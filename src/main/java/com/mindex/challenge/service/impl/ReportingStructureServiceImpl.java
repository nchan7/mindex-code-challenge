package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class of ReportingStructure. Provides the business logic for the defined API's of a ReportingStructure object.
 */

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure getReportsByEmployee(String id) {
        LOG.debug("Reading reporting structure for an employee [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(employee);
        int numberOfReports = 0;
        numberOfReports = getNumberOfReportsByEmployee(employee.getDirectReports(), numberOfReports);
        reportingStructure.setNumberOfReports(numberOfReports);

        return reportingStructure;
    }

    private int getNumberOfReportsByEmployee(List<Employee> employees, int numberOfReports) {
        // null check
        if (employees != null) {
            for (Employee employee : employees) {
                Employee report = employeeRepository.findByEmployeeId(employee.getEmployeeId());
                if (report == null) {
                    throw new RuntimeException("Invalid report employeeId: " + employee.getEmployeeId());
                }
                numberOfReports += 1;
                numberOfReports = getNumberOfReportsByEmployee(report.getDirectReports(), numberOfReports);
            }
        }
        return numberOfReports;
    }
}
