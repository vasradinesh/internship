package com.springboot.project11_manyToMany.dto;

import com.springboot.project11_manyToMany.domain.Student;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
public class Coursedto {

    private Long id;
    private String name;
    private String price;
    private List<Studentdto> studentList;
}
