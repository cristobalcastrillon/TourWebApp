package com.webdev.tourapp.Tours.Tour.Application.FindByTourName;

import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NoToursFoundForSpecifiedTourName;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Services.DomainTourNameFinder;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Este caso de uso debe retornar una lista de Tours que contengan la expresión (normalizada) pasada por parámetro
 */
//TODO: Normalización de la cadena de texto, antes de hacer la búsqueda.

public class TourNameFinder {
    private TourRepository repository;
    private DomainTourNameFinder finderService;

    public TourNameFinder(TourRepository repository){
        this.repository = repository;
        this.finderService = new DomainTourNameFinder(this.repository);
    }

    public TourNameFinderResponse execute(String name){
        Optional<List<Tour>> tourListOptional = repository.findByTourName(new TourName(name));

        if(tourListOptional.isEmpty()){
            throw new NoToursFoundForSpecifiedTourName("No existe ningún tour con el nombre especificado.");
        }

        List<Tour> tourList = tourListOptional.get();

        return new TourNameFinderResponse(tourList);
    }

}
