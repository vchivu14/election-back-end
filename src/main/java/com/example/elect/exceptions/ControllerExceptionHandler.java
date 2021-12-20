package com.example.elect.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    private ErrorMessage createErrorMessage(HttpStatus httpStatus, Exception ex, WebRequest request) {
        return new ErrorMessage(
                httpStatus.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        var httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(createErrorMessage(httpStatus,ex,request), httpStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
        var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(createErrorMessage(httpStatus,ex,request), httpStatus);
    }
}

