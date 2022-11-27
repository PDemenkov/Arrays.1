package com.example.arrays1.exception;

public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException() {
    }

    public ArrayIsFullException(String message) {
        super(message);
    }
}
