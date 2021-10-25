package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class GuidePhoneNumberNotValid extends RuntimeException{

    public GuidePhoneNumberNotValid(String message)
    {
        super (message);
    }
}
