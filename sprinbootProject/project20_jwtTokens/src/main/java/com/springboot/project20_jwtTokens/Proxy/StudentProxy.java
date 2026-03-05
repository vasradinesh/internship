package com.springboot.project20_jwtTokens.Proxy;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProxy {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String address;
    private String role;
}
