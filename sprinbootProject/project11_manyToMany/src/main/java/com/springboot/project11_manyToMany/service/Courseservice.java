package com.springboot.project11_manyToMany.service;

import com.springboot.project11_manyToMany.dto.Coursedto;

import java.util.List;

public interface Courseservice {

    public String saveCourse(Coursedto coursedto);
    public Coursedto getCourseById(Long id);
    public List<Coursedto> getAllCourse();


}
