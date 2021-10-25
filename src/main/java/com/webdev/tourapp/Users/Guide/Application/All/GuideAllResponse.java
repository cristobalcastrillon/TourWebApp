package com.webdev.tourapp.Users.Guide.Application.All;

import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.User.Domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GuideAllResponse {

    private List<Guide> guide;

    public GuideAllResponse(List<Guide> guide){
        this.guide = guide;
    }

    public List<HashMap<String,Object>> response()
    {
        List<HashMap<String,Object>> response = guide.stream().map(
                element -> element.data()).collect(Collectors.toList());
        return response;
    }
}
