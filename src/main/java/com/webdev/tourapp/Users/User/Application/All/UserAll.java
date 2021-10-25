package com.webdev.tourapp.Users.User.Application.All;

import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserAll {
    UserRepository myRep;

    public UserAll(UserRepository repository){
        this.myRep = repository;
    }

    public UserAllResponse execute(){
        Optional<List<User>> userListOpt = myRep.all();

        if(userListOpt.isEmpty()){
            throw new NoUsersFound("No se encontro ningun usuario registrado");
        }

        List<User> userList = userListOpt.get();

        return new UserAllResponse(userList);
    }
}
