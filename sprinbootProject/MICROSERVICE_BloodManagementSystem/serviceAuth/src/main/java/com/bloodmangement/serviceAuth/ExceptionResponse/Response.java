package com.bloodmangement.serviceAuth.ExceptionResponse;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Response {

    private String message;
    private String status;
    private LocalDateTime localDateTime;
    private String path;

}