package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {

    private String reportingStructureUrl;

    @Autowired
    private ReportingStructureService reportingStructureService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportingStructureUrl = "http://localhost:" + port + "/reportingStructure/{id}";
    }

    @Test
    public void testGetReportsByEmployee() {
        String employeeId = "16a596ae-edd3-4847-99fe-c4518e82c86f";

        // Perform the GET request for the reporting structure
        ReportingStructure reportingStructure = restTemplate.getForObject(reportingStructureUrl, ReportingStructure.class, employeeId);

        // Assert the reporting structure and employee are not null
        assertNotNull(reportingStructure);

        // Assert employee data is accurate
        assertEquals(employeeId, reportingStructure.getEmployee().getEmployeeId());
        assertEquals("John", reportingStructure.getEmployee().getFirstName());
        assertEquals("Lennon", reportingStructure.getEmployee().getLastName());
        assertEquals("Development Manager", reportingStructure.getEmployee().getPosition());
        assertEquals("Engineering", reportingStructure.getEmployee().getDepartment());

        // Assert total number of reports (direct + indirect is accurate)
        // John Lennon has 4 direct + indirect reports
        assertEquals(4, reportingStructure.getNumberOfReports());
    }
}
