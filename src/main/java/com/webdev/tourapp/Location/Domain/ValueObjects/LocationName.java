package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Location.Domain.Exceptions.LocationNameNotValid;
import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationName extends StringValueObject {

    private LocationName(){}

    public LocationName(String name){
        this.validate(name);
        this.value = name;
    }

    private void validate(String name) {
        if(/* Aqui va la validacion del nombre de un location*/"cumple".equals("cumple")){

        }else{
            throw new LocationNameNotValid("El nombre para la location no es correcto.");
        }
    }
    /*
    .
    .
    .
    Demas validaciones
    */
}

//Completado el VO
//Pendiente de revision