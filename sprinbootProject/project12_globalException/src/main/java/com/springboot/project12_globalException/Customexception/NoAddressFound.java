package com.springboot.project12_globalException.Customexception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoAddressFound extends RuntimeException{
    private String errmsg;
    private Integer statuscode;
    private LocalDateTime localDateTime;

    public NoAddressFound(String errmsg,Integer statuscode){
        this.errmsg = errmsg;
        this.statuscode=statuscode;
        this.localDateTime = LocalDateTime.now();
    }
}
