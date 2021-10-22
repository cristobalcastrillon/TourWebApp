package com.webdev.tourapp.Cities.Domain.ValueObjects;

import com.webdev.tourapp.Cities.Domain.Exeptions.NumberInNameNoValid;

public class CityName {
    private CityName(){};
    public CityName(String name) throws NumberInNameNoValid {
        validate(name);
    }

    private void validate(String name) throws NumberInNameNoValid {
        // Aqui se valida el nombre de la ciudad
        NameNotNumberValidate(name);
    }

    private void NameNotNumberValidate(String name) throws NumberInNameNoValid {
        throw new NumberInNameNoValid("Un numero en el nombre no es valido");
    }

}

// Completado
//Pendiente de revision