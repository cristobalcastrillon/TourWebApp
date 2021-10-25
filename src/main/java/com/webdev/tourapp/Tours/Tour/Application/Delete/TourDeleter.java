package com.webdev.tourapp.Tours.Tour.Application.Delete;

import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourIDNotFound;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;

import java.util.Optional;

public class TourDeleter {

    private TourRepository repository;

    public TourDeleter(TourRepository repository){
        this.repository = repository;
    }

    public void execute(String id){
        Optional<Tour> tour = this.validate(id);
        repository.delete(tour.get());
    }

    private Optional<Tour> validate(String tourID){
        Optional<Tour> tour = repository.findByID(new TourID(tourID));
        if(tour.isEmpty()){
            throw new TourIDNotFound("El tour con id " + tourID + ", que desea eliminar, no ha sido encontrado.");
        }
        return tour;
    }
}
