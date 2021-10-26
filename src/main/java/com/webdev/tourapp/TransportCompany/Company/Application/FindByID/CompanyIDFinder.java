package com.webdev.tourapp.TransportCompany.Company.Application.FindByID;

import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.CompanyIDNotFound;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyID;

import java.util.Optional;

public class CompanyIDFinder {

    private CompanyRepository repository;
    private CompanyIDFinder finderService;

    public CompanyIDFinder(CompanyRepository repository){
        this.repository = repository;
        finderService = new CompanyIDFinder(this.repository);
    }

    public CompanyIDFinderResponse execute(String id){
        Optional<Company> companyOptional = repository.findByID(new CompanyID(id));

        if(companyOptional.isEmpty()){
            throw new CompanyIDNotFound("No se ha encontrado ninguna empresa con el id " + id);
        }

        Company company = companyOptional.get();

        return new CompanyIDFinderResponse(company);
    }
}