package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class GuideLastNameNotValid extends RuntimeException{

    public GuideLastNameNotValid(String message)
    {
        super (message);
    }
}
