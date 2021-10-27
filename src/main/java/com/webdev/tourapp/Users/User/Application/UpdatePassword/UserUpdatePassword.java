package com.webdev.tourapp.Users.User.Application.UpdatePassword;

import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserID;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserPassword;

import java.util.Optional;

public class UserUpdatePassword {
    UserRepository myRep;

    public UserUpdatePassword(UserRepository repository){
        this.myRep = repository;
    }

    public void execute(String userID, String newPassword){
        Optional<User> userOpt = this.myRep.findByID(new UserID(userID));
        if (userOpt.isEmpty())
        {
            throw new NoUsersFound("El usuario con id " + userID + " no fue encontrado" +
                    " para actualizar");
        }
        User user = userOpt.get();
        user.UpdatePassword(new UserPassword(newPassword));
        myRep.update(user);
        //myRep.save(user); ??

    }
}
