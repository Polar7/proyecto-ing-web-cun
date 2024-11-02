package com.ingweb.cun.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(FormatEmailException.class)
    public ProblemDetail emailException(FormatEmailException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
        /* ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
       Map<String, Object> details = new HashMap<>();
        details.put("message", exception.getMessage());
        details.put("codigoHttp", HttpStatus.CONFLICT);
        problemDetail.setProperties(details);
        return problemDetail;*/
    }

    @ExceptionHandler({BrandCarExistsException.class, BrandCarNotExistsException.class})
    public ProblemDetail brandCarException(RuntimeException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
    }
}
