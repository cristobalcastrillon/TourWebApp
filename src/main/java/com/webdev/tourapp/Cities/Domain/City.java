package com.webdev.tourapp.Cities.Domain;

import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;
import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class City
{
    private CityID id;
    private CityName name;
    private CityDefaultIATA iata;
    private Optional<ArrayList<Location>> locationsInCity;
    private Optional<ArrayList<Tour>> tours;

    public City(
                //CityID id,
                CityName name,
                CityDefaultIATA iata,
                Optional<ArrayList<Location>> locationsInCity,
                Optional<ArrayList<Tour>> tours) {
        this.id = id;
        this.name = name;
        this.iata = iata;
        this.locationsInCity = locationsInCity;
        this.tours = tours;
    }

    public static City Create(
            //CityID id,
                              CityName name,
                              CityDefaultIATA iata,
                              ArrayList<Location> locationsInCity,
                              ArrayList<Tour> tours){
        City city = new City(
                //id,
                name,
                iata,
                Optional.ofNullable(locationsInCity),
                Optional.ofNullable(tours));

          // Pasos intermedios

          return city;
    }

    public City FindByCityName(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(name, city.name) && Objects.equals(iata, city.iata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, iata);
    }
}