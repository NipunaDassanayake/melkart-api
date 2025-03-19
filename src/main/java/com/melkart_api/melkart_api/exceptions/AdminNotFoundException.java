package com.melkart_api.melkart_api.exceptions;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(String message) {
        super(message);
    }
}
