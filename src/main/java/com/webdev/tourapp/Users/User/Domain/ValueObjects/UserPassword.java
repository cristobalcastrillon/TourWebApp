package com.webdev.tourapp.Users.User.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.tourapp.Users.User.Domain.Exceptions.PasswordNotValid;

import java.util.regex.Pattern;

public class UserPassword extends StringValueObject {
    public UserPassword(String password) {
        this.value = password;
    }
    private void validate(String password)
    {
        passwordPatternValidation(password);
    }
    private void passwordPatternValidation(String password)
    {
        Pattern p = Pattern.compile("^[^\s]$");
        int length = password.length();
        if (!p.matcher(password).find()) {
            throw new PasswordNotValid("La contraseña no puede tener espacios.");
        }
        if (length < 3)
        {
            throw new PasswordNotValid("La contraseña debe tener mas de 3 caracteres");
        }
    }
}
