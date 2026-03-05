package com.springboot.project21_fullimpl.service;

import com.springboot.project21_fullimpl.Proxy.Employeeproxy;

import java.util.List;

public interface AdminService {

    String deleteEmployeeByUserName(String username);

    String updateEmployeeByUserName(String username, Employeeproxy employeeproxy);

    List<Employeeproxy> getAllEmployee();
}
