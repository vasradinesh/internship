package com.sprinboot.project08_oneToonebidirectional.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    @Column(name = "pincode")
    private String pincode;

    @OneToOne(mappedBy = "address")
    private Student student;
}
