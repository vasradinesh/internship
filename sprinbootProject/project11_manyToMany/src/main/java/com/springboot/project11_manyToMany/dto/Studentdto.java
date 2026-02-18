package com.springboot.project11_manyToMany.dto;

import com.springboot.project11_manyToMany.domain.Course;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class Studentdto {

    private Long id;
    private String name;
    private String email;
    private List<Coursedto> courseList;

}
