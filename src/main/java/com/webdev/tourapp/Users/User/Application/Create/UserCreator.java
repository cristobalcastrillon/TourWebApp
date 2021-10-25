package com.webdev.tourapp.Users.User.Application.Create;

import com.webdev.tourapp.Shared.Domain.Ids.UserID;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.*;

import java.util.Optional;

public class UserCreator
{
    private UserRepository myRep;

    public UserCreator(UserRepository myRep) {
        this.myRep = myRep;
    }
    public void execute(String id, String fName, String lName, String uName, String pword)
    {
        this.validate(id, uName);
        User myUser = User.Create(new UserID(id), new Username (uName),
                new UserFirstName(fName), new UserLastName(lName),
                new UserPassword(pword));
        myRep.save(myUser);
    }
    private void validate(String id, String uName)
    {
        validateID(id);
        //TODO: Fix validateUsername
        // Exception: Can not set java.lang.String field com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject.value to java.lang.String
        //validateUsername(uName);
    }
    private void validateID(String id)
    {
        Optional<User> myUser = myRep.findByID(new UserID (id));
        if (myUser.isPresent())
        {
            throw new NoUsersFound("Dado el ID; el usuario no se pudo encontrar");
        }
    }
    private void validateUsername(String uName)
    {
        Optional<User> myUser = myRep.findByUsername(new Username(uName));
        if (myUser.isPresent())
        {
            throw new NoUsersFound("Dado el userName; el usuario no se pudo encontrar");
        }
    }
}