package com.springboot.project20_jwtTokens.Controller;

import com.springboot.project20_jwtTokens.Model.AuthReq;
import com.springboot.project20_jwtTokens.Model.AuthResp;
import com.springboot.project20_jwtTokens.Proxy.StudentProxy;
import com.springboot.project20_jwtTokens.service.Studentservice;
import com.springboot.project20_jwtTokens.service.serviceimpl.JwtBlackListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private Studentservice studentservice;

    @Autowired
    private JwtBlackListService jwtBlacklistService;


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


    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

    @PostMapping("/session")
    public String getSessionId(HttpServletRequest request){
        return request.getSession().getId();
    }




    @PostMapping("/user-logout")
    public String logout(HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            jwtBlacklistService.blacklistToken(token);

            System.out.println("heloo");

            return "Logged out successfully";
        }
        return "No token found";
    }




}
