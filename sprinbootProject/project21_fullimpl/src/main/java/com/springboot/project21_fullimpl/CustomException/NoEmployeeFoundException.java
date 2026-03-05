package com.springboot.project21_fullimpl.CustomException;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoEmployeeFoundException extends RuntimeException{

    private String errmsg;
    private String errcode;
    private LocalDateTime localDateTime;


    public NoEmployeeFoundException(String errmsg ,String errcode){
        this.errcode  = errcode;
        this.errmsg = errmsg;
        this.localDateTime = LocalDateTime.now();
    }


}
