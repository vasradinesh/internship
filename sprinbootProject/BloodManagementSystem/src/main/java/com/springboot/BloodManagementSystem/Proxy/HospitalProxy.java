package com.springboot.BloodManagementSystem.Proxy;


import com.springboot.BloodManagementSystem.Domain.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalProxy {

    private Long id;
    private String hospitalName;
    private String address;
    private String contactNumber;
    private String licenseNumber;
    private UsersProxy users;

}
