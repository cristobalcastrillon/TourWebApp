package com.webdev.tourapp.Users.User.Application.UpdateUsername;

import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserID;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Exceptions.UserAlreadyExists;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.Username;

import java.util.Optional;

public class UserUpdateUsername {
    UserRepository myRep;

    public UserUpdateUsername(UserRepository repository){
        this.myRep = repository;
    }

    public void execute(String userID, String newUsername){
        Optional<User> userOpt = this.myRep.findByID(new UserID(userID));
        if (userOpt.isEmpty())
        {
            throw new NoUsersFound("El usuario con id " + userID + " no fue encontrado" +
                    " para actualizar");
        }
        User user = userOpt.get();
        user.UpdateUsername(new Username(newUsername));
        Optional<User> userExistsByUsername = this.myRep.findByUsername(new Username(newUsername));
        if (userExistsByUsername.isPresent())
        {
            throw new UserAlreadyExists("El usuario con username " + newUsername
            + "ya existe.");
        }
        myRep.update(user);
        //myRep.save(user); ??

    }
}
