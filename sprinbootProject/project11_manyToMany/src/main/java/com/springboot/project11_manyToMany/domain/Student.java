package com.springboot.project11_manyToMany.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String name;
    private String email;


    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courseList;


}
