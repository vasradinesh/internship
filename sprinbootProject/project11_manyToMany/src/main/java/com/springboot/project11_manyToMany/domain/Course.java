package com.springboot.project11_manyToMany.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String name;
    private String price;

    @ManyToMany(mappedBy = "courseList",cascade = CascadeType.ALL)
    private List<Student> studentList;



}
