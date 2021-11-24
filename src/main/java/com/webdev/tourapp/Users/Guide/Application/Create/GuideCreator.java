package com.webdev.tourapp.Users.Guide.Application.Create;

import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.GuideID;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.GuideAlreadyExists;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.*;


import java.util.Optional;

public class GuideCreator
{
    private GuideRepository myRep;

    public GuideCreator(GuideRepository myRep) {
        this.myRep = myRep;
    }
    public void execute(String id, String status, String fName, String lName, Long phoneNumber,
           Double baseFare , String pword)
    {
        this.validate(id);
        Guide myGuide = Guide.Create(new GuideID(id), new GuideStatus(status), new GuideFirstName(fName)
                , new GuideLastName(lName), new GuidePhoneNumber(phoneNumber),
                new GuideBaseFare(baseFare), new GuidePassword(pword));
        myRep.save(myGuide);
    }
    private void validate(String id)
    {
        Optional<Guide> myGuide = myRep.findByID(new GuideID (id));
        if (myGuide.isPresent())
        {
            throw new GuideAlreadyExists("Dado el ID; el guia ya existe");
        }
    }

}