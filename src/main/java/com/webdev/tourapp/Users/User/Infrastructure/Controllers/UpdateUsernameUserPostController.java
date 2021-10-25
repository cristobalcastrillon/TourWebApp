package com.webdev.tourapp.Users.User.Infrastructure.Controllers;


import com.webdev.tourapp.Users.User.Application.UpdateLastName.UserUpdateLastName;
import com.webdev.tourapp.Users.User.Application.UpdateUsername.UserUpdateUsername;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Exceptions.UserAlreadyExists;
import com.webdev.tourapp.Users.User.Domain.Exceptions.UserLastNameNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Users")
public class UpdateUsernameUserPostController {
    @Autowired
    private UserUpdateUsername updateUsername;

    @PostMapping(value = "/updateUsername")
    public ResponseEntity execute(@RequestBody UserRequestUsername request)
    {
        updateUsername.execute(request.getId(), request.getUsername());
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
    @ExceptionHandler({UserLastNameNotValid.class, UserAlreadyExists.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    static class UserRequestUsername
    {
        private String id;
        private String username;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

}
