package com.example.prolect09_oneToonebidirectional.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empName;
    private String role;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;
}
