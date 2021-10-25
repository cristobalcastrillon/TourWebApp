package com.webdev.tourapp.Users.Guide.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.LongValueObject;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.GuidePriceFareNotValid;

public class GuidePhoneNumber extends LongValueObject
{
    public GuidePhoneNumber(Long cellNumber)
    {
        validate(cellNumber);
        this.value = cellNumber;
    }
    private void validate (Long cellNumber)
    {
        checkMaxLimitValue(cellNumber);
        checkMinLimitValue(cellNumber);
    }
    private void checkMaxLimitValue(Long cellNumber)
    {
        if(cellNumber > 1000000000000L)
        {
            throw new GuidePriceFareNotValid("El número celular no puede tener " +
                    "mas de 12 dígitos.");
        }
    }
    private void checkMinLimitValue(Long cellNumber)
    {
        if(cellNumber < 100000)
        {
            throw new GuidePriceFareNotValid("El número celular no puede tener " +
                    "menos de 6 dígitos.");
        }
    }

}