package com.webdev.tourapp.TransportCompany.Company.Infrastructure.Hibernate;

import com.webdev.tourapp.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyID;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyName;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateCompanyRepository extends HibernateRepository<Company> implements CompanyRepository {

    public HibernateCompanyRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Company.class);
    }

    @Override
    public void save(Company company) {
        persist(company);
    }

    @Override
    public void update(Company company) {
        updateEntity(company);
    }

    @Override
    public void delete(Company company) {
        deleteEntity(company);
    }

    @Override
    public Optional<List<Company>> all() {
        return getAll();
    }

    @Override
    public Optional<Company> findByID(CompanyID companyID) {
        return byId(companyID);
    }

    @Override
    public Optional<List<Company>> findByCompanyName(CompanyName nameQuery) {
        //TODO
        return Optional.empty();
    }
}
