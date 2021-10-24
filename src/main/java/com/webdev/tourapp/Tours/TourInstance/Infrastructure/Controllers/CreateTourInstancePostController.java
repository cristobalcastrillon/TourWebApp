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
        this.creator.execute(request.getDate(),
                request.getInstanceID(),
                request.getNumberOfPersons(),
                request.getTotalPrice(),
                request.getStatus(),
                request.getGuide(),
                request.getsLocation(),
                request.getUsers(),
                request.getCompanyHired());

        // DEBUG
        System.out.println(request.getStatus());

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
        private Date date;
        private String instanceID;
        private Integer numberOfPersons;
        private Double totalPrice;
        private String status;
        private TourGuide guide;
        private StartingLocation sLocation;
        private Optional<List<TourUser>> users;
        private Optional<TransportCompanyHired> companyHired;

        TourInstanceRequest(){}

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getInstanceID() {
            return instanceID;
        }

        public void setInstanceID(String instanceID) {
            this.instanceID = instanceID;
        }

        public Integer getNumberOfPersons() {
            return numberOfPersons;
        }

        public void setNumberOfPersons(Integer numberOfPersons) {
            this.numberOfPersons = numberOfPersons;
        }

        public Double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public TourGuide getGuide() {
            return guide;
        }

        public void setGuide(TourGuide guide) {
            this.guide = guide;
        }

        public StartingLocation getsLocation() {
            return sLocation;
        }

        public void setsLocation(StartingLocation sLocation) {
            this.sLocation = sLocation;
        }

        public Optional<List<TourUser>> getUsers() {
            return users;
        }

        public void setUsers(Optional<List<TourUser>> users) {
            this.users = users;
        }

        public Optional<TransportCompanyHired> getCompanyHired() {
            return companyHired;
        }

        public void setCompanyHired(Optional<TransportCompanyHired> companyHired) {
            this.companyHired = companyHired;
        }
    }
}