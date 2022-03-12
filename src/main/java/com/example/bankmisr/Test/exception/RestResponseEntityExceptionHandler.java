package com.example.bankmisr.Test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestResponseEntityExceptionHandler extends RuntimeException {



        public RestResponseEntityExceptionHandler() {
            super();
        }
        public RestResponseEntityExceptionHandler(String message, Throwable cause) {
            super(message, cause);
        }
        public RestResponseEntityExceptionHandler(String message) {
            super(message);
        }
        public RestResponseEntityExceptionHandler(Throwable cause) {
            super(cause);
        }
    }
