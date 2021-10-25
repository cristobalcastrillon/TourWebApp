package com.webdev.tourapp.Users.User.Domain.Exceptions;

public class UserUsernameNotValid extends RuntimeException {

    public UserUsernameNotValid(String message)
    {
        super (message);
    }

}
