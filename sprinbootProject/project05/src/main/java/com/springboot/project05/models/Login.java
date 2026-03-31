package com.springboot.project05.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Login {

    private String email;
    private String password;
}
