package com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.IntegerValueObject;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NotValidNumberOfPersons;

public class TourNumberOfPersons extends IntegerValueObject {

    private TourNumberOfPersons(){

    }

    public TourNumberOfPersons(Integer numberOfPersons){
        validate(numberOfPersons);
        super.value = numberOfPersons;
    }

    private void validate(Integer numberOfPersons){
        isNotNegativeValue(numberOfPersons);
    }

    private void isNotNegativeValue(Integer numberOfPersons){
        if(numberOfPersons <= 0)
            throw new NotValidNumberOfPersons("¡La cantidad de personas debe ser positiva!");
    }
}