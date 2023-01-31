package com.example.employee.controller;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class PositionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "position_name")
    private String position;
    @Column(name = "salary_min")
    private String salaryMin;
    @Column(name = "salary_max")
    private String salaryMax;

    public PositionModel() {
    }

    public PositionModel(Long id, String code, String position, String salaryMin, String salaryMax) {
        this.id = id;
        this.code = code;
        this.position = position;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(String salaryMin) {
        this.salaryMin = salaryMin;
    }

    public String getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(String salaryMax) {
        this.salaryMax = salaryMax;
    }
}
