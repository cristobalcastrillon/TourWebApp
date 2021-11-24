package com.webdev.tourapp.Users.User.Infrastructure.Controllers;

import com.webdev.tourapp.Users.User.Application.AddTourInstanceIDToList.AddTourInstanceIDToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/User")
public class AddTourInstanceIDToListPutController {

    @Autowired
    private AddTourInstanceIDToList tourInstanceIDToList;

    @PutMapping(value = "{id}")
    public ResponseEntity execute(@PathVariable("id") String id, @RequestBody UserRequest request){
        this.tourInstanceIDToList.execute(id, request.getTourInstanceID());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    //TODO: Exception handlers

    static class UserRequest {
        private String tourInstanceID;

        public UserRequest() {
        }

        public String getTourInstanceID() {
            return tourInstanceID;
        }

        public void setTourInstanceID(String tourInstanceID) {
            this.tourInstanceID = tourInstanceID;
        }
    }
}
