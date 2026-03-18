package com.bloodmangement.serviceHospital.Proxy;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String status;
}
