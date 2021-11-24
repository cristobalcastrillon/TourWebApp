package com.webdev.tourapp.Users.Guide.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.NotValidGuideStatus;

import java.util.Arrays;
import java.util.List;

public class GuideStatus extends StringValueObject {
    private GuideStatus (){

    }

    public GuideStatus(String status){
        validate(status);
    }

    private void validate(String status) {
        List<String> states = Arrays.asList("free","taken");
        if (!states.contains(status)) {
            throw new NotValidGuideStatus("Guide status not valid.");
        }
    }
}
