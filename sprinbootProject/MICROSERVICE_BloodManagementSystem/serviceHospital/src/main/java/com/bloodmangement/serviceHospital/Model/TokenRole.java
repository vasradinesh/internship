package com.bloodmangement.serviceHospital.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenRole {

    private String token;
    private String role;

}
