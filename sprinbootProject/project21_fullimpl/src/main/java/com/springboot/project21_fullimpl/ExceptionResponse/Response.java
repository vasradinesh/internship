package com.springboot.project21_fullimpl.ExceptionResponse;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {

    private String message;
    private String status;
    private LocalDateTime localDateTime;
    private String path;


}
