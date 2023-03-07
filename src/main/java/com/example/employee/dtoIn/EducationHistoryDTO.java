package com.example.employee.dtoIn;

public class EducationHistoryDTO {
    private String levelId;
    private String institution;
    private String description;

    public EducationHistoryDTO() {
    }

    public EducationHistoryDTO(String levelId, String institution, String description) {
        this.levelId = levelId;
        this.institution = institution;
        this.description = description;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
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
