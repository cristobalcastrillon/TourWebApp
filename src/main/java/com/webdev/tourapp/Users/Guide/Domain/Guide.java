package com.webdev.tourapp.Users.Guide.Domain;

import com.webdev.tourapp.Shared.Domain.Ids.GuideID;
import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.*;

import java.util.HashMap;

public class Guide
{
    private GuideID guideID;
    private GuideFirstName guideFirstName;
    private GuideLastName guideLastName;
    private GuidePhoneNumber guidePhoneNumber;
    private GuideBaseFare guideBaseFare;
    private GuidePassword guidePassword;

    public Guide(){}

    public Guide(GuideID id, GuideFirstName firstName, GuideLastName lastName,
                 GuidePhoneNumber phoneNumber, GuideBaseFare baseFare, GuidePassword guidePassword) {
        this.guideID = id;
        this.guideFirstName = firstName;
        this.guideLastName = lastName;
        this.guidePhoneNumber = phoneNumber;
        this.guideBaseFare = baseFare;
        this.guidePassword = guidePassword;
    }
    public static Guide Create(GuideID id, GuideFirstName firstName, GuideLastName lastName,
                               GuidePhoneNumber phoneNumber, GuideBaseFare baseFare, GuidePassword guidePassword)
    {
        Guide myGuide = new Guide(id, firstName, lastName, phoneNumber, baseFare, guidePassword);
        //TODO Events
        return myGuide;
    }
    public HashMap<String, Object> data()
    {
        return new HashMap<String, Object>() {{
            put("guideID", guideID.value());
            put("guideFirstName", guideFirstName.value());
            put("guideLastName", guideLastName.value());
            put("guidePhoneNumber", guidePhoneNumber.value());
            put("guideBaseFare", guideBaseFare.value());
            put("guidePassword", guidePassword.value());
        }};
    }

}