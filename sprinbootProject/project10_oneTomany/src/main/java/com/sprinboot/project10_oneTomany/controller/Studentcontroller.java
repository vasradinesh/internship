package com.sprinboot.project10_oneTomany.controller;


import com.sprinboot.project10_oneTomany.dto.Studentdto;
import com.sprinboot.project10_oneTomany.service.Studentservcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Studentcontroller {
    @Autowired
    private Studentservcie studentservcie;

    @PostMapping("save-Students")
    public ResponseEntity<String> saveStudents(@RequestBody Studentdto studentdto) {
        String msg =  studentservcie.saveStudents(studentdto);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("get-all-student")
    public List<Studentdto> getAllStudent() {
        return studentservcie.getAllStudent();
    }

    @GetMapping("get-student-by-id/{id}")
    public Studentdto GetStudentById(@PathVariable Long id) {
        return studentservcie.GetStudentById(id);
    }

    @DeleteMapping("delete-student-by-id/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        return studentservcie.deleteStudentById(id);
    }

    @DeleteMapping("delete-all-students")
    public String deleteAllStudents() {
        return studentservcie.deleteAllStudents();
    }

    @PutMapping("update-student-by-id/{id}")
    public String updateStudentBYid(@PathVariable Long id,@RequestBody Studentdto studentdto) {
        return studentservcie.updateStudentBYid(id,studentdto);
    }

}
