package com.example.prolect09_oneToonebidirectional.dto;


import jakarta.persistence.*;
import lombok.Data;

@Data
public class Companydto {

    private Long id;
    private String cname;
    private Double salary;
    private Employeedto employee;
}
