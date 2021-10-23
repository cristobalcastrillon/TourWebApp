package com.webdev.tourapp.Cities.Domain.ValueObjects;

import com.webdev.tourapp.Cities.Domain.Exeptions.IdNotValid;
import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class CityID extends StringValueObject {
    private CityID() {}
    public CityID(String id)  {
        validate(id);
        this.value = id;
    }

    private void validate(String id)  {
        // Validaciones de ID de ciudad
        IdValidate(id);
    }

    private void IdValidate(String id)  {
        if(!id.equals(/* Pendiente revisar cual es la estructura de un ID*/"")){

        }else{
            throw new IdNotValid("El ID no es valido.");
        }
    }
}

// Pendiente consensuar como van a ser los ID para las ciudades