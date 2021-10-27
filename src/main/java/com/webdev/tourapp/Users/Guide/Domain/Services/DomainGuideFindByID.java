package com.webdev.tourapp.Users.Guide.Domain.Services;

import com.webdev.tourapp.Users.Guide.Domain.Exceptions.NoGuideFound;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.GuideID;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;
import java.util.Optional;

public class DomainGuideFindByID {
    GuideRepository myRep;
    public DomainGuideFindByID(GuideRepository myRep)
    {
        this.myRep = myRep;
    }
    public Guide execute (String myID)
    {
        Optional<Guide> guide = myRep.findByID(new GuideID(myID));
        if (guide.isEmpty())
        {
            throw new NoGuideFound("No se ha podido encontrar el guía con ID " + myID);
        }
        return guide.get();
    }
}
