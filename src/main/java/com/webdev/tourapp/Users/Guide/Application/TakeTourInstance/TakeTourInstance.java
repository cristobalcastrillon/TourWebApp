package com.webdev.tourapp.Users.Guide.Application.TakeTourInstance;

import com.webdev.tourapp.Shared.Domain.Bus.Event.EventBus;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.GuideDoesNotExist;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.GuideID;

import java.util.Optional;

public class TakeTourInstance {

    private GuideRepository repository;
    private EventBus eventBus;

    public TakeTourInstance(GuideRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String guideID, String tourInstanceID){
        Optional<Guide> guideOptional = this.repository.findByID(new GuideID(guideID));
        if(guideOptional.isEmpty()){
            throw new GuideDoesNotExist("Guide with id " + guideID + " could not be found.");
        }
        Guide guide = guideOptional.get();
        guide.setGuideStatusToTaken(tourInstanceID);
        this.repository.update(guide);
        this.eventBus.publish(guide.pullDomainEvents());
    }
}
