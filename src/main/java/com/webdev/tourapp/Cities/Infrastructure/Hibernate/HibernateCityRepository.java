package com.webdev.tourapp.Cities.Infrastructure.Hibernate;

import com.webdev.tourapp.Cities.Domain.Entities.LocationInCity;
import com.webdev.tourapp.Cities.Domain.Entities.TourInCity;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityDefaultIATA;
import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.tourapp.Cities.Domain.Ports.CityRepository;
import com.webdev.tourapp.Cities.Domain.City;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityID;
import com.webdev.tourapp.Cities.Domain.ValueObjects.CityName;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateCityRepository extends HibernateRepository<City> implements CityRepository {

    public HibernateCityRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, City.class);
    }

    @Override
    public void save(City city){
        persist(city);
    }

    @Override
    public void update(City city){
        updateEntity(city);
    }

    @Override
    public void delete(City city){
        deleteEntity(city);
    }

    @Override
    public Optional<List<City>> all(){
        return getAll();
    }

    @Override
    public Optional<City> findByID(CityID cityID){
        return byId(cityID);
    }

    @Override
    public Optional<List<City>> findByName(CityName nameQuery){
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root = cq.from(City.class);
        cq.select(root).where(cb.like(root.get("cityName"), nameQuery.value()));

        List<City> cities = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(cities);
    }

    @Override
    public Optional<List<City>> findByDefaultIATA(CityDefaultIATA defaultIATA) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root = cq.from(City.class);
        cq.select(root).where(cb.like(root.get("defaultIATA"), defaultIATA.value()));

        List<City> cities = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(cities);
    }

    @Override
    public Optional<List<City>> findByListOfLocations(Optional<List<LocationInCity>> locationsInCity){
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root = cq.from(City.class);
        cq.select(root).where(root.get("locations").in(locationsInCity.get()));
        List<City> cities = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(cities);
    }
    @Override
    public Optional<List<City>> findByListOfTours(Optional<List<TourInCity>> toursInCity){
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root = cq.from(City.class);
        cq.select(root).where(root.get("tours").in(toursInCity.get()));
        List<City> cities = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(cities);
    }
}