package com.webdev.tourapp.Shared.Domain.DomainEvents;

import com.webdev.tourapp.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class TourInstanceTakenByGuideDomainEvent extends DomainEvent {

    private final String tourInstanceID;

    public TourInstanceTakenByGuideDomainEvent(String aggregateId, String tourInstanceID) {
        super(aggregateId);
        this.tourInstanceID = tourInstanceID;
    }

    public TourInstanceTakenByGuideDomainEvent(String aggregateId, String eventId, String occurredOn, String tourInstanceID) {
        super(aggregateId, eventId, occurredOn);
        this.tourInstanceID = tourInstanceID;
    }

    public TourInstanceTakenByGuideDomainEvent(String tourInstanceID) {
        super(null);
        this.tourInstanceID = tourInstanceID;
    }

    public String getTourInstanceID() {
        return tourInstanceID;
    }

    @Override
    public String eventName() {
        return "tourInstance.taken";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("tourInstanceID", tourInstanceID);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TourInstanceTakenByGuideDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("tourInstanceID"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourInstanceTakenByGuideDomainEvent that = (TourInstanceTakenByGuideDomainEvent) o;
        return Objects.equals(tourInstanceID, that.tourInstanceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourInstanceID);
    }
}
