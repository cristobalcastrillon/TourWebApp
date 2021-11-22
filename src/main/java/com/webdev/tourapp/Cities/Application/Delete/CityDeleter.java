package com.webdev.tourapp.Cities.Application.Delete;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityIDNotFoundException;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;

import java.util.Optional;

public class CityDeleter {
    private CityRepository cityRepository;

    public CityDeleter(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void deleter(String cityID) {
        Optional<City> city = this.validate(cityID);
        cityRepository.delete(city.get());
    }

    private Optional<City> validate(String cityID) {
        Optional<City> city = this.cityRepository.findByID(new CityID(cityID));
        if (!city.isPresent()) {
            throw new CityIDNotFoundException("City not found");
        }
        return city;
    }
}