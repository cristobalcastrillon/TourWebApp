package com.webdev.tourapp.Users.User.Domain.Exceptions;

public class UserLastNameNotValid extends RuntimeException{

    public UserLastNameNotValid(String message)
    {
        super (message);
    }
}
