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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cname;
    private Double salary;

    @OneToOne(mappedBy = "company",cascade = CascadeType.ALL)
    private Employee employee;
}
