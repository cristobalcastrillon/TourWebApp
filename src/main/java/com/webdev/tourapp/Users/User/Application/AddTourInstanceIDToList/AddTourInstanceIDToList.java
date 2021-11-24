package com.webdev.tourapp.Users.User.Application.AddTourInstanceIDToList;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddTourInstanceIDToList {
    UserRepository repository;

    public AddTourInstanceIDToList(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String userID, String tourInstanceID){
        Optional<User> userOptional = this.repository.findByID(new UserID(userID));
        if(userOptional.isEmpty()){
            throw new NoUsersFound("No users found for id " + userID);
        }
        User user = userOptional.get();
        CustomUUID tourInstanceIDForList = new CustomUUID(tourInstanceID);
        Optional<List<CustomUUID>> tourInstanceIDListOptional = user.getUserBookedTourIDs();
        List<CustomUUID> tourInstanceList = new ArrayList<>();

        if(tourInstanceIDListOptional.isPresent()){
            tourInstanceList = tourInstanceIDListOptional.get();
        }

        tourInstanceList.add(tourInstanceIDForList);
        Optional<List<CustomUUID>> optionalList = Optional.of(tourInstanceList);
        user.setUserBookedTourIDs(optionalList);
    }
}
