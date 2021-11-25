package com.webdev.tourapp.Tours.TourInstance.Application.Update;

import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourUserID;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TourInstanceUserIDListUpdater {
    private TourInstanceRepository repository;

    public TourInstanceUserIDListUpdater(TourInstanceRepository repository){
        this.repository = repository;
    }

    public void execute(String id, TourUserID newUserInTour){
        this.validate(id);
        TourInstance tourInstance = repository.findByID(new TourInstanceID(id)).get();

        List<TourUserID> tourUserIDs = new ArrayList<>();

        if(tourInstance.getTourUsers().isPresent())
            tourUserIDs = tourInstance.getTourUsers().get();

        tourUserIDs.add(newUserInTour);
        tourInstance.setTourUsers(Optional.of(tourUserIDs));
        repository.update(tourInstance);
    }

    private void validate(String id){
        Optional<TourInstance> tourInstanceOptional = repository.findByID(new TourInstanceID(id));
        if(tourInstanceOptional.isEmpty()){
            throw new TourInstanceIDNotFound("La instancia de tour con id " + id + ", que desea modificar, no ha sido encontrada.");
        }
    }
}
