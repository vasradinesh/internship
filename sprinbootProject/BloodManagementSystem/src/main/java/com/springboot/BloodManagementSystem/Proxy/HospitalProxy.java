package com.springboot.BloodManagementSystem.Proxy;


import com.springboot.BloodManagementSystem.CustomAnnotation.MobileNo;
import com.springboot.BloodManagementSystem.Domain.Users;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalProxy {

    private Long id;

    @NotBlank
    private String hospitalName;

    @NotBlank
    private String address;

    @MobileNo
    private String contactNumber;

    @NotBlank
    private String licenseNumber;

    private UsersProxy users;

}
