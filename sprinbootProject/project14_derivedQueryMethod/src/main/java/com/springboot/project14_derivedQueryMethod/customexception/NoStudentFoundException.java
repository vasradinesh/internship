package com.springboot.project14_derivedQueryMethod.customexception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoStudentFoundException extends RuntimeException{

    private String errmsg;
    private Integer errCode;
    private LocalDateTime localDateTime;

    public NoStudentFoundException(String errmsg,Integer errCode){
        this.errmsg = errmsg;
        this.errCode = errCode;
        this.localDateTime = LocalDateTime.now();
    }
}
