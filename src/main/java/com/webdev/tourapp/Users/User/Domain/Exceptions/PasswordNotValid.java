package com.webdev.tourapp.Users.User.Domain.Exceptions;

public class PasswordNotValid extends RuntimeException {

    public PasswordNotValid(String message)
    {
        super (message);
    }

}
