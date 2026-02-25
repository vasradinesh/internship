package com.springboot.project19_springseuritycore.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student {



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



}
