package com.example.employee.model;
import jakarta.persistence.*;

@Entity
@Table(name = "education_history")
public class EducationHistoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeModel employeeId;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private LevelModel levelId;
    @Column(name = "institution")
    private String institution;
    @Column(name = "description")
    private String description;

    public EducationHistoryModel() {
    }

    public EducationHistoryModel(Long id, String code, EmployeeModel employeeId, LevelModel levelId, String institution, String description) {
        this.id = id;
        this.code = code;
        this.employeeId = employeeId;
        this.levelId = levelId;
        this.institution = institution;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public LevelModel getLevelId() {
        return levelId;
    }

    public void setLevelId(LevelModel levelId) {
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
