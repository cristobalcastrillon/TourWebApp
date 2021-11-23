package com.webdev.tourapp.Cities.Application.Update;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Entities.LocationInCity;
import com.webdev.tourapp.Cities.Domain.Entities.TourInCity;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityIDNotFoundException;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;

import java.util.List;
import java.util.Optional;

public class CityUpdater {

    private CityRepository cityRepository;

    public CityUpdater(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void execute(String cityID,
                        String name,
                        String defaultIATA,
                        Optional<List<LocationInCity>> locationsInCity,
                        Optional<List<TourInCity>> toursInCity) {
        this.validate(cityID);
        City city = City.Create(new CityID(cityID)
                , new CityName(name)
                , new CityDefaultIATA(defaultIATA)
                , locationsInCity
                , toursInCity);
        this.cityRepository.update(city);
    }

    private void validate(String cityID) {
        Optional<City> city = cityRepository.findByID(new CityID(cityID));
        if(city.isEmpty()){
            throw new CityIDNotFoundException("City does not exist");
        }

    }
}