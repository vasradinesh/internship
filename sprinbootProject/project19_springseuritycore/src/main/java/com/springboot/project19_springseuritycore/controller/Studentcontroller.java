package com.springboot.project19_springseuritycore.controller;


import com.springboot.project19_springseuritycore.proxy.Studentproxy;
import com.springboot.project19_springseuritycore.service.Studentservice;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Studentcontroller {

    @Autowired
    private Studentservice studentservice;


    @GetMapping("getword")
    public String getWord(){
        return "hello";
    }

    @PostMapping("getremotehost")
    public String getClientIpAddress(HttpServletRequest request){
        return request.getRemoteHost();
    }

    @GetMapping("session")
    public String getSessionId(HttpServletRequest request){
        return request.getSession().getId();
    }

    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());

    }

    @PostMapping("/save-student")
    public ResponseEntity<String> saveStudent(@RequestBody Studentproxy studentproxy){
        String s = studentservice.saveStudent(studentproxy);
        return ResponseEntity.ok(s);
    }



}
