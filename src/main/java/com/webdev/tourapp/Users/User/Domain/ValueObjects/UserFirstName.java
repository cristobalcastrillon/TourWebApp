package com.webdev.tourapp.Users.User.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

import com.webdev.tourapp.Users.User.Domain.Exceptions.UserFirstNameNotValid;


public class UserFirstName extends StringValueObject
{
        public UserFirstName(){}

        public UserFirstName(String firstName)
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
                throw new UserFirstNameNotValid("El nombre del usuario debe" +
                        " de estar entre 2 y 20 caracteres");
            }
        }
}