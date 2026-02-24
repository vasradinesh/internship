package com.springboot.project17_fileHandling.Controller;


import com.springboot.project17_fileHandling.Proxy.Employeeproxy;
import com.springboot.project17_fileHandling.service.Employeeservice;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Employeecontroller {

    @Autowired
    private Employeeservice employeeservice;

    @GetMapping(value = "/save-fakeemployee")
    public String saveFakeEmployee(){
        return employeeservice.saveFakeData();
    }

    @PostMapping(value = "save-employee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveEmployee(@RequestBody Employeeproxy employeeproxy){
        return employeeservice.saveEmployee(employeeproxy);
    }

    @GetMapping("get-employee-by-email/{email}")
    public Employeeproxy getEmployeeByEmail(@PathVariable String email){
        return employeeservice.getEmployeeByEmail(email);
    }

    @GetMapping("get-all-employee")
    public List<Employeeproxy> getAllEmployee(){
        return employeeservice.getAllEmployee();
    }



}
