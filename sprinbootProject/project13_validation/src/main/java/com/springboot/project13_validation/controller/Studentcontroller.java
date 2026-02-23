package com.springboot.project13_validation.controller;


import com.springboot.project13_validation.dto.Studentdto;
import com.springboot.project13_validation.service.Studentservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Studentcontroller {

    @Autowired
    private Studentservice studentservice;

    @PostMapping("save-student")
    public ResponseEntity<String> saveStudent(@Valid @RequestBody Studentdto studentdto){
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
    public String deleteStudentById(@PathVariable Long id){
        return studentservice.deleteStudentById(id);
    }

    @DeleteMapping("delete-all-student")
    public String deleteAllStudent(){
        return studentservice.deleteAllStudent();
    }

    @PostMapping("update-student-by-id/{id}")
    public String updateStudentById(@PathVariable Long id,@Valid @RequestBody Studentdto studentdto){
        return studentservice.updateStudentById(id,studentdto);
    }
}
