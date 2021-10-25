package com.webdev.tourapp.Users.User.Application.UpdateLastName;

import com.webdev.tourapp.Shared.Domain.Ids.UserID;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserLastName;

import java.util.Optional;

public class UserUpdateLastName {
    UserRepository myRep;

    public UserUpdateLastName(UserRepository repository){
        this.myRep = repository;
    }

    public void execute(String userID, String newLastName){
        Optional<User> userOpt = this.myRep.findByID(new UserID(userID));
        if (userOpt.isEmpty())
        {
            throw new NoUsersFound("El usuario con id " + userID + " no fue encontrado" +
                    " para actualizar");
        }
        User user = userOpt.get();
        user.UpdateLastName(new UserLastName(newLastName));
        myRep.update(user);
        //myRep.save(user); ??

    }
}
