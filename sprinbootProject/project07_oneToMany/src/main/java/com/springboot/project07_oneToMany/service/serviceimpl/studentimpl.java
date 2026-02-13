package com.springboot.project07_oneToMany.service.serviceimpl;

import com.springboot.project07_oneToMany.domain.Address;
import com.springboot.project07_oneToMany.domain.Student;
import com.springboot.project07_oneToMany.repository.Studentrepo;
import com.springboot.project07_oneToMany.service.studentservice;
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
        Optional<Student> student1 = studentrepo.findById(id);
        if (student1.isPresent()){
            Student existingstudent = student1.get();
            student.setId(existingstudent.getId());
            existingstudent.getAddress().clear();

//            existingstudent.setName(student.getName());
//            existingstudent.setEmail(student.getEmail());
//            existingstudent.setPassword(student.getPassword());
//
//
//            for(Address address : student.getAddress()){
//                existingstudent.getAddress().add(address);
//            }


            studentrepo.save(student);

            return "updated";
        }else {
            return "there is no student of given id";
        }
    }

}
