package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Location.Domain.Exceptions.LocationCoordinatesInvalidFormat;
import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationCoordinates extends StringValueObject {
    private LocationCoordinates() {}

    public LocationCoordinates(String coordinates){
        validate(coordinates);
        this.value = coordinates;
    }

    private void validate(String coordinates) {
        // Validar unas coordenadas en formato DMS
        if(!coordinates.matches("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$")){
            throw new LocationCoordinatesInvalidFormat("Invalid coordinates format");
        }
    }
}