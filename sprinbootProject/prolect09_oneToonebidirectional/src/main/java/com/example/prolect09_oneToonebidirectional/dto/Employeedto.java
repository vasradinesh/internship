package com.example.prolect09_oneToonebidirectional.dto;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class Employeedto {

    private Long id;
    private String empName;
    private String role;
    private Companydto company;
}
