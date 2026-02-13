package com.sprinboot.project08_oneToonebidirectional.Controller;


import com.sprinboot.project08_oneToonebidirectional.dto.Studentdto;
import com.sprinboot.project08_oneToonebidirectional.service.studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Studentcontroller {

    @Autowired
    private studentservice studentservice;

    @PostMapping("save-student")
    public String saveStudent(@RequestBody Studentdto studentdto){
        return studentservice.saveStudents(studentdto);
    }

    @GetMapping("get-allstudent")
    public List<Studentdto> getStudentById(){
        return studentservice.getAllStudent();
    }

    @GetMapping("get-student-by-email/{email}")
    public Studentdto getStudentByEmail(@PathVariable String email){
        return studentservice.findStudentByEmail(email);
    }
}
