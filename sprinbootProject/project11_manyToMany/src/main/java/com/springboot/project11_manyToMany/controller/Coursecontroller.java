package com.springboot.project11_manyToMany.controller;


import com.springboot.project11_manyToMany.dto.Coursedto;
import com.springboot.project11_manyToMany.service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Coursecontroller {

    @Autowired
    private Courseservice courseservice;

    @PostMapping("save-course")
    public String saveCourse(@RequestBody Coursedto coursedto){
        return courseservice.saveCourse(coursedto);
    }

    @GetMapping("get-course-by-id/{id}")
    public Coursedto getCourseById(@PathVariable Long id){
        return courseservice.getCourseById(id);
    }

    @GetMapping("get-all-course")
    public List<Coursedto> getAllCourse(){
        return courseservice.getAllCourse();
    }
}
