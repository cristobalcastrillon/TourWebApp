package com.webdev.tourapp.Users.User.Infrastructure.Hibernate;

import com.webdev.tourapp.Shared.Domain.Ids.UserID;
import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateUserRepository extends HibernateRepository<User> implements UserRepository
{
    public HibernateUserRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }
    @Override
    public void save(User user)
    {
        persist(user);
    }
    @Override
    public void update (User user)
    {
        updateEntity(user);
    }
    @Override
    public void delete (User user)
    {
        deleteEntity(user);
    }

    @Override
    public Optional<List<User>> all()
    {
        return getAll();
    }

    @Override
    public Optional<User> findByID(UserID id)
    {
        return byId(id);
    }

    @Override
    public Optional<User> findByUsername (Username u_nameQuery)
    {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root).where(cb.equal(root.get("username"), u_nameQuery.value()));
        User userInstance = sessionFactory.getCurrentSession().createQuery(cq).getSingleResult();
        return Optional.ofNullable(userInstance);
    }

}
