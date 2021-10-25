package com.webdev.tourapp.Users.Guide.Application.FindGuideByID;

import com.webdev.tourapp.Users.Guide.Domain.Guide;

import java.util.HashMap;

public class FindGuideByIDResponse
{

    private Guide guide;

    public FindGuideByIDResponse(Guide guide) {
        this.guide = guide;
    }
    public HashMap response()
    {
        HashMap data = guide.data();
        //TODO Remove anything?
        return data;
    }
}
