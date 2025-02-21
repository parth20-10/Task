package com.example.exception;


public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
    public void display() {
        System.out.println(super.getMessage());
    }
}
