package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "title_name")
    private Long titleName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "nick_name")
    private String nickName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "image")
    private String image;
    @Column(name = "gender")
    private Long gender;
    @Column(name = "slack_name")
    private String slackName;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "email")
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "status")
    private boolean status;
    @Column(name = "department")
    private Long department;
    @Column(name = "position")
    private Long position;

    public EmployeeModel() {
    }

    public EmployeeModel(Long id, String code, Long titleName, String firstName, String lastName, String nickName, LocalDate birthday, String image, Long gender, String slackName, Long phoneNumber, String email, LocalDate startDate, LocalDate endDate, boolean status, Long department, Long position) {
        this.id = id;
        this.code = code;
        this.titleName = titleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthday = birthday;
        this.image = image;
        this.gender = gender;
        this.slackName = slackName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.department = department;
        this.position = position;
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

    public Long getTitleName() {
        return titleName;
    }

    public void setTitleName(Long titleName) {
        this.titleName = titleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getSlackName() {
        return slackName;
    }

    public void setSlackName(String slackName) {
        this.slackName = slackName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

}
