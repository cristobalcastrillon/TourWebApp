package com.webdev.tourapp.Users.User.Infrastructure.Controllers;


import com.webdev.tourapp.Users.User.Application.UpdateFirstName.UserUpdateFirstName;
import com.webdev.tourapp.Users.User.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Users")
public class UpdateFirstNameUserPostController {
    @Autowired
    private UserUpdateFirstName updateFirstName;

    @GetMapping(value = "/updatefName")
    public ResponseEntity execute(@RequestBody UserRequestFirstName request)
    {
        updateFirstName.execute(request.getId(), request.getFirstName());
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
    @ExceptionHandler({UserFirstNameNotValid.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    static class UserRequestFirstName
    {
        private String id;
        private String firstName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }

}
