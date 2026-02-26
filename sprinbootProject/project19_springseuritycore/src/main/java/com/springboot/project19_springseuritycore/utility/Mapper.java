package com.springboot.project19_springseuritycore.utility;


import com.springboot.project19_springseuritycore.Domain.Student;
import com.springboot.project19_springseuritycore.proxy.Studentproxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class Mapper {

    @Autowired
    private ObjectMapper objectMapper;

    public Student proxytToEntity(Studentproxy studentproxy){
        return objectMapper.convertValue(studentproxy,Student.class);
    }

    public Studentproxy entityToProxy(Student student){
        return objectMapper.convertValue(student, Studentproxy.class);
    }
}
