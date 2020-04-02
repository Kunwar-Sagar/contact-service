package com.abc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abc.exceptions.*;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
	
	@ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handleException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
		
	@ExceptionHandler({ContactValidationException.class})
    public ResponseEntity<String> handleException(ContactValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
