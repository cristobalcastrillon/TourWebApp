package com.webdev.tourapp.TransportCompany.Company.Application.Delete;

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
        Optional<Company> company = this.validate(id);
        repository.delete(company.get());
    }

    private Optional<Company> validate(String tourID){
        Optional<Company> company = repository.findByID(new CompanyID());
        if(company.isEmpty()){
            // throw new CompanyIDNotFound("La compañia de transporte con id " + CompanyID + ", que desea eliminar, no ha sido encontrado.");
        }
        return company;
    }
}