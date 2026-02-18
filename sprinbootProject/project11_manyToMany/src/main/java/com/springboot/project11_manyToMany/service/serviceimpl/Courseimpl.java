package com.springboot.project11_manyToMany.service.serviceimpl;


import com.springboot.project11_manyToMany.domain.Course;
import com.springboot.project11_manyToMany.dto.Coursedto;
import com.springboot.project11_manyToMany.repository.Courserepo;
import com.springboot.project11_manyToMany.service.Courseservice;
import com.springboot.project11_manyToMany.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Courseimpl implements Courseservice {

    @Autowired
    private Courserepo courserepo;

    @Autowired
    private Modelutility modelutility;


    @Override
    public String saveCourse(Coursedto coursedto) {
        List<Coursedto> coursedtoList = new ArrayList<>();
        coursedtoList.add(coursedto);
        coursedto.getStudentList().forEach(s->s.setCourseList(coursedtoList));
        courserepo.save(modelutility.courseDtoToEntity(coursedto));
        return "saved";
    }

    @Override
    public Coursedto getCourseById(Long id) {
        Optional<Course> courseOptional = courserepo.findById(id);
        if(courseOptional.isPresent()){
            return modelutility.courseEntityToDto(courseOptional.get());
        }
        return new Coursedto();
    }

    @Override
    public List<Coursedto> getAllCourse() {
        return modelutility.listCourseEntityTODto(courserepo.findAll());
    }
}
