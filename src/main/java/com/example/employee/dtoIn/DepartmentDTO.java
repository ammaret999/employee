package com.example.employee.dtoIn;


public class DepartmentDTO {
    private String department;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
