package com.springboot.project12_globalException.globalexception;


import com.springboot.project12_globalException.Customexception.NoAddressFound;
import com.springboot.project12_globalException.Customexception.NoStudentFoundException;
import com.springboot.project12_globalException.exception.response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class Globalexceptionhandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<response> runTimeException(RuntimeException ex, HttpServletRequest request){
        response response = new response();
        response.setMessage(ex.getMessage());
        response.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        response.setLocalDateTime(LocalDateTime.now());
        response.setPath(request.getRequestURI());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoStudentFoundException.class)
    public ResponseEntity<response> noStudentFoundException(NoStudentFoundException ex,HttpServletRequest request){
        response response = new response();
        response.setMessage(ex.getErrmsg());
        response.setPath(request.getRequestURI());
        response.setStatus(String.valueOf(ex.getErrCode()));
        response.setLocalDateTime(ex.getLocalDateTime());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND) ;
    }

    @ExceptionHandler(NoAddressFound.class)
    public ResponseEntity<response> noAddresFoundException(NoAddressFound ex, HttpServletRequest request){
        response response = new response();
        response.setMessage(ex.getErrmsg());
        response.setPath(request.getRequestURI());
        response.setStatus(String.valueOf(ex.getStatuscode()));
        response.setLocalDateTime(ex.getLocalDateTime());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND) ;
    }
}
