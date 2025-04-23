package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = EmptyResponseException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody ErrorResponse handleEmptyResponseException(EmptyResponseException exception) {
        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST, exception.getMessage())
                .type(URI.create(exception.getClass().getSimpleName()))
                .build();
    }

    @ExceptionHandler(value = DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleDataNotFoundException(DataNotFoundException exception) {
        return ErrorResponse.builder(exception, HttpStatus.NOT_FOUND, exception.getMessage())
                .type(URI.create(exception.getClass().getSimpleName()))
                .build();
    }
}
