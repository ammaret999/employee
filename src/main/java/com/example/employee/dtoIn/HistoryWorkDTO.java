package com.example.employee.dtoIn;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class HistoryWorkDTO {
    private Long employeeId;
    private String companyName;
    private LocalDate startWork;
    private LocalDate endWork;
    private String description;

    public HistoryWorkDTO() {
    }

    public HistoryWorkDTO(Long employeeId, String companyName, LocalDate startWork, LocalDate endWork, String description) {
        this.employeeId = employeeId;
        this.companyName = companyName;
        this.startWork = startWork;
        this.endWork = endWork;
        this.description = description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getStartWork() {
        return startWork;
    }

    public void setStartWork(LocalDate startWork) {
        this.startWork = startWork;
    }

    public LocalDate getEndWork() {
        return endWork;
    }

    public void setEndWork(LocalDate endWork) {
        this.endWork = endWork;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
