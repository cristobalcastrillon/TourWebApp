package com.webdev.tourapp.Tours.Tour.Application.FindByTourName;

import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Services.DomainTourNameFinder;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.ArrayList;
import java.util.List;

/*
 * Este caso de uso debe retornar una lista de Tours que contengan la expresión (normalizada) pasada por parámetro
 */

public class TourNameFinder {
    private TourRepository repository;
    private DomainTourNameFinder finderService;

    public TourNameFinder(TourRepository repository){
        this.repository = repository;
        this.finderService = new DomainTourNameFinder(this.repository);
    }

    public List<Tour> execute(String name){
        return finderService.execute(name);
    }

}
