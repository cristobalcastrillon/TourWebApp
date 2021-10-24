package com.webdev.tourapp.Tours.Tour.Domain.Ports;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;

import java.util.List;
import java.util.Optional;

public interface TourRepository {
    void save(Tour tour);
    void update(Tour tour);
    void delete(Tour tour);
    Optional<List<Tour>> all();
    Optional<Tour> findByID(TourID tourID);
    Optional<List<Tour>> findByBasePriceMaximum(TourPrice priceQuery);
    Optional<List<Tour>> findByTourName(TourName nameQuery);
    Optional<List<Tour>> findByListOfLocations(List<Location> locationList);
}