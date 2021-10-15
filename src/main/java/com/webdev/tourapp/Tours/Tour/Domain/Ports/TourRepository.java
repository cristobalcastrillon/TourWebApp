package com.webdev.tourapp.Tours.Tour.Domain.Ports;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;

import java.util.ArrayList;
import java.util.Optional;

public interface TourRepository {
    void save(Tour tour);
    void update(Tour tour);
    void delete();
    Optional<ArrayList<Tour>> all();
    Optional<Tour> findByID(TourID tourID);
    //TODO: Implement the Use Cases that use the following
    Optional<ArrayList<Tour>> findByTourName(String nameQuery);
    Optional<ArrayList<Tour>> findByListOfLocations(ArrayList<Location> locationList);
    Optional<ArrayList<Tour>> findByBasePrice(Double priceQuery);
}