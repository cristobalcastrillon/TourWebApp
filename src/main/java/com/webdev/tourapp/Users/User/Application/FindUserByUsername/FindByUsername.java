package com.webdev.tourapp.Users.User.Application.FindUserByUsername;

import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.Services.DomainUserFindByUsername;
import com.webdev.tourapp.Users.User.Domain.User;

public class FindByUsername
{
    private UserRepository myRep;
    private DomainUserFindByUsername finderService;

    public FindByUsername(UserRepository myRep) {
        this.myRep = myRep;
        finderService = new DomainUserFindByUsername(this.myRep);
    }
    public User execute(String username)
    {
        return finderService.execute(username);
    }
}
