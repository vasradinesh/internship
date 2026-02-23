package com.springboot.project13_validation.service.serviceimpl;


import com.springboot.project13_validation.customexception.NoStudentFoundException;
import com.springboot.project13_validation.domain.Student;
import com.springboot.project13_validation.dto.Studentdto;
import com.springboot.project13_validation.repository.Studentrepo;
import com.springboot.project13_validation.service.Studentservice;
import com.springboot.project13_validation.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Studentimpl implements Studentservice {
    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Modelutility modeluitility;

    @Override
    public String saveStudent(Studentdto studentdto) {
        studentdto.getAddressList().forEach(s->s.setStudent(studentdto));
        studentrepo.save(modeluitility.dtoToEntity(studentdto));
        return "saved ";
    }

    @Override
    public Studentdto getStudentById(Long id) {
        Optional<Student> student = studentrepo.findById(id);
        if (student.isPresent()){
            return modeluitility.entityToDto(student.get());
        }else {
            throw new NoStudentFoundException("student not found of given id", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public List<Studentdto> getAllStudent() {
        if(studentrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("there is no student in database",HttpStatus.NOT_FOUND.value());
        }
        return modeluitility.listStudentEntity(studentrepo.findAll());
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> student = studentrepo.findById(id);
        if (student.isPresent()){
            studentrepo.deleteById(id);
            return "deleted";
        }
        throw new NoStudentFoundException("there is no student of given id",HttpStatus.NOT_FOUND.value());
    }

    @Override
    public String deleteAllStudent() {
        if(studentrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("there is no data in database ",HttpStatus.NO_CONTENT.value());
        }
        studentrepo.deleteAll();
        return "all students are deleted";
    }

    @Override
    public String updateStudentById(Long id, Studentdto studentdto) {
        Optional<Student> student = studentrepo.findById(id);
        if(student.isPresent()){
            studentdto.getAddressList().forEach(s->s.setStudent(studentdto));
            studentrepo.save(modeluitility.dtoToEntity(studentdto));
            return "updated";
        }
        throw new NoStudentFoundException("there is no student of given is so you can't update ",HttpStatus.NO_CONTENT.value());
    }



}
