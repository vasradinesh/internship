package com.springboot.project03.controller;

import com.springboot.project03.models.Employee;
import com.springboot.project03.service.Employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private Employeeservice employeeservice;

    @PostMapping("/save_employees")
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeservice.saveEmployee(employee);
    }

    @GetMapping("/get_employeeById/{eid}")
    public Employee getEmployeeById(@PathVariable Long eid) {
        return employeeservice.getEmployeeById(eid);
    }


    @GetMapping("/getallemployee")
    public List<Employee> getAllEmployee() {
       return employeeservice.getAllEmployee();
    }


    @GetMapping("deleteEmployeeById/{eid}")
    public String deleteEmployeeById(@PathVariable Long eid) {
       return employeeservice.deleteEmployeeById(eid);
    }


    @GetMapping("deleteAllEmployee")
    public String deleteAllEmployee() {
        return employeeservice.deleteAllEmployee();
    }

    @PostMapping("updateEmployeeById/{eid}")
    public String updateEmployeeById(@RequestBody Employee employee,@PathVariable Long eid) {
        return employeeservice.updateEmployeeById(employee,eid);
    }

}
