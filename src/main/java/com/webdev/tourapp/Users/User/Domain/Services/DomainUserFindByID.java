package com.webdev.tourapp.Users.User.Domain.Services;

import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserID;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;

import java.util.Optional;

public class DomainUserFindByID {
    UserRepository myRep;
    public DomainUserFindByID(UserRepository myRep)
    {
        this.myRep = myRep;
    }
    public User execute (String myID)
    {
        Optional<User> user = myRep.findByID(new UserID(myID));
        if (user.isEmpty())
        {
            throw new NoUsersFound("No se ha podido encontrar el usuario.");
        }
        return user.get();
    }
}
