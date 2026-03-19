package com.bloodmangement.serviceAdmin.Proxy;

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
