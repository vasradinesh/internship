package com.springboot.project12_globalException.service.serviceimpl;

import com.springboot.project12_globalException.Customexception.NoStudentFoundException;
import com.springboot.project12_globalException.domain.Student;
import com.springboot.project12_globalException.dto.Studentdto;
import com.springboot.project12_globalException.repository.Studentrepo;
import com.springboot.project12_globalException.service.Studentservice;
import com.springboot.project12_globalException.uitility.Modeluitility;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
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
    private Modeluitility modeluitility;

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
        return modeluitility.listStudentEntity(studentrepo.findAll());
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> byId = studentrepo.findById(id);
        if(byId.isPresent()){
             studentrepo.deleteById(id);
             return "deleted";
        }else {
            throw new NoStudentFoundException("given id student is not present in database do you can't delete that enter exist id",HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public String deleteAllStudent() {
        if(studentrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("database is empty ",HttpStatus.NOT_FOUND.value());
        }else {
            studentrepo.deleteAll();
        return "deleted all students";
        }
    }

    @Override
    public String updateStudentById(Long id, Studentdto studentdto) {
        Optional<Student> byId = studentrepo.findById(id);
        if (byId.isPresent()){
            studentdto.getAddressList().forEach(s->s.setStudent(studentdto));
            studentrepo.save(modeluitility.dtoToEntity(studentdto));
            return "updated";
        }else {
            throw new NoStudentFoundException("no Student found of given id ",HttpStatus.NOT_FOUND.value());
        }
    }
}
