package com.webdev.tourapp.Users.Guide.Application.UpdateGuideStatus;

import com.webdev.tourapp.Users.Guide.Domain.Exceptions.GuideDoesNotExist;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.GuideID;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.GuideStatus;

import java.util.Optional;

public class GuideStatusUpdater {
    GuideRepository repository;

    public GuideStatusUpdater(GuideRepository repository) {
        this.repository = repository;
    }

    public void execute(String guideID, String newStatus){
        Optional<Guide> guideOptional = this.repository.findByID(new GuideID(guideID));
        if(guideOptional.isEmpty()){
            throw new GuideDoesNotExist("The guide with id " + guideID + " does not exist.");
        }
        Guide guide = guideOptional.get();
        guide.updateGuideStatus(new GuideStatus(newStatus));
        repository.update(guide);
    }
}
