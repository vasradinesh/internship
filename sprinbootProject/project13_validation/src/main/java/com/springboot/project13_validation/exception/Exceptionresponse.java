package com.springboot.project13_validation.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Exceptionresponse {
    private String message;
    private String status;
    private LocalDateTime localDateTime;
    private String path;
}
