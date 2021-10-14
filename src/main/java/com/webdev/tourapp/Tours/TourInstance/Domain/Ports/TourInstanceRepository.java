package com.webdev.tourapp.Tours.TourInstance.Domain.Ports;

import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;

import java.util.List;
import java.util.Optional;

public interface TourInstanceRepository {
    void save(TourInstance tourInstance);
    void update(TourInstance tourInstance);
    void delete(TourInstance tourInstance);
    Optional<List<TourInstance>> all();
    Optional<TourInstance> findByID(TourInstanceID id);
    //TODO: Implement the Use Cases that use the following
    //TODO: Implement findByDate()
    Optional<List<TourInstance>> findByDate();
    Optional<List<TourInstance>> findByStatus(String status);
    Optional<List<TourInstance>> findByNumberOfPersons(Integer numberOfPersons);
    Optional<List<TourInstance>> findByTotalPrice(Double totalPrice);
}