package com.springboot.project03.service;

import com.springboot.project03.models.Employee;

import java.util.List;

public interface Employeeservice {

    String saveEmployee(Employee employee);
    Employee getEmployeeById(Long eid);
    List<Employee> getAllEmployee();
    String deleteEmployeeById(Long id);
    String deleteAllEmployee();
    String updateEmployeeById(Employee employee ,Long eid);

}
