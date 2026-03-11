package com.springboot.BloodManagementSystem.GlobalException;


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
        Response response = new Response();
        response.setMessage(ex.getMessage());
        response.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setLocalDateTime(LocalDateTime.now());
        response.setPath(request.getRequestURI());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<Response> NoUserFoundException(NoUserFoundException ex,HttpServletRequest request){
        Response response = new Response();

        response.setMessage(ex.getErrmsg());
        response.setStatus(ex.getErrcode());
        response.setPath(request.getRequestURI());
        response.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }


}
