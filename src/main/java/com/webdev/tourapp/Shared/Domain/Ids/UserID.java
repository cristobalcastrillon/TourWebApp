package com.webdev.tourapp.Shared.Domain.Ids;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;
public class UserID extends CustomUUID
{
    public UserID(){}
    public UserID(String userID)
    {
        super(userID);
    }
}