package com.springboot.project11_manyToMany.controller;

import com.springboot.project11_manyToMany.dto.Studentdto;
import com.springboot.project11_manyToMany.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Studentcontroller {

    @Autowired
    private Studentservice studentservice;


    @PostMapping("save-student")
    public String saveStudent(@RequestBody Studentdto studentdto){
        return studentservice.saveStudent(studentdto);
    }

    @GetMapping("get-student-by-id/{id}")
    public Studentdto getStudentById(@PathVariable Long id){
        return studentservice.getStudentById(id);
    }

    @GetMapping("get-all-student")
    public List<Studentdto> getAllStudent(){
        return studentservice.getAllStudent();
    }

    @DeleteMapping("delete-student-by-id/{id}")
    public String deleteStudentBYId(@PathVariable Long id){
        return studentservice.deleteStudentById(id);
    }

    @DeleteMapping("delete-all-student")
    public String deleteAllStudent(){
        return studentservice.deleteAllStudent();
    }

    @PostMapping("update-student-by-id/{id}")
    public String updateStudentById(@PathVariable Long id,@RequestBody Studentdto studentdto){
        return studentservice.updateStudentById(id,studentdto);
    }

}
