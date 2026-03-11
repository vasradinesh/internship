package com.springboot.BloodManagementSystem.Proxy;


import com.springboot.BloodManagementSystem.CustomAnnotation.MobileNo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersProxy {

    private Long id;

    @NotBlank
    private String name;

    @Email(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",message = "enter correct email")
    private String email;

    @Size(min = 5 ,message = "enter strong password")
    private String password;

    private String role;

    @MobileNo
    private String phone;

    private String status;
}
