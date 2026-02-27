package com.springboot.project20_jwtTokens.service;

import com.springboot.project20_jwtTokens.Model.AuthReq;
import com.springboot.project20_jwtTokens.Model.AuthResp;
import com.springboot.project20_jwtTokens.Proxy.StudentProxy;

public interface Studentservice {

    String saveStudent(StudentProxy studentProxy);

    StudentProxy getStudentByUsername(String name);
    public AuthResp authenticateStudent(AuthReq authReq);
}
