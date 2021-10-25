package com.webdev.tourapp.Users.User.Infrastructure.Controllers;


import com.webdev.tourapp.Users.User.Application.All.UserAll;
import com.webdev.tourapp.Users.User.Application.All.UserAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Users")
public class AllUsersGetController {
    @Autowired
    private UserAll all;

    @GetMapping(value = "/")
    public ResponseEntity<List<HashMap<String,Object>>> execute()
    {
        UserAllResponse response = all.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
