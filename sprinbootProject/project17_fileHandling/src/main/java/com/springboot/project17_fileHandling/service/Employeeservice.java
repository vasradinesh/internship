package com.springboot.project17_fileHandling.service;

import com.springboot.project17_fileHandling.Proxy.Employeeproxy;

import java.util.List;

public interface Employeeservice {
    String saveEmployee(Employeeproxy employeeproxy);
    List<Employeeproxy> getAllEmployee();
    Employeeproxy getEmployeeByEmail(String email);
    String saveFakeData();
}
