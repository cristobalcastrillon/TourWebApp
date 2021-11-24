package com.webdev.tourapp.Users.Guide.Infrastructure.Controllers;

import com.webdev.tourapp.Users.Guide.Application.UpdateGuideStatus.GuideStatusUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Guide")
public class UpdateGuideStatusPutController {

    @Autowired
    GuideStatusUpdater updater;

    @PutMapping(value = "{id}")
    public ResponseEntity execute(@PathVariable("id") String id, @RequestBody GuideStatusRequest request){
        this.updater.execute(id, request.getStatus());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    //TODO: Exception handlers

    static class GuideStatusRequest {
        private String status;

        public GuideStatusRequest() {}

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

}