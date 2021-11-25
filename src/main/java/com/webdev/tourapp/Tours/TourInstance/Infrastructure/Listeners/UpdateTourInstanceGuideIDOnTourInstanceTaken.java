package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Listeners;

import com.webdev.tourapp.Shared.Domain.Bus.Event.Spring.DomainEventSubscriber;
import com.webdev.tourapp.Shared.Domain.DomainEvents.TourInstanceTakenByGuideDomainEvent;
import com.webdev.tourapp.Tours.TourInstance.Application.Update.TourInstanceGuideIDUpdater;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourGuide;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({TourInstanceTakenByGuideDomainEvent.class})
public class UpdateTourInstanceGuideIDOnTourInstanceTaken {

    private TourInstanceGuideIDUpdater updater;

    public UpdateTourInstanceGuideIDOnTourInstanceTaken(TourInstanceGuideIDUpdater updater) {
        this.updater = updater;
    }

    @EventListener
    public void on(TourInstanceTakenByGuideDomainEvent event){
        this.updater.execute(event.getTourInstanceID(), new TourGuide(event.aggregateId()));
    }
}
