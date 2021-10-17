package com.webdev.tourapp.Tours.TourInstance.Domain.Ports;

import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public interface TourInstanceRepository {
    void save(TourInstance tourInstance);
    void update(TourInstance tourInstance);
    void delete(TourInstance tourInstance);
    Optional<List<TourInstance>> all();
    Optional<TourInstance> findByID(TourInstanceID id);
    //TODO: Implement the Use Cases that use the following
    Optional<List<TourInstance>> findByDate(TourDate date);
    Optional<List<TourInstance>> findByStatus(TourInstanceStatus status);
    Optional<List<TourInstance>> findByNumberOfPersons(TourNumberOfPersons numberOfPersons);
    Optional<List<TourInstance>> findByTotalPrice(TourTotalPrice totalPrice);
}