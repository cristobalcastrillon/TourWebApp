package com.webdev.tourapp.Cities.Application.FinderByID;

import com.webdev.tourapp.Cities.Domain.City;

import com.webdev.tourapp.Cities.Domain.Exceptions.CityIDNotFoundException;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.Services.DomainCityIDFinder;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;

import java.util.ArrayList;
import java.util.Optional;

public class CityIDFinder {

    private CityRepository repository;
    private DomainCityIDFinder finderService;

    public CityIDFinder(CityRepository repository){
        this.repository = repository;
        this.finderService = new DomainCityIDFinder(this.repository);
    }

    public CityIDFinderResponse execute(String id){
        Optional<City> cityOptional = repository.findByID(new CityID(id));

        if(cityOptional.isEmpty()){
            throw new CityIDNotFoundException("No se ha encontrado ninguna ciudad con el id "+id);
        }
        City city = cityOptional.get();
        return new CityIDFinderResponse(city);
    }
}

// Completado
// Pendiente de revision