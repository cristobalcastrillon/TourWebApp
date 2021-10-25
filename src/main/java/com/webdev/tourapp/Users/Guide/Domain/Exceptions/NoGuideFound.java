package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class NoGuideFound extends RuntimeException{

    public NoGuideFound(String message)
    {
        super (message);
    }
}
