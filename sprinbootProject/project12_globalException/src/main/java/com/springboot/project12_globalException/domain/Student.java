package com.springboot.project12_globalException.domain;


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
    private String std;
    private String email;
    private String password;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Address> addressList;
}
