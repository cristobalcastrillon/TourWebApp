package com.webdev.tourapp.Users.User.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

import com.webdev.tourapp.Users.User.Domain.Exceptions.UserLastNameNotValid;


public class UserLastName extends StringValueObject
{
    public UserLastName(){}

    public UserLastName(String lastName)
    {
        validate(lastName);
        this.value = lastName;
    }
    private void validate(String lastName)
    {
        lastNameLength(lastName);
    }
    private void lastNameLength(String lastName)
    {
        int length = lastName.length();
        if (length < 2 || length > 20)
        {
            throw new UserLastNameNotValid("El apellido debe tener entre 2 y 20 caracteres.");
        }
    }
}