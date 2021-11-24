package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class NotValidGuideStatus extends RuntimeException {
    public NotValidGuideStatus(String s) {
        super(s);
    }
}
