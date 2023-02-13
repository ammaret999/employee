package com.example.employee.dtoIn;

import com.example.employee.model.EmployeeModel;
import jakarta.persistence.Column;

public class CertificateDTO {
    private Long employeeId;
    private String topic;
    private String description;

    public CertificateDTO() {
    }

    public CertificateDTO(Long employeeId, String topic, String description) {
        this.employeeId = employeeId;
        this.topic = topic;
        this.description = description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
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
