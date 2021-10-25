package com.webdev.tourapp.Users.User.Domain.Exceptions;

public class NoUsersFound extends RuntimeException{

    public NoUsersFound(String message)
    {
        super (message);
    }
}
