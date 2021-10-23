package com.webdev.tourapp.Cities.Application.FindByCityName;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;

import java.util.ArrayList;

public class CityNameFinder {

    private CityRepository repository;
    private DomainCityNameFinder finderService;

    public CityNameFinder(CityRepository repository){
        this.repository = repository;
        this.finderService = new DomainCityNameFinder(this.repository);
    }

    public City execute(String name){
        return finderService.execute(name);
    }

}

// Completado
// Pendiente de revision
