package com.webdev.tourapp.Tours.Tour.Domain.Ports;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;

import java.util.ArrayList;
import java.util.Optional;

public interface TourRepository {
    void save(Tour tour);
    void update(Tour tour);
    void delete();
    Optional<ArrayList<Tour>> all();
    Optional<Tour> findByID(TourID tourID);

    //TODO: El siguiente método encuentra todos los tours cuyo precio base (TourPrice) es menor o igual al maxBasePrice (tope de precio)
    Optional<ArrayList<Tour>> findByBasePriceMaximum(TourPrice priceQuery);

    Optional<ArrayList<Tour>> findByTourName(TourName nameQuery);
    Optional<ArrayList<Tour>> findByListOfLocations(ArrayList<Location> locationList);
}