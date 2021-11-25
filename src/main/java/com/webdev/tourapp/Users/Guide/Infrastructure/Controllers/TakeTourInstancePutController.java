package com.webdev.tourapp.Users.Guide.Infrastructure.Controllers;

import com.webdev.tourapp.Users.Guide.Application.TakeTourInstance.TakeTourInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Guide")
public class TakeTourInstancePutController {

    @Autowired
    private TakeTourInstance takeTourInstance;

    @PutMapping(value = "{id}")
    public ResponseEntity execute(@PathVariable("id") String id, @RequestBody GuideRequest request){
        this.takeTourInstance.execute(id, request.getTourInstanceID());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    //TODO: Exception handlers

    static class GuideRequest {
        private String tourInstanceID;

        public GuideRequest(){}

        public String getTourInstanceID(){
            return this.tourInstanceID;
        }

        public void setTourInstanceID(String id){
            this.tourInstanceID = id;
        }
    }
}
