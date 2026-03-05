package com.springboot.project21_fullimpl.service;

import com.springboot.project21_fullimpl.Model.AuthReq;
import com.springboot.project21_fullimpl.Model.AuthResp;
import com.springboot.project21_fullimpl.Proxy.Employeeproxy;

public interface EmployeeService {


    String saveEmployee(Employeeproxy employeeproxy);


    Employeeproxy getEmployeeByName(String name);

    AuthResp generateToken(AuthReq authReq);

}
