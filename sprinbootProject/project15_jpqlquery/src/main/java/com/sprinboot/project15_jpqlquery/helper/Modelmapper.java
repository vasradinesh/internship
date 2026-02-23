package com.sprinboot.project15_jpqlquery.helper;

import com.sprinboot.project15_jpqlquery.domain.Student;
import com.sprinboot.project15_jpqlquery.dto.Studentdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class Modelmapper {

    @Autowired
    private ObjectMapper objectMapper;

    public Student dtoToEntity(Studentdto studentdto){
        return objectMapper.convertValue(studentdto, Student.class);
    }

    public Studentdto entityToDto(Student student){
        return objectMapper.convertValue(student, Studentdto.class);
    }

    public List<Student> listStudentDtoToEntity(List<Studentdto> studentdtoList){
        return studentdtoList.stream().map(s->dtoToEntity(s)).toList();
    }

    public List<Studentdto> listStudentEntity(List<Student> studentList){
        return studentList.stream().map(s->entityToDto(s)).toList();
    }

}
