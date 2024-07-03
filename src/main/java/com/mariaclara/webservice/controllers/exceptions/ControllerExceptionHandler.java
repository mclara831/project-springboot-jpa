package com.mariaclara.webservice.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mariaclara.webservice.services.exceptions.DatabaseException;
import com.mariaclara.webservice.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(HttpServletRequest request, ResourceNotFoundException e) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandartError> database (HttpServletRequest request, DatabaseException e) {
        String error = "Data base error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()));
    }

}
