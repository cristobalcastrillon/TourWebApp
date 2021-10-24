package com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NotValidState;

import java.util.Arrays;
import java.util.List;

public class TourInstanceStatus extends StringValueObject {

    public TourInstanceStatus(){}

    public TourInstanceStatus(String status){
        validate(status);
        this.value = status;
    }

    private void validate(String status){
        validState(status);
    }

    private void validState(String status){
        List<String> validStates = Arrays.asList("finalizado", "incompleto");
        if (!validStates.contains(status)) {
            throw new NotValidState("El estado del viaje no se encuentra entre los permitidos");
        }
    }
}
