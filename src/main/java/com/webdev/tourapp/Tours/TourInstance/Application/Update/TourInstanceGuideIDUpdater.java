package com.webdev.tourapp.Tours.TourInstance.Application.Update;

import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourGuide;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;

import java.util.Optional;

public class TourInstanceGuideIDUpdater {

    private TourInstanceRepository repository;

    public TourInstanceGuideIDUpdater(TourInstanceRepository repository) {
        this.repository = repository;
    }

    public void execute(String tourInstanceID, TourGuide guideID){
        this.validate(tourInstanceID);
        TourInstance tourInstance = repository.findByID(new TourInstanceID(tourInstanceID)).get();
        tourInstance.setTourGuideID(Optional.of(guideID));
        repository.update(tourInstance);
    }

    private void validate(String id) {
        Optional<TourInstance> tourInstanceOptional = repository.findByID(new TourInstanceID(id));
        if(tourInstanceOptional.isEmpty()){
            throw new TourInstanceIDNotFound("La instancia de tour con id " + id + ", que desea modificar, no ha sido encontrada.");
        }
    }
}
