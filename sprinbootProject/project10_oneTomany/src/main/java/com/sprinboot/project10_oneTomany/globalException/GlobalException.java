package com.sprinboot.project10_oneTomany.globalException;

import com.sprinboot.project10_oneTomany.customexception.NoStudentFoundException;
import com.sprinboot.project10_oneTomany.exception.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoStudentFoundException.class)
    public ResponseEntity<Response> noStudentFoundException(NoStudentFoundException ex , HttpServletRequest request){
        Response response = new Response();
        response.setMessage(ex.getErrmsg());
        response.setStatus(ex.getStatusCode());
        response.setPath(request.getRequestURI());
        response.setLocalDateTime(ex.getLocalDateTime());
        return new  ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
