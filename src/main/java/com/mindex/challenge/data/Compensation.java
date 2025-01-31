package com.mindex.challenge.data;

import java.util.Date;

/**
 * Compensation model with the given attributes.
 */

    // Could be added within the Employee model but chose to separate due to the tasks presented and to keep a separation of concerns.
    // Consider including in the Employee model if there are additional features needed to link these models together.
    // Another consideration included adding a variable for a compensationId, however I did not include as it wasn't necessary for this particular exercise. An id may be useful in the future
public class Compensation {
    private String employeeId;
    private Double salary;
    private Date effectiveDate;

    public String getEmployeeId() { return employeeId; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public Double getSalary() { return salary; }

    public void setSalary(Double salary) { this.salary = salary; }

    public Date getEffectiveDate() { return effectiveDate; }

    public void setEffectiveDate(Date effectiveDate) { this.effectiveDate = effectiveDate; }
}
