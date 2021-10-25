package com.webdev.tourapp.Users.Guide.Application.All;

import com.webdev.tourapp.Users.Guide.Domain.Exceptions.NoGuideFound;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;

import java.util.List;
import java.util.Optional;

public class GuideAll {
    GuideRepository myRep;

    public GuideAll(GuideRepository repository){
        this.myRep = repository;
    }

    public GuideAllResponse execute(){
        Optional<List<Guide>> guideListOpt = myRep.all();

        if(guideListOpt.isEmpty()){
            throw new NoGuideFound("No se encontro ningun usuario registrado");
        }

        List<Guide> guideList = guideListOpt.get();

        return new GuideAllResponse(guideList);
    }
}
