package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationPrice extends DoubleValueObject {
    private LocationPrice() {  }
    public  LocationPrice(double price){
        validate(price);
        this.value = price;
    }

    private void validate(double price) {
    }
}