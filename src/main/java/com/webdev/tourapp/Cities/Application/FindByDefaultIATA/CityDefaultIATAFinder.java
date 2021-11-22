package com.webdev.tourapp.Cities.Application.FindByDefaultIATA;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityDefaultIATANotFound;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.Services.DomainCityDefaultFinder;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDefaultIATAFinder {

    private CityRepository repository;
    private DomainCityDefaultFinder finderService;

    public CityDefaultIATAFinder(CityRepository repository){
        this.repository = repository;
        this.finderService = new DomainCityDefaultFinder(this.repository);
    }

    public CityDefaultIATAFinderResponse execute(String defaultiata){
        Optional<List<City>> optionalListCity = this.repository.findByDefaultIATA(new CityDefaultIATA(defaultiata));
        if(optionalListCity.isEmpty()){
            throw new CityDefaultIATANotFound("La ciudad con IATA "+defaultiata+" no fue encontrada");
        }
        List<City> listCity = optionalListCity.get();

        return new CityDefaultIATAFinderResponse(listCity);
    }

}