package com.example.employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gender")
public class GenderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "gender")
    private String gender;

    public GenderModel() {
    }

    public GenderModel(Long id, String code, String gender) {
        this.id = id;
        this.code = code;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
