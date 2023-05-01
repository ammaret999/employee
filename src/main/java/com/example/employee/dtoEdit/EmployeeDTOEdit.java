package com.example.employee.dtoEdit;

import com.example.employee.model.DepartmentModel;
import com.example.employee.model.GenderModel;
import com.example.employee.model.PositionModel;
import com.example.employee.model.TitleNameModel;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeDTOEdit {
    private Long titleName;
    private String firstName;
    private String lastName;
    private String nickName;
    private Date birthday;
    private Long gender;
    private String slackName;
    private Long phoneNumber;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status;
    private Long department;
    private Long position;

    public EmployeeDTOEdit() {
    }

    public EmployeeDTOEdit(Long titleName, String firstName, String lastName, String nickName, Date birthday, Long gender, String slackName, Long phoneNumber, String email, LocalDate startDate, LocalDate endDate, boolean status, Long department, Long position) {
        this.titleName = titleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
