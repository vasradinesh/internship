package com.springboot.project21_fullimpl.GlobalException;


import com.springboot.project21_fullimpl.CustomException.NoEmployeeFoundException;
import com.springboot.project21_fullimpl.ExceptionResponse.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoEmployeeFoundException.class)
    public ResponseEntity<Response> NoEmployeeFound(NoEmployeeFoundException e, HttpServletRequest request){
        Response response =new Response();

        response.setPath(request.getRequestURI());
        response.setStatus(e.getErrcode());
        response.setLocalDateTime(e.getLocalDateTime());
        response.setMessage(e.getErrmsg());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


}
