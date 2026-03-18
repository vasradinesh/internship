package com.bloodmangement.serviceAdmin.CustomException;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoUserFoundException extends RuntimeException{

    private String errmsg;
    private String errcode;
    private LocalDateTime localDateTime;

    public NoUserFoundException(String errmsg ,String errcode){
        this.errcode  = errcode;
        this.errmsg = errmsg;
        this.localDateTime = LocalDateTime.now();
    }
}
