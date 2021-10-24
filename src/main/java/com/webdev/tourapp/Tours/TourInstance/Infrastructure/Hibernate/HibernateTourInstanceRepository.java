package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Hibernate;

import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTourInstanceRepository extends HibernateRepository<TourInstance> implements TourInstanceRepository {

    public HibernateTourInstanceRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, TourInstance.class);
    }

    @Override
    public void save(TourInstance tourInstance) {
        persist(tourInstance);
    }

    @Override
    public void update(TourInstance tourInstance) {
        updateEntity(tourInstance);
    }

    @Override
    public void delete(TourInstance tourInstance) {
        deleteEntity(tourInstance);
    }

    @Override
    public Optional<List<TourInstance>> all() {
        return getAll();
    }

    @Override
    public Optional<TourInstance> findByID(TourInstanceID id) {
        return byId(id);
    }

    @Override
    public Optional<List<TourInstance>> findByDate(TourDate date) {
        /*
        Java.util.Date dt = new Java.util.Date();

        Java.text.SimpleDateFormat sdf =
             new Java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dateTime = sdf.format(dt);
         */

        //TODO: Probar esto para ver si es necesario (o no) hacer la conversión a DateTime de manera explícita con el bloque de código comentado

        Date dateTime = date.value();

        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<TourInstance> cq = cb.createQuery(TourInstance.class);
        Root<TourInstance> root = cq.from(TourInstance.class);
        cq.select(root).where(cb.equal(root.get("date"), dateTime));
        List<TourInstance> tourInstances = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(tourInstances);
    }

    @Override
    public Optional<List<TourInstance>> findByStatus(TourInstanceStatus status) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<TourInstance> cq = cb.createQuery(TourInstance.class);
        Root<TourInstance> root = cq.from(TourInstance.class);
        cq.select(root).where(cb.equal(root.get("tourInstanceStatus"), status.value()));
        List<TourInstance> tourInstances = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(tourInstances);
    }

    @Override
    public Optional<List<TourInstance>> findByNumberOfPersons(TourNumberOfPersons numberOfPersons) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<TourInstance> cq = cb.createQuery(TourInstance.class);
        Root<TourInstance> root = cq.from(TourInstance.class);
        cq.select(root).where(cb.equal(root.get("tourNumberOfPersons"), numberOfPersons.value()));
        List<TourInstance> tourInstances = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(tourInstances);
    }

    @Override
    public Optional<List<TourInstance>> findByTotalPrice(TourTotalPrice totalPrice) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<TourInstance> cq = cb.createQuery(TourInstance.class);
        Root<TourInstance> root = cq.from(TourInstance.class);
        cq.select(root).where(cb.lessThanOrEqualTo(root.get("tourTotalPrice"), totalPrice.value()));
        List<TourInstance> tourInstances = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(tourInstances);
    }
}
