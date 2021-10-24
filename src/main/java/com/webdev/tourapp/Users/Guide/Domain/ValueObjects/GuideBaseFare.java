package com.webdev.tourapp.Users.Guide.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.GuidePhoneNumberNotValid;

public class GuideBaseFare extends DoubleValueObject
{
    public GuideBaseFare(Double price)
    {
        validate(price);
        this.value = price;
    }
    private void validate(Double price)
    {
        checkMaxLimitValue( price);
        checkNegatives( price);
    }
    private void checkMaxLimitValue(Double price)
    {
        if(price > 10000000)
        {
            throw new GuidePhoneNumberNotValid("El precio base no puede ser mayor a " +
                    "10 millones de pesos.");
        }
    }
    private void checkNegatives(Double price)
    {
        if(price < 0)
        {
            throw new GuidePhoneNumberNotValid("El precio del guia no puede ser " +
                    "negativo.");
        }
    }
}