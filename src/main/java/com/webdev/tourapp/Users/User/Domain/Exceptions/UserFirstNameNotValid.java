package com.webdev.tourapp.Users.User.Domain.Exceptions;

public class UserFirstNameNotValid extends RuntimeException{

    public UserFirstNameNotValid(String message)
    {
        super (message);
    }
}
