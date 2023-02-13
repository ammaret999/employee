package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "work_history")
public class HistoryWorkModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeModel employeeId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "start_work")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startWork;
    @Column(name = "end_work")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endWork;
    @Column(name = "description")
    private String description;

    public HistoryWorkModel() {
    }

    public HistoryWorkModel(Long id, EmployeeModel employeeId, String companyName, LocalDate startWork, LocalDate endWork, String description) {
        this.id = id;
        this.employeeId = employeeId;
        this.companyName = companyName;
        this.startWork = startWork;
        this.endWork = endWork;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeModel getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeModel employeeId) {
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
