package com.webdev.tourapp.Cities.Domain.Ports;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Entities.LocationInCity;
import com.webdev.tourapp.Cities.Domain.Entities.TourInCity;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.List;
import java.util.Optional;

public interface CityRepository{
    void save(City city);
    void update(City city);
    void delete(City city);

    Optional<City> findByID(CityID id);
    Optional<List<City>> findByName(CityName name);
    Optional<List<City>> findByDefaultIATA(CityDefaultIATA defaultIATA);
    Optional<List<City>> findByListOfLocations(Optional<List<LocationInCity>> locationsInCity);
    Optional<List<City>> findByListOfTours(Optional<List<TourInCity>> toursInCity);
    Optional<List<City>> all();
}