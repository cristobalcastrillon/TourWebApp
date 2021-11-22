package com.webdev.tourapp.Cities.Domain;

import com.webdev.tourapp.Cities.Domain.Entities.LocationsInCity;
import com.webdev.tourapp.Cities.Domain.Entities.ToursInCity;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.*;

public class City
{
    private CityID cityID;
    private CityName cityName;
    private CityDefaultIATA cityDefaultIATA;
    private Optional<List<LocationsInCity>> locationsInCity;
    private Optional<List<ToursInCity>> toursInCity;

    public City(
            CityID id,
            CityName name,
            CityDefaultIATA iata,
            Optional<List<LocationsInCity>> locationsInCity,
            Optional<List<ToursInCity>> toursInCity) {
        this.cityID = id;
        this.cityName = name;
        this.cityDefaultIATA = iata;
        this.locationsInCity = locationsInCity;
        this.toursInCity = toursInCity;
    }

    public static City Create(
            CityID id,
            CityName name,
            CityDefaultIATA iata,
            Optional<List<LocationsInCity>> locationsInCity,
            Optional<List<ToursInCity>> toursInCity){
        City city = new City(
                id,
                name,
                iata,
                locationsInCity,
                toursInCity);

        // Pasos intermedios

        return city;
    }

    /*public City FindByCityName(){
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityID, city.cityID) &&
                Objects.equals(cityName, city.cityName) &&
                Objects.equals(cityDefaultIATA, city.cityDefaultIATA) &&
                Objects.equals(locationsInCity,city.locationsInCity) &&
                Objects.equals(toursInCity,city.toursInCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityID, cityName, cityDefaultIATA);
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>(){
            {
                put("id", cityID.value());
                put("name", cityName.value());
                put("iata", cityDefaultIATA.value());
            }
        };

        data.put("locationsInCity",this.dataLocationsInCity());
        data.put("toursInCity",this.dataToursInCity());
        return data;
    }

    private List<HashMap<String,Object>> dataLocationsInCity() {

        List<HashMap<String,Object>> data = new ArrayList<>();
        for (LocationsInCity location :
                locationsInCity.get()) {
            HashMap<String, Object> locationJSON = new HashMap<>();
            locationJSON.put("location",location.dataDB());
            data.add(locationJSON);
        }
        return data;
    }

    private List<HashMap<String,Object>> dataToursInCity() {

        List<HashMap<String,Object>> data = new ArrayList<>();
        for (ToursInCity tour :
                toursInCity.get()) {
            HashMap<String, Object> tourJSON = new HashMap<>();
            tourJSON.put("tour",tour.dataDB());
            data.add(tourJSON);
        }
        return data;
    }

}