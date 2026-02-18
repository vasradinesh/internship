package com.springboot.project11_manyToMany.service.serviceimpl;

import com.springboot.project11_manyToMany.domain.Student;
import com.springboot.project11_manyToMany.dto.Studentdto;
import com.springboot.project11_manyToMany.repository.Studentrepo;
import com.springboot.project11_manyToMany.service.Studentservice;
import com.springboot.project11_manyToMany.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Studentimpl implements Studentservice {

    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Modelutility modelutility;

    @Override
    public Studentdto getStudentById(Long id) {
        Optional<Student> byId = studentrepo.findById(id);
        if(byId.isPresent()) {
            return modelutility.studentEntityToDto(byId.get());
        }
        return new Studentdto();
    }

    @Override
    public String saveStudent(Studentdto studentdto) {
        studentrepo.save(modelutility.studentDtoToEntity(studentdto));
        return "saved";
    }

    @Override
    public List<Studentdto> getAllStudent() {
        return modelutility.listStudentEntityToDto(studentrepo.findAll());
    }

    @Override
    public String deleteAllStudent() {
        studentrepo.deleteAll();
        return "all student has been deleted";
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> studentOptional = studentrepo.findById(id);
        if(studentOptional.isPresent()){
            studentrepo.deleteById(id);
            return "deleted";
        }
        return "there is no such student of given id";
    }

    @Override
    public String updateStudentById(Long id,Studentdto studentdto) {
        Optional<Student> studentOptional = studentrepo.findById(id);
        if(studentOptional.isPresent()){
            studentrepo.save(modelutility.studentDtoToEntity(studentdto));
            return "updates";
        }
        return "there is no such student of given id";
    }
}
