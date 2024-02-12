package com.example.springsecurityauth.controller;

import com.example.springsecurityauth.model.ApplicationUser;
import com.example.springsecurityauth.model.RegistrationDTO;
import com.example.springsecurityauth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }


}
