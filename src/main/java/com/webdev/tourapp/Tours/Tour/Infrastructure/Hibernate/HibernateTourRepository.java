package com.webdev.tourapp.Tours.Tour.Infrastructure.Hibernate;

import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTourRepository extends HibernateRepository<Tour> implements TourRepository {

    public HibernateTourRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Tour.class);
    }

    @Override
    public void save(Tour tour) {
        persist(tour);
    }

    @Override
    public void update(Tour tour) {
        updateEntity(tour);
    }

    @Override
    public void delete(Tour tour) {
        deleteEntity(tour);
    }

    @Override
    public Optional<List<Tour>> all() {
        return getAll();
    }

    @Override
    public Optional<Tour> findByID(TourID tourID) {
        return byId(tourID);
    }

    @Override
    public Optional<List<Tour>> findByBasePriceMaximum(TourPrice priceQuery) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Tour> cq = cb.createQuery(Tour.class);
        Root<Tour> root = cq.from(Tour.class);
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("tourPrice"), priceQuery.value()));
        List<Tour> tours = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(tours);
    }

    @Override
    public Optional<List<Tour>> findByTourName(TourName nameQuery) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Tour> cq = cb.createQuery(Tour.class);
        Root<Tour> root = cq.from(Tour.class);
        cq.select(root).where(cb.equal(root.get("tourName"), nameQuery.value()));
        List<Tour> tours = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(tours);
    }

    @Override
    public Optional<List<Tour>> findByListOfLocations(Optional<List<Location>> locationList) {
        //TODO
        return Optional.empty();
    }
}
