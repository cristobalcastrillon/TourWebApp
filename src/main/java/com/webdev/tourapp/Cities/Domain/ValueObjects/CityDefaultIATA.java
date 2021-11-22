package com.webdev.tourapp.Cities.Domain.ValueObjects;

import com.webdev.tourapp.Cities.Domain.Exceptions.*;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class CityDefaultIATA extends StringValueObject {

    private CityDefaultIATA(){ }

    public CityDefaultIATA(String iata)  {
        validate(iata);
        this.value=iata;
    }

    private void validate(String iata)  {
        IataLenghtValidate(iata);
        IataLetterValidate(iata);
    }

    private void IataLenghtValidate(String iata)  {

        if(iata.length()!=3){
            throw new IataLenghtNotValid("La longitud del código IATA no es valida.");
        }
    }

    private void IataLetterValidate(String iata){
        // Validacion de letras
        // Pendientes

    }
}