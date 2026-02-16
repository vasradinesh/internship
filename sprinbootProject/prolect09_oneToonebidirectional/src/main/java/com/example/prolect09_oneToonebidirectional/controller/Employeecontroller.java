package com.example.prolect09_oneToonebidirectional.controller;


import com.example.prolect09_oneToonebidirectional.dto.Employeedto;
import com.example.prolect09_oneToonebidirectional.service.Employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Employeecontroller {

    @Autowired
    private Employeeservice employeeservice;

    @PostMapping("save-employee")
    public String SaveEmployee(@RequestBody Employeedto employeedto){
        return employeeservice.saveAllEmployee(employeedto);
    }

    @GetMapping("get-employee-by-id/{id}")
    public Employeedto getEmployeeById(@PathVariable Long id){
        return employeeservice.getEmployeeById(id);
    }

    @GetMapping("get-allemployee")
    public List<Employeedto> getAllEmployee(){
        return employeeservice.getAllEmployee();
    }

    @PostMapping("update-employee-by-id/{id}")
    public String updateEmployeeById(@PathVariable Long id,@RequestBody Employeedto employeedto){
        return employeeservice.updateEmployeeById(id,employeedto);
    }

    @GetMapping("delete-employee-by-id/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return employeeservice.deleteEmployeeById(id);
    }
}
