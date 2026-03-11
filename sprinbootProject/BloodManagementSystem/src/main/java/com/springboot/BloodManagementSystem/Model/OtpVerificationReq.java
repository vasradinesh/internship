package com.springboot.BloodManagementSystem.Model;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpVerificationReq {

    @Email(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",message = "enter correct email")
    private String email;
    private String otp;


}
