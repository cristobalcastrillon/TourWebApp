package com.webdev.tourapp.Cities.Domain;

import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.Objects;

public class City
{
    private CityID id;
    private CityName name;
    private CityDefaultIATA iata;


    public City(CityID id, CityName name, CityDefaultIATA iata) {
        this.id = id;
        this.name = name;
        this.iata = iata;


    }
    public static City Create(CityID id, CityName name, CityDefaultIATA iata){
        City city = new City(id, name, iata);

          // Pasos intermedios

          return city;
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