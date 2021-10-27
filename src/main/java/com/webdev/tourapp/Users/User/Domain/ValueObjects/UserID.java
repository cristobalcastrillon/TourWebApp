package com.webdev.tourapp.Users.User.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;
public class UserID extends CustomUUID
{
    public UserID(){}
    public UserID(String userID)
    {
        super(userID);
    }
}