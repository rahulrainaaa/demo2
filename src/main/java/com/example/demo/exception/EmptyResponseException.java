package com.example.demo.exception;

public class EmptyResponseException extends RuntimeException {

    public EmptyResponseException(String msg) {
        super(msg);
    }
}
