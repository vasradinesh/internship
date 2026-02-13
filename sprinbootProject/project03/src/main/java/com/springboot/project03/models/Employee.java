package com.springboot.project03.models;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private long eid;
    private String name;
    private String address;
}
