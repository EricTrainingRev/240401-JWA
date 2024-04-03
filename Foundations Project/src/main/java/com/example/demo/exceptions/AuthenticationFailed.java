package com.example.demo.exceptions;

public class AuthenticationFailed extends RuntimeException {
    public AuthenticationFailed(String message) {
        super(message);
    }
}
