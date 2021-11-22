package com.webdev.tourapp.Location.Domain.Exceptions;

public class NoLocationsFoundForCategoryException extends RuntimeException{
    public NoLocationsFoundForCategoryException(String message) {
        super(message);
    }
}