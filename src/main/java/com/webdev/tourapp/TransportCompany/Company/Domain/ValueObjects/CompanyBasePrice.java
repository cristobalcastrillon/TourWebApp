package com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.NotValidBasePrice;

public class CompanyBasePrice extends DoubleValueObject {

    public CompanyBasePrice(){

    }

    public CompanyBasePrice(Double price){
        validate(price);
        this.value = price;
    }

    private void validate(Double price){
        isNotNegativeValue(price);
    }

    private void isNotNegativeValue(Double price){
        if(price < 0.0)
            throw new NotValidBasePrice("¡El precio base no puede ser negativo!");
    }
}