package com.springboot.project13_validation.globalexception;


import com.springboot.project13_validation.customexception.NoStudentFoundException;
import com.springboot.project13_validation.exception.Exceptionresponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoStudentFoundException.class)
    public ResponseEntity<Exceptionresponse> NoStudentFoundException(NoStudentFoundException ex, HttpServletRequest request){
        Exceptionresponse exceptionresponse = new Exceptionresponse();
        exceptionresponse.setMessage(ex.getErrmsg());
        exceptionresponse.setPath(request.getRequestURI());
        exceptionresponse.setLocalDateTime(ex.getLocalDateTime());
        exceptionresponse.setStatus(String.valueOf(ex.getErrCode()));

        return new ResponseEntity<>(exceptionresponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest req){

        HashMap<String,String > errorMap = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error ->{
            String field = ((FieldError) error).getField();//particular filed return (key)ex name,email
            String defaultMessage = error.getDefaultMessage();//return (value)-> not empty not null
            errorMap.put(field,defaultMessage);
        });


        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }



}
