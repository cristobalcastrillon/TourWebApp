package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class GuideDoesNotExist extends RuntimeException {
    public GuideDoesNotExist(String s) {
        super(s);
    }
}
