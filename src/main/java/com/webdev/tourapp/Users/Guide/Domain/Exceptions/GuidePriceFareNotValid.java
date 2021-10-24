package com.webdev.tourapp.Users.Guide.Domain.Exceptions;

public class GuidePriceFareNotValid extends RuntimeException{

    public GuidePriceFareNotValid(String message)
    {
        super (message);
    }
}
