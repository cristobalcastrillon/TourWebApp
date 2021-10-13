package com.webdev.tourapp.Tours.Tour.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NotValidTourPrice;

public class TourPrice extends DoubleValueObject {

    private TourPrice(){

    }

    public TourPrice(Double price){
        validate(price);
        this.value = price;
    }

    private void validate(Double price){
        if(price < 0.0){
            throw new NotValidTourPrice("¡El precio del tour no puede ser negativo!");
        }
    }
}