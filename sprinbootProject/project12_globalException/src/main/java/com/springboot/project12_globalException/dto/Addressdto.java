package com.springboot.project12_globalException.dto;

import com.springboot.project12_globalException.domain.Student;
import lombok.Data;

@Data
public class Addressdto {


    private Long id;
    private String state;
    private String city;
    private String pincode;
    private Studentdto student;

}
