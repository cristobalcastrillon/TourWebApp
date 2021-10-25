package com.webdev.tourapp.Users.User.Infrastructure.Controllers;


import com.webdev.tourapp.Users.User.Application.All.UserAll;
import com.webdev.tourapp.Users.User.Application.All.UserAllResponse;
import com.webdev.tourapp.Users.User.Application.DeleteUser.UserDelete;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Users")
public class DeleteUserPostController {
    @Autowired
    private UserDelete delete;

    @GetMapping(value = "/")
    public ResponseEntity execute(@PathVariable("id") String id)
    {
        delete.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
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
