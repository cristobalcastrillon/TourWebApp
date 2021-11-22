package com.webdev.tourapp.Cities.Domain.Services;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityNotFound;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.Optional;

public class DomainCityIDFinder {
    private CityRepository repository;

    public DomainCityIDFinder(CityRepository repository) {
        this.repository = repository;
    }

    public City execute(String id) {
        Optional<City> cityOptional=repository.findByID(new CityID(id));

        if(cityOptional.isEmpty()){
            throw new CityNotFound("La ciudad con id "+ id + " no ha sido encontrada");
        }
        return cityOptional.get();
    }
}