package com.webdev.tourapp.Cities.Domain.Services;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityDefaultIATANotFound;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;

import java.util.List;
import java.util.Optional;

public class DomainCityDefaultFinder {
    private CityRepository repository;

    public DomainCityDefaultFinder(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> execute(String defaultIATA){
        Optional<List<City>> cityListOptional = repository.findByDefaultIATA(new CityDefaultIATA(defaultIATA));

        if(cityListOptional.isEmpty()){
            throw new CityDefaultIATANotFound("La ciudad con codigo "+defaultIATA+" no fue encontrada");
        }
        return cityListOptional.get();
    }
}