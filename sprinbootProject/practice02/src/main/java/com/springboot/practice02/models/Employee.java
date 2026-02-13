package com.springboot.practice02.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Employee {
    private long empId;
    private String empName;
    private String empAddress;
    private String role;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    public Employee(long empId, String empName, String empAddress, String role, Date date) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.role = role;
        this.date = date;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        role = role;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", Role='" + role + '\'' +
                ", date=" + date +
                '}';
    }

    public Employee() {
    }
}
