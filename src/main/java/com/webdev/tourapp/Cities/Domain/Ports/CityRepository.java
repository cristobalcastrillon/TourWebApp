package com.webdev.tourapp.Cities.Domain.Ports;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CityRepository{
    void save(City city);
    void update(City city);
    void delete(City city);

    Optional<City> findByID(CityID id);
    Optional<List<City>> findByName(CityName name);
    Optional<List<City>> findByDefaultIATA(CityDefaultIATA defaultIATA);
    Optional<List<City>> all();

    //org.apache.el.stream.Optional all();
}