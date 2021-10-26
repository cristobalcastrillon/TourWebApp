package com.webdev.tourapp.TransportCompany.Company.Application.Delete;

import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.CompanyIDNotFound;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyID;

import java.util.Optional;

public class CompanyDeleter {

    private CompanyRepository repository;

    public CompanyDeleter(CompanyRepository repository){
        this.repository = repository;
    }

    public void execute(String id){
        Optional<Company> companyOptional = this.validate(id);
        repository.delete(companyOptional.get());
    }

    private Optional<Company> validate(String id){
        Optional<Company> company = repository.findByID(new CompanyID(id));
        if(company.isEmpty()){
            throw new CompanyIDNotFound("No se ha encontrado ninguna compañía de transporte con ID " + id);
        }
        return company;
    }
}