package com.webdev.tourapp.Users.User.Application.UpdateFirstName;

import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserID;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserFirstName;

import java.util.Optional;

public class UserUpdateFirstName {
    UserRepository myRep;

    public UserUpdateFirstName(UserRepository repository){
        this.myRep = repository;
    }

    public void execute(String userID, String newFirstName){
        Optional<User> userOpt = this.myRep.findByID(new UserID(userID));
        if (userOpt.isEmpty())
        {
            throw new NoUsersFound("El usuario con id " + userID + " no fue encontrado para actualizar");
        }
        User user = userOpt.get();
        user.UpdateFirstName(new UserFirstName(newFirstName));
        myRep.update(user);
    }
}
