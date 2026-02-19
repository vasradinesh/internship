package com.springboot.project12_globalException.controller;


import com.springboot.project12_globalException.dto.Studentdto;
import com.springboot.project12_globalException.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Studentcontroller {

    @Autowired
    private Studentservice studentservice;

    @PostMapping("save-student")
    public ResponseEntity<String> saveStudent(@RequestBody Studentdto studentdto){
        String msg = studentservice.saveStudent(studentdto);

        return new ResponseEntity<>(msg, HttpStatus.CREATED);
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
