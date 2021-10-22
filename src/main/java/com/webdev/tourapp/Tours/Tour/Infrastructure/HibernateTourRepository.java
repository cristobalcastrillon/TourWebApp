package com.webdev.tourapp.Tours.Tour.Infrastructure;

import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Optional;

public class HibernateTourRepository extends HibernateRepository<Tour> implements TourRepository {

    public HibernateTourRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Tour.class);
    }

    @Override
    public void save(Tour tour) {

    }

    @Override
    public void update(Tour tour) {

    }

    @Override
    public void delete() {

    }

    @Override
    public Optional<ArrayList<Tour>> all() {
        return Optional.empty();
    }

    @Override
    public Optional<Tour> findByID(TourID tourID) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<Tour>> findByBasePriceMaximum(TourPrice priceQuery) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<Tour>> findByTourName(TourName nameQuery) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<Tour>> findByListOfLocations(ArrayList<Location> locationList) {
        return Optional.empty();
    }
}
