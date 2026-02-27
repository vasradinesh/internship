package com.springboot.project20_jwtTokens.Utility;


import com.springboot.project20_jwtTokens.Entity.Student;
import com.springboot.project20_jwtTokens.Proxy.StudentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class Mapper {

    @Autowired
    private ObjectMapper objectMapper;


    public Student proxyToEntity(StudentProxy studentProxy){
        return objectMapper.convertValue(studentProxy, Student.class);
    }

    public StudentProxy entityToProxy(Student student){
        return objectMapper.convertValue(student, StudentProxy.class);
    }
}
