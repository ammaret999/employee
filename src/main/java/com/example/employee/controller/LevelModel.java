package com.example.employee.controller;

import jakarta.persistence.*;

@Entity
@Table(name = "level")
public class LevelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "level")
    private String level;

    public LevelModel() {
    }

    public LevelModel(Long id, String code, String level) {
        this.id = id;
        this.code = code;
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
