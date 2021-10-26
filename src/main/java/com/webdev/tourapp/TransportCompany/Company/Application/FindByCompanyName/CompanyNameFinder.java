package com.webdev.tourapp.TransportCompany.Company.Application.FindByCompanyName;

import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.NoCompaniesFoundForSpecifiedCompanyName;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.Services.DomainCompanyNameFinder;
import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyName;

import java.util.List;
import java.util.Optional;


public class CompanyNameFinder {
    private CompanyRepository repository;
    private DomainCompanyNameFinder finderService;

    public CompanyNameFinder(CompanyRepository repository){
        this.repository = repository;
        this.finderService = new DomainCompanyNameFinder(this.repository);
    }

    public CompanyNameFinderResponse execute(String name){
        Optional<List<Company>> companyListOptional = repository.findByCompanyName(new CompanyName(name));

        if(companyListOptional.isEmpty()){
            throw new NoCompaniesFoundForSpecifiedCompanyName("No existe ninguna compañía con el nombre especificado.");
        }

        List<Company> companyList = companyListOptional.get();

        return new CompanyNameFinderResponse(companyList);
    }

}