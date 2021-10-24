package com.webdev.tourapp.Users.User.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

import com.webdev.tourapp.Users.User.Domain.Exceptions.UserUsernameNotValid;

import java.util.regex.Pattern;

public class Username extends StringValueObject
{
    public Username(String userName)
    {
        validate(userName);
        this.value = userName;
    }
    private void validate(String userName)
    {
        userNamePatternValidation(userName);
    }
    private void userNamePatternValidation(String userName)
    {
        Pattern p = Pattern.compile("^[^\s]$");
        int length = userName.length();
        if (!p.matcher(userName).find()) {
            throw new UserUsernameNotValid("El nombre de usuario no puede tener espacios.");
        }
        if (length < 3 || length > 20)
        {
            throw new UserUsernameNotValid("El nombre de usuario debe tener entre 3 y 20 caracteres.");
        }
    }

}