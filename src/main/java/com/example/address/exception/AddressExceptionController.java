package com.example.address.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressExceptionController {

    @ExceptionHandler(value = AddressNotFoundException.class)
    public ResponseEntity<Object> exception(AddressNotFoundException exception) {
        return new ResponseEntity<>("Address Not Found", HttpStatus.NOT_FOUND);
    }

}
