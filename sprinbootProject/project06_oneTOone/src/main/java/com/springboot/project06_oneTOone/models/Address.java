package com.springboot.project06_oneTOone.models;


import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dob;

    @Column(name = "address")
    private String addresss;

    @Column(name = "account_no")
    private String accno;

    @Column(name = "mobile_no")
    private String mobno;

}
