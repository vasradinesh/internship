package com.springboot.BloodManagementSystem.GlobalException;


import com.springboot.BloodManagementSystem.CustomException.NoBloodFoundException;
import com.springboot.BloodManagementSystem.CustomException.NoUserFoundException;
import com.springboot.BloodManagementSystem.ExceptionResponse.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> runTimeException(RuntimeException ex, HttpServletRequest request){
        Response response = Response.builder()
                .localDateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .status(String.valueOf(HttpStatus.BAD_REQUEST)).build();
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<Response> NoUserFoundException(NoUserFoundException ex,HttpServletRequest request){
        Response response = Response.builder()
                .message(ex.getErrmsg())
                .status(ex.getErrcode())
                .path(request.getRequestURI())
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoBloodFoundException.class)
    public ResponseEntity<Response> NoBloodFoundException(NoBloodFoundException ex , HttpServletRequest request){
        Response response = Response.builder()
                .message(ex.getErrmsg())
                .path(request.getRequestURI())
                .localDateTime(ex.getLocalDateTime())
                .status(ex.getErrcode())
                .build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);


    }


}
