package com.webdev.tourapp.Tours.TourInstance.Application.Delete;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;

import java.util.Optional;

public class TourInstanceDeleter {

    private TourInstanceRepository repository;

    public TourInstanceDeleter(TourInstanceRepository repository){
        this.repository = repository;
    }

    public void execute(String id){
        Optional<TourInstance> tourInstance = this.validate(id);
        repository.delete(tourInstance.get());
    }

    private Optional<TourInstance> validate(String tourInstanceID){
        Optional<TourInstance> tourInstance = repository.findByID(new TourInstanceID(tourInstanceID));
        if(tourInstance.isEmpty()){
            throw new TourInstanceIDNotFound("La instancia de tour con id " + tourInstanceID + ", que desea eliminar, no ha sido encontrada.");
        }
        return tourInstance;
    }
}
