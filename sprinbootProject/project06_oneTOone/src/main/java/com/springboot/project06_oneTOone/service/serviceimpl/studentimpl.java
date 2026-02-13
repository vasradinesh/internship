package com.springboot.project06_oneTOone.service.serviceimpl;

import com.springboot.project06_oneTOone.models.Address;
import com.springboot.project06_oneTOone.models.Student;
import com.springboot.project06_oneTOone.repository.Studentrepo;

import com.springboot.project06_oneTOone.service.studentservice;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentimpl implements studentservice {

    @Autowired
    private Studentrepo studentrepo;

    @Override
    public String saveStudents(Student student) {
            return studentrepo.save(student).toString();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentrepo.findAll();
    }

    @Override
    public Student GetStudentById(Long id) {
        Optional<Student> student = studentrepo.findById(id);
        if (student.isPresent()){
            return student.get();
        }else {
            return new Student();
        }
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> student = studentrepo.findById(id);
        if (student.isPresent()){
            studentrepo.deleteById(id);
            return "deleted";
        }else {
            return "there is no student of given id";
        }
    }

    @Override
    public String deleteAllStudents() {
        studentrepo.deleteAll();
        return "all students are deleted ";
    }

    @Override
    public String updateStudentBYid(Long id, Student student) {
        Optional<Student> student2 = studentrepo.findById(id);
        if (student2.isPresent()){
            Student student1 = student2.get();

            Address address = student1.getAddress();
//            address.setAccno(student.getAddress().getAccno());
//            address.setDob(student.getAddress().getDob());
//            address.setMobno(student.getAddress().getMobno());
//            address.setAddresss(student.getAddress().getAddresss());
//            address.setAccno(student.getAddress().getAccno());
            student.setId(student1.getId());
            student1.getAddress().setId(address.getId());
            return "updated";


        }else {
            return "there is no student of given id";
        }
    }
}
