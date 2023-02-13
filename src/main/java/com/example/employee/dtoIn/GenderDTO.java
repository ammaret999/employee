package com.example.employee.dtoIn;

import jakarta.persistence.Column;

public class GenderDTO {
    private String gender;

    public GenderDTO() {
    }

    public GenderDTO(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
