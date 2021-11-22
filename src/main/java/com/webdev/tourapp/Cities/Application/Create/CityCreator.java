package com.webdev.tourapp.Cities.Application.Create;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Entities.LocationsInCity;
import com.webdev.tourapp.Cities.Domain.Entities.ToursInCity;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityAlreadyExists;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;
import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityCreator{

    private CityRepository repository;

    public CityCreator(CityRepository repository){
        this.repository = repository;
    }

    public void execute(String id,
                        String name,
                        String defaultIATA,
                        Optional<List<LocationsInCity>> locationsInCity,
                        Optional<List<ToursInCity>> toursInCity)   {
        this.validate(id);
        City city = City.Create(
                new CityID(id),
                new CityName(name),
                new CityDefaultIATA(defaultIATA),
                locationsInCity,
                toursInCity);
        repository.save(city);
    }

    private void validate(String cityID){
        Optional<City> city = repository.findByID(new CityID(cityID));
        if(city.isPresent()){
            throw new CityAlreadyExists("La ciudad con id "+cityID.toString()+" ya existe.");
        }
    }
}

// Completado
// Pendiente para revisar