package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NotValidTourTotalPrice;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceAlreadyExists;
import com.webdev.tourapp.Tours.TourInstance.Application.Create.TourInstanceCreator;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.StartingLocation;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourGuide;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourUser;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TransportCompanyHired;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NotValidNumberOfPersons;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NotValidState;
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
public class CreateTourInstancePostController {

    @Autowired
    private TourInstanceCreator creator;

    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody TourInstanceRequest request) {
        this.creator.execute(request.getTourDate(),
                request.getTourInstanceID(),
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

    @ExceptionHandler(TourInstanceAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleTourInstanceAlreadyExists(TourInstanceAlreadyExists exception){
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({NotValidNumberOfPersons.class, NotValidState.class, NotValidTourTotalPrice.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class TourInstanceRequest {
        private Date tourDate;
        private String tourInstanceID;
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

        public String getTourInstanceID() {
            return tourInstanceID;
        }

        public void setTourInstanceID(String tourInstanceID) {
            this.tourInstanceID = tourInstanceID;
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