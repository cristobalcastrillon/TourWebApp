package com.webdev.tourapp.Location.Infrastructure.Hibernate;

import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.*;
import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateLocationRepository extends HibernateRepository<Location> implements LocationRepository {
    public HibernateLocationRepository(@Qualifier("session-factory")SessionFactory sessionFactory) {
        super(sessionFactory, Location.class);
    }

    @Override
    public void save(Location location) {
        persist(location);
    }

    @Override
    public void update(Location location) {
        updateEntity(location);
    }

    @Override
    public void delete(Location location) {
        deleteEntity(location);
    }

    @Override
    public Optional<Location> findById(LocationID id) {
        return byId(id);
    }

    @Override
    public Optional<List<Location>> all(){
        return getAll();
    }

    @Override
    public Optional<List<Location>> findByName(LocationName nameQuery) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
        Root<Location> root = criteria.from(Location.class);
        criteria.select(root).where(builder.like(root.get("locationName"), nameQuery.value()));

        List<Location> locationList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return Optional.ofNullable(locationList);
    }

    @Override
    public Optional<List<Location>> findByWebsiteURL(LocationWebsiteURL websiteURLQuery) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
        Root<Location> root = criteria.from(Location.class);
        criteria.select(root).where(builder.equal(root.get("websiteURL"), websiteURLQuery.value()));

        List<Location> locationList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return Optional.ofNullable(locationList);
    }

    @Override
    public Optional<List<Location>> findByCoordinates(LocationCoordinates coordinatesQuery) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
        Root<Location> root = criteria.from(Location.class);
        criteria.select(root).where(builder.equal(root.get("coordinates"), coordinatesQuery.value()));

        List<Location> locationList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return Optional.ofNullable(locationList);
    }

    @Override
    public Optional<List<Location>> findByDescription(LocationDescription descriptionQuery) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
        Root<Location> root = criteria.from(Location.class);
        criteria.select(root).where(builder.equal(root.get("description"), descriptionQuery.value()));

        List<Location> locationList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return Optional.ofNullable(locationList);
    }

    @Override
    public Optional<List<Location>> findByCategory(LocationCategory categoryQuery) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
        Root<Location> root = criteria.from(Location.class);
        criteria.select(root).where(builder.equal(root.get("category"), categoryQuery.value()));

        List<Location> locationList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return Optional.ofNullable(locationList);
    }

    @Override
    public Optional<List<Location>> findByPrice(LocationPrice priceQuery) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
        Root<Location> root = criteria.from(Location.class);
        criteria.select(root).where(builder.equal(root.get("price"), priceQuery.value()));

        List<Location> locationList = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return Optional.ofNullable(locationList);
    }
}