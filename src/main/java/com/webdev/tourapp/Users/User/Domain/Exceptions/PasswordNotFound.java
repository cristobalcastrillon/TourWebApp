package com.webdev.tourapp.Users.User.Domain.Exceptions;
public class PasswordNotFound extends RuntimeException{

    public PasswordNotFound(String message)
    {
        super (message);
    }
}
