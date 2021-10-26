package com.webdev.tourapp.TransportCompany.Company.Application.All;

import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.NoCompaniesFound;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.Company;

import java.util.List;
import java.util.Optional;

public class CompanyAll {
    CompanyRepository repository;

    public CompanyAll(CompanyRepository repository){
        this.repository = repository;
    }

    public CompanyAllResponse execute(){
        Optional<List<Company>> companyListOptional = repository.all();

        if(companyListOptional.isEmpty()){
            throw new NoCompaniesFound("No se ha encontrado ningún compañía de transporte.");
        }

        List<Company> companyList = companyListOptional.get();

        return new CompanyAllResponse(companyList);
    }
}