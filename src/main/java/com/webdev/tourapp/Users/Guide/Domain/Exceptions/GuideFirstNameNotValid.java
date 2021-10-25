package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class GuideFirstNameNotValid extends RuntimeException{

    public GuideFirstNameNotValid(String message)
    {
        super (message);
    }
}
