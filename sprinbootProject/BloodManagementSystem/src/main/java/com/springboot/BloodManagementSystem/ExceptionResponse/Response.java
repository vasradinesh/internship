package com.springboot.BloodManagementSystem.ExceptionResponse;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {

    private String message;
    private String status;
    private LocalDateTime localDateTime;
    private String path;

}
