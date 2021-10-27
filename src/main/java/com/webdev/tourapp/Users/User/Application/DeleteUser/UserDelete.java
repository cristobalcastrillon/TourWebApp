package com.webdev.tourapp.Users.User.Application.DeleteUser;

import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserID;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.User;

import java.util.Optional;

public class UserDelete {
    UserRepository myRep;

    public UserDelete(UserRepository repository){
        this.myRep = repository;
    }

    public void execute(String userID){
        Optional<User> userOpt = this.myRep.findByID(new UserID(userID));
        if (userOpt.isEmpty())
        {
            throw new NoUsersFound("El usuario con id " + userID + " no fue encontrado" +
                    " para borrar");
        }
        User user = userOpt.get();
        myRep.delete(user);

    }
}
