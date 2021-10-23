package com.webdev.tourapp.Cities.Domain.Ports;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;

import java.util.ArrayList;
import java.util.Optional;

public interface CityRepository{
    void save(City city);
    Optional<City> find(CityID id);
    /*
    void update(City city);
    Optional<ArrayList<City>> all();
    void delete(City city);
    // Aqui falta algo pero no C
    */
}