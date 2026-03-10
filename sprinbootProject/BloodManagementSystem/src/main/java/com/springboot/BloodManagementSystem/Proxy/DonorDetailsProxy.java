package com.springboot.BloodManagementSystem.Proxy;

import com.springboot.BloodManagementSystem.Domain.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorDetailsProxy {

    private Long id;
    private String bloodGroup;
    private Integer age;
    private String gender;
    private String city;
    private LocalDateTime lastDonationDate;
    private String available;

    private Users user;
}
