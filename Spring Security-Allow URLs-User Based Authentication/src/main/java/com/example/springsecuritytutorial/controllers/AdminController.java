package com.example.springsecuritytutorial.controllers;


import com.example.springsecuritytutorial.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AuthenticationManager authManager;
    @PostMapping("/authentication")
    public String authentication(@RequestBody UserInfo userInfo){

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userInfo.getUsername(),
                        userInfo.getPassword()
                )
        );
        if(authentication.isAuthenticated()){
          return "ADMIN";
        }

        return "ERROR";
    }
}
