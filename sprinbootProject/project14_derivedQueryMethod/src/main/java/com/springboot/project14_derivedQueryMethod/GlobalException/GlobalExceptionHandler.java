package com.springboot.project14_derivedQueryMethod.GlobalException;

import com.springboot.project14_derivedQueryMethod.customexception.NoStudentFoundException;
import com.springboot.project14_derivedQueryMethod.exceptionResponse.Exceptionresponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


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


}
