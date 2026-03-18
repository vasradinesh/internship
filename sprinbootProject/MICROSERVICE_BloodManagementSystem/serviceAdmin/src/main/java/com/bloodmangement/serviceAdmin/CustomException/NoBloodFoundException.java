package com.bloodmangement.serviceAdmin.CustomException;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class NoBloodFoundException extends RuntimeException{

    private String errmsg;
    private String errcode;
    private LocalDateTime localDateTime;

    public NoBloodFoundException(String errmsg ,String errcode){
        this.errcode  = errcode;
        this.errmsg = errmsg;
        this.localDateTime = LocalDateTime.now();
    }

}
