package com.webdev.tourapp.Users.User.Application.All;

import com.webdev.tourapp.Users.User.Domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserAllResponse {

    private List<User> users;

    public UserAllResponse(List<User> users){
        this.users = users;
    }

    public List<HashMap<String,Object>> response()
    {
        List<HashMap<String,Object>> response = users.stream().map(
                element -> element.data()).collect(Collectors.toList());
        return response;
    }
}
