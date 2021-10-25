package com.webdev.tourapp.Shared.Domain.Ids;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;
public class GuideID extends CustomUUID
{
    private GuideID(){}
    public GuideID(String guideID)
    {
        super(guideID);
    }
}