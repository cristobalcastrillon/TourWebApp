package com.webdev.tourapp.Shared.Domain.Ids;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;
public class GuideID extends CustomUUID
{
    public GuideID(){}
    public GuideID(String guideID)
    {
        super(guideID);
    }
}