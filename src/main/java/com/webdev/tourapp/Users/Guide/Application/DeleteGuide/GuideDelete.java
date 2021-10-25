package com.webdev.tourapp.Users.Guide.Application.DeleteGuide;

import com.webdev.tourapp.Shared.Domain.Ids.GuideID;
import com.webdev.tourapp.Shared.Domain.Ids.UserID;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.NoGuideFound;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.User;

import java.util.Optional;

public class GuideDelete {
    GuideRepository myRep;

    public GuideDelete(GuideRepository repository){
        this.myRep = repository;
    }

    public void execute(String guideID){
        Optional<Guide> guideOpt = this.myRep.findByID(new GuideID(guideID));
        if (guideOpt.isEmpty())
        {
            throw new NoGuideFound("El guia con id " + guideID + " no fue encontrado" +
                    " para borrar");
        }
        Guide guide = guideOpt.get();
        myRep.delete(guide);

    }
}
