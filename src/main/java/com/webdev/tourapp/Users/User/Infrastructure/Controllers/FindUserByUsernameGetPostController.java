package com.webdev.tourapp.Users.User.Infrastructure.Controllers;


import com.webdev.tourapp.Users.User.Application.FindUserByID.FindByID;
import com.webdev.tourapp.Users.User.Application.FindUserByID.FindByIDResponse;
import com.webdev.tourapp.Users.User.Application.FindUserByUsername.FindByUsername;
import com.webdev.tourapp.Users.User.Application.FindUserByUsername.FindByUsernameResponse;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Users")
public class FindUserByUsernameGetPostController
{
    @Autowired
    private FindByUsername findUsername;

    @GetMapping(value = "/")
    public ResponseEntity<Object> execute(@PathVariable("username") String uName)
    {
        User user = findUsername.execute(uName);
        FindByUsernameResponse response = new FindByUsernameResponse(user);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
    @ExceptionHandler(NoUsersFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTripAlreadyExist(NoUsersFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
