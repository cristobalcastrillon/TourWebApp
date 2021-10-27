package com.webdev.tourapp.Users.Guide.Infrastructure.Hibernate;

import com.webdev.tourapp.Users.Guide.Domain.ValueObjects.GuideID;
import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import com.webdev.tourapp.Users.Guide.Domain.Ports.GuideRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateGuideRepository extends HibernateRepository<Guide> implements GuideRepository
{
    public HibernateGuideRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Guide.class);
    }
    @Override
    public void save(Guide guide)
    {
        persist(guide);
    }
    @Override
    public void update (Guide guide)
    {
        updateEntity(guide);
    }
    @Override
    public void delete (Guide guide)
    {
        deleteEntity(guide);
    }

    @Override
    public Optional<List<Guide>> all()
    {
        return getAll();
    }

    @Override
    public Optional<Guide> findByID(GuideID id)
    {
        return byId(id);
    }


}
