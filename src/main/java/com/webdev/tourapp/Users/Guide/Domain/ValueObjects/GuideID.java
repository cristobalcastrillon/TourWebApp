package com.webdev.tourapp.Users.Guide.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;
public class GuideID extends CustomUUID
{
    public GuideID(){}
    public GuideID(String guideID)
    {
        super(guideID);
    }
}