package com.webdev.tourapp.Users.User.Application.Login;

import com.webdev.tourapp.Shared.Applicacion.TokenGeneration;
import com.webdev.tourapp.Shared.Applicacion.TokenGenerationResponse;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Exceptions.PasswordNotFound;
import com.webdev.tourapp.Users.User.Domain.Ports.UserRepository;
import com.webdev.tourapp.Users.User.Domain.User;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.UserPassword;
import com.webdev.tourapp.Users.User.Domain.ValueObjects.Username;

import java.util.Optional;

public class UserLogin
{
    UserRepository myRep;
    private final TokenGeneration tokenGeneration;

    public UserLogin(TokenGeneration tokenGeneration) {
        this.tokenGeneration = tokenGeneration;
    }

    public UserLoginResponse execute(String username, String password)
    {
        Optional<User> userOpt = this.myRep.findByUsername(new Username(username));
        if (userOpt.isEmpty())
        {
            throw new NoUsersFound("El usuario con username " + username + " no fue encontrado para actualizar");
        }
        User user = userOpt.get();
        if (user.VerifyPassword(new UserPassword(password)))
        {
            TokenGenerationResponse responseToken = this.tokenGeneration.execute(username);
            UserLoginResponse response = new UserLoginResponse(username, responseToken.token());
            return response;
        }
        else
        {
            throw new PasswordNotFound("Error en validación de contraseña del usuario " + username );

        }

    }
}
