package com.webdev.tourapp.Users.Guide.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;
import com.webdev.tourapp.Users.Guide.Application.Create.GuideCreator;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.*;
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
@RequestMapping(value = "/Guide")
public class CreateGuidePostController
{
    @Autowired
    private GuideCreator creator;

    @PostMapping(value = "/Create")
    public ResponseEntity execute(@RequestBody GuideRequest request) {
        this.creator.execute(request.getGuideID(), request.getGuideStatus(), request.getGuideFirstName(),
                request.getGuideLastName(), request.getGuidePhoneNumber()
                , request.getGuideBaseFare(), request.getGuidePassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(GuideAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleGuideAlreadyExists(UserAlreadyExists exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({GuideFirstNameNotValid.class, GuideLastNameNotValid.class,
            GuidePhoneNumberNotValid.class, GuidePasswordNotValid.class,
            GuidePriceFareNotValid.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class GuideRequest {
        private String guideID;

        public String getGuideStatus() {
            return guideStatus;
        }

        public void setGuideStatus(String guideStatus) {
            this.guideStatus = guideStatus;
        }

        private String guideStatus;
        private String guideFirstName;
        private String guideLastName;
        private Long guidePhoneNumber;
        private Double guideBaseFare;
        private String guidePassword;

        public String getGuideID() {
            return guideID;
        }

        public void setGuideID(String guideID) {
            this.guideID = guideID;
        }

        public String getGuideFirstName() {
            return guideFirstName;
        }

        public void setGuideFirstName(String guideFirstName) {
            this.guideFirstName = guideFirstName;
        }

        public String getGuideLastName() {
            return guideLastName;
        }

        public void setGuideLastName(String guideLastName) {
            this.guideLastName = guideLastName;
        }

        public Long getGuidePhoneNumber() {
            return guidePhoneNumber;
        }

        public void setGuidePhoneNumber(Long guidePhoneNumber) {
            this.guidePhoneNumber = guidePhoneNumber;
        }

        public Double getGuideBaseFare() {
            return guideBaseFare;
        }

        public void setGuideBaseFare(Double guideBaseFare) {
            this.guideBaseFare = guideBaseFare;
        }

        public String getGuidePassword() {
            return guidePassword;
        }

        public void setGuidePassword(String guidePassword) {
            this.guidePassword = guidePassword;
        }
    }
}
