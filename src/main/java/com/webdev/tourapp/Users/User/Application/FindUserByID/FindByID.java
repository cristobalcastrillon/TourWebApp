package com.webdev.tourapp.Users.User.Application.FindUserByID;

import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.Services.DomainUserFindByID;

public class FindByID
{
    private UserRepository myRep;
    private DomainUserFindByID finderService;

    public FindByID(UserRepository myRep) {
        this.myRep = myRep;
        finderService = new DomainUserFindByID(this.myRep);
    }
    public User execute(String id)
    {
        return finderService.execute(id);
    }
}
