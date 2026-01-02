package com.epm.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "increment")
public class Increment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long employeeId;
    private Double currentSalary;
    private Double requestedSalary;
    private String reason;
    private String status;
    private Date requestDate;
    @Version
private int version;

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public Double getCurrentSalary() {
        return currentSalary;
    }
    public void setCurrentSalary(Double currentSalary) {
        this.currentSalary = currentSalary;
    }
    public Double getRequestedSalary() {
        return requestedSalary;
    }
    public void setRequestedSalary(Double requestedSalary) {
        this.requestedSalary = requestedSalary;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    
}
