package com.webdev.tourapp.TransportCompany.Company.Application.Update;

import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.CompanyIDNotFound;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyID;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyName;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyBasePrice;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyURL;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyCellphone;

import java.util.List;
import java.util.Optional;

public class CompanyUpdater {
    private CompanyRepository repository;

    public CompanyUpdater(CompanyRepository repository){
        this.repository = repository;
    }

    public void execute(String id,
                        String name,
                        Double price,
                        String url,
                        String cellphone
    ){
        this.validate(id);
        Company company = Company.Create(new CompanyID(id), new CompanyName(name), new CompanyBasePrice(price), new CompanyCellphone(cellphone), new CompanyURL(url));
        repository.update(company);
    }

    private void validate(String companyID){
        Optional<Company> company = repository.findByID(new CompanyID(companyID));
        if(company.isEmpty()){
            throw new CompanyIDNotFound("La compañia de id " + companyID + ", que desea modificar, no ha sido encontrada.");
        }
    }
}