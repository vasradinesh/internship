package com.sprinboot.project10_oneTomany.customexception;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoStudentFoundException extends RuntimeException{

    private String errmsg;
    private Integer statusCode;
    private LocalDateTime localDateTime;

    public NoStudentFoundException(String errmsg,Integer statusCode){
        this.errmsg = errmsg;
        this.statusCode = statusCode;
        this.localDateTime = LocalDateTime.now();
    }
}
