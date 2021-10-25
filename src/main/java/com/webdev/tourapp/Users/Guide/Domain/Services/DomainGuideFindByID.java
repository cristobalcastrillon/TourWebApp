package com.webdev.tourapp.Users.Guide.Domain.Services;

import com.webdev.tourapp.Shared.Domain.Ids.GuideID;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
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
            throw new NoUsersFound("No se ha podido encontrar el guia por ID.");
        }
        return guide.get();
    }
}
