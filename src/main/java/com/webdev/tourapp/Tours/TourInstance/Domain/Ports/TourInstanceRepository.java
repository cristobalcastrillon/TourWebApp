package com.webdev.tourapp.Tours.TourInstance.Domain.Ports;

import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;

import java.util.ArrayList;
import java.util.Optional;

public interface TourInstanceRepository {
    void save(TourInstance tourInstance);
    void update(TourInstance tourInstance);
    void delete(TourInstance tourInstance);
    Optional<ArrayList<TourInstance>> all();
    Optional<TourInstance> findByID(TourInstanceID id);
    //TODO: Implement the Use Cases that use the following
    Optional<ArrayList<TourInstance>> findByDate(TourDate date);
    Optional<ArrayList<TourInstance>> findByStatus(TourInstanceStatus status);
    Optional<ArrayList<TourInstance>> findByNumberOfPersons(TourNumberOfPersons numberOfPersons);
    Optional<ArrayList<TourInstance>> findByTotalPrice(TourTotalPrice totalPrice);
}