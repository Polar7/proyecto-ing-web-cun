package com.ingweb.cun.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
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

    /**
     * Agrupa los errores relacionados con los campos cuando se usa Validation
     * @param ex Excepcion lanzada por spring-boot-starter-validation
     * @return ResponseEntity-BadRequest con los campos donde hay errores
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, Object> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Error al validar campos obligatorios en el JSON");
        problemDetail.setProperties(errors);

        return problemDetail;
    }
}
