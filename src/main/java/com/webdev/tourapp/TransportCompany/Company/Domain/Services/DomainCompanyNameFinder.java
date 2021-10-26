package com.webdev.tourapp.TransportCompany.Company.Domain.Services;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyName;

import java.util.List;
import java.util.Optional;

public class DomainCompanyNameFinder {
    private CompanyRepository repository;

    public DomainCompanyNameFinder(CompanyRepository repository){
        this.repository = repository;
    }

    public List<Company> execute(String companyName){
        Optional<List<Company>> companyListOptional = repository.findByCompanyName(new CompanyName(companyName));

        if(companyListOptional.isEmpty()){
            throw new TourInstanceIDNotFound("La compañía de transporte " + companyName + " no ha sido encontrada." );
        }

        return companyListOptional.get();
    }
}
