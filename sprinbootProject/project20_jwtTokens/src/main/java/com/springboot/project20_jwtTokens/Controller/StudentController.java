package com.springboot.project20_jwtTokens.Controller;

import com.springboot.project20_jwtTokens.Model.AuthReq;
import com.springboot.project20_jwtTokens.Model.AuthResp;
import com.springboot.project20_jwtTokens.Proxy.StudentProxy;
import com.springboot.project20_jwtTokens.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private Studentservice studentservice;


    @PostMapping("save-student")
    public String saveStudent(@RequestBody StudentProxy studentProxy){
        return studentservice.saveStudent(studentProxy);
    }


    @GetMapping("get-all-student/{name}")
    public StudentProxy getStudentByUsername(@PathVariable String name){
        return studentservice.getStudentByUsername(name);
    }


    //auth

    @PostMapping("auth/login")
    public ResponseEntity<AuthResp> login(@RequestBody AuthReq authReq){
        AuthResp authResp = studentservice.authenticateStudent(authReq);

        return new ResponseEntity<>(authResp, HttpStatus.OK);
    }






}
