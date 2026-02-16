package com.example.prolect09_oneToonebidirectional.service;


import com.example.prolect09_oneToonebidirectional.dto.Employeedto;

import java.util.List;

public interface Employeeservice {
    public Employeedto getEmployeeById(Long id);
    public String saveAllEmployee(Employeedto employeedto);
    public List<Employeedto> getAllEmployee();
    public String deleteEmployeeById(Long id);
    public String updateEmployeeById(Long id,Employeedto employeedto);
}
