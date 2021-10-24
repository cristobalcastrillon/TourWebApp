package com.webdev.tourapp.Cities.Application.FindByDefaultIATA;

import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;

import java.util.ArrayList;

public class CityDefaultIATAFinder {

    private CityRepository repository;
    private DomainCityDefaultFinder finderService;

    public CityDefaultIATAFinder(CityRepository repository){
        this.repository = repository;
        this.finderService = new DomainCityDefaultFinder(this.repository);
    }

    public City execute(String defaultiata){
        return finderService.execute(defaultiata);
    }
}
