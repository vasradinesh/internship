package com.springboot.project04_orm_sql.service;

import com.springboot.project04_orm_sql.models.Employee;

import java.util.List;

public interface employeeservice {

    public String saveEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long eid);
    public String deleteEmployeeById(Long eid);
    public String deleteAllEmployee();
    public String updateEmployeeById(Long eid,Employee employee);
}
