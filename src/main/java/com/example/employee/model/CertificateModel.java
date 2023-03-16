package com.example.employee.model;

import javax.persistence.*;

@Entity
@Table(name = "certificate")
public class CertificateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeModel employeeId;
    @Column(name = "topic")
    private String topic;
    @Column(name = "description")
    private String description;

    public CertificateModel() {
    }

    public CertificateModel(Long id, String code, EmployeeModel employeeId, String topic, String description) {
        this.id = id;
        this.code = code;
        this.employeeId = employeeId;
        this.topic = topic;
        this.description = description;
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

    public EmployeeModel getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeModel employeeId) {
        this.employeeId = employeeId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
