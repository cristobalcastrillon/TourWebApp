package com.webdev.tourapp.Users.User.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers.CreateTourPostController;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;
import com.webdev.tourapp.Users.User.Application.Create.UserCreator;
import com.webdev.tourapp.Users.User.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Users")
public class CreateUserPostController
{
        @Autowired
        private UserCreator creator;

    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody UserRequest request)
    {
            this.creator.execute(request.getUserID(), request.getUserFirstName()
                    , request.getUserLastName(), request.getUsername(), request.getUserPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    @ExceptionHandler(UserAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleTourAlreadyExists(UserAlreadyExists exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    @ExceptionHandler({UserFirstNameNotValid.class, UserLastNameNotValid.class,
            UserUsernameNotValid.class, PasswordNotValid.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class UserRequest
    {
        private String userID;
        private String userFirstName;
        private String userLastName;
        private String username;
        private String userPassword;
        private Optional<List<TourInstanceID>> toursUserSigned;

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getUserFirstName() {
            return userFirstName;
        }

        public void setUserFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
        }

        public String getUserLastName() {
            return userLastName;
        }

        public void setUserLastName(String userLastName) {
            this.userLastName = userLastName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public Optional<List<TourInstanceID>> getToursUserSigned() {
            return toursUserSigned;
        }

        public void setToursUserSigned(Optional<List<TourInstanceID>> toursUserSigned) {
            this.toursUserSigned = toursUserSigned;
        }
    }
}