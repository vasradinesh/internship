package com.sprinboot.project10_oneTomany.domain;

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

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Address> address;
}
