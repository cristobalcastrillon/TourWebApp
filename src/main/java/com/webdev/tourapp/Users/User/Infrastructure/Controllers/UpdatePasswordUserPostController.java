package com.webdev.tourapp.Users.User.Infrastructure.Controllers;


import com.webdev.tourapp.Users.User.Application.UpdateLastName.UserUpdateLastName;
import com.webdev.tourapp.Users.User.Application.UpdatePassword.UserUpdatePassword;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import com.webdev.tourapp.Users.User.Domain.Exceptions.PasswordNotValid;
import com.webdev.tourapp.Users.User.Domain.Exceptions.UserLastNameNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Users")
public class UpdatePasswordUserPostController {
    @Autowired
    private UserUpdatePassword updatePassword;

    @PostMapping(value = "/updatePassword")
    public ResponseEntity execute(@RequestBody UserRequestPassword request)
    {
        updatePassword.execute(request.getId(), request.getPassword());
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
    @ExceptionHandler({PasswordNotValid.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    static class UserRequestPassword
    {
        private String id;
        private String password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
