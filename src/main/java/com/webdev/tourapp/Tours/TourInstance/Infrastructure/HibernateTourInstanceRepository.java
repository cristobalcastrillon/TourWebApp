package com.webdev.tourapp.Tours.TourInstance.Infrastructure;

import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Optional;

public class HibernateTourInstanceRepository extends HibernateRepository<TourInstance> implements TourInstanceRepository {

    public HibernateTourInstanceRepository(SessionFactory sessionFactory, Class<TourInstance> aggregateClass) {
        super(sessionFactory, aggregateClass);
    }

    @Override
    public void save(TourInstance tourInstance) {

    }

    @Override
    public void update(TourInstance tourInstance) {

    }

    @Override
    public void delete(TourInstance tourInstance) {

    }

    @Override
    public Optional<ArrayList<TourInstance>> all() {
        return Optional.empty();
    }

    @Override
    public Optional<TourInstance> findByID(TourInstanceID id) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<TourInstance>> findByDate(TourDate date) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<TourInstance>> findByStatus(TourInstanceStatus status) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<TourInstance>> findByNumberOfPersons(TourNumberOfPersons numberOfPersons) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<TourInstance>> findByTotalPrice(TourTotalPrice totalPrice) {
        return Optional.empty();
    }
}
