package com.mindex.challenge.data;

import java.util.Date;

/**
 * Compensation model with the given attributes.
 */

public class Compensation {
    private String employeeId;
    private Float salary;
    private Date effectiveDate;

    public String getEmployeeId() { return employeeId; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public Float getSalary() { return salary; }

    public void setSalary(Float salary) { this.salary = salary; }

    public Date getEffectiveDate() { return effectiveDate; }

    public void setEffectiveDate(Date effectiveDate) { this.effectiveDate = effectiveDate; }
}
