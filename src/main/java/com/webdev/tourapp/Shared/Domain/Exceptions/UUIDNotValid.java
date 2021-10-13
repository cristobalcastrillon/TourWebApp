package com.webdev.tourapp.Shared.Domain.Exceptions;

public class UUIDNotValid extends RuntimeException {
    public UUIDNotValid(String message) {
        super(message);
    }
}
