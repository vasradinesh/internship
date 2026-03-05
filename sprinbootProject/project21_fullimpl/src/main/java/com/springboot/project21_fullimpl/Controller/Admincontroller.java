package com.springboot.project21_fullimpl.Controller;


import com.springboot.project21_fullimpl.Model.AuthReq;
import com.springboot.project21_fullimpl.Model.AuthResp;
import com.springboot.project21_fullimpl.Proxy.Employeeproxy;
import com.springboot.project21_fullimpl.service.AdminService;
import com.springboot.project21_fullimpl.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class Admincontroller {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AdminService adminService;


    @GetMapping("get-all-Employee")
    public ResponseEntity<List<Employeeproxy>> getAllEmployee(){
        return new ResponseEntity<>(adminService.getAllEmployee(), HttpStatus.FOUND);
    }

    @GetMapping("delete-employee-by-username/{username}")
    public ResponseEntity<String> deleteEmployeeByusername(@PathVariable String username){
        return new ResponseEntity<>(adminService.deleteEmployeeByUserName(username),HttpStatus.OK);
    }

    @PostMapping("update-employee-by-username/{username}")
    public ResponseEntity<String> updateEmployeeByUserName(@PathVariable String username, @Valid @RequestBody Employeeproxy employeeproxy){
        String s = adminService.updateEmployeeByUserName(username, employeeproxy);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<AuthResp> getlogin(@RequestBody AuthReq authReq){
        return new ResponseEntity<>(employeeService.generateToken(authReq),HttpStatus.OK);
    }


}
