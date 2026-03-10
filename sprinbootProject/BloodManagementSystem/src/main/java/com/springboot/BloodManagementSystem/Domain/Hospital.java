package com.springboot.BloodManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospitalName;
    private String address;
    private String contactNumber;

    private String licenseNumber;

    @OneToOne
    @JoinColumn(name = "User_id")
    private Users users;


}
