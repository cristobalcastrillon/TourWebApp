package com.webdev.tourapp.Cities.Application.All;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Exceptions.NoCitiesFound;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;

import java.util.List;
import java.util.Optional;

public class CityAll{
    CityRepository repository;

    public CityAll(CityRepository repository){
        this.repository = repository;
    }

    public CityAllResponse execute(){
        Optional<List<City>> cityListOptional = repository.all();

        if(cityListOptional.isEmpty()){
            throw new NoCitiesFound("No se ha encontrado ninguna ciudad.");
        }

        List<City> cityList =  cityListOptional.get();

        return new CityAllResponse(cityList);

    }

}
// Completado
// Pendiente para revisar