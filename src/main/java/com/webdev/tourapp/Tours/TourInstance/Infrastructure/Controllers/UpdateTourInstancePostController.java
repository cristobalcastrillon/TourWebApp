package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.TourInstance.Application.Update.TourInstanceUpdater;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.StartingLocation;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourGuide;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourUser;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TransportCompanyHired;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/TourInstance")
public class UpdateTourInstancePostController {

    @Autowired
    private TourInstanceUpdater updater;

    @PostMapping(value = "/update")
    public ResponseEntity execute(@RequestParam("id") String tourInstanceID, @RequestBody TourInstanceRequest request) {
        this.updater.execute(request.getTourDate(),
                tourInstanceID,
                request.getTourNumberOfPersons(),
                request.getTourTotalPrice(),
                request.getTourInstanceStatus(),
                request.getTourGuide(),
                request.getStartingLocation(),
                request.getTourUsers(),
                request.getTransportCompanyHired(),
                request.getAssociatedTourID());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(TourInstanceIDNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTourInstanceIDNotFound(TourInstanceIDNotFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    static class TourInstanceRequest {
        private Date tourDate;
        private Integer tourNumberOfPersons;
        private Double tourTotalPrice;
        private String tourInstanceStatus;
        private Optional<TourGuide> tourGuide;
        private Optional<StartingLocation> startingLocation;
        private Optional<List<TourUser>> tourUsers;
        private Optional<TransportCompanyHired> transportCompanyHired;
        private String associatedTourID;

        public TourInstanceRequest(){}

        public Date getTourDate() {
            return tourDate;
        }

        public void setTourDate(Date tourDate) {
            this.tourDate = tourDate;
        }

        public Integer getTourNumberOfPersons() {
            return tourNumberOfPersons;
        }

        public void setTourNumberOfPersons(Integer tourNumberOfPersons) {
            this.tourNumberOfPersons = tourNumberOfPersons;
        }

        public Double getTourTotalPrice() {
            return tourTotalPrice;
        }

        public void setTourTotalPrice(Double tourTotalPrice) {
            this.tourTotalPrice = tourTotalPrice;
        }

        public String getTourInstanceStatus() {
            return tourInstanceStatus;
        }

        public void setTourInstanceStatus(String tourInstanceStatus) {
            this.tourInstanceStatus = tourInstanceStatus;
        }

        public Optional<TourGuide> getTourGuide() {
            return tourGuide;
        }

        public void setTourGuide(Optional<TourGuide> tourGuide) {
            this.tourGuide = tourGuide;
        }

        public Optional<StartingLocation> getStartingLocation() {
            return startingLocation;
        }

        public void setStartingLocation(Optional<StartingLocation> startingLocation) {
            this.startingLocation = startingLocation;
        }

        public Optional<List<TourUser>> getTourUsers() {
            return tourUsers;
        }

        public void setTourUsers(Optional<List<TourUser>> tourUsers) {
            this.tourUsers = tourUsers;
        }

        public Optional<TransportCompanyHired> getTransportCompanyHired() {
            return transportCompanyHired;
        }

        public void setTransportCompanyHired(Optional<TransportCompanyHired> transportCompanyHired) {
            this.transportCompanyHired = transportCompanyHired;
        }

        public String getAssociatedTourID() {
            return associatedTourID;
        }

        public void setAssociatedTourID(String associatedTourID) {
            this.associatedTourID = associatedTourID;
        }
    }

}