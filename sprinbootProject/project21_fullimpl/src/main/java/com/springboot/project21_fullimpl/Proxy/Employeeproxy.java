package com.springboot.project21_fullimpl.Proxy;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employeeproxy {

    private Long id;
    private String name;

    @NotNull
    @NotBlank(message = "username is required")
    private String userName;
    @NotNull
    @NotBlank(message = "password is required")
    private String password;

    private String department;
    private String role;
    private String address;

    @NotBlank
    @NotNull
    @Email(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",message = "enter correct email")
    private String email;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Mobile number must be exactly 10 digits"
    )
    private String mobileNo;

}
