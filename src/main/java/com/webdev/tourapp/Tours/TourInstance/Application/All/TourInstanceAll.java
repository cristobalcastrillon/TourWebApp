package com.webdev.tourapp.Tours.TourInstance.Application.All;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NoTourInstancesFound;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.List;
import java.util.Optional;

public class TourInstanceAll {
    TourInstanceRepository repository;

    public TourInstanceAll(TourInstanceRepository repository){
        this.repository = repository;
    }

    public TourInstanceAllResponse execute(){
        Optional<List<TourInstance>> tourInstanceListOptional = repository.all();

        if(tourInstanceListOptional.isEmpty()){
            throw new NoTourInstancesFound("No se ha encontrado ningún tour.");
        }

        List<TourInstance> tourInstanceList = tourInstanceListOptional.get();

        return new TourInstanceAllResponse(tourInstanceList);
    }
}
