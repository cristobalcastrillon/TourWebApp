package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class GuideAlreadyExists extends RuntimeException{

    public GuideAlreadyExists(String message)
    {
        super (message);
    }
}
