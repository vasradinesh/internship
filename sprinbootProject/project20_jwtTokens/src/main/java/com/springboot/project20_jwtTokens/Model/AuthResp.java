package com.springboot.project20_jwtTokens.Model;


import lombok.Data;

@Data
public class AuthResp {

    private String token;
    private String username;
}
