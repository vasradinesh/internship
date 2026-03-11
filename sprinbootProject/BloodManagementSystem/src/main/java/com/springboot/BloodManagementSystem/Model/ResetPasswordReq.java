package com.springboot.BloodManagementSystem.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordReq {

    @Email(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",message = "enter correct email")
    private String email;
    @Size(min = 5 ,message = "enter strong password")
    private String newPassword;

}
