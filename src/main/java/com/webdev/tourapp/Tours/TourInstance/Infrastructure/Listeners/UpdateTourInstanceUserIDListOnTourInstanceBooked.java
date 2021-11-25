package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Listeners;

import com.webdev.tourapp.Shared.Domain.Bus.Event.Spring.DomainEventSubscriber;
import com.webdev.tourapp.Shared.Domain.DomainEvents.TourInstanceBookedDomainEvent;
import com.webdev.tourapp.Tours.TourInstance.Application.Update.TourInstanceUserIDListUpdater;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourUserID;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({TourInstanceBookedDomainEvent.class})
public final class UpdateTourInstanceUserIDListOnTourInstanceBooked {

    private TourInstanceUserIDListUpdater tourInstanceUserIDListUpdater;

    public UpdateTourInstanceUserIDListOnTourInstanceBooked(TourInstanceUserIDListUpdater tourInstanceUserIDListUpdater) {
        this.tourInstanceUserIDListUpdater = tourInstanceUserIDListUpdater;
    }

    @EventListener
    public void on(TourInstanceBookedDomainEvent event){
        this.tourInstanceUserIDListUpdater.execute(event.getTourInstanceID(), new TourUserID(event.aggregateId()));
    }
}
