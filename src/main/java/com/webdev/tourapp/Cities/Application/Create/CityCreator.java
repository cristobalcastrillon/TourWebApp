package com.webdev.tourapp.Cities.Application.Create;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;

public class CityCreator{

    private CityRepository repository;

    public CityCreator(CityRepository repository){
        this.repository = repository;
    }

    public void execute(String id,
                        String name,
                        String defaultIATA,
                        ArrayList<Location> locationsInCity,
                        ArrayList<Tour> tours){
        this.validate(id);
        City city = City.Create(new CityID(id), new CityName(name), new CityDefaulIATA(defaultIATA), locationsInCity, tours);
        repository.save(city);
    }

    private void validate(String cityID){
        Optional<City> city = repository.findByID(new CityID(CityID));
        if(city.isPresent()){
            throw new CityAlreadyExists("La ciudad con id "+cityID.toString()+" ya existe.");
        }
    }
}

// Completado
// Pendiente para revisar