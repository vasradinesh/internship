package com.sprinboot.project10_oneTomany.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String pincode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Student_id")
    private Student student;
}
