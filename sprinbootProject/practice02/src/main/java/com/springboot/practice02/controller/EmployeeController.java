package com.springboot.practice02.controller;

import com.springboot.practice02.models.Employee;
import com.springboot.practice02.service.implementation.EmployeeIplemantation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeIplemantation employeeIplemantation;

    @PostMapping("/save-Employee")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeIplemantation.saveEmployee(employee);
    }

    @GetMapping("/get-employees")
    public List<Employee> getAllEmployees(){
        return employeeIplemantation.getAllEmployees();
    }

    @GetMapping("/get-employeeById/{empId}")
    public Employee getEmpById(@PathVariable Long empId){
        return employeeIplemantation.getEmpById(empId);
    }
    @GetMapping("/delete-allEmployees")
    public String DeleteAllEmp(){
        return employeeIplemantation.DeleteAllEmp();
    }
    @GetMapping("/delete-employeeById/{empId}")
    public String deleteEmpById(@PathVariable Long empId){
        return employeeIplemantation.deleteEmpById(empId);
    }
    @PostMapping("upadate-employeeDetails/{empId}")
    public String upadateEmpById(@PathVariable Long empId,@RequestBody Employee employee){
        return employeeIplemantation.updateEmpByid(empId,employee);
    }







}
