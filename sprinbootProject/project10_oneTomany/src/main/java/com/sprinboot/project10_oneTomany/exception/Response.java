package com.sprinboot.project10_oneTomany.exception;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {

    private String message;
    private Integer status;
    private LocalDateTime localDateTime;
    private String path;

}
