package com.webdev.tourapp.Users.User.Domain.Entities;

import java.util.HashMap;

import com.webdev.tourapp.Shared.Domain.Ids.UserID;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.*;

public class User
{
    private UserID userID;
    private Username username;
    private UserFirstName userFirstName;
    private UserLastName userLastName;
    //Constructor:
    public User(UserID userID, Username username,
                UserFirstName userFirstName, UserLastName userLastName)
    {
        this.userID = userID;
        this.username = username;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }
    public static User Create(UserID userID, Username username,
                              UserFirstName userFirstName, UserLastName userLastName)
    {
        User myUser = new User (userID , username, userFirstName, userLastName);
        //TODO Intermediate events.
        return myUser;
    }

    public HashMap<String, Object> data()
    {
        return new HashMap<>(){{
            put ("id", userID.value());
            put ("firstName", userFirstName.value());
            put ("lastName", userLastName.value());
            put ("username", username.value());

        }};
    }


}