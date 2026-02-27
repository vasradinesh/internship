package com.springboot.project20_jwtTokens.Model;


import lombok.Data;

@Data
public class AuthReq {
    private String username;
    private String password;
}
