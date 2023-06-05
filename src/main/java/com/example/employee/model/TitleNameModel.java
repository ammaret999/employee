package com.example.employee.model;
import javax.persistence.*;
@Entity
@Table(name = "title_name")
public class TitleNameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "title_name")
    private String titleName;

    public TitleNameModel() {
    }

    public TitleNameModel(Long id, String code, String titleName) {
        this.id = id;
        this.code = code;
        this.titleName = titleName;
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

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
