package com.webdev.tourapp.Cities.Application.All;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import org.apache.el.stream.Optional;

import java.util.ArrayList;

public class CityAll{
    CityRepository repository;

    public CityAll(CityRepository repository){
        this.repository = repository;
    }

    public CityAllResponse execute(){
        Optional<ArrayList<City>> cityListOptional = repository.all();

        if(cityListOptional.isEmpty()){
            throw new NoCitiesFound("No se ha encontrado ninguna ciudad.");
        }

        ArrayList<City> cityList = (ArrayList<City>) cityListOptional.get();

        return new CityAllResponse(cityList);

    }
}
// Completado
// Pendiente para revisar
