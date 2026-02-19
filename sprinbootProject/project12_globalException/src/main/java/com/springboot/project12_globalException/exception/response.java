package com.springboot.project12_globalException.exception;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class response {

    private String message;
    private String status;
    private LocalDateTime localDateTime;
    private String path;

}
