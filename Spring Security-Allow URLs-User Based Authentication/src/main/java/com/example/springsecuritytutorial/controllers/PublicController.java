package com.example.springsecuritytutorial.controllers;

import com.example.springsecuritytutorial.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/v1")
public class PublicController {

    @Autowired
    private AuthenticationManager manager;

    @GetMapping("/message")
    public String message(){
        return "URL IS ALLOWED :)";
    }

    @PostMapping("/usernamepasswordauth")
    public String usernamepasswordauth(@RequestBody UserInfo info){
       try{
           Authentication authentication = manager.authenticate(
                   new UsernamePasswordAuthenticationToken(
                           info.getUsername(),
                           info.getPassword()
                   )
           );
           if(authentication.isAuthenticated()){
               return "USER " + info.getUsername() + " IS AUTHORIZED";
           }
           return "NOT AUTHORIZED";
       }
       catch (Exception e){
           return e.getMessage();
       }
    }
}
