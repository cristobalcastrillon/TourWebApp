package com.webdev.tourapp.Users.Guide.Application.FindGuideByID;

import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;
import com.webdev.tourapp.Users.Guide.Domain.Services.DomainGuideFindByID;

public class FindGuideByID
{
    private GuideRepository myRep;
    private DomainGuideFindByID finderService;

    public FindGuideByID(GuideRepository myRep) {
        this.myRep = myRep;
        finderService = new DomainGuideFindByID(this.myRep);
    }
    public Guide execute(String id)
    {
        return finderService.execute(id);
    }
}
