package com.dh.Clase15_SpringMVC.exception;

public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }
}
