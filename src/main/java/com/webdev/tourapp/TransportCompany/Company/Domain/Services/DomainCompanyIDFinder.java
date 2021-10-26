package com.webdev.tourapp.TransportCompany.Company.Domain.Services;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import com.webdev.tourapp.TransportCompany.Company.Application.FindByID.CompanyIDFinder;
import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyID;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyName;

import java.util.List;
import java.util.Optional;

public class DomainCompanyIDFinder {
    private CompanyRepository repository;

    public DomainCompanyIDFinder(CompanyRepository repository){
        this.repository = repository;
    }

    public Company execute(String companyID){
        Optional<Company> companyOptional = repository.findByID(new CompanyID(companyID));

        if(companyOptional.isEmpty()){
            throw new TourInstanceIDNotFound("La compañía de transporte con id " + companyID + " no ha sido encontrada." );
        }

        return companyOptional.get();
    }
}
