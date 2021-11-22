package com.webdev.tourapp.Cities.Domain.Services;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityNameNotFound;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.List;
import java.util.Optional;

public class DomainCityNameFinder {
    private CityRepository repository;

    public DomainCityNameFinder(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> execute(String name) {

        Optional<List<City>> cityListOptional = repository.findByName(new CityName(name));

        if(cityListOptional.isEmpty()) {
            throw new CityNameNotFound("City not found by name");
        }
        return cityListOptional.get();
    }
}