package com.webdev.tourapp.Users.User.Domain.Exceptions;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message)
    {
        super (message);
    }
}
