package com.webdev.tourapp.Users.User.Application.FindUserByID;

import com.webdev.tourapp.Users.User.Domain.User;

import java.util.HashMap;

public class FindByIDResponse
{

    private User user;

    public FindByIDResponse(User user) {
        this.user = user;
    }
    public HashMap response()
    {
        HashMap data = user.data();
        //TODO Remove anything?
        return data;
    }
}
