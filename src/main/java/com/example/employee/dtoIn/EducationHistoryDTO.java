package com.example.employee.dtoIn;

public class EducationHistoryDTO {
    private Long employeeId;
    private Long levelId;
    private String institution;
    private String description;

    public EducationHistoryDTO() {
    }

    public EducationHistoryDTO(Long employeeId, Long levelId, String institution, String description) {
        this.employeeId = employeeId;
        this.levelId = levelId;
        this.institution = institution;
        this.description = description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
