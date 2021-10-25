package com.webdev.tourapp.Users.User.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.webdev.tourapp.Shared.Domain.Ids.UserID;
import com.webdev.tourapp.Users.User.Domain.Entities.UserTourInstance;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.*;

public class User
{
    private UserID userID;
    private Username username;
    private UserFirstName userFirstName;
    private UserLastName userLastName;
    private UserPassword userPassword;
    private Optional<List<UserTourInstance>> userInscribedTours;
    //Constructor:
    public User(UserID userID, Username username,
                UserFirstName userFirstName, UserLastName userLastName,
                UserPassword password,
                Optional<List<UserTourInstance>> userInscribedTours)
    {
        this.userID = userID;
        this.username = username;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = password;
        this.userInscribedTours = userInscribedTours;
    }
    public static User Create(UserID userID, Username username,
                              UserFirstName userFirstName, UserLastName userLastName,
                              UserPassword password)
    {


        User myUser = new User (userID , username, userFirstName, userLastName,
                password, Optional.empty());
        //TODO Intermediate events.
        return myUser;
    }
    public HashMap<String, Object> data()
    {
        return new HashMap<String, Object>() {{
            put("userID", userID.value());
            put("username", username.value());
            put("userFirstName", userFirstName.value());
            put("userLastName", userLastName.value());
            put("userPassword", userPassword.value());
        }};
    }
    public void UpdateFirstName(UserFirstName fName)
    {
        this.userFirstName = fName;
    }
    public void UpdateLastName(UserLastName lName)
    {
        this.userLastName = lName;
    }
    public void UpdateUsername(Username uName)
    {
        this.username = uName;
    }
    public void UpdatePassword(UserPassword password)
    {
        this.userPassword = password;
    }



}