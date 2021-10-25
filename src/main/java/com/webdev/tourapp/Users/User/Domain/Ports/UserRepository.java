package com.webdev.tourapp.Users.User.Domain.Ports;

import com.webdev.tourapp.Shared.Domain.Ids.UserID;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.Username;

import java.util.List;
import java.util.Optional;

public interface UserRepository
{
    void save (User user);
    void update (User user);
    void delete (User user);
    Optional<User> findByID(UserID id);
    Optional<User> findByUsername (Username u_nameQuery);
    Optional<List<User>> all();

}