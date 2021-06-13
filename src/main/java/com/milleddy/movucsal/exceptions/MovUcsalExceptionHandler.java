package com.milleddy.movucsal.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovUcsalExceptionHandler {

    @ExceptionHandler(MovUcsalException.class)
    protected ResponseEntity<Object> handleException(MovUcsalException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }
}
