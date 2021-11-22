package com.webdev.tourapp.Cities.Application.FindByCityName;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityNameNotFound;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.Services.DomainCityNameFinder;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.List;
import java.util.Optional;

public class CityNameFinder {

    private CityRepository repository;
    private DomainCityNameFinder finderService;

    public CityNameFinder(CityRepository repository){
        this.repository = repository;
        this.finderService = new DomainCityNameFinder(this.repository);
    }

    public CityNameFinderResponse execute(String name){
        Optional<List<City>> optionalListCity = this.repository.findByName(new CityName(name));

        if(optionalListCity.isEmpty()){
            throw new CityNameNotFound("No existe ninguna ciudad con el nombre especificado");
        }

        List<City> cityList = optionalListCity.get();

        return new CityNameFinderResponse(cityList);
    }

}

// Completado
// Pendiente de revision