package com.webdev.tourapp.Cities.Domain.ValueObjects;

import com.webdev.tourapp.Cities.Domain.Exceptions.*;
import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class CityName extends StringValueObject {

    private CityName(){}

    public CityName(String name)  {
        validate(name);
        this.value=name;
    }

    private void validate(String name)  {
        // Aqui se valida el nombre de la ciudad
        NameNotNumberValidate(name);
    }

    private void NameNotNumberValidate(String name)  {
        if(/*Contiene un numero*/ true){

        }else {
            throw new NumberInNameNoValid("Un numero en el nombre no es valido");
        }
    }
}

//Pendiente de revision de las validaciones