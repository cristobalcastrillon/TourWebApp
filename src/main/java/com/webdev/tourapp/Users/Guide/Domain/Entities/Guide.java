package com.webdev.tourapp.Users.Guide.Domain.Entities;

import com.webdev.tourapp.Shared.Domain.Ids.GuideID;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.*;

import java.util.HashMap;

public class Guide
{
    private GuideID id;
    private GuideFirstName firstName;
    private GuideLastName lastName;
    private GuidePhoneNumber phoneNumber;
    private GuideBaseFare baseFare;

    public Guide(GuideID id, GuideFirstName firstName, GuideLastName lastName,
                 GuidePhoneNumber phoneNumber, GuideBaseFare baseFare) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.baseFare = baseFare;
    }
    public static Guide Create(GuideID id, GuideFirstName firstName, GuideLastName lastName,
                               GuidePhoneNumber phoneNumber, GuideBaseFare baseFare)
    {
        Guide myGuide = new Guide(id, firstName, lastName, phoneNumber, baseFare);
        //TODO Events
        return myGuide;
    }
    public HashMap<String, Object> data()
    {
        return new HashMap<>(){{
            put ("id", id.value());
            put ("firstName", firstName.value());
            put ("lastName", lastName.value());
            put ("phone_number", phoneNumber.value());
            put ("base_fare", baseFare.value());

        }};
    }
}