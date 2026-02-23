package com.springboot.project14_derivedQueryMethod.exceptionResponse;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Exceptionresponse {
    private String message;
    private String status;
    private LocalDateTime localDateTime;
    private String path;

}
