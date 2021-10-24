package com.webdev.tourapp.Users.Guide.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.GuideFirstNameNotValid;

public class GuideFirstName extends StringValueObject
{
    public GuideFirstName(String firstName)
    {
        validate(firstName);
        this.value = firstName;
    }
    private void validate(String firstName)
    {
        firstNameLength(firstName);
    }
    private void firstNameLength(String firstName)
    {
        int length = firstName.length();
        if (length < 2 || length > 20)
        {
            throw new GuideFirstNameNotValid("El nombre del guia debe" +
                    " de estar entre 2 y 20 caracteres");
        }
    }
}