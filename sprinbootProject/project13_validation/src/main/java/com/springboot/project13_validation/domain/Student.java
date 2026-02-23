package com.springboot.project13_validation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String mono;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
    private List<Address> addressList ;
}
