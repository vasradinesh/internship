package com.springboot.project06_oneTOone.controller;


import com.springboot.project06_oneTOone.models.Student;
import com.springboot.project06_oneTOone.service.studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class Studentcontroller {

    @Autowired
    private studentservice studentservice;

    @PostMapping("saveStudents")
    public String saveStudents(@RequestBody Student student) {
        return studentservice.saveStudents(student);
    }

    @GetMapping("getAllStudent")
    public List<Student> getAllStudent() {
        return studentservice.getAllStudent();
    }

    @GetMapping("GetStudentById/{id}")
    public Student GetStudentById(@PathVariable Long id) {
        return studentservice.GetStudentById(id);
    }

    @DeleteMapping("deleteStudentById/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        return studentservice.deleteStudentById(id);
    }

    @DeleteMapping("deleteAllStudents")
    public String deleteAllStudents() {
        return studentservice.deleteAllStudents();
    }

    @PutMapping("updateStudentBYid/{id}")
    public String updateStudentBYid(@PathVariable Long id,@RequestBody Student student) {
        return studentservice.updateStudentBYid(id,student);
    }
}
