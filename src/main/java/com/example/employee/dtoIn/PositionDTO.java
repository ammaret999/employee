package com.example.employee.dtoIn;

public class PositionDTO {
    private String position;
    private int salaryMin;
    private int salaryMax;

    public PositionDTO() {
    }

    public PositionDTO(String position, int salaryMin, int salaryMax) {
        this.position = position;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(int salaryMin) {
        this.salaryMin = salaryMin;
    }

    public int getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(int salaryMax) {
        this.salaryMax = salaryMax;
    }
}
