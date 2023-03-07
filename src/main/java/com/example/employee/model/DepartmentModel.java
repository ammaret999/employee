package com.example.employee.model;
import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "department_name")
    private String department;

    public DepartmentModel() {
    }

    public DepartmentModel(Long id, String code, String department) {
        this.id = id;
        this.code = code;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
