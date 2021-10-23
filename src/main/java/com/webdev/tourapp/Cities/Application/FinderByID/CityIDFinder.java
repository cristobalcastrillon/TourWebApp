package com.webdev.tourapp.Cities.Application.FinderByID;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;

import java.util.ArrayList;

public class CityIDFinder {

    private CityRepository repository;
    private DomainCityIDFinder finderService;

    public CityIDFinder(CityRepository repository){
        this.repository = repository;
        this.finderService = new DomainCityIDFinder(this.repository);
    }

    public City execute(String id){
        return finderService.execute(id);
    }

}

// Completado
// Pendiente de revision


