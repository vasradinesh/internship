package com.springboot.project19_springseuritycore.proxy;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studentproxy {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String address;
}
