package com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NotValidTourPrice;

public class TourTotalPrice extends DoubleValueObject {
    // This Value Object represents the total price a customer will pay through the platform
    // taxes and other fares not included in the (TourPrice) subtotal considered
    private TourTotalPrice(){

    }

    public TourTotalPrice(Double price){
        validate(price);
        this.value = price;
    }

    private void validate(Double price){
        isNotNegativeValue(price);
    }

    private void isNotNegativeValue(Double price){
        if(price < 0.0)
            throw new NotValidTourPrice("¡El precio del tour no puede ser negativo!");
    }
}