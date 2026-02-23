package com.sprinboot.project15_jpqlquery.controller;

import com.sprinboot.project15_jpqlquery.dto.Studentdto;
import com.sprinboot.project15_jpqlquery.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Studentcontroller {
    @Autowired
    private Studentservice studentservice;

    @GetMapping("save-student")
    public void saveStudent(){
        studentservice.insertFakeData();
    }

    @PostMapping("update-student-age-by-id/{id}")
    public void updateStudentAgeById(@PathVariable Long id, @RequestBody Studentdto studentdto){
        studentservice.updateAgeByIdJPQL(id,studentdto.getAge(), studentdto.getFirstName(), studentdto.getLastName(),studentdto.getEmail(),studentdto.getMobileNo());
    }

    @DeleteMapping("delete-student-by-email/{email}")
    public void deleteStudentByEmail(@PathVariable String email){
        studentservice.deleteByEmail(email);
    }

}
