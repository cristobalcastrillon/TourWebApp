package com.webdev.tourapp.Users.User.Infrastructure.Controllers;

import com.webdev.tourapp.Users.User.Application.Login.UserLogin;
import com.webdev.tourapp.Users.User.Application.Login.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/Users")
public class UserLoginPostController {
    @Autowired
    private UserLogin userLogin;
    @PostMapping(value = "/Login")
    public ResponseEntity<HashMap<String, Object>> execute(@RequestBody UserLoginRequest request)
    {
        UserLoginResponse response = this.userLogin.execute(request.getUsername(), request.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
    static class UserLoginRequest
    {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public UserLoginRequest(){}
    }
}
