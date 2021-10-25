package com.webdev.tourapp.Users.Guide.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.GuidePasswordNotValid;

import java.util.regex.Pattern;

public class GuidePassword extends StringValueObject {
    public GuidePassword(String password) {
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
            throw new GuidePasswordNotValid("La contraseña no puede tener espacios.");
        }
        if (length < 3)
        {
            throw new GuidePasswordNotValid("La contraseña debe tener mas de 3 caracteres");
        }
    }
}
