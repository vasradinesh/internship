package com.springboot.project17_fileHandling.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employeeproxy {
    private Long id;
    private String name;
    private String mobileNo;
    private String email;
    private String address;


}
