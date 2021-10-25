package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class GuidePasswordNotValid extends RuntimeException {

    public GuidePasswordNotValid(String message)
    {
        super (message);
    }

}
