package com.webdev.tourapp.Cities.Domain.ValueObjects;

import com.webdev.tourapp.Cities.Domain.Exeptions.IataLenghtNotValid;

public class CityDefaultIATA{

    private CityDefaultIATA(){ }

    public CityDefaultIATA(String iata) throws IataLenghtNotValid {
        validate(iata);
    }

    private void validate(String iata) throws IataLenghtNotValid {
        IataLenghtValidate(iata);
        IataLetterValidate(iata);
    }

    private void IataLenghtValidate(String iata) throws IataLenghtNotValid {

        if(iata.length()!=3){
            throw new IataLenghtNotValid("La longitud del código IATA no es valida.");
        }
    }

    private void IataLetterValidate(String iata){
        // Validacion de letras
        // Pendientes

    }

}