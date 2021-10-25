package com.webdev.tourapp.Users.User.Domain.Services;

import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.Username;

import java.util.Optional;

public class DomainUserFindByUsername {
    UserRepository myRep;
    public DomainUserFindByUsername(UserRepository myRep)
    {
        this.myRep = myRep;
    }
    public User execute (String myID)
    {
        Optional<User> user = myRep.findByUsername(new Username(myID));
        if (user.isEmpty())
        {
            throw new NoUsersFound("No se ha podido encontrar el usuario a través de su nombre");
        }
        return user.get();
    }
}
