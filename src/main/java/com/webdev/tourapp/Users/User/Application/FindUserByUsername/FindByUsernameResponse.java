package com.webdev.tourapp.Users.User.Application.FindUserByUsername;

import com.webdev.tourapp.Users.User.Domain.User;

import java.util.HashMap;

public class FindByUsernameResponse
{

    private User user;

    public FindByUsernameResponse(User user) {
        this.user = user;
    }
    public HashMap response()
    {
        HashMap data = user.data();
        //TODO Remove anything?
        return data;
    }
}
