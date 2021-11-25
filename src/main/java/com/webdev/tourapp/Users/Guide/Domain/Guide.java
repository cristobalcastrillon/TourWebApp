package com.webdev.tourapp.Users.Guide.Domain;

import com.webdev.tourapp.Shared.Domain.Aggregate.AggregateRoot;
import com.webdev.tourapp.Shared.Domain.DomainEvents.TourInstanceTakenByGuideDomainEvent;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.GuideID;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.*;

import java.util.HashMap;

public class Guide extends AggregateRoot
{
    private GuideID guideID;
    private GuideStatus guideStatus;
    private GuideFirstName guideFirstName;
    private GuideLastName guideLastName;
    private GuidePhoneNumber guidePhoneNumber;
    private GuideBaseFare guideBaseFare;
    private GuidePassword guidePassword;

    public Guide(){}

    public Guide(GuideID id, GuideStatus guideStatus, GuideFirstName firstName, GuideLastName lastName,
                 GuidePhoneNumber phoneNumber, GuideBaseFare baseFare, GuidePassword guidePassword) {
        this.guideID = id;
        this.guideStatus = guideStatus;
        this.guideFirstName = firstName;
        this.guideLastName = lastName;
        this.guidePhoneNumber = phoneNumber;
        this.guideBaseFare = baseFare;
        this.guidePassword = guidePassword;
    }
    public static Guide Create(GuideID id, GuideStatus status, GuideFirstName firstName, GuideLastName lastName,
                               GuidePhoneNumber phoneNumber, GuideBaseFare baseFare, GuidePassword guidePassword)
    {
        Guide myGuide = new Guide(id, status, firstName, lastName, phoneNumber, baseFare, guidePassword);
        //TODO Events
        return myGuide;
    }
    public HashMap<String, Object> data()
    {
        return new HashMap<String, Object>() {{
            put("guideID", guideID.value());
            put("guideStatus", guideStatus.value());
            put("guideFirstName", guideFirstName.value());
            put("guideLastName", guideLastName.value());
            put("guidePhoneNumber", guidePhoneNumber.value());
            put("guideBaseFare", guideBaseFare.value());
            put("guidePassword", guidePassword.value());
        }};
    }

    public void setGuideStatusToTaken(String tourInstanceID) {
        this.guideStatus = new GuideStatus("taken");
        this.record(new TourInstanceTakenByGuideDomainEvent(this.guideID.value(), tourInstanceID));
    }
}