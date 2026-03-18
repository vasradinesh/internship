package com.bloodmangement.serviceAuth.Model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthReq {

    @Email(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",message = "enter correct email")
    private String email;
    private String password;

}